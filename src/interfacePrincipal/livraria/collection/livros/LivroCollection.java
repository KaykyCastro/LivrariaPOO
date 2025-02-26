package interfacePrincipal.livraria.collection.livros;

import interfacePrincipal.livraria.collection.alugueis.ListaAlugueis;
import interfacePrincipal.livraria.collection.clientes.ListaClientes;
import interfacePrincipal.livraria.exceptions.ClienteJaExisteException;
import interfacePrincipal.livraria.exceptions.ClienteNaoExisteException;
import interfacePrincipal.livraria.exceptions.LivroNaoExisteException;
import interfacePrincipal.livraria.models.cliente.Cliente;
import interfacePrincipal.livraria.models.livros.Livro;
import interfacePrincipal.livraria.models.livros.LivroTecnico;
import interfacePrincipal.livraria.models.livros.StatusLivro;

import java.util.Calendar;
import java.util.List;

public interface LivroCollection {

    public Livro getLivro(String code) throws LivroNaoExisteException;
    public void cadastrarLivro(Livro livro);
    public void removerLivro(String code) throws LivroNaoExisteException;
    public void alugarLivro(String code)throws ClienteNaoExisteException, LivroNaoExisteException;
    public void devolucao(Livro livro) throws NullPointerException, LivroNaoExisteException;
    public Livro[] listarLivrosDisponiveis();
    public Livro[] listarLivrosDisponiveisPorGenero(String genero);
    public Livro[] listarLivrosAlugados(ListaAlugueis alugueis);
    public Livro[] listarTodosOsLivros(ListaAlugueis alugueis);

}
