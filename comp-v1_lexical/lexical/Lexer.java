package lexical;

import java.io.*;
import java.util.*;
import lexical.literal.*;

public class Lexer {

    public static int line = 1;
    private char peek = ' ';
    private FileReader file;
    private Hashtable<String, Word> words = new Hashtable<String, Word>();

    private void reserve(Word w) {
        words.put(w.getLexeme(), w);
    }

    public Lexer(String fileName) throws FileNotFoundException {
        try {
            file = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            throw e;
        }

        // RESERVE WORDS, OPERATORS, ETC...
        reserve(new Word("start", Tag.START));
        reserve(new Word("exit", Tag.EXIT));
        reserve(new Word("int", Tag.INT));
        reserve(new Word("float", Tag.FLOAT));
        reserve(new Word("string", Tag.STRING));
        reserve(new Word("if", Tag.IF));
        reserve(new Word("then", Tag.THEN));
        reserve(new Word("else", Tag.ELSE));
        reserve(new Word("end", Tag.END));
        reserve(new Word("do", Tag.DO));
        reserve(new Word("while", Tag.WHILE));
        reserve(new Word("scan", Tag.SCAN));
        reserve(new Word("print", Tag.PRINT));

        reserve(new Word("==", Tag.EQUALS));
        reserve(new Word(">", Tag.GREATER));
        reserve(new Word(">=", Tag.GREATER_THAN));
        reserve(new Word("<", Tag.LESS));
        reserve(new Word("<=", Tag.LESS_THAN));
        reserve(new Word("!", Tag.NEGATION));
        reserve(new Word("<>", Tag.DIFFERENT));
        reserve(new Word("&&", Tag.AND));
        reserve(new Word("||", Tag.OR));
        reserve(new Word("+", Tag.PLUS));
        reserve(new Word("-", Tag.MINUS));
        reserve(new Word("*", Tag.TIMES));
        reserve(new Word("/", Tag.DIVIDE));
        reserve(new Word("=", Tag.ASSIGN));

        reserve(new Word("(", Tag.OPEN_PARENTHESIS));
        reserve(new Word(")", Tag.CLOSE_PARENTHESIS));
        reserve(new Word("{", Tag.OPEN_BRACE));
        reserve(new Word("}", Tag.CLOSE_BRACE));
        reserve(new Word("[", Tag.OPEN_BRACKET));
        reserve(new Word("]", Tag.CLOSE_BRACKET));
        reserve(new Word(";", Tag.SEMICOLON));
        reserve(new Word(",", Tag.COMMA));
        reserve(new Word(".", Tag.DOT));
        reserve(new Word("\"", Tag.QUOTE));
    }

    private void readch() throws IOException {
        peek = (char) file.read();
    }

    private boolean readch(char c) throws IOException {
        readch();
        if (peek != c)
            return false;
        peek = ' ';
        return true;
    }

    public Token scan() throws IOException {

        // DELIMITADORES
        for (;; readch()) {
            if (peek == ' ' || peek == '\t' || peek == '\r')
                continue;
            else if (peek == '\n')
                line++;
            else
                break;
        }

        // OPERADORES
        switch (peek) {
            case '=':
                if (readch('='))
                    return Word.equals;
                else
                    return new Token('=');
            case '<':
                if (readch('='))
                    return Word.less_equal;
                else if (readch('>'))
                    return Word.different;
                else
                    return new Token('<');
            case '>':
                if (readch('='))
                    return Word.greater_equal;
                else
                    return new Token('>');
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
        }

        // NUMEROS
        if (Character.isDigit(peek)) {
            int value = 0;
            do {
                value = 10 * value + Character.digit(peek, 10);
                readch();
            } while (Character.isDigit(peek));
            if (peek != '.')
                return new IntegerLiteral(value);
            else
                readch();
            float valuef = value;
            float decUnit = 10;
            do {
                valuef = valuef + Character.digit(peek, 10) / decUnit;
                decUnit = decUnit * 10;
                readch();
            } while (Character.isDigit(peek));
            return new FloatLiteral(valuef);
        }

        // PALAVRAS
        if (Character.isLetter(peek)) {
            StringBuffer b = new StringBuffer();
            do {
                b.append(peek);
                readch();
            } while (Character.isLetterOrDigit(peek));
            String s = b.toString();
            Word w = (Word) words.get(s);
            if (w != null)
                return w;
            // w = new Word(s, Tag.ID);
            w = new Word(s, 0);
            words.put(s, w);
            return w;
        }

        // OUTROS
        Token t = new Token(peek);
        peek = ' ';
        return t;
    }
}
