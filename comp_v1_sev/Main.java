import java.io.IOException;
import lexico.*;
import lexico.tokens.*;

public class Main {
    public static void main(String[] args) {
        try {
            Lexer lex = new Lexer("tests/test1.txt");
            int i = 0;
            while (i < 50) {
                Token tok = lex.scan();
                System.out.println(tok);
                i++;
                if (tok.tag == Tag.EOF)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}