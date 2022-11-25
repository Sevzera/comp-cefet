package semantico;

import env.*;
import env.tokens.Word;

public class Semantic {

    public Semantic() {
    }

    public boolean isDeclared(String lexeme) {
        if (Globals.symbolTable.containsKey(lexeme)) {
            return true;
        }
        return false;
    }

    public boolean areOfEqualTypes(Word w, Word w2) {
        if (w.type == w2.type) {
            return true;
        }
        return false;
    }

    public void appendValue(String lexeme, String value) {
        Word w = Globals.symbolTable.get(lexeme);
        w.value = value;
        Globals.symbolTable.put(lexeme, w);
    }

    public void appendType(String lexeme, int type) {
        Word w = Globals.symbolTable.get(lexeme);
        w.type = type;
        Globals.symbolTable.put(lexeme, w);
    }

    public int getIDType(String lexeme) {
        Word w = Globals.symbolTable.get(lexeme);
        return w.type;
    }

    public String getIDValue(String lexeme) {
        Word w = Globals.symbolTable.get(lexeme);
        return w.value;
    }
}
