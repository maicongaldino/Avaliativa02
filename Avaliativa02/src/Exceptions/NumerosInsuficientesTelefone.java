package Exceptions;

public class NumerosInsuficientesTelefone extends Exception {
    private static final long serialVersionUID = 1L;

    public NumerosInsuficientesTelefone() {
        super("Números insuficientes do telefone !!!");
    }

    public NumerosInsuficientesTelefone(String menssagem) {
        super(menssagem);
    }
}