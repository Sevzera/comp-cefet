/*
    Trabalho   -  Compilador
    Alunos     -  Vitor Brandao Raposo & Fernando Faria Soares 
    Professora -  Kecia Marques Ferreira
*/

package lexer;

public class Main {
    public static void main(String[] args) {
        Lexer lex = new Lexer(args[0]);
        Token t = null;
        System.out.print("----- TOKENS LIDOS PELO ANALISADOR LEXICO -----\n");
        while((t = lex.proximoToken()).nome != TipoToken.End) {
            System.out.print(t);
            System.out.print('\n');
        }
    }
}
