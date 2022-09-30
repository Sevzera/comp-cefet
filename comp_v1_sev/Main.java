import java.io.IOException;
import java.util.Set;

import lexico.Lexer;
import lexico.tokens.*;

public class Main {
    public static void main(String[] args) {
        try {
            Lexer lex = new Lexer("testes/" + args[0] + ".txt");
            float i = 0;
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------");
            System.out.println("TOKENS");
            System.out.println("------");
            while (true) {
                Token scanned = lex.scan();
                if (scanned.tag == Tag.LIT_STRING) {
                    LiteralString token = (LiteralString) scanned;
                    System.out.print(token.toString());
                } else if (scanned.tag == Tag.LIT_INT) {
                    LiteralInteger token = (LiteralInteger) scanned;
                    System.out.print(token.toString());
                } else if (scanned.tag == Tag.LIT_FLOAT) {
                    LiteralFloat token = (LiteralFloat) scanned;
                    System.out.print(token.toString());
                } else if (scanned.tag == Tag.EOF) {
                    break;
                } else {
                    System.out.print(scanned.toString());
                }
                if (i == 6) {
                    i = 0;
                    System.out.println();
                } else {
                    i++;
                    System.out.print("   ");
                }
            }
            i = 0;
            System.out.println();
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------");
            System.out.println("SYMBOL TABLE");
            System.out.println("------------");
            Set<String> lexeme = Lexer.words.keySet();
            for (String l : lexeme) {
                System.out.print("[Token: " + Lexer.words.get(l).toString() + ", Lexeme: " + l + "]   ");
                if (i == 3) {
                    i = 0;
                    System.out.println();
                } else {
                    i++;
                }
            }
            i = 0;
            System.out.println();
            System.out.println(
                    "-------------------------------------------------------------------------------------------------------------------");

            Set<Token> faultyToken = Lexer.errors.keySet();
            if (faultyToken.size() > 0) {
                System.out.println("ERROR REPORT");
                System.out.println("------------");
                for (Token t : faultyToken) {
                    System.out.print(
                            "ERROR: Pattern " + (char) t.tag + " not recognized in line " + Lexer.errors.get(t));
                    System.out.println();
                }
            } else
                System.out.println("Compilation successful!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}