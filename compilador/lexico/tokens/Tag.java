package lexico.tokens;

public class Tag {
    public final static int
    // Palavras reservadas
    RW_START = 256, RW_EXIT = 257, RW_END = 258, RW_IF = 259, RW_THEN = 260, RW_ELSE = 261, RW_DO = 262, RW_WHILE = 263,
            RW_SCAN = 264, RW_PRINT = 265;

    public final static int
    // Pontuação
    PT_SEMI = 266, PT_COMMA = 267, PT_DOT = 268, PT_OPAR = 269, PT_CPAR = 270, PT_OBRA = 271, PT_CBRA = 272;

    public final static int
    // Operadores relacionais
    RL_AND = 273, RL_OR = 274, RL_NOT = 275;

    public final static int
    // Operadores aritmeticos
    AR_ADD = 276, AR_SUB = 277, AR_MUL = 278, AR_DIV = 279, AR_ASG = 280;

    public final static int
    // Operadores de comparacao
    CP_GT = 281, CP_GE = 282, CP_LT = 283, CP_LE = 284, CP_DF = 285, CP_EQ = 286;

    public final static int
    // Tipos
    TYPE_INT = 287, TYPE_FLOAT = 288, TYPE_STRING = 289;

    public final static int
    // Literais
    LIT_INT = 290, LIT_FLOAT = 291, LIT_STRING = 292;

    public final static int
    // Identificador
    ID = 293;

    public final static int
    // EOF
    EOF = 65535;
}