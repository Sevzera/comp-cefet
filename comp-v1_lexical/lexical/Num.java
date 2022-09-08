package lexical;
public class Num extends Token {
 
    public final int value;
 
    public Num(int value) {
        super(0);
        // super(Tag.NUM)
        this.value = value;
    }
 
    public String toString() {
        return "" + this.value;
    }
}
