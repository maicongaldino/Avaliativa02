package Comparadores;
import java.util.Comparator;

import Classes.Contatos;

public class OrdemAlfabetica implements Comparator<Contatos> {
    @Override
    public int compare(Contatos c1, Contatos c2) {
        return c1.getNome().compareTo(c2.getNome());
    }
}