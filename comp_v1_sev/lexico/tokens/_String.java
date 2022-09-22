
package lexico.tokens;

public class _String extends Token {
    public final String value;

    public _String(String value) {
        super(Tag._STRING_LIT);
        this.value = value;
    }

    public String toString() {
        return "<" + value + ", " + (char) tag + ">";
    }
}