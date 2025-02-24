package interfacePrincipal.livraria.models.livros.generos;

public enum Cultura {
    MUSICA("Música"),
    CINEMA("Cinema"),
    TV("TV"),
    FOTOGRAFIA("Fotografia"),
    MODA("Moda");

    private final String nome;

    Cultura(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public static Cultura fromNome(String nome) {
        for (Cultura cultura : Cultura.values()) {
            if (cultura.getNome().equalsIgnoreCase(nome)) {
                return cultura;
            }
        }
        return null; // Retorna null se não encontrar
    }
}