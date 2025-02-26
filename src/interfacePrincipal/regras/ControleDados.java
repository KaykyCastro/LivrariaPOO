package interfacePrincipal.regras;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import interfacePrincipal.livraria.collection.alugueis.ListaAlugueis;
import interfacePrincipal.livraria.collection.clientes.ListaClientes;
import interfacePrincipal.livraria.collection.livros.ListaLivros;
import interfacePrincipal.livraria.exceptions.ClienteJaExisteException;
import interfacePrincipal.livraria.exceptions.LivroNaoExisteException;
import interfacePrincipal.livraria.models.cliente.Cliente;
import interfacePrincipal.livraria.models.livros.LivroFiccao;
import interfacePrincipal.livraria.models.livros.LivroGastronomia;
import interfacePrincipal.livraria.models.livros.LivroHq;
import interfacePrincipal.livraria.models.livros.LivroInfantil;
import interfacePrincipal.livraria.models.livros.LivroNaoFiccao;
import interfacePrincipal.livraria.models.livros.LivroTecnico;
import interfacePrincipal.livraria.models.livros.generos.AutoAjuda;
import interfacePrincipal.livraria.models.livros.generos.Ficcao;
import interfacePrincipal.livraria.models.livros.generos.Gastronomia;
import interfacePrincipal.livraria.models.livros.generos.Hq;
import interfacePrincipal.livraria.models.livros.generos.Infantil;
import interfacePrincipal.livraria.models.livros.generos.NaoFiccao;
import interfacePrincipal.livraria.models.livros.generos.Tecnico;



public class ControleDados {
    
    /*Apesar de não ser eficiente, mas pare fins didáticos irei explicar como será feita a gravação dos dados sobre o vetor
     * 1. Vou considerar um Object que vai considerar ou Clientes ou Livros
     * 2. Toda vez que esse gravar dados for chamado(vou puxar a estrutura inteira da gravada, desserializar e adicionar o elemento no arquivo e depois sobreescrever o arquivo)
     * 3. Para exclusão é a mesma coisa só considerar que eu vou puxar tudo, excluir livro ou cliente e sobreescrever o arquivo.
     * OBS: A lógica do Array atualizado ou não será passado LivrariaApp
     */
	 public static String caminhoraiz =  System.getProperty("user.dir");
	 public static String caminhoLivros = caminhoraiz + "\\src\\interfacePrincipal\\regras\\dados\\livros.ser";
	 public static String caminhoClientes = caminhoraiz + "\\src\\interfacePrincipal\\regras\\dados\\clientes.ser";
	 public static String caminhoAluguel = caminhoraiz +  "\\src\\interfacePrincipal\\regras\\dados\\alugueis.ser";
	   
	       

    //public static voi criarPasta() --> Criar pasta no caminho do SO do usuário!
    public static void gravarLivros(String arquivo, ListaLivros managerLivros) throws FileNotFoundException, IOException{
        try(ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(arquivo))){
            oss.writeObject(managerLivros);
            //System.out.println(managerLivros);   
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Erro ao salvar clientes: " + e.getMessage());
            e.printStackTrace();

        }
    }
    public static void gravarClientes(String arquivo, ListaClientes managerClientes) throws FileNotFoundException, IOException{
       
        try(ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(arquivo))){
            oss.writeObject(managerClientes);
            //System.out.println(managerClientes);   
         
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Erro ao salvar aluguel livros: " + e.getMessage());
            e.printStackTrace();

        }
    }
    public static void gravarAlugueis(String arquivo, ListaAlugueis managerAlugueis) throws FileNotFoundException, IOException{
       
        try(ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(arquivo))){
            oss.writeObject(managerAlugueis);
            //System.out.println(managerAlugueis);   
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("Erro ao salvar aluguel livros: " + e.getMessage());
            e.printStackTrace();

        }
    }

    public static ListaClientes lerCliente(String arquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
    
        ListaClientes lista = new ListaClientes();
        File file = new File(arquivo);

        // Cria um arquivo caso não exista
        if(!file.exists()){
            return lista;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            Object obj =  ois.readObject();
            System.out.println(obj.toString());
            if (obj instanceof ListaClientes) {
                lista = (ListaClientes) obj;
            } else {
                System.err.println("Arquivo não contém uma ListaLivros.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar clientes: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }
    public static ListaLivros lerLivro(String arquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
    
        ListaLivros lista = new ListaLivros();
        File file = new File(arquivo);

        // Cria um arquivo caso não exista
        if(!file.exists()){
            return lista;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            Object obj =  ois.readObject();
            if (obj instanceof ListaLivros) {
                lista = (ListaLivros) obj;
            } else {
                System.err.println("Arquivo não contém uma ListaLivros.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar clientes: " + e.getMessage());
            e.printStackTrace();
        }
        return  lista;
    }
    public static ListaAlugueis lerAlugueis(String arquivo) throws FileNotFoundException, IOException, ClassNotFoundException {
    
        ListaAlugueis lista = new ListaAlugueis();
        File file = new File(arquivo);

        // Cria um arquivo caso não exista
        if(!file.exists()){
            return lista;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(arquivo))) {
            Object obj =  ois.readObject();
            if (obj instanceof ListaAlugueis) {
                lista = (ListaAlugueis) obj;
            } else {
                System.err.println("Arquivo não contém uma ListaLivros.");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erro ao carregar clientes: " + e.getMessage());
            e.printStackTrace();
        }
        return  lista;
    }
        

        public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, ClienteJaExisteException, LivroNaoExisteException {

            ListaClientes clientes = new ListaClientes();

            Cliente cliente1 = new Cliente("João da Silva", "123.456.789-00", "Rua das Flores, 123");
            Cliente cliente2 = new Cliente("Maria Oliveira", "987.654.321-00", "Avenida Principal, 456");
            Cliente cliente3 = new Cliente("Carlos Pereira", "111.222.333-44", "Travessa da Paz, 789");
            Cliente cliente4 = new Cliente("Ana Souza", "444.555.666-77", "Largo da Matriz, 1011");
            Cliente cliente5 = new Cliente("Pedro Santos", "222.333.444-55", "Rua da Praia, 567");
            Cliente cliente6 = new Cliente("Mariana Costa", "333.444.555-66", "Avenida Beira Mar, 890");
            Cliente cliente7 = new Cliente("Lucas Ferreira", "555.666.777-88", "Rua do Sol, 1234");
            clientes.cadastrarCliente(cliente1);
            clientes.cadastrarCliente(cliente2);
            clientes.cadastrarCliente(cliente3);
            clientes.cadastrarCliente(cliente4);
            clientes.cadastrarCliente(cliente5);
            clientes.cadastrarCliente(cliente6);
            clientes.cadastrarCliente(cliente7);

            ListaLivros listaDeLivros = new ListaLivros();

            // Cria e adiciona 10 livros à lista
            listaDeLivros.cadastrarLivro(new LivroFiccao("Dom Quixote", "1001", "As aventuras de um cavaleiro sonhador", Ficcao.CONTOS, "Miguel de Cervantes"));
            listaDeLivros.cadastrarLivro(new LivroFiccao("1984", "1002", "Um futuro distópico e totalitário", Ficcao.FICCAO_CIENTIFICA, "George Orwell"));
            listaDeLivros.cadastrarLivro(new LivroFiccao("O Pequeno Príncipe", "1003", "Uma fábula sobre a importância da amizade", Ficcao.CONTOS, "Antoine de Saint-Exupéry"));
            listaDeLivros.cadastrarLivro(new LivroHq("Batman: Ano Um", "2001", "A origem do Batman", Hq.SUPER_HEROIS, "Frank Miller"));
            listaDeLivros.cadastrarLivro(new LivroHq("Berserk", "2002", "Um mundo sombrio de fantasia medieval", Hq.MANGA, "Kentaro Miura"));
            listaDeLivros.cadastrarLivro(new LivroNaoFiccao("Sapiens: Uma Breve História da Humanidade", "3001", "Uma visão geral da história da humanidade", NaoFiccao.HISTORIA, "Yuval Noah Harari"));
            listaDeLivros.cadastrarLivro(new LivroTecnico("O Poder do Hábito", "4001", "Como os hábitos funcionam e como mudá-los", AutoAjuda.DESENVOLVIMENTO_PESSOAL, "Charles Duhigg"));
            listaDeLivros.cadastrarLivro(new LivroTecnico("A Arte da Guerra", "5001", "Um tratado militar clássico", Tecnico.CIENCIAS_HUMANAS, "Sun Tzu"));
            listaDeLivros.cadastrarLivro(new LivroGastronomia("Larousse da Cozinha", "6001", "Um guia completo de técnicas culinárias", Gastronomia.TECNICAS_CULINARIAS, "Larousse"));
            listaDeLivros.cadastrarLivro(new LivroInfantil("Onde Vivem os Monstros", "7001", "Um clássico da literatura infantil", Infantil.LIVRO_ILUSTRADO, "Maurice Sendak"));
          
    gravarLivros(caminhoLivros,listaDeLivros);
    //ListaLivros listaClientes = lerLivro("C:\\Users\\Usuario\\Downloads\\Livraria-main (1)\\Livraria-main\\src\\interfacePrincipal\\regras\\dados\\livros.ser");
    //System.out.println(listaClientes.getElement(0));
    gravarClientes(caminhoClientes, clientes);
    }
}