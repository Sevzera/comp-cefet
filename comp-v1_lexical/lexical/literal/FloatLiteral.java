
package lexical.literal;

import lexical.*;

public class FloatLiteral extends Token {

    public final float value;

    public FloatLiteral(float value) {
        super(Tag.FLOATING);
        this.value = value;
    }

    public String toString() {
        return "" + this.value;
    }
}
