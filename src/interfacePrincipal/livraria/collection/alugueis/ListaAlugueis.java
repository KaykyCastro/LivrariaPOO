package interfacePrincipal.livraria.collection.alugueis;

import interfacePrincipal.livraria.collection.clientes.ListaClientes;
import interfacePrincipal.livraria.collection.livros.ListaLivros;
import interfacePrincipal.livraria.exceptions.ClienteNaoExisteException;
import interfacePrincipal.livraria.exceptions.LivroNaoExisteException;
import interfacePrincipal.livraria.models.cliente.Cliente;
import interfacePrincipal.livraria.models.livros.Livro;
import interfacePrincipal.livraria.models.livros.StatusLivro;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ListaAlugueis implements AlugueisCollection, Serializable{

    private Cliente cliente;
    public List<Livro> livrosAlugados = new ArrayList<Livro>();

    public static final double valorMulta = 1;

    public Livro getLivro(String code) throws LivroNaoExisteException {
        return null;
    }
    public void cadastrarAlugueis(Object livro) throws ClassCastException{
    	
    	livrosAlugados.add((Livro) livro);
    
    }
    public void alugarLivro(ListaClientes clientes, ListaLivros livros, String cpf, String code) throws ClienteNaoExisteException, LivroNaoExisteException {
        Cliente clienteAlugar = clientes.getCliente(cpf);
        Livro livroAlugar = livros.getLivro(code);
        livroAlugar.setStatus(StatusLivro.ALUGADO);

        Calendar dataDevolucao = Calendar.getInstance();
        dataDevolucao.add(Calendar.DAY_OF_MONTH, 7);
        livroAlugar.setDataDevolucao(dataDevolucao);

        this.cliente = clienteAlugar;
        livrosAlugados.add(livroAlugar);

        
    }

    public Livro devolucao(ListaClientes clientes, String cpf, String code) throws ClienteNaoExisteException, LivroNaoExisteException {
        Cliente cliente = clientes.getCliente(cpf);
        if(cpf.equals(cliente.getCpf())){
            System.out.println("Tamanho LivrosAlugados: " + livrosAlugados.size());
            for(Livro livro: livrosAlugados){
                if(code.equals(livro.getCode())){
                    livrosAlugados.remove(livro);
                    Calendar dataAtual = Cliente.oBterDataAtual();
                    if(livro.getDataDevolucao().before(dataAtual)){
                        long diffMillis = dataAtual.getTimeInMillis() - livro.getDataDevolucao().getTimeInMillis();
                        int diasAtraso = (int) (diffMillis/ (1000 * 60 * 60 * 24));
                        this.cliente.removerValorMulta(diasAtraso * valorMulta);
                    }

                    livro.setStatus(StatusLivro.DISPONIVEL);
                    return livro;
                }
            }
        }
        return null;
    }

    public Livro[] listarTodosOsLivros() {
        Livro[] retorno = new Livro[livrosAlugados.size()];
        return livrosAlugados.toArray(retorno);
    }
    
   
    public List<Livro> listarLivrosAlugadosCliente(String cpf) throws ClienteNaoExisteException {
        if(cpf.equals(cliente.getCpf())){
            return livrosAlugados;
        }
        return null;
    }

    public double gerarMulta(){
        int diasAtraso = 0;
        Calendar dataAtual = Cliente.oBterDataAtual();
        for(Livro livro : livrosAlugados){
            if(livro.getDataDevolucao().before(dataAtual)){
                long diffMillis = dataAtual.getTimeInMillis() - livro.getDataDevolucao().getTimeInMillis();
                diasAtraso = (int) (diffMillis/ (1000 * 60 * 60 * 24));
            }
        }
        double valorMulta = diasAtraso * 1;

        if(cliente.getMulta() < valorMulta){
            cliente.setMulta(valorMulta);
            return valorMulta;
        }
        return valorMulta;
    }

    public static Calendar oBterDataAtual(){
        return Calendar.getInstance();
    }

    public int getDimensao(){
        return this.livrosAlugados.size();
    }
    public Livro getElement(int indice){
        return this.livrosAlugados.get(indice);

    }
}