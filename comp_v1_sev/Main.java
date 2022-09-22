import java.io.IOException;
import lexico.*;
import lexico.tokens.*;

public class Main {
    public static void main(String[] args) {
        try {
            Lexer lex = new Lexer("tests/test1.txt");
            int i = 0;
            while (i < 80) {
                Token scanned = lex.scan();
                System.out.println(scanned.tag);
                if (scanned.tag == Tag._STRING_LIT) {
                    _String token = (_String) scanned;
                    System.out.println(token);
                } else if (scanned.tag == Tag._INT_LIT) {
                    _Integer token = (_Integer) scanned;
                    System.out.println(token);
                } else if (scanned.tag == Tag._FLOAT_LIT) {
                    _Float token = (_Float) scanned;
                    System.out.println(token);
                } else if (scanned.tag == Tag.EOF) {
                    break;
                } else {
                    System.out.println(scanned);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}