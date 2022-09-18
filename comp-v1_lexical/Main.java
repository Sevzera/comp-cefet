import java.io.IOException;
import lexical.Token;

public class Main {

    public static void main(String[] args) {
        try {
            // args[0] é o primeiro argumento da linha de comando
            CharStream cs = CharStreams.fromFileName(args[0]);
            AlgumaLexer lex = new AlgumaLexer(cs);
            while (lex.nextToken().getType() != Token.EOF) {
                System.out.println("");
            }
        } catch (IOException ex) {
        }
    }

}