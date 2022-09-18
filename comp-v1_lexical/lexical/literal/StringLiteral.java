package lexical.literal;

import lexical.*;

public class StringLiteral extends Token {

    public final String value;

    public StringLiteral(String value) {
        super(Tag.STRING_LITERAL);
        this.value = value;
    }

    public String toString() {
        return "" + this.value;
    }
}
