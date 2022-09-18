package lexical;

public class Word extends Token {

    private String lexeme = "";

    // RESERVED WORDS, OPERATORS, ETC...
    public final static Word start = new Word("start", Tag.START);
    public final static Word exit = new Word("exit", Tag.EXIT);
    public final static Word _int = new Word("int", Tag.INT);
    public final static Word _float = new Word("float", Tag.FLOAT);
    public final static Word string = new Word("string", Tag.STRING);
    public final static Word _if = new Word("if", Tag.IF);
    public final static Word then = new Word("then", Tag.THEN);
    public final static Word _else = new Word("else", Tag.ELSE);
    public final static Word end = new Word("end", Tag.END);
    public final static Word _do = new Word("do", Tag.DO);
    public final static Word _while = new Word("while", Tag.WHILE);
    public final static Word scan = new Word("scan", Tag.SCAN);
    public final static Word print = new Word("print", Tag.PRINT);

    public final static Word equals = new Word("==", Tag.EQUALS);
    public final static Word greater = new Word(">", Tag.GREATER);
    public final static Word greater_equal = new Word(">=", Tag.GREATER_EQUAL);
    public final static Word less = new Word("<", Tag.LESS);
    public final static Word less_equal = new Word("<=", Tag.LESS_EQUAL);
    public final static Word negation = new Word("!", Tag.NEGATION);
    public final static Word different = new Word("<>", Tag.DIFFERENT);
    public final static Word and = new Word("&&", Tag.AND);
    public final static Word or = new Word("||", Tag.OR);
    public final static Word plus = new Word("+", Tag.PLUS);
    public final static Word minus = new Word("-", Tag.MINUS);
    public final static Word times = new Word("*", Tag.TIMES);
    public final static Word divide = new Word("/", Tag.DIVIDE);
    public final static Word assign = new Word("=", Tag.ASSIGN);

    public final static Word open_parenthesis = new Word("(", Tag.OPEN_PARENTHESIS);
    public final static Word close_parenthesis = new Word(")", Tag.CLOSE_PARENTHESIS);
    public final static Word open_brace = new Word("{", Tag.OPEN_BRACE);
    public final static Word close_brace = new Word("}", Tag.CLOSE_BRACE);
    public final static Word comma = new Word(",", Tag.COMMA);
    public final static Word semicolon = new Word(";", Tag.SEMICOLON);
    public final static Word dot = new Word(".", Tag.DOT);
    public final static Word quote = new Word("\"", Tag.QUOTE);

    public Word(String lexeme, int tag) {
        super(tag);
        this.lexeme = lexeme;
    }

    public String getLexeme() {
        return this.lexeme;
    }

    public String toString() {
        return this.lexeme;
    }
}
