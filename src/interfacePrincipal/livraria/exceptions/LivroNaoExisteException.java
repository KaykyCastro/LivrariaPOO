package interfacePrincipal.livraria.exceptions;

public class LivroNaoExisteException extends Exception{

    public LivroNaoExisteException(String code){
        super("O livro de codigo :" + code + " nao existe!");
    }

}
