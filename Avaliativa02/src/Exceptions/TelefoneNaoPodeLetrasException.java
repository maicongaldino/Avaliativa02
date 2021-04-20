package Exceptions;

public class TelefoneNaoPodeLetrasException extends Exception {
    private static final long serialVersionUID = 1L;

    public TelefoneNaoPodeLetrasException() {
        super("Telefone não pode conter letras !!!");
    }

    public TelefoneNaoPodeLetrasException(String menssagem) {
        super(menssagem);
    }
}