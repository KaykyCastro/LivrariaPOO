package interfacePrincipal.livraria.collection.clientes;


import interfacePrincipal.livraria.exceptions.ClienteJaExisteException;
import interfacePrincipal.livraria.exceptions.ClienteNaoExisteException;
import interfacePrincipal.livraria.models.cliente.Cliente;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
 

public class ListaClientes implements ClienteCollection, Serializable{

    public List<Cliente> clientes = new ArrayList<Cliente>();

    @Override
    public void cadastrarCliente(Cliente cliente)throws ClienteJaExisteException {
        try {
            getCliente(cliente.getCpf());
            throw new ClienteJaExisteException(cliente.getCpf());
        } catch (ClienteNaoExisteException e){
            clientes.add(cliente);
        }
    }

    @Override
    public Cliente getCliente(String cpf) throws ClienteNaoExisteException {
        for(Cliente cliente: clientes){
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        throw new ClienteNaoExisteException(cpf);
    }

    @Override
    public void editarCliente(String cpf, String nome, String endereco) throws ClienteNaoExisteException {
        Cliente clienteParaEditar = getCliente(cpf);
        clienteParaEditar.setNome(nome);
        clienteParaEditar.setEndereco(endereco);
    }

    @Override
    public void removerCliente(String cpf) throws ClienteNaoExisteException {
        Cliente clienteDeletar = getCliente(cpf);
        clientes.remove(clienteDeletar);
    }

    @Override
    public List<Cliente> listarClientes() {
        return clientes;
    }
    
    public int getDimensao(){
        return this.clientes.size();
    }
    public Cliente getElement(int indice){
        return this.clientes.get(indice);
    }
 
}
