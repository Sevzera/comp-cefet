/*
    Trabalho   -  Compilador
    Alunos     -  Vitor Brandao Raposo & Fernando Faria Soares 
    Professora -  Kecia Marques Ferreira
*/

package lexer;

public enum TipoToken {

    PCStart,
    PCExit, 
    PCInt, 
    PCFloat, 
    PCString,
    PCIf, 
    PCThen,
    PCElse,
    PCEnd, 
    PCDo,
    PCWhile,
    PCScan,
    PCPrint, 
    OpAritMult, 
    OpAritDiv, 
    OpAritSoma, 
    OpAritSub, 
    OpRelMenor, 
    OpRelMenorIgual, 
    OpRelMaior, 
    OpRelMaiorIgual, 
    OpRelIgual,
    OpRelAssign, 
    OpRelDif, 
    OpBoolAnd, 
    OpBoolOr, 
    OpBoolNot,
    Delim,
    Virgula,
    AbrePar, 
    FechaPar,
    Aspas, 
    Identificador,
    Literal, 
    NumInt, 
    NumFloat, 
    Cadeia, 
    End
}
