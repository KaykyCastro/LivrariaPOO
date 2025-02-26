package interfacePrincipal.paineis;

import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import interfacePrincipal.regras.ControleDados;
import interfacePrincipal.livraria.collection.clientes.ListaClientes;
import interfacePrincipal.livraria.collection.livros.ListaLivros;
import interfacePrincipal.livraria.exceptions.ClienteNaoExisteException;
import interfacePrincipal.livraria.exceptions.LivroNaoExisteException;

public class HeaderListagem {
	
	private JPanel painelListagem;
	private JComboBox<String> comboBoxLivro;
	private JComboBox<String> comboBoxCliente;
	private JButton b1;
	private FlowLayout fl;
	   public static String caminhoraiz =  System.getProperty("user.dir");
	   public static String caminhoLivros = caminhoraiz + "\\src\\interfacePrincipal\\regras\\dados\\livros.ser";
	   public static String caminhoClientes = caminhoraiz + "\\src\\interfacePrincipal\\regras\\dados\\clientes.ser";
	   public static String caminhoAluguel = caminhoraiz +  "\\src\\interfacePrincipal\\regras\\dados\\alugueis.ser";
	   
       

	
	public HeaderListagem() {
		// TODO Auto-generated constructor stub
		b1 = new JButton("teste");
		/*
		 * Configura a combobox de Lvro adicionando as opcoes
		 * disponiveis
		 * */
		this.comboBoxLivro = new JComboBox<String>();
		this.comboBoxLivro.addItem("Livro");
		this.comboBoxLivro.addItem("Listagem por Status");
		this.comboBoxLivro.addItem("Listagem por Genero");
		this.comboBoxLivro.setVisible(true);
		
		/*
		 * Configura a combobox de Cliente adicionando as opcoes
		 * disponiveis, no caso so uma por enquanto
		 * */
		this.comboBoxCliente = new JComboBox<String>();
		this.comboBoxCliente.setToolTipText("Cliente");
		this.comboBoxCliente.addItem("Cliente");
		
		//Configura Painel
		this.painelListagem = new JPanel();
		this.fl = new FlowLayout(FlowLayout.RIGHT);
		
		this.fl = new FlowLayout();
		this.fl.setAlignment(FlowLayout.LEFT);
		this.painelListagem.setLayout(this.fl);
		//this.painelListagem.setBackground(Color.BLUE);
	}
	/*
	 * 
	 * Aqui esta a funcao que voce deve adicionar a acao, fique a vontade
	 * pode criar funcoes por ai tambem, essa e com relacao aos itens do combobox
	 * quando clicados
	 * */
	public JPanel retPainel() {
		comboBoxLivro.addActionListener(e -> {
			//Escreva sua fucao de buscar dados aqui
			if(comboBoxLivro.getSelectedItem().toString() =="Livro"){
				
				
				try {
					ListaLivros lista = ControleDados.lerLivro(caminhoLivros);
					pesquisaLivros(lista,"*");
					System.out.println("Combobox acionado!");
					System.out.println(lista.getDimensao());

				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClienteNaoExisteException e1) {
									// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LivroNaoExisteException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
				}
		});
		comboBoxCliente.addActionListener(e -> {
			if(comboBoxCliente.getSelectedItem().toString() =="Cliente"){
				try {
					ListaClientes lista = ControleDados.lerCliente(caminhoClientes);
					pesquisaClientes(lista,"*");
					System.out.println("Combobox acionado!");
					System.out.println(lista.getDimensao());

				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClienteNaoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (LivroNaoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		);
		
		
		
		//Adiciona componentes
		this.painelListagem.add(comboBoxLivro);
		this.painelListagem.add(comboBoxCliente);
		this.painelListagem.setBorder(BorderFactory.createEmptyBorder(0, (int) Math.ceil(ContainerCROUD.screenWidth*0.009), 0, 0));;
		return this.painelListagem;
	}
	public void pesquisaLivros(ListaLivros valor, String codigo) throws FileNotFoundException, ClassNotFoundException, IOException, ClienteNaoExisteException, LivroNaoExisteException {
		
		ContainerPesquisa.getTableData(valor,codigo, "Livro");
	}
	public void pesquisaClientes(ListaClientes valor, String cpf) throws ClienteNaoExisteException, LivroNaoExisteException {
		ContainerPesquisa.getTableData(valor, cpf, "Cliente");
	}
	
	
}

