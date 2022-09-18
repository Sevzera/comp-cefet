package lexical;

public class Tag {

    // RESERVED WORDS
    public final static int 
        START = 256, EXIT = 257, INT = 258, FLOAT = 259, STRING = 260,
        IF = 261, THEN = 262, ELSE = 263, END = 264, DO = 265,
        WHILE = 266, SCAN = 267, PRINT = 268;

    // OPERATORS
    public final static int 
        EQUALS = 269, GREATER = 270, GREATER_EQUAL = 271, LESS = 272, LESS_EQUAL = 273,
        NEGATION = 274, DIFFERENT = 275, AND = 276, OR = 277,
        PLUS = 278, MINUS = 279, TIMES = 280, DIVIDE = 281, ASSIGN = 282;

    // DELIMITERS
    public final static int 
        OPEN_PARENTHESIS = 283, CLOSE_PARENTHESIS = 284,
        OPEN_BRACE = 285, CLOSE_BRACE = 286,
        OPEN_BRACKET = 287, CLOSE_BRACKET = 288,
        COMMA = 289, SEMICOLON = 290, DOT = 291, QUOTE = 292, EOF = 293;

    // LITERALS
    public final static int INTEGER = 294, FLOATING = 295, STRING_LITERAL = 296, IDENTIFIER = 297;

}