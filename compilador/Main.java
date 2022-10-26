import java.io.IOException;
import java.util.Set;

import lexico.Lexer;
import lexico.tokens.*;
import sintatico.Parser;

public class Main {
    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer("testes/" + args[0] + ".txt");
            Parser parser = new Parser(lexer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}