
package lexico.tokens;

public class LiteralString extends Token {
    public final String value;

    public LiteralString(String value) {
        super(Tag.LIT_STRING);
        this.value = value;
    }

    public String toString() {
        return "<" + value + ", " + tag + ">";
    }
}