import java.io.IOException;
import java.util.*;

import env.Globals;
import lexico.Lexer;
import semantico.Semantic;
import sintatico.Parser;
import env.tokens.*;

public class Main {
    public static void main(String[] args) {
        try {
            Lexer lexer = new Lexer("testes/" + args[0] + ".txt");
            Semantic semantic = new Semantic();
            Parser parser = new Parser(lexer, semantic);
            parser.start();
            for (Map.Entry<String, Word> entry : Globals.symbolTable.entrySet()) {
                String key = entry.getKey();
                Word word = entry.getValue();

                if (word.value != null) {
                    System.out.println(key + " = " + word.value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}