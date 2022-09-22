package lexico.tokens;

public class _Float extends Token {
    public final float value;

    public _Float(float value) {
        super(Tag._FLOAT_LIT);
        this.value = value;
    }

    public String toString() {
        return "<" + value + ", " + (char) tag + ">";
    }
}