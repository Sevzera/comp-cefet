package lexical.literal;

import lexical.*;

public class IntegerLiteral extends Token {

    public final int value;

    public IntegerLiteral(int value) {
        super(Tag.INTEGER);
        this.value = value;
    }

    public String toString() {
        return "" + this.value;
    }
}
