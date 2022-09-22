import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Lexer lex = new Lexer("comp_v1_sev\\frontend\\lexico\\teste.txt");
            while (true) {
                Token tok = lex.scan();
                System.out.println(tok);
                if (tok.tag == Tag.EOF)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}