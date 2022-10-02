package lexico.tokens;

public class LiteralFloat extends Token {
    public final float value;

    public LiteralFloat(float value) {
        super(Tag.LIT_FLOAT);
        this.value = value;
    }

    public String toString() {
        return "<" + value + ", " + tag + ">";
    }
}