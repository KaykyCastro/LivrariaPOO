package interfacePrincipal.livraria.models.livros.generos;

public enum Hq {
    SUPER_HEROIS("Super-Heróis"),
    MANGA("Mangá"),
    GNI("GNI");

    private final String nome;

    Hq(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public static Hq fromNome(String nome) {
        for (Hq hq : Hq.values()) {
            if (hq.getNome().equalsIgnoreCase(nome)) {
                return hq;
            }
        }
        return null; // Retorna null se não encontrar
    }
}