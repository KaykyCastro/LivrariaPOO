package interfacePrincipal.livraria.models.livros;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public abstract class Livro implements Serializable {
    protected String name;
    protected String code;
    protected String descricao;
    protected Enum genero;
    protected String autor;
    protected StatusLivro status;
    protected Calendar dataDevolucao;

    public Livro(String name, String code, String descricao, Enum genero, String autor, StatusLivro status) {
        this.name = name;
        this.code = code;
        this.descricao = descricao;
        this.genero = genero;
        this.autor = autor;
        this.status = status;
    }

    public Livro(String name, String code, String descricao, Enum genero, String autor) {
        this(name, code, descricao, genero, autor, StatusLivro.DISPONIVEL);
    }

    /**
     * Retorna o nome do Livro.
     *
     * @return nome , nome no qual pertence ao livro instanciado.
     * **/
    public String getName() {
        return name;
    }

    /**
     * Adiciona o nome do Livro.
     *
     * @param (name) , nome nome no qual sera adicionado ao livro instanciado.
     * **/
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retorna o codigo do Livro.
     *
     * @return code , codigo no qual pertence ao livro instanciado.
     * **/
    public String getCode() {
        return code;
    }

    /**
     * Adiciona o codigo do Livro.
     *
     * @param (code) , codigo no qual sera adicionado ao livro instanciado.
     * **/
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Retorna a descricao do Livro.
     *
     * @return descricao , descricao na qual pertence ao livro instanciado.
     * **/
    public String getDescricao() {
        return descricao;
    }

    /**
     * Adiciona a descricao do Livro.
     *
     * @param (descricao) , descricao no qual sera adicionado ao livro instanciado.
     * **/
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o genero do Livro.
     *
     * @return genero , genero no qual pertence ao livro instanciado.
     * **/
    public Enum getGenero() {
        return genero;
    }

    /**
     * Adiciona o genero do Livro.
     *
     * @param (genero) , genero no qual sera adicionado ao livro instanciado.
     * **/
    public void setGenero(Enum genero) {
        this.genero = genero;
    }

    /**
     * Retorna o autor do Livro.
     *
     * @return autor , autor no qual pertence ao livro instanciado.
     * **/
    public String getAutor() {
        return autor;
    }

    /**
     * Adiciona o autor do Livro.
     *
     * @param (autor) , autor no qual sera adicionado ao livro instanciado.
     * **/
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Retorna o status do Livro.
     *
     * @return status , status no qual pertence ao livro instanciado.
     * **/
    public StatusLivro getStatus() {
        return status;
    }

    /**
     * Adiciona o status do Livro.
     *
     * @param (status) , status no qual sera adicionado ao livro instanciado.
     * **/
    public void setStatus(StatusLivro status) {
        this.status = status;
    }

    /**
     * Retorna a data de devolucao do Livro.
     *
     * @return Calendar , data na qual pertence ao livro instanciado.
     * **/
    public Calendar getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * Adiciona a data de devolucao do Livro.
     *
     * @param (dataDevolucao) , data na qual sera adicionado ao livro instanciado.
     * **/
    public void setDataDevolucao(Calendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * Edita todos os dados de um livro especifico.
     *
     * @param (code, data) , codigo do livro a ser editado e os dados novos do livro.
     * **/
    public void editarLivro(String name, String code, String descricao, Enum genero, String autor, StatusLivro status, Calendar dataDevolucao){
        this.name = name;
        this.code = code;
        this.descricao = descricao;
        this.genero = genero;
        this.autor = autor;
        this.status = status;
        this.dataDevolucao = dataDevolucao;
    }

    @Override
    /**
     * Retorna um modelo para ser exibido.
     *
     * @return String , String na qual contem os dados do livro a ser exibido.
     * **/
    public String toString() {
        return "Livro{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", descricao='" + descricao + '\'' +
                ", genero=" + genero +
                ", autor='" + autor + '\'' +
                ", status=" + status +
                ", dataDevolucao=" + dataDevolucao +
                '}';
    }

    public Class<? extends Livro> getSuperClasse(){
        return this.getClass();
    }
}