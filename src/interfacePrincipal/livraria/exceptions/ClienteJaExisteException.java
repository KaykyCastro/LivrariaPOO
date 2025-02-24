package interfacePrincipal.livraria.exceptions;

public class ClienteJaExisteException extends Exception{

    public ClienteJaExisteException(String cpf){
        super("A conta de cpf: " + cpf + "ja existe;");
    }

}
