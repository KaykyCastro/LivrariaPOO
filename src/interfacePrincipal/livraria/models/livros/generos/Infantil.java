package interfacePrincipal.livraria.models.livros.generos;

public enum Infantil {
    LIVRO_ILUSTRADO("Livro Ilustrado"),
    CONTO_FADAS("Conto de Fadas"),
    INFANTOJUVENIL("Infantojuvenil"),
    YOUNG_ADULT("Young Adult");

    private final String nome;

    Infantil(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public static Infantil fromNome(String nome) {
        for (Infantil infantil : Infantil.values()) {
            if (infantil.getNome().equalsIgnoreCase(nome)) {
                return infantil;
            }
        }
        return null; // Retorna null se não encontrar
    }
}