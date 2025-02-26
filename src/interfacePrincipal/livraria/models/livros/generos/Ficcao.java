package interfacePrincipal.livraria.models.livros.generos;

public enum Ficcao {
    ROMANCE("Romance"),
    FANTASIA("Fantasia"),
    FICCAO_CIENTIFICA("Ficção Científica"),
    TERROR("Terror"),
    SUSPENSE("Suspense"),
    CONTOS("Contos");

    private final String nome;

    Ficcao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public static Ficcao fromNome(String nome) {
        for (Ficcao ficcao : Ficcao.values()) {
            if (ficcao.getNome().equalsIgnoreCase(nome)) {
                return ficcao;
            }
        }
        return null; // Retorna null se não encontrar
    }
}