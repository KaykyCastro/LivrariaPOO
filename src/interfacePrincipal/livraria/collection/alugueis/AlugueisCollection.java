package interfacePrincipal.livraria.collection.alugueis;

import interfacePrincipal.livraria.collection.clientes.ListaClientes;
import interfacePrincipal.livraria.collection.livros.ListaLivros;
import interfacePrincipal.livraria.exceptions.ClienteNaoExisteException;
import interfacePrincipal.livraria.exceptions.LivroNaoExisteException;
import interfacePrincipal.livraria.models.livros.Livro;

public interface AlugueisCollection {
    public Livro getLivro(String code) throws LivroNaoExisteException;
    public void alugarLivro(ListaClientes clientes, ListaLivros livros, String cpf, String code)throws ClienteNaoExisteException, LivroNaoExisteException;
    public Livro devolucao(ListaClientes clientes, String cpf, String code)throws ClienteNaoExisteException, LivroNaoExisteException;
    public Livro[] listarTodosOsLivros();

}
