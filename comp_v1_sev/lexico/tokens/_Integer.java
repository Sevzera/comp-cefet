package lexico.tokens;

public class _Integer extends Token {
    public final int value;

    public _Integer(int value) {
        super(Tag._INT_LIT);
        this.value = value;
    }

    public String toString() {
        return "<" + value + ", " + (char) tag + ">";
    }
}