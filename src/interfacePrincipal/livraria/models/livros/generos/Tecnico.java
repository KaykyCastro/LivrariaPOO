package interfacePrincipal.livraria.models.livros.generos;

public enum Tecnico {
    DIDATICO("Didático"),
    CIENCIAS_EXATAS("Ciências Exatas"),
    CIENCIAS_HUMANAS("Ciências Humanas"),
    DIREITO("Direito"),
    MEDICINA("Medicina");

    private final String nome;

    Tecnico(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public static Tecnico fromNome(String nome) {
        for (Tecnico tecnico : Tecnico.values()) {
            if (tecnico.getNome().equalsIgnoreCase(nome)) {
                return tecnico;
            }
        }
        return null; // Retorna null se não encontrar
    }
}
