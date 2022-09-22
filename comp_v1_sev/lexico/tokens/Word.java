package lexico.tokens;

public class Word extends Token {
    private String lexeme = "";
    public static final Word start = new Word("start", Tag.START);
    public static final Word exit = new Word("exit", Tag.EXIT);
    public static final Word end = new Word("end", Tag.END);
    public static final Word _if = new Word("if", Tag.IF);
    public static final Word then = new Word("then", Tag.THEN);
    public static final Word _else = new Word("else", Tag.ELSE);
    public static final Word _do = new Word("do", Tag.DO);
    public static final Word _while = new Word("while", Tag.WHILE);
    public static final Word scan = new Word("scan", Tag.SCAN);
    public static final Word print = new Word("print", Tag.PRINT);
    public static final Word semi = new Word(";", Tag.SEMI);
    public static final Word colon = new Word(",", Tag.COLON);
    public static final Word dot = new Word(".", Tag.DOT);
    public static final Word opar = new Word("(", Tag.OPAR);
    public static final Word cpar = new Word(")", Tag.CPAR);
    public static final Word obra = new Word("{", Tag.OBRA);
    public static final Word cbra = new Word("}", Tag.CBRA);
    public static final Word and = new Word("&&", Tag.OP_AND);
    public static final Word or = new Word("||", Tag.OP_OR);
    public static final Word not = new Word("!", Tag.OP_NOT);
    public static final Word add = new Word("+", Tag.OP_ADD);
    public static final Word sub = new Word("-", Tag.OP_SUB);
    public static final Word mul = new Word("*", Tag.OP_MUL);
    public static final Word div = new Word("/", Tag.OP_DIV);
    public static final Word asg = new Word("=", Tag.OP_ASG);
    public static final Word gt = new Word(">", Tag.OP_GT);
    public static final Word ge = new Word(">=", Tag.OP_GE);
    public static final Word lt = new Word("<", Tag.OP_LT);
    public static final Word le = new Word("<=", Tag.OP_LE);
    public static final Word df = new Word("<>", Tag.OP_DF);
    public static final Word eq = new Word("==", Tag.OP_EQ);
    public static final Word _int = new Word("int", Tag._INT);
    public static final Word _float = new Word("float", Tag._FLOAT);
    public static final Word _string = new Word("string", Tag._STRING);

    public Word(String s, int tag) {
        super(tag);
        lexeme = s;
    }

    public String getLexeme() {
        return lexeme;
    }

    public String toString() {
        return "<" + lexeme + ", " + (char) tag + ">";
    }
}
