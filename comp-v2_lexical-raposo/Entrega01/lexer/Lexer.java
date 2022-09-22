/*
    Trabalho   -  Compilador
    Alunos     -  Vitor Brandao Raposo & Fernando Faria Soares 
    Professora -  Kecia Marques Ferreira
*/

package lexer;

public class Lexer {

    LeitorDeArquivosTexto leitor;

    public Lexer(String arquivo) {
        leitor = new LeitorDeArquivosTexto(arquivo);
    }

    public Token proximoToken() {
        Token proximo = null;
        espacosEComentarios();
        leitor.confirmar();
        proximo = end();
        if (proximo == null) {
            leitor.zerar();
        } else {
            leitor.confirmar();
            return proximo;
        }
        proximo = palavrasChave();
        if (proximo == null) {
            leitor.zerar();
        } else {
            leitor.confirmar();
            return proximo;
        }
        proximo = variavel();
        if (proximo == null) {
            leitor.zerar();
        } else {
            leitor.confirmar();
            return proximo;
        }
        proximo = literal();
        if (proximo == null) {
            leitor.zerar();
        } else {
            leitor.confirmar();
            return proximo;
        }
        proximo = numeros();
        if (proximo == null) {
            leitor.zerar();
        } else {
            leitor.confirmar();
            return proximo;
        }
        proximo = operadorAritmetico();
        if (proximo == null) {
            leitor.zerar();
        } else {
            leitor.confirmar();
            return proximo;
        }
        proximo = operadorRelacional();
        if (proximo == null) {
            leitor.zerar();
        } else {
            leitor.confirmar();
            return proximo;
        }
        proximo = virgula();
        if (proximo == null) {
            leitor.zerar();
        } else {
            leitor.confirmar();
            return proximo;
        }
        proximo = delimitador();
        if (proximo == null) {
            leitor.zerar();
        } else {
            leitor.confirmar();
            return proximo;
        }
        proximo = parenteses();
        if (proximo == null) {
            leitor.zerar();
        } else {
            leitor.confirmar();
            return proximo;
        }
        proximo = cadeia();
        if (proximo == null) {
            leitor.zerar();
        } else {
            leitor.confirmar();
            return proximo;
        }
        System.err.println("Erro léxico!");
        System.err.println(leitor.toString());
        return null;
    }

    private void espacosEComentarios() {
        int estado = 1;
        int contador = 0;
        int tempoMaximo = 1000;
        while (true) {
            char c = (char) leitor.lerProximoCaractere();
            if (estado == 1) {
                if (Character.isWhitespace(c) || c == ' ') {
                    estado = 2;
                } else if (c == '/') {
                    estado = 3;
                } else {
                    leitor.retroceder();
                    return;
                }
            } else if (estado == 2) {
                if (c == '/') {
                    estado = 3;
                } else if (!(Character.isWhitespace(c) || c == ' ')) {
                    leitor.retroceder();
                    return;
                }
            } else if (estado == 3) {
                if (c == '/') {
                    estado = 4;
                } else if (c == '*') {
                    estado = 5;
                }
            } else if (estado == 4) {
                if (c == '\n') {
                    estado = 1;
                }
            } else if (estado == 5) {
                if (c == '*') {
                    estado = 6;
                } else if(contador >= tempoMaximo) {
                    System.err.println("Erro léxico! Comentário nao fechado!");
                    return;
                }
                contador++;
            } else if (estado == 6) {
                if (c == '/') {
                    estado = 1;
                } else if(contador >= tempoMaximo) {
                    System.err.println("Erro léxico! Comentário nao fechado!");
                    return;
                }
                contador++;
            }
        }
    }

    private Token operadorAritmetico() {
        int caractereLido = leitor.lerProximoCaractere();
        char c = (char) caractereLido;
        if (c == '*') {
            return new Token(TipoToken.OpAritMult, leitor.getLexema());
        } else if (c == '/') {
            return new Token(TipoToken.OpAritDiv, leitor.getLexema());
        } else if (c == '+') {
            return new Token(TipoToken.OpAritSoma, leitor.getLexema());
        } else if (c == '-') {
            return new Token(TipoToken.OpAritSub, leitor.getLexema());
        } else {
            return null;
        }
    }

    private Token delimitador() {
        int caractereLido = leitor.lerProximoCaractere();
        char c = (char) caractereLido;
        if (c == ';') {
            return new Token(TipoToken.Delim, leitor.getLexema());
        } else {
            return null;
        }
    }

    private Token virgula() {
        int caractereLido = leitor.lerProximoCaractere();
        char c = (char) caractereLido;
        if ((c == ',')) {
            return new Token(TipoToken.Virgula, leitor.getLexema());
        } else {
            return null;
        }
    }

    private Token parenteses() {
        int caractereLido = leitor.lerProximoCaractere();
        char c = (char) caractereLido;
        if (c == '(') {
            return new Token(TipoToken.AbrePar, leitor.getLexema());
        } else if (c == ')') {
            return new Token(TipoToken.FechaPar, leitor.getLexema());
        } else {
            return null;
        }
    }

    private Token operadorRelacional() {
        int caractereLido = leitor.lerProximoCaractere();
        char c = (char) caractereLido;
        if (c == '<') {
            c = (char) leitor.lerProximoCaractere();
            if (c == '>') {
                return new Token(TipoToken.OpRelDif, leitor.getLexema());
            } else if (c == '=') {
                return new Token(TipoToken.OpRelMenorIgual, leitor.getLexema());
            } else {
                leitor.retroceder();
                return new Token(TipoToken.OpRelMenor, leitor.getLexema());
            }
        } else if (c == ':') {
            c = (char) leitor.lerProximoCaractere();
            if (c == '=') {
                return new Token(TipoToken.OpRelAssign, leitor.getLexema());
            }
        } else if (c == '=') {
            return new Token(TipoToken.OpRelIgual, leitor.getLexema());
        } else if (c == '>') {
            c = (char) leitor.lerProximoCaractere();
            if (c == '=') {
                return new Token(TipoToken.OpRelMaiorIgual, leitor.getLexema());
            } else {
                leitor.retroceder();
                return new Token(TipoToken.OpRelMaior, leitor.getLexema());
            }
        } else if (c == '&') {
            if (c == '&') {
                c = (char) leitor.lerProximoCaractere();
                return new Token(TipoToken.OpBoolAnd, leitor.getLexema());
            }
        } else if (c == '|') {
            if (c == '|') {
                c = (char) leitor.lerProximoCaractere();
                return new Token(TipoToken.OpBoolOr, leitor.getLexema());
            }
        } else if (c == '!') {
            return new Token(TipoToken.OpBoolNot, leitor.getLexema());
        }
        return null;
    }

    private Token numeros() {
        int estado = 1;
        while (true) {
            char c = (char) leitor.lerProximoCaractere();
            if (estado == 1) {
                if (Character.isDigit(c)) {
                    estado = 2;
                } else {
                    return null;
                }
            } else if (estado == 2) {
                if (c == '.') {
                    c = (char) leitor.lerProximoCaractere();
                    if (Character.isDigit(c)) {
                        estado = 3;
                    } else {
                        return null;
                    }
                } else if (!Character.isDigit(c)) {
                    leitor.retroceder();
                    return new Token(TipoToken.NumInt, leitor.getLexema());
                }
            } else if (estado == 3) {
                if (!Character.isDigit(c)) {
                    leitor.retroceder();
                    return new Token(TipoToken.NumFloat, leitor.getLexema());
                }
            }
        }
    }

    private Token variavel() {
        int estado = 1;
        while (true) {
            char c = (char) leitor.lerProximoCaractere();
            if (estado == 1) {
                if (Character.isLetter(c)) {
                    estado = 2;
                } else {
                    return null;
                }
            } else if (estado == 2) {
                if (!Character.isLetterOrDigit(c)) {
                    leitor.retroceder();
                    return new Token(TipoToken.Identificador, leitor.getLexema());
                }
            }
        }
    }

    private Token literal() {
        int estado = 1;
        while (true) {
            char c = (char) leitor.lerProximoCaractere();
            if (estado == 1) {
                if (c == '{') {
                    estado = 2;
                } else {
                    return null;
                }
            } else if (estado == 2) {
                if (c == '}') {
                    return new Token(TipoToken.Literal, leitor.getLexema());
                }
            }
        }
    }

    private Token cadeia() {
        int estado = 1;
        while (true) {
            char c = (char) leitor.lerProximoCaractere();
            if (estado == 1) {
                if (c == '\'') {
                    estado = 2;
                } else {
                    return null;
                }
            } else if (estado == 2) {
                if (c == '\n') {
                    return null;
                }
                if (c == '\'') {
                    return new Token(TipoToken.Cadeia, leitor.getLexema());
                } else if (c == '\\') {
                    estado = 3;
                }
            } else if (estado == 3) {
                if (c == '\n') {
                    return null;
                } else {
                    estado = 2;
                }
            }
        }
    }

    private Token palavrasChave() {
        while (true) {
            char c = (char) leitor.lerProximoCaractere();
            if (!Character.isLetter(c)) {
                leitor.retroceder();
                String lexema = leitor.getLexema();
                if (lexema.equals("start")) {
                    return new Token(TipoToken.PCStart, lexema);
                } else if (lexema.equals("start")) {
                    return new Token(TipoToken.PCStart, lexema);
                } else if (lexema.equals("exit")) {
                    return new Token(TipoToken.PCExit, lexema);
                } else if (lexema.equals("int")) {
                    return new Token(TipoToken.PCInt, lexema);
                } else if (lexema.equals("float")) {
                    return new Token(TipoToken.PCFloat, lexema);
                } else if (lexema.equals("string")) {
                    return new Token(TipoToken.PCString, lexema);
                } else if (lexema.equals("if")) {
                    return new Token(TipoToken.PCIf, lexema);
                } else if (lexema.equals("then")) {
                    return new Token(TipoToken.PCThen, lexema);
                } else if (lexema.equals("else")) {
                    return new Token(TipoToken.PCElse, lexema);
                } else if (lexema.equals("end")) {
                    return new Token(TipoToken.PCEnd, lexema);
                } else if (lexema.equals("do")) {
                    return new Token(TipoToken.PCDo, lexema);
                } else if (lexema.equals("while")) {
                    return new Token(TipoToken.PCWhile, lexema);
                } else if (lexema.equals("scan")) {
                    return new Token(TipoToken.PCScan, lexema);
                } else if (lexema.equals("print")) {
                    return new Token(TipoToken.PCPrint, lexema);
                } else {
                    return null;
                }
            }
        }
    }

    private Token end() {
        int caractereLido = leitor.lerProximoCaractere();
        if (caractereLido == -1) {
            return new Token(TipoToken.End, "end");
        }
        return null;
    }
}