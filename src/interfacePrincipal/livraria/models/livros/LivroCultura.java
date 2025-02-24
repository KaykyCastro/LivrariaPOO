package interfacePrincipal.livraria.models.livros;

import java.util.Calendar;

public class LivroCultura extends Livro{
    public LivroCultura(String name, String code, String descricao, Enum genero, String autor) {
        super(name, code, descricao, genero, autor);
    }
}
