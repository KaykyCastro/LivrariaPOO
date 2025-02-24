package interfacePrincipal.livraria.collection.livros;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import interfacePrincipal.livraria.collection.alugueis.ListaAlugueis;
import interfacePrincipal.livraria.exceptions.ClienteNaoExisteException;
import interfacePrincipal.livraria.exceptions.LivroNaoExisteException;
import interfacePrincipal.livraria.models.livros.Livro;
import interfacePrincipal.livraria.models.livros.StatusLivro;

public class ListaLivros implements LivroCollection, Serializable{
    private static final long serialVersionUID = 1L;
    
    public List<Livro> livros = new ArrayList<>();
    @Override
    /**
     * Adiciona um livro na lista livros.
     *
     * @param (livro) , livros ser cadastrado.
     * **/
    public void cadastrarLivro(Livro livro) {
                livros.add(livro);
    }

    @Override
    /**
     * Retorna um livro de acordo com o codigo do livro.
     *
     * @return livro , livro encontrado.
     * **/
    public Livro getLivro(String code) throws LivroNaoExisteException{
        for(Livro livro : livros){
            if(livro.getCode().equals(code)){
                return livro;
            }
        }
        throw new LivroNaoExisteException(code);
    }

    @Override
    /**
     * Remove um livro da lista de livro com base no codigo do livro.
     *
     * @param (code) , codigo do livro a ser removido.
     * **/
    public void removerLivro(String code) throws LivroNaoExisteException {
        Livro livroRemover = getLivro(code);
        livros.remove(livroRemover);
    }


    @Override
    /**
     * Adiciona um livro na lista de livros do Cliente e remove o livro da lista da livraria,
     * assim efetuando o aluguel do livro pro cliente.
     *
     * @param (clientes, cpf, code) , clientes é a lista de clientes da livraria, cpf é o cpf
     *do cliente que alugara, e code o codigo do livro a ser alugado, respectivamente.
     * **/
    public void alugarLivro(String code) throws ClienteNaoExisteException, LivroNaoExisteException {
            Livro livroAlugar = getLivro(code);
            livros.remove(livroAlugar);
    }

    @Override
    /**
     * Retorna um livro a livraria, adicionando novamente o livro a lista de livros da livraria
     * e removendo da lista de livros do cliente, e zera o valor da multa que o livro gerava.
     *
     * @param (clientes, cpf, code) , lientes é a lista de clientes da livraria, cpf é o cpf
     * do cliente que alugara, e code o codigo do livro a ser alugado, respectivamente.
     * **/
    public void devolucao(Livro livro){
            for(Livro l: livros){
                if(l.getCode() == livro.getCode()){
                    l.setStatus(StatusLivro.DISPONIVEL);                }
            }
            
    }

    @Override
    /**
     * Retorna uma Array com todos os filmes com status: DISPONIVEL.
     *
     * @return Array , Array no qual cotem todos os livros disponiveis.
     * **/
    public Livro[] listarLivrosDisponiveis() {
        List<Livro> livrosDisponiveis = new ArrayList<Livro>();
        for (Livro livro : livros){
            if(livro.getStatus().equals(StatusLivro.DISPONIVEL)){
                livrosDisponiveis.add(livro);
            }
        }

        return livrosDisponiveis.toArray(new Livro[0]);
    }

    @Override
    /**
     * Retorna uma Array com todos os filmes com status: DISPONIVEL e por genero.
     *
     * @param (genero) genero no qual o livro pertence
     * @return Array , Array no qual cotem todos os livros diponiveis e do genero especificado.
     * **/
    public Livro[] listarLivrosDisponiveisPorGenero(String genero) {
       List<Livro> livrosGenero = new ArrayList<Livro>();
       for(Livro livro: livros){
           if(livro.getGenero().equals(genero) && livro.getStatus().equals(StatusLivro.DISPONIVEL)){
               livrosGenero.add(livro);
           }
       }

       return livrosGenero.toArray(new Livro[0]);
    }

    @Override
    /**
     * Retorna uma Array com todos os filmes com status: ALUGADO.
     *
     * @return Array , Array no qual cotem todos os livros alugados.
     * **/
    public Livro[] listarLivrosAlugados(ListaAlugueis alugueis) {
        List<Livro> livrosAlugados = new ArrayList<Livro>();
        for (Livro livro : alugueis.listarTodosOsLivros()){
            if(livro.getStatus().equals(StatusLivro.ALUGADO)){
                livrosAlugados.add(livro);
            }
        }

        return livrosAlugados.toArray(new Livro[0]);
    }

    @Override
    /**
     * Retorna uma Array com todos os filmes com status: DISPONIVEL E ALUGADO.
     *
     * @return Array , Array no qual cotem todos os livros diponiveis e alugados.
     * **/
    public Livro[] listarTodosOsLivros(ListaAlugueis alugueis) {
        List<Livro> livrosAlugado = new ArrayList<Livro>(livros);
        livrosAlugado.addAll(alugueis.livrosAlugados);
        return livrosAlugado.toArray(new Livro[0]);
    }

    public int getDimensao(){
        return this.livros.size();
    }
    public Livro getElement(int indice){
        return this.livros.get(indice);
    }
}
