package interfacePrincipal.livraria.models.livros;

public enum StatusLivro {
    DISPONIVEL("Disponível"),
    ALUGADO("Alugado");
    
    private final String nome;

    StatusLivro(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    public static StatusLivro fromNome(String nome) {
        for (StatusLivro s : StatusLivro.values()) {
            if (s.getNome().equalsIgnoreCase(nome)) {
                return s;
            }
        }
        return null; // Retorna null se não encontrar
    }
}