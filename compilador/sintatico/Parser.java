package sintatico;

import lexico.Lexer;
import lexico.tokens.Token;
import lexico.tokens.Tag;

public class Parser {

    Lexer lexer;
    Token token;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
        advance();
        program();
    }

    void advance() {
        token = lexer.scan(); // lê próximo token
    }

    void eat(int tag) {
        if (token.tag == tag)
            advance();
        else
            error("Syntax error");
    }

    void error(String msg) {
        throw new Error("Error at line " + Lexer.line + ": " + msg);
    }

    void program() {
        eat(RW_START);
    }
}
