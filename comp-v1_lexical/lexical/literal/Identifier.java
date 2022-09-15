package lexical;
public class Identifier extends Token {
 
    public final String value;
 
    public Identifier(String value) {
        super(Tag.IDENTIFIER)
        this.value = value;
    }
 
    public String toString() {
        return "" + this.value;
    }
}
