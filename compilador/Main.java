import java.io.IOException;

import env.Globals;
import lexico.Lexer;
import semantico.Semantic;
import sintatico.Parser;

public class Main {
    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer("testes/" + args[0] + ".txt");
            Semantic semantic = new Semantic();
            Parser parser = new Parser(lexer, semantic);
            parser.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}