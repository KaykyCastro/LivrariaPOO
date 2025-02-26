package interfacePrincipal.livraria.models.livros.generos;

public enum NaoFiccao {
    BIOGRAFIA("Biografia"),
    HISTORIA("História"),
    CIENCIA("Ciência"),
    FILOSOFIA("Filosofia"),
    RELIGIAO("Religião");

    private final String nome;

    NaoFiccao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public static NaoFiccao fromNome(String nome) {
        for (NaoFiccao naoFiccao : NaoFiccao.values()) {
            if (naoFiccao.getNome().equalsIgnoreCase(nome)) {
                return naoFiccao;
            }
        }
        return null; // Retorna null se não encontrar
    }
}