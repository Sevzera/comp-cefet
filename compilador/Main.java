import java.io.IOException;

import lexico.Lexer;
import sintatico.Parser;

public class Main {
    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer("testes/" + args[0] + ".txt");
            Parser parser = new Parser(lexer);
            parser.start();
            System.out.println("Analise sintatica realizada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}