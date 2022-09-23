import java.io.IOException;
import java.util.Set;

import lexico.Lexer;
import lexico.tokens.*;

public class Main {
    public static void main(String[] args) {
        try {
            Lexer lex = new Lexer("testes/test1.txt");
            while (true) {
                Token scanned = lex.scan();
                if (scanned.tag == Tag.LIT_STRING) {
                    LiteralString token = (LiteralString) scanned;
                    System.out.println(token.toString());
                } else if (scanned.tag == Tag.LIT_INT) {
                    LiteralInteger token = (LiteralInteger) scanned;
                    System.out.println(token.toString());
                } else if (scanned.tag == Tag.LIT_FLOAT) {
                    LiteralFloat token = (LiteralFloat) scanned;
                    System.out.println(token.toString());
                } else if (scanned.tag == Tag.EOF) {
                    break;
                } else {
                    System.out.println(scanned.toString());
                }
                System.out.println("----------------");
            }
            System.out.println("SYMBOL TABLE");
            System.out.println("----------------");
            Set<String> lexeme = Lexer.words.keySet();
            for (String l : lexeme) {
                if (Lexer.words.get(l).tag == Tag.ID) {
                    System.out.println("Token: " + Lexer.words.get(l).toString());
                    System.out.println("Lexeme: " + l);
                    System.out.println("----------------");
                }
            }

            System.out.println("ERROR REPORT");
            System.out.println("----------------");
            Set<Token> faultyToken = Lexer.errors.keySet();
            for (Token t : faultyToken) {
                System.out.println(
                        "ERROR: Pattern " + (char) t.tag + " not recognized in line " + Lexer.errors.get(t));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}