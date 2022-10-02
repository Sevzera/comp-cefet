package lexico.tokens;

public class LiteralInteger extends Token {
    public final int value;

    public LiteralInteger(int value) {
        super(Tag.LIT_INT);
        this.value = value;
    }

    public String toString() {
        return "<" + value + ", " + tag + ">";
    }
}