package Classes;

import Exceptions.NomeNaoPodeLetraException;
import Exceptions.NumerosInsuficientesTelefone;
import Exceptions.TelefoneNaoPodeLetrasException;

public class Contatos {
    private String nome;
    private String telefone;
    private int codigo;

    public Contatos(String nome, String telefone, int codigo) throws NomeNaoPodeLetraException, NumerosInsuficientesTelefone, TelefoneNaoPodeLetrasException {
        setNome(nome);
        setTelefone(telefone);
        setCodigo(codigo);
    }

    //region Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) throws NomeNaoPodeLetraException {
        if (nome.matches(".*[A-Za-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÍÏÓÔÕÖÚÇÑ].\\s*"))
        {
            this.nome = nome;
        }
        else
        {
            throw new NomeNaoPodeLetraException();
        }
    }
    public String getTelefone() {
        return formataTelefone(telefone);
    }
    public void setTelefone(String telefone) throws NumerosInsuficientesTelefone, TelefoneNaoPodeLetrasException {
        telefone = telefone.trim().replace(" ", "").replace(".", "").replace("-", "").replace("(", "").replace(")", "");

        if (telefone.matches(".*[a-zA-Z]+.*"))
        {
            throw new TelefoneNaoPodeLetrasException();
        }
        else
        {
            if (telefone.length() == 8 || telefone.length() == 9 || telefone.length() == 11 || telefone.length() == 12)
            {
                this.telefone = telefone; 
            }
            else
            {
                throw new NumerosInsuficientesTelefone();
            }
        }
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getTestarTelefone() {
        return telefone;
    }
    //endregion

    private String formataTelefone(String telefone) {
        if (this.telefone.length() == 12)
        {
            telefone = telefone.replaceAll("(\\d{2})(\\d{4})(\\d{4})", "($1) $2-$3");
            return telefone;
        }
        else
        {
            if (this.telefone.length() == 11)
            {
                telefone = telefone.replaceAll("(\\d{2})(\\d{5})(\\d{4})", "($1)-$2-$3");
                return telefone;
            }
            else
            {
                if (this.telefone.length() == 9)
                {
                    telefone = telefone.replaceAll("(\\d{5})(\\d{4})", "$1-$2");
                    return telefone;
                }
                else
                {
                    if (this.telefone.length() == 8)
                    {
                        telefone = telefone.replaceAll("(\\d{4})(\\d{4})", "$1-$2");
                        return telefone;
                    }
                }
            }
        }
        return telefone;
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome + "\nTelefone: " + formataTelefone(telefone) + "\nCodigo: " + codigo;
    }
}