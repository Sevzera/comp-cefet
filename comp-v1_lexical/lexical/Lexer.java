package lexical;
import java.io.*;
import java.util.*;

public class Lexer {
    
    public static int line = 1;
    private char peek = ' ';
    private FileReader file;
    private Hashtable words = new Hashtable();

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

        // TO-DO -> RESERVE WORDS, OPERATORS, ETC...
        // e.g.
        // reserve(new Word("&&", Tag.AND));
        // reserve(new Word("||", Tag.OR));
        // reserve(new Word("==", Tag.EQ));
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
            //  TO-DO -> SKIP DELIMITERS
            //  e.g.
            // if (peek == ' ' || peek == '\t' || peek == '\r')...
            if (peek == ' ')
                continue;
            else if (peek == '\n')
                line++;
            else
                break;
        }

        // OPERADORES
        switch (peek) {
            // TO-DO -> OPERATORS
            // e.g.
            // case '&':
            //     if (readch('&'))
            //         return Word.and;
            //     else
            //         return new Token('&');
        }

        // NUMEROS
        if (Character.isDigit(peek)) {
            int value = 0;
            do {
                value = 10 * value + Character.digit(peek, 10);
                readch();
            } while (Character.isDigit(peek));
            return new Num(value);
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
