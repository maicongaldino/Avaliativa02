package Comparadores;

import Classes.Contatos;
import java.util.Comparator;

public class OrdemCodigo implements Comparator<Contatos> {

    @Override
    public int compare(Contatos c1, Contatos c2) {
        return Integer.compare(c1.getCodigo(), c2.getCodigo());
    }
}