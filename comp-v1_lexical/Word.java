public class Word extends Token {
    
    private String lexeme = "";

    // TO-DO -> RESERVED WORDS, OPERATORS, ETC...
    // e.g.
    // public final static Word and = new Word("&&", Tag.AND);
    // public final static Word or = new Word("||", Tag.OR);
    // public final static Word eq = new Word("==", Tag.EQ);

    public Word(String lexeme, int tag) {
        super(tag);
        this.lexeme = lexeme;
    }

    public String getLexeme() {
        return this.lexeme;
    }

    public String toString() {
        return this.lexeme;
    }
}
