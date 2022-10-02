package lexico.tokens;

public class Word extends Token {
    private String lexeme = "";
    public static final Word start = new Word("start", Tag.RW_START);
    public static final Word exit = new Word("exit", Tag.RW_EXIT);
    public static final Word end = new Word("end", Tag.RW_END);
    public static final Word _if = new Word("if", Tag.RW_IF);
    public static final Word then = new Word("then", Tag.RW_THEN);
    public static final Word _else = new Word("else", Tag.RW_ELSE);
    public static final Word _do = new Word("do", Tag.RW_DO);
    public static final Word _while = new Word("while", Tag.RW_WHILE);
    public static final Word scan = new Word("scan", Tag.RW_SCAN);
    public static final Word print = new Word("print", Tag.RW_PRINT);
    public static final Word semi = new Word(";", Tag.PT_SEMI);
    public static final Word comma = new Word(",", Tag.PT_COMMA);
    public static final Word dot = new Word(".", Tag.PT_DOT);
    public static final Word opar = new Word("(", Tag.PT_OPAR);
    public static final Word cpar = new Word(")", Tag.PT_CPAR);
    public static final Word obra = new Word("{", Tag.PT_OBRA);
    public static final Word cbra = new Word("}", Tag.PT_CBRA);
    public static final Word and = new Word("&&", Tag.RL_AND);
    public static final Word or = new Word("||", Tag.RL_OR);
    public static final Word not = new Word("!", Tag.RL_NOT);
    public static final Word add = new Word("+", Tag.AR_ADD);
    public static final Word sub = new Word("-", Tag.AR_SUB);
    public static final Word mul = new Word("*", Tag.AR_MUL);
    public static final Word div = new Word("/", Tag.AR_DIV);
    public static final Word asg = new Word("=", Tag.AR_ASG);
    public static final Word gt = new Word(">", Tag.CP_GT);
    public static final Word ge = new Word(">=", Tag.CP_GE);
    public static final Word lt = new Word("<", Tag.CP_LT);
    public static final Word le = new Word("<=", Tag.CP_LE);
    public static final Word df = new Word("<>", Tag.CP_DF);
    public static final Word eq = new Word("==", Tag.CP_EQ);
    public static final Word type_int = new Word("int", Tag.TYPE_INT);
    public static final Word type_float = new Word("float", Tag.TYPE_FLOAT);
    public static final Word type_string = new Word("string", Tag.TYPE_STRING);

    public Word(String s, int tag) {
        super(tag);
        lexeme = s;
    }

    public String getLexeme() {
        return lexeme;
    }

    public String toString() {
        return "<" + lexeme + ", " + tag + ">";
    }
}
