package interfacePrincipal.livraria.collection.clientes;

import interfacePrincipal.livraria.exceptions.ClienteJaExisteException;
import interfacePrincipal.livraria.exceptions.ClienteNaoExisteException;
import interfacePrincipal.livraria.models.cliente.Cliente;

import java.util.List;

public interface ClienteCollection {

    public void cadastrarCliente(Cliente cliente)throws ClienteJaExisteException;
    public Cliente getCliente(String cpf) throws ClienteNaoExisteException;
    public void editarCliente(String cpf, String nome, String endereco) throws ClienteNaoExisteException;
    public void removerCliente(String cpf) throws ClienteNaoExisteException;
    public List<Cliente> listarClientes();

}

