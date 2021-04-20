package Programa;

import Classes.Contatos;
import Comparadores.OrdemAlfabetica;
import Comparadores.OrdemCodigo;
import Exceptions.NomeNaoPodeLetraException;
import Exceptions.NumerosInsuficientesTelefone;
import Exceptions.TelefoneNaoPodeLetrasException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AtividadeAvali2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner ler = new Scanner(System.in);
        
        List<Contatos> listaContatos = new ArrayList<>();
        
        boolean achei;
        int opcao;
        
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

        do
        {
            System.out.println("\n1  --  Cadastrar contatos");
            System.out.println("2  --  Exibir contatos cadastrados");
            System.out.println("3  --  Localizar contato por código");
            System.out.println("4  --  Localizar contato por nome");
            System.out.println("5  --  Excluir contato");
            System.out.printf("0  --  Sair\n-->\t");
            opcao = ler.nextInt();
            ler.nextLine();
            
            switch (opcao)
            {
                case 1:
                    int loop = -1;
                    while (loop != 0)
                    {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.printf("\nDigite o nome que deseja adicionar na lista de contatos (\"SAIR\" para encerrar programa):\n-->\t");
                        String nomeAdicionar = ler.nextLine();
                        if (nomeAdicionar.equalsIgnoreCase("SAIR"))
                        {
                            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                            break;
                        }
                        else
                        {
                            System.out.printf("Digite o telefone que deseja adicionar na lista de contatos:\n-->\t");
                            String telefoneAdicionar = ler.nextLine();
                            System.out.printf("Digite o código que deseja adicionar na lista de contatos:\n-->\t");
                            int codigoAdicionar = ler.nextInt();
                            boolean acheiNome = false;
                            boolean acheiTelefone = false;
                            boolean acheiCodigo = false;
                            ler.nextLine();
                            for (Contatos c : listaContatos)
                            {
                                if (c.getNome().equalsIgnoreCase(nomeAdicionar))
                                {
                                    acheiNome = true;
                                }
                                if (c.getTestarTelefone().equalsIgnoreCase(telefoneAdicionar))
                                {
                                    acheiTelefone = true;
                                }
                                if (c.getCodigo() == codigoAdicionar)
                                {
                                    acheiCodigo = true;
                                }
                            }
                            if (acheiNome == true)
                            {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                System.out.printf("\nNome: %s, já existe na lista, impossivel adicionar !!!\n", nomeAdicionar);
                                break;
                            }
                            else if(acheiTelefone == true)
                            {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                System.out.printf("\nTelefone: %s, já existe na lista, impossivel adicionar !!!\n", telefoneAdicionar);
                                break;
                            }
                            else if (acheiCodigo == true)
                            {
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                System.out.printf("\nCódigo: %d, já existe na lista, impossivel adicionar !!!\n", codigoAdicionar);
                                break;
                            }
                            else
                            {
                                try
                                {
                                    Contatos contato = new Contatos(nomeAdicionar, telefoneAdicionar, codigoAdicionar);
                                    listaContatos.add(contato);
                                }
                                catch (NomeNaoPodeLetraException | NumerosInsuficientesTelefone | TelefoneNaoPodeLetrasException e)
                                {
                                    System.out.println(e.getMessage());
                                } 
                            }
                        }
                    }
                break;
                case 2:
                    if (listaContatos.isEmpty())
                    {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println("Lista de contatos está vazia.");
                    }
                    else
                    {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.printf("Digite \"1\" para ordem alfabética, \"2\" para ordem código\n-->\t");
                        int alfaOrCod = ler.nextInt();
                        
                        switch (alfaOrCod)
                        {
                            case 1:
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                listaContatos.sort(new OrdemAlfabetica());
    
                                System.out.println("\n>>>     Lista de contatos em ordem alfabética     <<<\n");
                                for (Contatos c : listaContatos) {
                                    System.out.println(c);
                                }
                            break;
                            case 2:
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                listaContatos.sort(new OrdemCodigo());
    
                                System.out.println("\n>>>     Lista de contatos em ordem de código     <<<\n");
                                for (Contatos c : listaContatos) {
                                    System.out.println(c);
                                }
                            break;
                            default:
                                System.out.println("Opção inválida, voltando ao menu !!!");
                            break;
                        }
                    }
                break;
                case 3:
                    if (listaContatos.isEmpty())
                    {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println("Lista de contatos está vazia.");
                    }
                    else
                    {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.printf("Digite o código que deseja procurar na lista:\n-->\t");
                        int procuraCodigo = ler.nextInt();
                        achei = false;
                        for (Contatos c : listaContatos) {
                            if (c.getCodigo() == procuraCodigo)
                            {
                                System.out.println(c);
                                achei = true;
                                break;
                            }
                        }
                        if (achei == false)
                        {
                            System.out.printf("%d não existe na lista contatos !!!\n", procuraCodigo);
                        }
                    }
                break;
                case 4:
                    if (listaContatos.isEmpty())
                    {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println("Lista de contatos está vazia.");
                    }
                    else
                    {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.printf("Digite o nome que deseja procurar na lista:\n-->\t");
                        String procuraNome = ler.nextLine();
                        achei = false;
                        for (Contatos c : listaContatos) {
                            if (c.getNome().equalsIgnoreCase(procuraNome))
                            {
                                System.out.println(c);
                                achei = true;
                                break;
                            }
                        }
                        if (achei == false)
                        {
                            System.out.printf("%s não existe na lista contatos !!!\n", procuraNome);
                        }
                    }
                break;
                case 5:
                    if (listaContatos.isEmpty())
                    {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.println("Lista de contatos está vazia.");
                    }
                    else
                    {
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        System.out.printf("\"1\" para remover por código, \"2\" para remover por nome:\n-->\t");
                        int nomeOrCod = ler.nextInt();
                        ler.nextLine();
    
                        switch (nomeOrCod)
                        {
                            case 1:
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                System.out.printf("Digite o código que deseja remover da lista:\n-->\t");
                                int codigoRemover = ler.nextInt();
    
                                achei = false;
                                for (Contatos c : listaContatos) {
                                    if (c.getCodigo() == codigoRemover)
                                    {
                                        listaContatos.remove(c);
                                        System.out.printf("Código: %d, removido com sucesso !!!", codigoRemover);
                                        achei = true;
                                        break;
                                    }
                                }
                                if (achei == false)
                                {
                                    System.out.printf("%d não existe na lista contatos, impossivel remover !!!\n", codigoRemover);
                                }
                            break;
                            case 2:
                                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                System.out.printf("Digite o nome que deseja remover da lista:\n-->\t");
                                String nomeRemover = ler.nextLine();
                                achei = false;
    
                                for (Contatos c : listaContatos) {
                                    if (c.getNome().equalsIgnoreCase(nomeRemover))
                                    {
                                        listaContatos.remove(c);
                                        System.out.printf("Nome: %s, removido com sucesso !!!", nomeRemover);
                                        achei = true;
                                        break;
                                    }
                                }
                                if (achei == false)
                                {
                                    System.out.printf("%s não existe na lista contatos, impossivel remover !!!\n", nomeRemover);
                                }
                            break;
                        }
                    }
                break;
                case 0:
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    System.out.println("Encerrando programa....");
                    Thread.sleep(1500);
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                break;
                default:
                    System.out.println("Opção inválidade, voltando ao menu.");
                    Thread.sleep(1500);
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } while (opcao != 0);
        ler.close();
    }   
}