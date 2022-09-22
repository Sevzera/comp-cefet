package tokens;
public class _Float extends Token {
    public final float value;

    public _Float(float value) {
        super(Tag._FLOAT);
        this.value = value;
    }

    public String toString() {
        return "" + value;
    }
}