package symbols;

public class Id {

    public final String name;
    public final int type;
    public int offset;

    public Id(String name, int type, int offset) {
        this.name = name;
        this.type = type;
        this.offset = offset;
    }

    public String toString() {
        return this.name;
    }
}
