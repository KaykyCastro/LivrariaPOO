package interfacePrincipal.livraria.models.livros.generos;

public enum AutoAjuda {
    DESENVOLVIMENTO_PESSOAL("Desenvolvimento Pessoal"),
    PSICOLOGIA("Psicologia"),
    INTELIGENCIA_EMOCIONAL("Inteligência Emocional"),
    MOTIVACAO("Motivação"),
    ESPIRITUALIDADE("Espiritualidade");
    
    private final String nome;

    AutoAjuda(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    public static AutoAjuda fromNome(String nome) {
        for (AutoAjuda autoAjuda : AutoAjuda.values()) {
            if (autoAjuda.getNome().equalsIgnoreCase(nome)) {
                return autoAjuda;
            }
        }
        return null; // Retorna null se não encontrar
    }
}