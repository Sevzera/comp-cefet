package sintatico;

import lexico.Lexer;
import lexico.tokens.Token;
import lexico.tokens.Tag;

public class Parser {

    private Lexer lexer;
    private Token token;

    public Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    public void start() {
        advance();
        program();
    }

    private void advance() {
        try{
            token = lexer.scan(); // lê próximo token
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void eat(int tag) {
        if (token.tag == tag)
            advance();
        else
            error("Syntax error");
    }

    private void error(String msg) {
        throw new Error("Error at line " + Lexer.line + ": " + msg);
    }

    private void program() {
        switch (token.tag) {
            case Tag.RW_START:
                eat(Tag.RW_START);
                if (token.tag == Tag.LIT_INT || token.tag == Tag.LIT_FLOAT || token.tag == Tag.LIT_STRING) {
                    decl_list();
                }
                stmt_list();
                eat(Tag.RW_EXIT);
                break;
            default:
                error("Syntax error --> Missing 'start' keyword at the beginning of the program or invalid token or missing 'exit' keyword at the end of the program");
        }
    }

    private void decl_list() {
        switch (token.tag) {
            case Tag.LIT_INT:
            case Tag.LIT_FLOAT:
            case Tag.LIT_STRING:
                decl();
                while (token.tag == Tag.LIT_INT || token.tag == Tag.LIT_FLOAT || token.tag == Tag.LIT_STRING) {
                    decl();
                }
                break;
            default:
                error("Syntax error --> Wrong declaration");
        }
    }

    private void decl() {
        switch (token.tag) {
            case Tag.LIT_INT:
            case Tag.LIT_FLOAT:
            case Tag.LIT_STRING:
                type();
                ident_list();
                eat(Tag.PT_SEMI);
                break;
            default:
                error("Syntax error --> Missing type declaration or missing semicolon");
        }
    }

    private void ident_list() {
        switch (token.tag) {
            case Tag.ID:
                identifier();
                while (token.tag == Tag.PT_COMMA) {
                    eat(Tag.PT_COMMA);
                    identifier();
                }
                break;
            default:
                error("Syntax error --> Missing identifier or missing comma");
        }
    }

    private void type () {
        switch (token.tag) {
            case Tag.LIT_INT:
                eat(Tag.LIT_INT);
                break;
            case Tag.LIT_FLOAT:
                eat(Tag.LIT_FLOAT);
                break;
            case Tag.LIT_STRING:
                eat(Tag.LIT_STRING);
                break;
            default:
                error("Syntax error --> Missing type declaration (int, float or string)"); 
        }
    }

    private void stmt_list() {
        switch (token.tag) {
            case Tag.ID:
            case Tag.RW_IF:
            case Tag.RW_DO:
            case Tag.RW_SCAN:
            case Tag.RW_PRINT:
                stmt();
                while (token.tag == Tag.RW_IF || token.tag == Tag.RW_DO || token.tag == Tag.RW_SCAN || token.tag == Tag.RW_PRINT) {
                    stmt();
                }
                break;
            default:
                error("Syntax error --> Missing statement (if, do, scan or print)");
        }
    }

    private void stmt() {
        switch (token.tag) {
            case Tag.ID:
                assign_stmt();
                break;
            case Tag.RW_IF:
                if_stmt();
                break;
            case Tag.RW_DO:
                while_stmt();
                break;
            case Tag.RW_SCAN:
                read_stmt();
                break;
            case Tag.RW_PRINT:
                write_stmt();
                break;
            default:
                error("Syntax error --> Missing statement (if, do, scan or print)");
        }
    }

    private void assign_stmt() {

    }

    private void if_stmt() {

    }

    private void if_stmt_tail() {

    }

    private void condition() {

    }

    private void while_stmt() {

    }

    private void stmt_sufix() {

    }

    private void read_stmt() {

    }

    private void write_stmt() {

    }

    private void writable() {

    }

    private void expression() {

    }

    private void expression_tail() {

    }

    private void simple_expression() {

    }

    private void simple_expression_tail() {

    }

    private void term() {

    }

    private void term_tail() {

    }

    private void factor_a() {

    }

    private void factor() {

    }
    
    private void relop() {

    }

    private void addop() {

    }

    private void mulop() {

    }

    private void constant() {
        
    }

    private void integer_const() {

    }

    private void float_const() {

    }

    private void literal() {

    }

    private void identifier() {

    }

    private void letter() {

    }

    private void digit() {

    }

    private void caractere() {

    }


}
