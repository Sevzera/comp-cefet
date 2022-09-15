package lexical;
public class StringLiteral extends Token {
 
    public final String value;
 
    public Integer(String value) {
        super(Tag.STRING_LITERAL)
        this.value = value;
    }
 
    public String toString() {
        return "" + this.value;
    }
}
