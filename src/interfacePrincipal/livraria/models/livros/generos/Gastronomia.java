package interfacePrincipal.livraria.models.livros.generos;

public enum Gastronomia {
    RECEITA("Receita"),
    TECNICAS_CULINARIAS("Técnicas Culinárias"),
    GASTRONOMIA_INTERNACIONAL("Gastronomia Internacional"),
    ALIMENTACAO_SAUDAVEL("Alimentação Saudável");

    private final String nome;

    Gastronomia(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public static Gastronomia fromNome(String nome) {
        for (Gastronomia gastronomia : Gastronomia.values()) {
            if (gastronomia.getNome().equalsIgnoreCase(nome)) {
                return gastronomia;
            }
        }
        return null; // Retorna null se não encontrar
    }
}