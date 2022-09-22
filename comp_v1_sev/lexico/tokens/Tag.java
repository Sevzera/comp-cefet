package lexico.tokens;

public class Tag {
    public final static int
    // Palavras reservadas
    START = 256,
            EXIT = 257,
            END = 258,
            IF = 259,
            THEN = 260,
            ELSE = 261,
            DO = 262,
            WHILE = 263,
            SCAN = 264,
            PRINT = 265,
            // Pontuação
            SEMI = 266,
            COLON = 267,
            DOT = 268,
            OPAR = 269,
            CPAR = 270,
            OBRA = 271,
            CBRA = 272,
            // Operadores relacionais
            OP_AND = 273,
            OP_OR = 274,
            OP_NOT = 275,
            // Operadores aritmeticos
            OP_ADD = 276,
            OP_SUB = 277,
            OP_MUL = 278,
            OP_DIV = 279,
            OP_ASG = 280,
            // Operadores de comparaca
            OP_GT = 281,
            OP_GE = 282,
            OP_LT = 283,
            OP_LE = 284,
            OP_DF = 285,
            OP_EQ = 286,
            // Tipos
            _INT = 278,
            _FLOAT = 279,
            _STRING = 280,
            // Literais
            _INT_LIT = 281,
            _FLOAT_LIT = 282,
            _STRING_LIT = 283,
            // Identificador
            ID = 284,
            // EOF
            EOF = 285;
}