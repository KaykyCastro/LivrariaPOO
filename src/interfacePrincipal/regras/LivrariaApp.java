package interfacePrincipal.regras;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import interfacePrincipal.livraria.collection.alugueis.ListaAlugueis;
import interfacePrincipal.livraria.collection.clientes.ListaClientes;
import interfacePrincipal.livraria.collection.livros.ListaLivros;
import interfacePrincipal.livraria.exceptions.ClienteJaExisteException;
import interfacePrincipal.livraria.exceptions.ClienteNaoExisteException;
import interfacePrincipal.livraria.exceptions.LivroNaoExisteException;
import interfacePrincipal.livraria.models.cliente.Cliente;
import interfacePrincipal.livraria.models.livros.Livro;

public class LivrariaApp  {

        public static String caminhoLivro = "C:\\Users\\Usuario\\Downloads\\Livraria-main (1)\\Livraria-main\\src\\interfacePrincipal\\regras\\dados\\livros.ser";
        public static String caminhoClientes = "C:\\Users\\Usuario\\Downloads\\Livraria-main (1)\\Livraria-main\\src\\interfacePrincipal\\regras\\dados\\clientes.ser";
        public static String caminhoAluguel = "C:\\Users\\Usuario\\Downloads\\Livraria-main (1)\\Livraria-main\\src\\interfacePrincipal\\regras\\dados\\alugueis.ser";

        // Gerenciadores
        ListaClientes managerClientes = new ListaClientes();
        ListaLivros managerLivros = new ListaLivros();
        ListaAlugueis managerAlugueis = new ListaAlugueis();
        ControleDados fluxo = new ControleDados();
        
        // 0. Iniciar objetos de acordo os tips gravagos
        public void getDadosGravadosClientes() throws FileNotFoundException, ClassNotFoundException, IOException, ClienteNaoExisteException, UnsupportedOperationException, ClienteJaExisteException{
                ListaClientes dadosClientes = ControleDados.lerCliente(caminhoClientes);
                System.out.println("Instanciando dados Clientes gravados" + dadosClientes);
                for( int i = 0; i < dadosClientes.getDimensao(); i++){
                    managerClientes.cadastrarCliente(dadosClientes.getElement(i));
                    
                }
                System.out.println(managerClientes.getDimensao());
        }
        public void getDadosGravadosLivros() throws FileNotFoundException, ClassNotFoundException, IOException, UnsupportedOperationException{
                ListaLivros  dadosLivros = ControleDados.lerLivro(caminhoLivro);
                System.out.println("Instanciando dados Livros gravados" + dadosLivros);
                for( int i = 0; i < dadosLivros.getDimensao(); i++){
                    managerLivros.cadastrarLivro(dadosLivros.getElement(i));
                    
                }
                System.out.println(managerLivros.getDimensao());
        }
        public void getDadosAlugueisLivros() throws FileNotFoundException, ClassNotFoundException, IOException, UnsupportedOperationException{
            
            ListaAlugueis dadosAlugueis = ControleDados.lerAlugueis(caminhoAluguel);
            if(dadosAlugueis ==null){
                System.out.println("Lista vazia em alugueis");
            }else{
            
                for( int i = 0; i < dadosAlugueis.getDimensao(); i++){
                    managerLivros.cadastrarLivro(dadosAlugueis.getElement(i)); 
                }
        }
            System.out.println(managerLivros.getDimensao());
    }
        
       // 1. Cadastrando o cliente
        public String cadastrarCliente(Cliente cliente) throws ClienteJaExisteException, FileNotFoundException, ClassNotFoundException, IOException{
            try{
                managerClientes.cadastrarCliente(cliente);
                ControleDados.gravarClientes(caminhoClientes, managerClientes);
                return "Cliente cadastrado";
            } catch (ClienteJaExisteException e) {
                throw new ClienteJaExisteException(cliente.getCpf());
            }
        }
      // 2. Cadastrando livros
       public String cadastrarLivros(Livro livro)  {       
        try{

                managerLivros.cadastrarLivro(livro);
                ControleDados.gravarLivros(caminhoLivro, managerLivros);
                return "Livro cadastrado com sucesso!";
              
                } catch (Exception e) { // caso ocorra um erro genérico(memória cheia, por exemplo)
                    return "Erro: Ao cadastrar livro - " + e.getMessage();
            }
       
    }
        // 3. Alugando um livro via `managerAlugueis`
       public String alugarLivro(String codigoCliente, String codigoLivro) throws ClienteNaoExisteException, LivroNaoExisteException, FileNotFoundException, IOException, NullPointerException, ClassNotFoundException{
           try {
               managerAlugueis.alugarLivro(managerClientes, managerLivros, codigoCliente, codigoLivro);
               ControleDados.gravarLivros(caminhoLivro, managerLivros);
               ControleDados.gravarClientes(caminhoClientes, managerClientes);
               ControleDados.gravarAlugueis(caminhoAluguel, managerAlugueis);

               return "Livro alugado com sucesso!";

           } catch (LivroNaoExisteException e) {
               return "Erro: Livro não existe - " + e.getMessage();
           } catch(ClienteNaoExisteException e) {
               return "Erro: Cliente não existe - " + e.getMessage();
           }
       }
       // 4. Exibir multa antes da devolução
         public double gerarMulta() {
              return managerAlugueis.gerarMulta();
         }

        // 5. Listar livros alugados pelo cliente
         public List<Livro> listarLivrosAlugados(String cpf) throws ClienteNaoExisteException {
            try{
                return managerAlugueis.listarLivrosAlugadosCliente(cpf);
            } catch (ClienteNaoExisteException e) {
                throw new ClienteNaoExisteException(cpf);        

         }
        }

         // 6. Devolução do livro
         public String devolucao(String cpf, String codigoLivro) throws ClienteNaoExisteException, LivroNaoExisteException, FileNotFoundException, IOException{
             try {
                 managerLivros.devolucao(managerAlugueis.devolucao(managerClientes,cpf, codigoLivro));
                 ControleDados.gravarLivros(caminhoLivro, managerLivros);
                 ControleDados.gravarClientes(caminhoClientes, managerClientes);
                 ControleDados.gravarAlugueis(caminhoAluguel, managerAlugueis);

                 return "Livro devolvido com sucesso!";
             } catch (ClienteNaoExisteException e) {
                 return "Erro: Cliente não existe - " + e.getMessage();
             } catch (LivroNaoExisteException e) {
                 return "Erro: Livro não existe - " + e.getMessage();
             }
         }
         
         // 7. Listando livros disponíveis na biblioteca após a devolução
        public Livro[] listarLivrosDisponiveis() {
           
            try{
                Livro[] livrosDisponiveis = managerLivros.listarLivrosDisponiveis();
                return livrosDisponiveis;
            } catch (Exception e) {
                return null;
            }
    }

        // Remover livro
        public void removerLivro(String codigo) throws LivroNaoExisteException, FileNotFoundException, ClassNotFoundException, IOException{
         
            managerLivros.removerLivro(codigo);          
            ControleDados.gravarLivros(caminhoLivro, managerLivros);
            
        }
        public String  getNome(String codigo) throws LivroNaoExisteException{
            try{
                return managerLivros.getLivro(codigo).getName();
            }catch(LivroNaoExisteException lne){
                throw new LivroNaoExisteException(codigo);
            }
        }
        public void removerCliente(String cpf) throws ClienteNaoExisteException, FileNotFoundException, IOException, ClassNotFoundException{
       
            managerClientes.removerCliente(cpf);
            ControleDados.gravarClientes(caminhoClientes, managerClientes);
        }

}