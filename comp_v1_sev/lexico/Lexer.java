package lexico;

import java.io.*;
import java.util.*;
import lexico.tokens.*;

public class Lexer {
    public static int line = 1; // contador de linhas
    private char ch = ' '; // caractere lido do arquivo
    private FileReader file;
    public static Hashtable<String, Word> words = new Hashtable<String, Word>();
    public static Hashtable<Token, Integer> errors = new Hashtable<Token, Integer>();

    /* Método para inserir palavras reservadas na HashTable */
    private void reserve(Word w) {
        words.put(w.getLexeme(), w); // lexema é a chave para entrada na
        // HashTable
    }

    /* Método construtor */
    public Lexer(String fileName) throws FileNotFoundException {
        try {
            file = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found at: " + fileName);
            throw e;
        }
        // Insere palavras reservadas na HashTable
        reserve(Word.start);
        reserve(Word.exit);
        reserve(Word.end);
        reserve(Word._if);
        reserve(Word.then);
        reserve(Word._else);
        reserve(Word._do);
        reserve(Word._while);
        reserve(Word.scan);
        reserve(Word.print);
        reserve(Word.semi);
        reserve(Word.comma);
        reserve(Word.dot);
        reserve(Word.opar);
        reserve(Word.cpar);
        reserve(Word.obra);
        reserve(Word.cbra);
        reserve(Word.and);
        reserve(Word.or);
        reserve(Word.not);
        reserve(Word.add);
        reserve(Word.sub);
        reserve(Word.mul);
        reserve(Word.div);
        reserve(Word.asg);
        reserve(Word.gt);
        reserve(Word.ge);
        reserve(Word.lt);
        reserve(Word.le);
        reserve(Word.df);
        reserve(Word.eq);
        reserve(Word.type_int);
        reserve(Word.type_float);
        reserve(Word.type_string);
    }

    /* Lê o próximo caractere do arquivo */
    private void readch() throws IOException {
        ch = (char) file.read();
    }

    /* Lê o próximo caractere do arquivo e verifica se é igual a c */
    private boolean readch(char c) throws IOException {
        readch();
        if (ch != c)
            return false;
        ch = ' ';
        return true;
    }

    public Token scan() throws IOException {
        // Desconsidera delimitadores na entrada
        for (;; readch()) {
            if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\b')
                continue;
            else if (ch == '\n')
                line++; // conta linhas
            else
                break;
        }
        // Comentários
        if (ch == '/') {
            readch();
            if (ch == '/') {
                do {
                    readch();
                    if (ch == '\n') {
                        readch();
                        line++;
                        break;
                    }
                } while ((int) ch != 65535);
            } else if (ch == '*') {
                do {
                    readch();
                    if (ch == '\n') {
                        line++;
                    }
                    if (ch == '*') {
                        readch();
                        if (ch == '/') {
                            readch();
                            break;
                        }
                    }
                } while ((int) ch != 65535);

            } else {
                return Word.div;
            }
        }
        // Pontuação
        switch (ch) {
            case ';':
                readch();
                return Word.semi;
            case ',':
                readch();
                return Word.comma;
            case '.':
                readch();
                return Word.dot;
            case '(':
                readch();
                return Word.opar;
            case ')':
                readch();
                return Word.cpar;
            case '{':
                readch();
                return Word.obra;
            case '}':
                readch();
                return Word.cbra;
        }

        switch (ch) {
            // Operadores
            case '&':
                if (readch('&'))
                    return Word.and;
                else
                    return new Token('&');
            case '|':
                if (readch('|'))
                    return Word.or;
                else
                    return new Token('|');
            case '!':
                readch();
                return Word.not;
            case '+':
                readch();
                return Word.add;
            case '-':
                readch();
                return Word.sub;
            case '*':
                readch();
                return Word.mul;
            case '/':
                readch();
                return Word.div;
            case '=':
                if (readch('='))
                    return Word.eq;
                else
                    return Word.asg;
            case '>':
                if (readch('='))
                    return Word.ge;
                else
                    return Word.gt;
            case '<':
                readch();
                if (ch == '=')
                    return Word.le;
                else if (ch == '>')
                    return Word.df;
                else
                    return Word.lt;
        }
        // Números
        if (Character.isDigit(ch)) {
            int value = 0;
            do {
                value = 10 * value + Character.digit(ch, 10);
                readch();
            } while (Character.isDigit(ch));
            if (ch != '.')
                return new LiteralInteger(value);
            else
                readch();
            float valuef = value;
            float decUnit = 10;
            do {
                valuef = valuef + Character.digit(ch, 10) / decUnit;
                decUnit = decUnit * 10;
                readch();
            } while (Character.isDigit(ch));
            return new LiteralFloat(valuef);
        }
        // Strings
        if (ch == '"') {
            StringBuffer sb = new StringBuffer();
            do {
                sb.append(ch);
                readch();
            } while (ch != '"' && (int) ch != 65535);
            sb.append(ch);
            readch();
            return new LiteralString(sb.toString());
        }
        // Identificadores (e palavras reservadas)
        if (Character.isLetter(ch) || ch == '_') {
            StringBuffer sb = new StringBuffer();
            do {
                sb.append(ch);
                readch();
            } while (Character.isLetterOrDigit(ch));
            String s = sb.toString();
            Word w = (Word) words.get(s);
            if (w != null)
                return w; // palavra reservada
            w = new Word(s, Tag.ID);
            words.put(s, w);
            return w;
        }
        // Caracteres não especificados
        Token t = new Token(ch);
        if (t.tag != 65535)
            errors.put(t, line);
        ch = ' ';
        return t;
    }
}