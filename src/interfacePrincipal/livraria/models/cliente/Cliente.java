package interfacePrincipal.livraria.models.cliente;



import java.io.Serializable;
import java.util.Calendar;


public class Cliente implements Serializable{
    private String nome;
    private String cpf;
    private String endereco;
    private double multa;

    public Cliente(String nome, String cpf, String endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.multa = 0;
    }

    /**
     * Retorna o nome do Cliente.
     *
     * @return nome , nome no qual pertence ao cliente instanciado.
     * **/
    public String getNome() {
        return nome;
    }

    /**
     * Adiciona o nome do Cliente.
     *
     * @param (name) , nome nome no qual sera adicionado ao cliente instanciado.
     * **/
    public void setNome(String name) {
        this.nome = name;
    }

    /**
     * Retorna o cpf do Cliente.
     *
     * @return cpf , cpf no qual pertence ao cliente instanciado.
     * **/
    public String getCpf() {
        return cpf;
    }

    /**
     * Adiciona o cpf do Cliente.
     *
     * @param (cpf) , cpf no qual sera adicionado ao cliente instanciado.
     * **/
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Retorna o endereco do Cliente.
     *
     * @return endereco , endereco no qual pertence ao cliente instanciado.
     * **/
    public String getEndereco() {
        return endereco;
    }

    /**
     * Adiciona o endereco do Cliente.
     *
     * @param (endereco) , endereco no qual sera adicionado ao cliente instanciado.
     * **/
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Adiciona uma multa ao Cliente.
     *
     * @param (multa) , multa no qual sera adicionado ao cliente instanciado.
     * **/
    public void setMulta(double multa) {
        this.multa += multa;
    }

    public void removerValorMulta(double valor){
        this.multa -= valor;
    }

    public double getMulta(){
        return this.multa;
    }

    @Override
    /**
     * Retorna um modelo para ser exibido.
     *
     * @return String , String na qual contem os dados do cliente a ser exibido.
     * **/
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", endereco='" + endereco + '\'' +
                ", multa=" + multa +
                '}';
    }

    /**
     * Retorna a data atual.
     *
     * @return Calendar , retorna a data atual a ser usada.
     * **/
    public static Calendar oBterDataAtual(){
      return Calendar.getInstance();
    }
}
