package lexico.tokens;

public class ID extends Token {
    public final String value;

    public ID(String value) {
        super(Tag.ID);
        this.value = value;
    }

    public String toString() {
        return "" + value;
    }
}