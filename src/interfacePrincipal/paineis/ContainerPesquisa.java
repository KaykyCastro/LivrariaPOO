package interfacePrincipal.paineis;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import interfacePrincipal.livraria.collection.clientes.ListaClientes;
import interfacePrincipal.livraria.collection.livros.ListaLivros;
import interfacePrincipal.livraria.exceptions.ClienteNaoExisteException;
import interfacePrincipal.livraria.exceptions.LivroNaoExisteException;
import interfacePrincipal.livraria.models.cliente.Cliente;
import interfacePrincipal.livraria.models.livros.Livro;

public class ContainerPesquisa{
	
	private static Object[][] ArrayList = null;
		private JPanel container;
		//testes de Layout
		private FlowLayout fl;
		private GridLayout gl;
		
		
		public Object[][] dados;
		private Object[][] dadosReserva = {{"A", "", "", "", "",""}};
		
		
		private JScrollPane rolagem;
		
		private HeaderPainelBotoes headerBotoes;
		private HeaderListagem headerListagem;
		
		/*
		 * Adicionando um container para a tabela JTable 
		 * de apresentacao de dados
		 * */
		private JPanel painelTabela;
		private static JTable tabelaDados;
				
				//mudado
				private static DefaultTableModel tb;
				
				public ContainerPesquisa() {
					// TODO Auto-generated constructor stub
					
					//idela que seja mudado
					tabelaDados = new JTable();
					tb = new DefaultTableModel();
					
					this.container = new JPanel();
					this.fl = new FlowLayout();
					//this.gl = new GridLayout(1,1);
					this.fl.setVgap(0);
					fl.setHgap(0);
					
					this.fl.setAlignment(FlowLayout.CENTER);
					
					//BorderLayout bd = new BorderLayout();
					
					this.container.setLayout(fl);
					
					//Instancia paineis
					this.headerBotoes = new HeaderPainelBotoes();
					this.headerListagem = new HeaderListagem();
					this.painelTabela = new JPanel();
					
					
					//adiciona o header1
					this.container.add(headerBotoes.retPanel());
					this.container.add(this.headerListagem.retPainel());
					
					//instancia o scroll da tabela
					this.rolagem = new JScrollPane();
					
				}
				
				public JPanel retPanel() {
					//this.container.setBackground(Color.BLACK);
					//this.container.
					
					this.container.setVisible(true);
					return this.container;
				}
				
				public JPanel retPainelBiblioteca() {
					
					//this.painelTabela.setBackground(null);
					
					
					//this.tabelaDadosLivro = new JTable(this.getTableModel());
					/*
					 * Para uma tabela vamos testar a insercao de uma matriz 
					 * de objetos recebidos de algum lugar junto a uma coluna setada.
					 * Este e apenas um EXEMPLO, vamos colocar o correto depois.
					 * */
			
					rolagem.setVisible(true);
					setTableData();
					this.painelTabela.add(tabelaDados);
					this.rolagem.add(this.painelTabela);
					//this.painelTabela.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
					this.painelTabela.setLayout(new GridLayout());
					
					return this.painelTabela;
				}
				
				public static void getTableData(Object lista, String chave,String tipo) throws ClienteNaoExisteException, LivroNaoExisteException{
					//recebe de um getDados por exemplo					
					if(tipo =="Cliente"){
						Object[] colunas;
						colunas = new Object[] {"Nome","Cpf", "Endereco"};
						if(lista instanceof ListaClientes){
								if(chave =="*"){
									ListaClientes lista_c= (ListaClientes) lista;
									System.out.println(lista_c.getDimensao());
									System.out.println(lista_c.listarClientes());
									Object[][] dados = new Object[lista_c.getDimensao() + 1][3];
									dados[0][0] = colunas[0];
									dados[0][1] = colunas[1];
									dados[0][2] = colunas[2];
									for (int i = 0; i < lista_c.getDimensao(); i++) {
										
										Object elemento = lista_c.getElement(i);
										if(elemento instanceof Cliente){
											Cliente cliente = (Cliente) lista_c.getElement(i);
											dados[i + 1][0] = cliente.getNome();
											dados[i + 1][1] = cliente.getCpf();
											dados[i + 1][2] = cliente.getEndereco();
										}
										DefaultTableModel modeloTabela = new DefaultTableModel(dados,colunas);
										tabelaDados.setModel(modeloTabela);
								}
								}else if(chave!="*"){
									ListaClientes lista_c= (ListaClientes) lista;
									
									Object[][] dados = new Object[2][3];
									dados[0][0] = colunas[0];
									dados[0][1] = colunas[1];
									dados[0][2] = colunas[2];
									
									Cliente cliente = (Cliente) lista_c.getCliente(chave);
									dados[1][0] = cliente.getNome();
									dados[1][1] = cliente.getCpf();
									dados[1][2] = cliente.getEndereco();
								

			
						DefaultTableModel modeloTabela = new DefaultTableModel(dados,colunas);
			
						tabelaDados.setModel(modeloTabela);
					}
				}
			}
			else if(tipo=="Livro"){
				System.out.println("entrou em listar livros");

				if(lista instanceof ListaLivros){
					if(chave =="*"){
						System.out.println("entrou em listar livros: *");

						Object[] colunas;
						colunas = new Object[] {"Código","Nome", "Gênero", "Autor","Status"};
			
						System.out.println(lista);
						
						ListaLivros lista_l= (ListaLivros) lista;								
						Object[][] dados = new Object[lista_l.getDimensao() + 1][5];
						dados[0][0] = colunas[0];
						dados[0][1] = colunas[1];
						dados[0][2] = colunas[2];
						dados[0][3] = colunas[3];
						dados[0][4] = colunas[4];
						
						System.out.println(lista_l);
						for (int i = 0; i < lista_l.getDimensao(); i++) {
							
						
							try{
									Livro livro = (Livro) lista_l.getElement(i);
									dados[i+1][0] = livro.getCode();
									dados[i+1][1] = livro.getName();
									dados[i+1][2] = livro.getGenero();
									dados[i+1][3] = livro.getAutor();
									dados[i+1][4] = livro.getStatus();
								
							}catch(NullPointerException e){
								System.out.println("Tipo Inválido");
								
						}
						DefaultTableModel modeloTabela = new DefaultTableModel(dados,colunas);
						tabelaDados.setModel(modeloTabela);
					}
					
			
					}else if(chave!="*"){
						Object[] colunas;
						colunas = new Object[] {"Código","Nome", "Gênero", "Autor","Status"};
			
						System.out.println("Lista Livros _------->" + lista);
						
						ListaLivros lista_l= (ListaLivros) lista;								
						Object[][] dados = new Object[2][5];
						dados[0][0] = colunas[0];
						dados[0][1] = colunas[1];
						dados[0][2] = colunas[2];
						dados[0][3] = colunas[3];
						dados[0][4] = colunas[4];
						
						Livro livro = (Livro) lista_l.getLivro(chave);
						dados[1][0] = livro.getCode();
						dados[1][1] = livro.getName();
						dados[1][2] = livro.getGenero();
						dados[1][3] = livro.getAutor();
						dados[1][4] = livro.getStatus();
					
						DefaultTableModel modeloTabela = new DefaultTableModel(dados,colunas);
						tabelaDados.setModel(modeloTabela);
							}
			
					}
					
					}
				}
			
	public void setTableData(){
		
		
		//Aqui se vai obter os dados, como? nao sei
		Object[] colunas = {"Codigo", "Nome", "Autor/Endereco", "Genero", "Status", "Multa"};
		try {
			
				tabelaDados.setModel(ContainerPesquisa.tb);
		}catch(Exception e) {
			System.out.println("excessao");
			ContainerPesquisa.tb.setDataVector(dadosReserva, colunas);
		}
		
		
		
	}	
	
	
}
