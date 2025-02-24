package interfacePrincipal.livraria.exceptions;

public class ClienteNaoExisteException extends Exception{

    public ClienteNaoExisteException(String cpf) {
        super("Cliente com cpf :" + cpf + "nao existe no banco de clientes!");
    }

}
