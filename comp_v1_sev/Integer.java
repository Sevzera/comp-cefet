public class Integer extends Token {
    public final int value;

    public Integer(int value) {
        super(Tag._INT);
        this.value = value;
    }

    public String toString() {
        return "" + value;
    }
}