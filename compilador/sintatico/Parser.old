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
        try {
            token = lexer.scan(); // lê próximo token
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void eat(int tag) {
        if (token.tag == tag)
            advance();
        else
            error("Syntax error --> Missing token: " + tag);
    }

    private void error(String msg) {
        throw new Error("Error at line " + Lexer.line + ": " + msg + "\nError token: " + token.toString());
    }

    private void program() {
        System.out.println("program");
        switch (token.tag) {
            case Tag.RW_START:
                eat(Tag.RW_START);
                if (token.tag == Tag.TYPE_INT || token.tag == Tag.TYPE_FLOAT || token.tag == Tag.TYPE_STRING) {
                    decl_list();
                }
                stmt_list();
                eat(Tag.RW_EXIT);
                break;
            default:
                error("Syntax error _program_ --> Missing 'start' keyword at the beginning of the program or invalid token or missing 'exit' keyword at the end of the program");
        }
    }

    private void decl_list() {
        System.out.println("decl_list");
        switch (token.tag) {
            case Tag.TYPE_INT:
            case Tag.TYPE_FLOAT:
            case Tag.TYPE_STRING:
                decl();
                while (token.tag == Tag.TYPE_INT || token.tag == Tag.TYPE_FLOAT || token.tag == Tag.TYPE_STRING) {
                    decl();
                }
                break;
            default:
                error("Syntax error _decl-list_ --> Wrong declaration");
        }
    }

    private void decl() {
        System.out.println("decl");
        switch (token.tag) {
            case Tag.TYPE_INT:
            case Tag.TYPE_FLOAT:
            case Tag.TYPE_STRING:
                type();
                ident_list();
                eat(Tag.PT_SEMI);
                break;
            default:
                error("Syntax error _decl_ --> Missing type declaration or missing semicolon");
        }
    }

    private void ident_list() {
        System.out.println("ident_list");
        switch (token.tag) {
            case Tag.ID:
                identifier();
                while (token.tag == Tag.PT_COMMA) {
                    eat(Tag.PT_COMMA);
                    identifier();
                }
                break;
            default:
                error("Syntax error _ident-list_ --> Missing identifier or missing comma");
        }
    }

    private void type() {
        System.out.println("type");
        switch (token.tag) {
            case Tag.TYPE_INT:
                eat(Tag.TYPE_INT);
                break;
            case Tag.TYPE_FLOAT:
                eat(Tag.TYPE_FLOAT);
                break;
            case Tag.TYPE_STRING:
                eat(Tag.TYPE_STRING);
                break;
            default:
                error("Syntax error _type_ --> Missing type declaration (int, float or string)");
        }
    }

    private void stmt_list() {
        System.out.println("stmt_list");
        switch (token.tag) {
            case Tag.ID:
            case Tag.RW_IF:
            case Tag.RW_DO:
            case Tag.RW_SCAN:
            case Tag.RW_PRINT:
                stmt();
                while (token.tag == Tag.ID || token.tag == Tag.RW_IF || token.tag == Tag.RW_DO
                        || token.tag == Tag.RW_SCAN || token.tag == Tag.RW_PRINT) {
                    stmt();
                    System.out.println("\n");
                }
                break;
            default:
                error("Syntax error _stmt-list_ --> Missing statement");
        }
    }

    private void stmt() {
        System.out.println("stmt");
        switch (token.tag) {
            case Tag.ID:
                assign_stmt();
                eat(Tag.PT_SEMI);
                break;
            case Tag.RW_IF:
                if_stmt();
                break;
            case Tag.RW_DO:
                while_stmt();
                break;
            case Tag.RW_SCAN:
                read_stmt();
                eat(Tag.PT_SEMI);
                break;
            case Tag.RW_PRINT:
                write_stmt();
                eat(Tag.PT_SEMI);
                break;
            default:
                error("Syntax error _stmt_ --> Missing statement (if, do, scan, print) or identifier");
        }
    }

    private void assign_stmt() {
        System.out.println("assign_stmt");
        switch (token.tag) {
            case Tag.ID:
                identifier();
                eat(Tag.AR_ASG);
                simple_expression();
                break;
            default:
                error("Syntax error _assign-stmt_ --> Missing identifier or missing assignment operator");
        }
    }

    private void if_stmt() {
        System.out.println("if_stmt");
        switch (token.tag) {
            case Tag.RW_IF:
                eat(Tag.RW_IF);
                condition();
                eat(Tag.RW_THEN);
                stmt_list();
                if_stmt_tail();
                eat(Tag.RW_END);
                break;
            default:
                error("Syntax error _if-stmt_ --> Missing 'if' keyword or missing 'then' keyword or missing 'end' keyword");
        }
    }

    private void if_stmt_tail() {
        System.out.println("if_stmt_tail");
        switch (token.tag) {
            case Tag.RW_ELSE:
                eat(Tag.RW_ELSE);
                stmt_list();
                break;
            case Tag.RW_END:
                break;
            default:
                error("Syntax error _if-stmt-tail_ --> Missing 'else' keyword or missing 'end' keyword");
        }
    }

    private void condition() {
        System.out.println("condition");
        switch (token.tag) {
            case Tag.ID:
            case Tag.LIT_INT:
            case Tag.LIT_FLOAT:
            case Tag.PT_OBRA:
            case Tag.PT_OPAR:
            case Tag.RL_NOT:
            case Tag.AR_SUB:
                expression();
                break;
            default:
                error("Syntax error _condition_ --> Missing identifier or literal or parenthesis or '!' or '-'");
        }
    }

    private void while_stmt() {
        System.out.println("while_stmt");
        switch (token.tag) {
            case Tag.RW_DO:
                eat(Tag.RW_DO);
                stmt_list();
                stmt_sufix();
                break;
            default:
                error("Syntax error _while-stmt_ --> Missing 'do' keyword");
        }
    }

    private void stmt_sufix() {
        System.out.println("stmt_sufix");
        switch (token.tag) {
            case Tag.RW_WHILE:
                eat(Tag.RW_WHILE);
                condition();
                eat(Tag.RW_END);
                break;
            default:
                error("Syntax error _stmt-sufix_ --> Missing 'while' keyword or missing 'end' keyword");
        }
    }

    private void read_stmt() {
        System.out.println("read_stmt");
        switch (token.tag) {
            case Tag.RW_SCAN:
                eat(Tag.RW_SCAN);
                eat(Tag.PT_OPAR);
                identifier();
                eat(Tag.PT_CPAR);
                break;
            default:
                error("Syntax error _read-stmt_ --> Missing 'scan' keyword or missing parenthesis");
        }
    }

    private void write_stmt() {
        System.out.println("write_stmt");
        switch (token.tag) {
            case Tag.RW_PRINT:
                eat(Tag.RW_PRINT);
                eat(Tag.PT_OPAR);
                writable();
                eat(Tag.PT_CPAR);
                break;
            default:
                error("Syntax error _write-stmt_ --> Missing 'print' keyword or missing parenthesis");
        }
    }

    private void writable() {
        System.out.println("writable");
        switch (token.tag) {
            case Tag.ID:
            case Tag.LIT_INT:
            case Tag.LIT_FLOAT:
            case Tag.PT_OBRA:
            case Tag.PT_OPAR:
            case Tag.RL_NOT:
            case Tag.AR_SUB:
                simple_expression();
                break;
            // case Tag.PT_OBRA:
            // literal();
            // break;
            default:
                error("Syntax error _writable_ --> Missing identifier or literal or constant or parenthesis or '!' or '-' or '{'");
        }
    }

    private void expression() {
        System.out.println("expression");
        switch (token.tag) {
            case Tag.ID:
            case Tag.LIT_INT:
            case Tag.LIT_FLOAT:
            case Tag.PT_OBRA:
            case Tag.PT_OPAR:
            case Tag.RL_NOT:
            case Tag.AR_SUB:
                simple_expression();
                expression_tail();
                break;
            default:
                error("Syntax error _expression_ --> Missing identifier or literal or constant or parenthesis or '!' or '-'");
        }
    }

    private void expression_tail() {
        System.out.println("expression_tail");
        switch (token.tag) {
            case Tag.CP_DF:
            case Tag.CP_EQ:
            case Tag.CP_GE:
            case Tag.CP_GT:
            case Tag.CP_LE:
            case Tag.CP_LT:
                relop();
                simple_expression();
                break;
            case Tag.RW_THEN:
            case Tag.RW_END:
            case Tag.PT_CPAR:
                break;
            default:
                error("Syntax error _expression-tail_ --> Missing relational operator or missing 'then' keyword or missing 'end' keyword or missing parenthesis");
        }
    }

    private void simple_expression() {
        System.out.println("simple_expression");
        switch (token.tag) {
            case Tag.ID:
            case Tag.LIT_INT:
            case Tag.LIT_FLOAT:
            case Tag.PT_OBRA:
            case Tag.PT_OPAR:
            case Tag.RL_NOT:
            case Tag.AR_SUB:
                term();
                simple_expression_tail();
                break;
            default:
                error("Syntax error _simple-expression_ --> Missing identifier or literal or constant or parenthesis or '!' or '-'");
        }
    }

    private void simple_expression_tail() {
        System.out.println("simple_expression_tail");
        switch (token.tag) {
            case Tag.AR_ADD:
            case Tag.AR_SUB:
            case Tag.RL_OR:
                addop();
                term();
                if (Tag.AR_ADD == token.tag || Tag.AR_SUB == token.tag || Tag.RL_OR == token.tag
                        || Tag.CP_DF == token.tag ||
                        Tag.CP_EQ == token.tag || Tag.CP_GE == token.tag || Tag.CP_GT == token.tag
                        || Tag.CP_LE == token.tag ||
                        Tag.CP_LT == token.tag || Tag.PT_CPAR == token.tag || Tag.PT_SEMI == token.tag
                        || Tag.AR_MUL == token.tag || Tag.AR_DIV == token.tag || Tag.RL_AND == token.tag) {
                    simple_expression_tail();
                }
                break;
            case Tag.CP_DF:
            case Tag.CP_EQ:
            case Tag.CP_GE:
            case Tag.CP_GT:
            case Tag.CP_LE:
            case Tag.CP_LT:
            case Tag.AR_MUL:
            case Tag.AR_DIV:
            case Tag.RL_AND:
            case Tag.RW_THEN:
            case Tag.PT_CPAR:
            case Tag.PT_SEMI:
                break;
            default:
                error("Syntax error _simple-expression-tail_ --> Missing additive operator or missing relational operator '||' or missing parenthesis");
        }
    }

    private void term() {
        System.out.println("term");
        switch (token.tag) {
            case Tag.ID:
            case Tag.LIT_INT:
            case Tag.LIT_FLOAT:
            case Tag.PT_OBRA:
            case Tag.PT_OPAR:
            case Tag.RL_NOT:
            case Tag.AR_SUB:
                factor_a();
                term_tail();
                break;
            default:
                error("Syntax error _term_ --> Missing identifier or literal or constant or parenthesis or '!' or '-'");
        }
    }

    private void term_tail() {
        System.out.println("term_tail");
        switch (token.tag) {
            case Tag.AR_MUL:
            case Tag.AR_DIV:
            case Tag.RL_AND:
                mulop();
                factor_a();
                if (Tag.AR_MUL == token.tag || Tag.AR_DIV == token.tag || Tag.RL_AND == token.tag
                        || Tag.AR_ADD == token.tag ||
                        Tag.AR_SUB == token.tag || Tag.RL_OR == token.tag || Tag.PT_SEMI == token.tag) {
                    term_tail();
                }
                break;
            case Tag.AR_ADD:
            case Tag.AR_SUB:
            case Tag.RL_OR:
            case Tag.CP_DF:
            case Tag.CP_EQ:
            case Tag.CP_GE:
            case Tag.CP_GT:
            case Tag.CP_LE:
            case Tag.CP_LT:
            case Tag.RW_THEN:
            case Tag.PT_CPAR:
            case Tag.PT_SEMI:
                break;
            default:
                error("Syntax error _term-tail_ --> Missing multiplicative operator or missing additive operator or missing relational operator '||'");
        }
    }

    private void factor_a() {
        System.out.println("factor_a");
        switch (token.tag) {
            case Tag.ID:
            case Tag.LIT_INT:
            case Tag.LIT_FLOAT:
            case Tag.PT_OBRA:
            case Tag.PT_OPAR:
                factor();
                break;
            case Tag.RL_NOT:
                eat(token.tag);
                factor();
                break;
            case Tag.AR_SUB:
                eat(token.tag);
                factor();
                break;
            default:
                error("Syntax error _factor-a_ --> Missing identifier or literal or constant or parenthesis or '!' or '-'");
        }
    }

    private void factor() {
        System.out.println("factor");
        switch (token.tag) {
            case Tag.ID:
                identifier();
                break;
            case Tag.LIT_INT:
            case Tag.LIT_FLOAT:
            case Tag.PT_OBRA:
                constant();
                break;
            case Tag.PT_OPAR:
                eat(Tag.PT_OPAR);
                expression();
                eat(Tag.PT_CPAR);
                break;
            default:
                error("Syntax error _factor_ --> Missing identifier or constant or parenthesis");
        }
    }

    private void relop() {
        System.out.println("relop");
        switch (token.tag) {
            case Tag.CP_DF:
                eat(Tag.CP_DF);
                break;
            case Tag.CP_EQ:
                eat(Tag.CP_EQ);
                break;
            case Tag.CP_GE:
                eat(Tag.CP_GE);
                break;
            case Tag.CP_GT:
                eat(Tag.CP_GT);
                break;
            case Tag.CP_LE:
                eat(Tag.CP_LE);
                break;
            case Tag.CP_LT:
                eat(Tag.CP_LT);
                break;
            default:
                error("Syntax error _relop_ --> Missing relational operator");
        }
    }

    private void addop() {
        System.out.println("addop");
        switch (token.tag) {
            case Tag.AR_ADD:
                eat(Tag.AR_ADD);
                break;
            case Tag.AR_SUB:
                eat(Tag.AR_SUB);
                break;
            case Tag.RL_OR:
                eat(Tag.RL_OR);
                break;
            default:
                error("Syntax error _addop_ --> Missing additive operator or missing relational operator '||'");
        }
    }

    private void mulop() {
        System.out.println("mulop");
        switch (token.tag) {
            case Tag.AR_MUL:
                eat(Tag.AR_MUL);
                break;
            case Tag.AR_DIV:
                eat(Tag.AR_DIV);
                break;
            case Tag.RL_AND:
                eat(Tag.RL_AND);
                break;
            default:
                error("Syntax error _mulop_ --> Missing multiplicative operator or missing relational operator '&&'");
        }
    }

    private void constant() {
        System.out.println("constant");
        switch (token.tag) {
            case Tag.LIT_INT:
                integer_const();
                break;
            case Tag.LIT_FLOAT:
                float_const();
                break;
            case Tag.PT_OBRA:
                literal();
                break;
            default:
                error("Syntax error _constant_ --> Missing integer or float constant");
        }
    }

    private void integer_const() {
        System.out.println("integer_const");
        switch (token.tag) {
            case Tag.LIT_INT:
                eat(Tag.LIT_INT);
                break;
            default:
                error("Syntax error _integer-const_ --> Missing integer constant");
        }
    }

    private void float_const() {
        System.out.println("float_const");
        switch (token.tag) {
            case Tag.LIT_FLOAT:
                eat(Tag.LIT_FLOAT);
                break;
            default:
                error("Syntax error _float-const_ --> Missing float constant");
        }
    }

    private void literal() {
        System.out.println("literal");
        switch (token.tag) {
            case Tag.PT_OBRA:
                eat(Tag.PT_OBRA);
                eat(Tag.LIT_STRING);
                eat(Tag.PT_CBRA);
                break;
            default:
                error("Syntax error _literal_ --> Missing '{' or missing string literal or missing '}'");
        }
    }

    private void identifier() {
        System.out.println("identifier");
        switch (token.tag) {
            case Tag.ID:
                eat(Tag.ID);
                break;
            default:
                error("Syntax error _identifier_ --> Missing identifier");
        }
    }

}
