package Exceptions;

public class NomeNaoPodeLetraException extends Exception {
    private static final long serialVersionUID = 1L;

    public NomeNaoPodeLetraException() {
        super("O nome não pode conter números !!!");
    }

    public NomeNaoPodeLetraException(String menssagem) {
        super(menssagem);
    }
}