package interfacePrincipal.livraria.models.livros;

import java.util.Calendar;

public class LivroNaoFiccao extends Livro{
    public LivroNaoFiccao(String name, String code, String descricao, Enum genero, String autor) {
        super(name, code, descricao, genero, autor);
    }
}
