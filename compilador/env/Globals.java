package env;

import java.util.Hashtable;

import env.tokens.Token;
import env.tokens.Word;

public abstract class Globals {
    public static int line = 1; // contador de linhas
    public static Hashtable<String, Word> symbolTable = new Hashtable<String, Word>(); // tabela de simbolos
    public static Hashtable<Token, Integer> errorTable = new Hashtable<Token, Integer>(); // tabela de erros

    public static void error(String msg, Token t) {
        throw new Error("Error at line " + Globals.line + ": " + msg + "\nError token: " + t.toString());
    }
}
