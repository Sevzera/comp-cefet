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
            System.out.println("\n\nCompilado com sucesso!");
            System.out.println("\nTipos -> 1: int, 2: float, 3: string\n");
            System.out.println("Identificadores na tabela de símbolos:");
            for (Map.Entry<String, Word> entry : Globals.symbolTable.entrySet()) {
                String key = entry.getKey();
                Word word = entry.getValue();

                if (word.value != null) {
                    System.out.println(key + ", tipo: " + word.type + ", valor: " + word.value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}