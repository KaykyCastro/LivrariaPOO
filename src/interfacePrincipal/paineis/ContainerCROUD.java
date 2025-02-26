package interfacePrincipal.paineis;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import interfacePrincipal.livraria.exceptions.ClienteJaExisteException;
import interfacePrincipal.livraria.exceptions.ClienteNaoExisteException;
import interfacePrincipal.livraria.exceptions.LivroNaoExisteException;
import interfacePrincipal.livraria.models.cliente.Cliente;
import interfacePrincipal.livraria.models.livros.Livro;
import interfacePrincipal.livraria.models.livros.LivroAutoAjuda;
import interfacePrincipal.livraria.models.livros.LivroCultura;
import interfacePrincipal.livraria.models.livros.LivroFiccao;
import interfacePrincipal.livraria.models.livros.LivroGastronomia;
import interfacePrincipal.livraria.models.livros.LivroHq;
import interfacePrincipal.livraria.models.livros.LivroInfantil;
import interfacePrincipal.livraria.models.livros.LivroNaoFiccao;
import interfacePrincipal.livraria.models.livros.LivroTecnico;
/*
 * A classe que contem os botoes chama-se "PainelButoes"
 * ao final voce pode adicionar seus metodos ou simplesmente usar os que ja tem
 * */
import interfacePrincipal.livraria.models.livros.generos.AutoAjuda;
import interfacePrincipal.livraria.models.livros.generos.Cultura;
import interfacePrincipal.livraria.models.livros.generos.Ficcao;
import interfacePrincipal.livraria.models.livros.generos.Gastronomia;
import interfacePrincipal.livraria.models.livros.generos.Hq;
import interfacePrincipal.livraria.models.livros.generos.Infantil;
import interfacePrincipal.livraria.models.livros.generos.NaoFiccao;
import interfacePrincipal.livraria.models.livros.generos.Tecnico;
import interfacePrincipal.paineis.interfaces.JPanelsActions;
import interfacePrincipal.regras.LivrariaApp;


class PainelHeader implements JPanelsActions{
	private JPanel header;
	private JLabel txtTitulo;
	private JLabel iconeUFC;
	
	public static String caminhoraiz =  System.getProperty("user.dir");
	public static String caminhoLivros = caminhoraiz + "\\Livraria\\src\\interfacePrincipal\\regras\\dados\\livros.ser";
	public static String caminhoClientes = caminhoraiz + "\\Livraria\\src\\interfacePrincipal\\regras\\dados\\clientes.ser";
	public static String caminhoAluguel = caminhoraiz +  "\\Livraria\\src\\interfacePrincipal\\regras\\dados\\alugueis.ser";
	   
	       

     PainelHeader() {
		// TODO Auto-generated constructor stub
		this.header = new JPanel();
		txtTitulo = new JLabel();
		txtTitulo.setText("Livraria");
		Font f = new Font("Teste", 3, 20);
		txtTitulo.setFont(f);
		
		/*
		 * Adicao de icone da UFC, redimensionado em estala pela funcao de Image
		 * */
		ImageIcon ufc = new ImageIcon(getClass().getResource("/imagens/ufc.png"));
		Image icone = ufc.getImage();
		Image novaImagem = icone.getScaledInstance(80, 25, Image.SCALE_SMOOTH);
		ufc = new ImageIcon(novaImagem);
		
		iconeUFC = new JLabel(ufc);
		iconeUFC.setSize(30, 20);
	}
	
	public JPanel getPanel() {
		FlowLayout fl = new FlowLayout();
		fl.setAlignment(FlowLayout.RIGHT);
		//Adicionando componentes a header
		
		this.header.add(txtTitulo);
		this.header.add(iconeUFC);
		
		this.header.setLayout(fl);
		this.header.setVisible(true);
		this.header.setBorder(BorderFactory.createEmptyBorder((int) Math.ceil(ContainerCROUD.screenHeight*0.008), 0, (int) Math.ceil(ContainerCROUD.screenHeight*0.008), 0));
		//this.header.setBackground(Color.MAGENTA);
		return this.header;
		
	}
}

//------Classe do Painel de Livros
class PainelLivros implements JPanelsActions{
	private JPanel painelLivros;
	private JLabel labelCodigo;
	private JLabel labelNome;
	private JLabel labelTipo;
	private JLabel labelGenero;
	private JLabel labelAutor;
	private JLabel labelDesc;
	private JLabel labelTituloPainel;
	
	private JTextField campoCodigo;
	private JTextField campoNome;
	private JTextField campoAutor;
	
	private JTextArea areaDescricao;
	
	private JComboBox<String> selecaoTipo;
	private JComboBox<String> selecaoGenero;
	
	//Acessar campoNome

	public PainelLivros() {
		//instancia o painel
		this.painelLivros = new JPanel();
		
		//Cria os objetos labels
		
		this.labelCodigo = new JLabel("Codigo:");
		this.labelNome = new JLabel("Nome:");
		this.labelTipo = new JLabel("Tipo:");
		this.labelGenero = new JLabel("Genero:");
		this.labelAutor = new JLabel("Autor:");
		this.labelDesc = new JLabel("Descriçao:");
		
		Font f = new Font("Font A", 4, 15);
		this.labelTituloPainel = new JLabel("Livros");
		this.labelTituloPainel.setFont(f);
		//cria os objetos campos de texto
		this.campoCodigo = new JTextField(15);
		this.campoNome = new JTextField(15);
		this.campoAutor = new JTextField(15);

		/*
		 * Configurando campos de texto
		 * */
		
		
		//Cria objetos de area de texto
		this.areaDescricao =  new JTextArea(10,10);
		//this.areaDescricao.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 13));
		//cria objetos de caixa de selecao combo
		this.selecaoGenero = new JComboBox<String>();
		setDadosGenero();
		
		this.selecaoTipo =  new JComboBox<String>();
		setDadosTipo((String) selecaoGenero.getSelectedItem());

		// Adiciona o ActionListener para selecaoGenero
		selecaoGenero.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				setDadosTipo((String) selecaoGenero.getSelectedItem()); // Atualiza selecaoTipo com base no gênero
			}
		});
	}
		
	
		/*
		 * Temos que popular os dados dessa selecao de tipo
		 * por enquanto eu mesmo populei
		 * */


	/*
	 * Aqui esta, fique a vontade para buscar dados a sua maneira ou modificar as 
	 * funcoes abaixo
	 * */
	public boolean setDadosGenero(){
		ArrayList<String> generos = new ArrayList<String>();
		//Aqui deveriamos buscar os dados a partir de uma funcao
		//Mas eu coloquei manualmente
		
		generos.add((String) "Auto Ajuda");
		generos.add((String) "Cultura");
		generos.add((String) "Gastronomia");
		generos.add((String) "Hq");
		generos.add((String) "Infantil");
		generos.add((String) "Não Ficção");
		generos.add((String) "Técnico");
		
		/*Um tratamento simples paraa verificar se a lista ta vazia
		 *  o correto seria lancar uma excessao aqui
		 * 
		 */
		if(generos.isEmpty() != true) {
			for(String genero : generos) {
				this.selecaoGenero.addItem(genero);
			}
		}else {
			System.out.println("Tipos vazio");
			JOptionPane.showMessageDialog(null, "Nao ha tipos, esta vazio!");
			return false;
		}
		
		return true;
	}

	public boolean setDadosTipo(String generoSelecionado){
		selecaoTipo.removeAllItems();
		ArrayList<String> tipos = new ArrayList<String>();
		
		//Aqui deveriamos buscar os dados a partir de uma funcao
		//Mas eu coloquei manualmente
		;

		if(generoSelecionado == "Auto Ajuda"){
			for (AutoAjuda tipo : AutoAjuda.values()) {
				tipos.add(tipo.getNome());
			  }
		}else if(generoSelecionado == "Cultura"){
			for (Cultura tipo : Cultura.values()) {
				tipos.add(tipo.getNome());
			  }
		}else if(generoSelecionado == "Gastronomia"){
			for (Gastronomia tipo : Gastronomia.values()) {
				tipos.add(tipo.getNome());
			  }
		}else if(generoSelecionado == "Hq"){
			for (Hq tipo : Hq.values()) {
				tipos.add(tipo.getNome());
			  }
		}else if(generoSelecionado == "Infantil"){
			for (Infantil tipo : Infantil.values()) {
				tipos.add(tipo.getNome());
			  }
		}else if(generoSelecionado == "Não Ficção"){
			for (NaoFiccao tipo : NaoFiccao.values()) {
				tipos.add(tipo.getNome());
			  }
		}else if(generoSelecionado == "Técnico"){
			for (Tecnico tipo : Tecnico.values()) {
				tipos.add(tipo.getNome());
			  }
		} 
		
		/*Um tratamento simples paraa verificar se a lista ta vazia
		 *  o correto seria lancar uma excessao aqui
		 * 
		 */
		
		if(tipos.isEmpty() != true) {
			for(String tipo : tipos) {
				this.selecaoTipo.addItem(tipo);
			}
		
		}else {
			System.out.println("Tipos vazio");
			JOptionPane.showMessageDialog(null, "Nao ha tipos, está vazio!");
			return false;
		}
		
		return true;
	}
	
	//Metodo para pegar o nome do campo
	//public String getCampoNome(){
	//	return this.campoNome.getText();}
	/*
	private JTextField campoCodigo;
	private JTextField campoNome;
	private JTextField campoAutor;
	
	private JTextArea areaDescricao;
	
	private JComboBox<String> selecaoTipo;
	private JComboBox<String> selecaoGenero; */
	
	@Override
	public JPanel getPanel() {
		this.painelLivros.setLayout(new GridBagLayout());
		GridBagConstraints constante = new GridBagConstraints();
		
		
		//Adiciona itens de componentes
		// ||||||||||
//		constante.gridx = 0;
//		constante.gridy = 0;
//		constante.gridwidth = 8;
//		constante.gridheight = 1;
//		constante.fill = GridBagConstraints.RELATIVE;
//		this.painelLivros.add(new JLabel(" "), constante);
		constante.gridx = 0;
		constante.gridy = 0;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		this.painelLivros.add(labelTituloPainel, constante);
		
		constante.gridx = 0;
		constante.gridy = 1;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		//constante.fill = GridBagConstraints.RELATIVE;
		this.painelLivros.add(labelCodigo, constante);
		
		constante.gridx = 0;
		constante.gridy = 2;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.RELATIVE;
		this.painelLivros.add(campoCodigo, constante);
		
		constante.gridx = 5;
		constante.gridy = 1;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		//constante.fill = GridBagConstraints.RELATIVE;
		this.painelLivros.add(labelNome, constante);
		constante.gridx = 5;
		constante.gridy = 2;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.RELATIVE;
		this.painelLivros.add(campoNome, constante);
		
		constante.gridx = 0;
		constante.gridy = 3;
		constante.gridwidth = 2;
		constante.gridheight = 1;
		//constante.fill = GridBagConstraints.WEST;
		labelTipo.setLabelFor(selecaoTipo);
		this.painelLivros.add(labelTipo, constante);
		
		constante.gridx = 0;
		constante.gridy = 4;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		//constante.fill = GridBagConstraints.RELATIVE;
		this.painelLivros.add(selecaoTipo, constante);
		
		constante.gridx = 3;
		constante.gridy = 3;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		//constante.fill = GridBagConstraints.RELATIVE;
		this.painelLivros.add(labelGenero, constante);
		
		constante.gridx = 2;
		constante.gridy = 4;
		constante.gridwidth = 2;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.RELATIVE;
		this.painelLivros.add(selecaoGenero, constante);
		
		constante.gridx = 5;
		constante.gridy = 3;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.RELATIVE;
		labelAutor.setLabelFor(campoAutor);
		this.painelLivros.add(labelAutor, constante);
		constante.gridx = 5;
		constante.gridy = 4;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		
		//constante.fill = GridBagConstraints.RELATIVE;
		this.painelLivros.add(campoAutor, constante);
		
		constante.gridx = 0;
		constante.gridy = 7;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.RELATIVE;
		this.painelLivros.add(labelDesc, constante);
		constante.gridx = 0;
		constante.gridy = 8;
		constante.gridwidth = 10;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.BOTH;
		this.painelLivros.add(areaDescricao, constante);
		
		
//		constante.gridx = 0;
//		constante.gridy = 8;
//		constante.gridwidth = 8;
//		constante.gridheight = 1;
//		constante.fill = GridBagConstraints.RELATIVE;
//		this.painelLivros.add(new JLabel(" "), constante);
//		
		this.painelLivros.setBorder(BorderFactory.createEmptyBorder(15, 2, 15, 2));
		this.painelLivros.setBackground(Color.WHITE);
		this.painelLivros.setVisible(true);
		return this.painelLivros;
	}

	public JPanel getPainelLivros() {
		return painelLivros;
	}

	public void setPainelLivros(JPanel painelLivros) {
		this.painelLivros = painelLivros;
	}

	public JLabel getLabelCodigo() {
		return labelCodigo;
	}

	public void setLabelCodigo(JLabel labelCodigo) {
		this.labelCodigo = labelCodigo;
	}

	public JLabel getLabelNome() {
		return labelNome;
	}

	public void setLabelNome(JLabel labelNome) {
		this.labelNome = labelNome;
	}

	public JLabel getLabelTipo() {
		return labelTipo;
	}

	public void setLabelTipo(JLabel labelTipo) {
		this.labelTipo = labelTipo;
	}

	public JLabel getLabelGenero() {
		return labelGenero;
	}

	public void setLabelGenero(JLabel labelGenero) {
		this.labelGenero = labelGenero;
	}

	public JLabel getLabelAutor() {
		return labelAutor;
	}

	public void setLabelAutor(JLabel labelAutor) {
		this.labelAutor = labelAutor;
	}

	public JLabel getLabelDesc() {
		return labelDesc;
	}

	public void setLabelDesc(JLabel labelDesc) {
		this.labelDesc = labelDesc;
	}

	public JLabel getLabelTituloPainel() {
		return labelTituloPainel;
	}

	public void setLabelTituloPainel(JLabel labelTituloPainel) {
		this.labelTituloPainel = labelTituloPainel;
	}

	public JTextField getCampoCodigo() {
		return campoCodigo;
	}

	public void setCampoCodigo(JTextField campoCodigo) {
		this.campoCodigo = campoCodigo;
	}

	public JTextField getCampoNome() {
		return this.campoNome;
	}

	public void setCampoNome(JTextField campoNome) {
		this.campoNome = campoNome;
	}

	public JTextField getCampoAutor() {
		return campoAutor;
	}

	public void setCampoAutor(JTextField campoAutor) {
		this.campoAutor = campoAutor;
	}

	public JTextArea getAreaDescricao() {
		return areaDescricao;
	}

	public void setAreaDescricao(JTextArea areaDescricao) {
		this.areaDescricao = areaDescricao;
	}

	public JComboBox<String> getSelecaoTipo() {
		return selecaoTipo;
	}

	public void setSelecaoTipo(JComboBox<String> selecaoTipo) {
		this.selecaoTipo = selecaoTipo;
	}

	public JComboBox<String> getSelecaoGenero() {
		return selecaoGenero;
	}

	public void setSelecaoGenero(JComboBox<String> selecaoGenero) {
		this.selecaoGenero = selecaoGenero;
	}
	
	
}

//---Classe que configura o painel de Clientes a ser adicionado no container
class PainelClientes implements JPanelsActions{
	
	//Variaveis, vamos colocar o que vai ter no painel de clientes
	//Layouts tambem seria legal colocar aqui, vamos de GridBagLayout
	private JPanel painelClientes;
	
	private JLabel labelTituloClientes;
	private JLabel labelCpf;
	private JLabel labelNome;
	private JLabel labelEndereco;
	
	private JTextField campoNome;
	private JTextField campoCpf;
	private JTextField campoEndereco;
	
	private GridBagLayout gbl;

	public PainelClientes() {
		/*
		 * Vamos instanciar as nossas variaveis aqui
		 * afinal a configuracao do nosso painel e padrao e nao variavel
		 * conforme instancia.
		 * */
		
		this.painelClientes = new JPanel();
		
		
		
		//Instanciando objetos das Labels e campos
		//, vamos evitar Null pointer nos proximos metodos
		this.labelTituloClientes = new JLabel("Clientes");
		this.labelCpf = new JLabel("CPF:");
		this.labelNome = new JLabel("Nome:");
		this.labelEndereco = new JLabel("Endereço");
		
		this.campoNome = new JTextField(15);
		this.campoCpf = new JTextField(15);
		this.campoEndereco = new JTextField(31);
		
		

	}
	
	
	@Override
	public JPanel getPanel() {
		// Essa constante contem os valores relacionados a posicao e ocupamento de celulas
		GridBagConstraints constante = new GridBagConstraints();
		this.gbl = new GridBagLayout();
		this.painelClientes.setLayout(gbl);
		
		//Titulo "Clientes"
		constante.gridx = 0;
		constante.gridy = 0;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		Font f = new Font("Fonte A", 4, 15);
		this.labelTituloClientes.setFont(f);
		this.painelClientes.add(labelTituloClientes, constante);
		
		constante.gridx = 0;
		constante.gridy = 1;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		this.painelClientes.add(labelCpf, constante);
		
		constante.gridx = 0;
		constante.gridy = 2;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.RELATIVE;
		this.painelClientes.add(campoCpf, constante);
		
		constante.gridx = 6;
		constante.gridy = 1;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		this.painelClientes.add(labelNome, constante);
		
		constante.gridx = 6;
		constante.gridy = 2;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.RELATIVE;
		this.painelClientes.add(campoNome, constante);
		
		constante.gridx = 0;
		constante.gridy = 3;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.RELATIVE;
		this.painelClientes.add(labelEndereco, constante);
		
		constante.gridx = 0;
		constante.gridy = 7;
		constante.gridwidth = 10;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.RELATIVE;
		this.painelClientes.add(campoEndereco, constante);
		
		
		//this.painelClientes.setBorder(BorderFactory.createEmptyBorder(15, 2, 15, 2));
		this.painelClientes.setBackground(Color.WHITE);
		
		
		return this.painelClientes;
	}
	public JTextField getNomeCliente(){
		return this.campoNome;
	}
	public JTextField getCpf(){
		return this.campoCpf;
	}
	public JTextField getEndereco(){
		return this.campoEndereco;
	}
	
}

class PainelButoes implements JPanelsActions{

	private JPanel painelBotoes;
	
	private JButton btnCadastrarLivro;
	private JButton btnRemoverLivro;
	private JButton btnAlugarLivro;
	
	private JButton btnCadastrarCliente;
	private JButton btnRemoverCliente;
	private JButton btnDevolucao;
	
	private GridBagLayout gbl;
	private GridBagConstraints constante;
	
	//private PainelClientes painelClientes;
	private PainelLivros painelLivros;
	private PainelClientes painelClientes;
	private LivrariaApp app;
	private Livro livro;

	
	public PainelButoes(PainelLivros painelLivros, PainelClientes painelClientes, LivrariaApp app) throws FileNotFoundException, ClassNotFoundException, IOException, ClienteNaoExisteException, UnsupportedOperationException, ClienteJaExisteException { 
		// Adicionando Controle para livros, clientes e LivrariaApp
		this.painelLivros = painelLivros;
		this.painelClientes = painelClientes;
		this.app = app;		
		this.app.getDadosGravadosClientes();
		this.app.getDadosGravadosLivros();
		this.app.getDadosAlugueisLivros();
		/*Adicionando Paineis */
		
		// TODO Auto-generated constructor stub
		this.painelBotoes = new JPanel();
		this.gbl = new GridBagLayout();
		this.constante = new GridBagConstraints();
		
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
		this.btnCadastrarLivro =  new JButton("Cadastrar Livro");
		this.btnRemoverLivro =  new JButton("Remover Livro");
		this.btnAlugarLivro =  new JButton("Alugar Livro");
		this.btnCadastrarCliente =  new JButton("Cadastrar Cliente");
		this.btnRemoverCliente =  new JButton("Remover Cliente");
		this.btnDevolucao =  new JButton("Devoluçoes");
		
		this.btnRemoverLivro.setCursor(c);
		this.btnCadastrarLivro.setCursor(c);
		this.btnAlugarLivro.setCursor(c);
		this.btnCadastrarCliente.setCursor(c);
		this.btnRemoverCliente.setCursor(c);
		this.btnDevolucao.setCursor(c);
	}
	
	
	@Override
	public JPanel getPanel() {
		this.painelBotoes.setLayout(gbl);
		constante.insets = new Insets(5, 5, 5, 5);
		
		constante.gridx = 0;
		constante.gridy = 1;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.BOTH;
		this.painelBotoes.add(btnCadastrarLivro, constante);
		
		constante.gridx = 0;
		constante.gridy = 2;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.BOTH;
		this.painelBotoes.add(btnRemoverLivro, constante);
		
		constante.gridx = 0;
		constante.gridy = 3;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.BOTH;
		this.painelBotoes.add(btnAlugarLivro, constante);
		
		constante.gridx = 5;
		constante.gridy = 1;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.BOTH;
		this.painelBotoes.add(btnCadastrarCliente, constante);
		
		constante.gridx = 5;
		constante.gridy = 2;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.BOTH;
		this.painelBotoes.add(btnRemoverCliente, constante);
		
		constante.gridx = 5;
		constante.gridy = 3;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.BOTH;
		this.painelBotoes.add(btnDevolucao, constante);
		
		
		/*
		 * Aqui e outra sessao interessante, sao as proprias funcoes configuradas que 
		 * voce pode mexer e configurar a vontade.
		 * */
		this.btnCadastrarLivro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(PainelLivros.getDados());
				btnCadastrarLivro();
			}
		});
		this.btnRemoverLivro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				try {
					btnRemoveLivro();
				} catch (LivroNaoExisteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}			
			}
		});
		this.btnAlugarLivro.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					btnAlugarLivro();
				} catch (ClienteNaoExisteException cne) {
					// TODO Auto-generated catch block
					cne.printStackTrace();
				}catch(LivroNaoExisteException lne){
					lne.printStackTrace();
				} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NullPointerException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
		}
		});
		this.btnCadastrarCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					btnCadastrarCliente();
				} catch (ClienteJaExisteException cje) {
					// TODO Auto-generated catch block
					cje.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		this.btnRemoverCliente.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
				try {
					btnRemoverCliente();
				} catch (ClienteNaoExisteException cne) {
					// TODO Auto-generated catch block
					cne.printStackTrace();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		this.btnDevolucao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					try {
						btnDevolucao();
					}
					catch (ClienteNaoExisteException cne) {
						// TODO Auto-generated catch block
						cne.printStackTrace();
					}catch(LivroNaoExisteException lne){
						lne.printStackTrace();
					} catch (FileNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
				}
			});
		
		
		this.painelBotoes.setBackground(Color.WHITE);
		//this.painelBotoes.setBorder(BorderFactory.createEmptyBorder(ContainerCROUD.screenHeight/20, 2, ContainerCROUD.screenHeight/20, 2));
		return this.painelBotoes;
	}
	
	
	
	/*
	 * Esta sessao e dedicada a voce, meu caro, todos os metodos abaixo ate o 
	 * final da classe sao acoes dos respectivos botoes, fique a vontade para
	 * modificar ou adicionar novos metodos.
	 * */
	public void btnCadastrarLivro() {
		
			System.out.println("Cadastrando Livro");
	
			String codigo = painelLivros.getCampoCodigo().getText();
			String nome = painelLivros.getCampoNome().getText();
			String autor = painelLivros.getCampoAutor().getText();
			String descricao = painelLivros.getAreaDescricao().getText();
			String tipo = (String) painelLivros.getSelecaoTipo().getSelectedItem();

			/* Regras para cadastrar livro:
				* Parte 1: Verificar se os campos estão preenchidos
			*/
			if (codigo.isEmpty() || nome.isEmpty() || autor.isEmpty() || descricao.isEmpty() || tipo.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos");
				return;
			}
			/*	* Parte 2: Verificar se o código é um número
					* 1. Verificar se o código é um número
								
				*/
			else if(!codigo.matches("[0-9]+")&& codigo.length() >= 0) {
				JOptionPane.showMessageDialog(null, "O código deve ser um número");
				return;
				
			}
			/* Parte 3:  Cadastra de livro */
			else{
				//Cadastrar livro
				
				String generoSelecionado = (String) painelLivros.getSelecaoGenero().getSelectedItem();
				if(generoSelecionado == "Auto Ajuda"){
					LivroAutoAjuda livro = new LivroAutoAjuda(nome, codigo, descricao, AutoAjuda.fromNome(tipo), autor);
					app.cadastrarLivros(livro);

				}else if(generoSelecionado == "Cultura"){
					LivroCultura livro = new LivroCultura(nome, codigo, descricao, Cultura.fromNome(tipo), autor);
					app.cadastrarLivros(livro);
				}
				else if(generoSelecionado == "Ficção"){
					LivroFiccao livro = new LivroFiccao(nome, codigo, descricao, Ficcao.fromNome(tipo), autor);
					app.cadastrarLivros(livro);
				}
				else if(generoSelecionado == "Gastronomia"){
					LivroGastronomia livro = new LivroGastronomia(nome, codigo, descricao, Gastronomia.fromNome(tipo), autor);
					app.cadastrarLivros(livro);
				}
				else if(generoSelecionado == "Hq"){
					LivroHq livro = new LivroHq(nome, codigo, descricao, Hq.fromNome(tipo), autor);
					app.cadastrarLivros(livro);
				}
				else if(generoSelecionado == "Infantil"){
					LivroInfantil livro = new LivroInfantil(nome, codigo, descricao, Infantil.fromNome(tipo), autor);
					app.cadastrarLivros(livro);
				}
				else if(generoSelecionado == "Não Ficção"){
					LivroNaoFiccao livro = new LivroNaoFiccao(nome, codigo, descricao, NaoFiccao.fromNome(tipo), autor);
					app.cadastrarLivros(livro);
				}
				else if(generoSelecionado == "Técnico"){
					LivroTecnico livro = new LivroTecnico(nome, codigo, descricao, Tecnico.fromNome(tipo), autor);
					app.cadastrarLivros(livro);
				}
			
				JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso");
				

				// mostrar no painel atualizado!
				//somente na chamada
				
				}
		}
		
		
		public void btnRemoveLivro() throws LivroNaoExisteException, FileNotFoundException, ClassNotFoundException, IOException {

			String codigoLivro = JOptionPane.showInputDialog(null, "Digite o código do livro a ser removido:", "Remover Livro", JOptionPane.QUESTION_MESSAGE);
			if(codigoLivro!=null){
				String nomeLivro = app.getNome(codigoLivro);
				app.removerLivro(codigoLivro);
				JOptionPane.showMessageDialog(null, "Livro " + nomeLivro+ " removido");
			}else{
				JOptionPane.showMessageDialog(null, "Passe um valor válido");
			}

		}
		public void btnAlugarLivro() throws ClienteNaoExisteException, LivroNaoExisteException, FileNotFoundException, IOException, NullPointerException, ClassNotFoundException {
			// cria um caixa de diálogo para alugar o livro
			// Cria o painel
			JPanel painel = new JPanel(new GridLayout(0, 1)); // Layout de uma coluna
			painel.add(new JLabel("Código do Livro:"));
			JTextField campoCodigo = new JTextField();
			painel.add(campoCodigo);
			painel.add(new JLabel("CPF do Cliente:"));
			JTextField campoCPF = new JTextField();
			painel.add(campoCPF);

			// Construia a caixa de diálogo
			JOptionPane.showConfirmDialog(null, painel, "Alugar Livro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

			try{
				if(campoCodigo.getText()!=null && campoCPF.getText()!=null){
					System.out.println("executando cadastrado de aluguel");
					app.alugarLivro(campoCPF.getText(), campoCodigo.getText());
			}else{
				JOptionPane.showMessageDialog(null, "Algum dos valores não foi colocado corretamente");
			}
			}catch(ClienteNaoExisteException cne){
				JOptionPane.showMessageDialog(null, "Cliente não existe!");
			}catch(LivroNaoExisteException lne){
				JOptionPane.showMessageDialog(null, "Livro não existe!");
			}
		}
		public void btnCadastrarCliente() throws ClienteJaExisteException, FileNotFoundException, ClassNotFoundException, IOException {
			String nome = painelClientes.getNomeCliente().getText();
			String cpf = painelClientes.getCpf().getText();
			String endereco = painelClientes.getEndereco().getText();
			try{
					if(nome==null || cpf== null || endereco==null){
						JOptionPane.showMessageDialog(null, "Campo(s) preenchido(s) sem valor!");
					}else{
						Cliente cliente = new Cliente(nome, cpf, endereco);
						app.cadastrarCliente(cliente);
					}
			}catch(ClienteJaExisteException cje){
				JOptionPane.showMessageDialog(null, "Cliente já cadastrado!");
			}
			
		}
		public void btnRemoverCliente() throws ClienteNaoExisteException, FileNotFoundException, ClassNotFoundException, IOException{
			try{
				String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do cliente a ser removido:", "Remover Livro", JOptionPane.QUESTION_MESSAGE);
		
				if(cpf== null){
					JOptionPane.showMessageDialog(null, "Campo(s) preenchido(s) sem valor!");
				}else{
					app.removerCliente(cpf);

					
				}
			}catch(ClienteNaoExisteException cne){
				JOptionPane.showMessageDialog(null, "Cliente não existente!");
			}
			
		}
		public void btnDevolucao() throws ClienteNaoExisteException, LivroNaoExisteException, FileNotFoundException, IOException{
			// cria um caixa de diálogo para alugar o livro
			// Cria o painel
			JPanel painel = new JPanel(new GridLayout(0, 1)); // Layout de uma coluna
			painel.add(new JLabel("Código do Livro:"));
			JTextField campoCodigo = new JTextField();
			painel.add(campoCodigo);
			painel.add(new JLabel("CPF do Cliente:"));
			JTextField campoCPF = new JTextField();
			painel.add(campoCPF);

			// Construia a caixa de diálogo
			JOptionPane.showConfirmDialog(null, painel, "Alugar Livro", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

			try{
			if(campoCodigo.getText()!=null && campoCPF.getText()!=null){
				app.devolucao(campoCPF.getText(),campoCodigo.getText());
			}else{
				JOptionPane.showMessageDialog(null, "Algum dos valores não foi cadastrado corretamente");
			}
			}catch(ClienteNaoExisteException cne){
				JOptionPane.showMessageDialog(null, "Cliente não existe!");
			}catch(LivroNaoExisteException lne){
				JOptionPane.showMessageDialog(null, "Livro não existe!");
			}
		}
	}
	



public class ContainerCROUD implements JPanelsActions{
	private LivrariaApp gerenciador =  new LivrariaApp();;
	private Dimension screenSize;
	public static int screenWidth;  // Largura da tela
    public static int screenHeight;
	
	private JPanel container;
	private JPanel englobaLivros;
	private PainelHeader painelHeader;
	private PainelLivros painelLivros;
	private PainelClientes painelClientes;
	private PainelButoes painelBotoes;
	
	//painel auxiliar
	private JPanel englobaClientes;
	private JPanel englobaLivrosEClientes;
	private JPanel englobaBotoes;
		
		public ContainerCROUD() throws FileNotFoundException, ClassNotFoundException, IOException, ClienteNaoExisteException, UnsupportedOperationException, ClienteJaExisteException {
			// TODO Auto-generated constructor stub
			screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			screenWidth = screenSize.width;
			screenHeight = screenSize.height;
			//pega a dimensao da tela
			//Instancia os paineis
			this.painelHeader = new PainelHeader();
			this.painelLivros = new PainelLivros();
			this.painelClientes = new PainelClientes();
			this.painelBotoes = new PainelButoes(this.painelLivros, this.painelClientes,this.gerenciador);
		
		
		//painel auxiliar para organizar os livros e os clientes
		this.englobaLivros = new JPanel();
		this.englobaLivros.setLayout(new BorderLayout());
		this.englobaClientes = new JPanel();
		this.englobaClientes.setLayout(new BorderLayout());
		this.englobaLivrosEClientes = new JPanel();
		this.englobaBotoes = new JPanel();
		this.englobaBotoes.setLayout(new BorderLayout());
		
		
		//Configuracoes de borda devem ser personalizadas para cada computador
		this.englobaLivros.setBorder(BorderFactory.createEmptyBorder( (int) Math.ceil(screenHeight*0.008), (int) Math.ceil(screenWidth *0.008), (int) Math.ceil(screenHeight*0.008), (int) Math.ceil(screenWidth*0.008)));
		this.englobaBotoes.setBorder(BorderFactory.createEmptyBorder( (int) Math.ceil(screenHeight*0.008), (int) Math.ceil(screenWidth *0.008), (int) Math.ceil(screenHeight*0.008), (int) Math.ceil(screenWidth*0.008)));
		this.englobaClientes.setBorder(BorderFactory.createEmptyBorder( (int) Math.ceil(screenHeight*0.008), (int) Math.ceil(screenWidth *0.008), (int) Math.ceil(screenHeight*0.008), (int) Math.ceil(screenWidth*0.008)));
		this.englobaLivrosEClientes.setLayout(new BorderLayout());
		
		this.container = new JPanel();
		BorderLayout bl = new BorderLayout();
		this.container.setLayout(bl);
		
	}
	
	public JPanel getPanel() {
		/*
		 * Esse metodo serve especificamente para configuracoes
		 * iniciais do painel, ele devolve um painel configurado
		 * o ideal e adicionar os itens do painel no momento que ele for
		 * instanciado, assim pelo menos a gente vai saber onde procurar
		 * os itens dele.
		 * 
		 * aqui podemos colocar funcoes tambem, principalmente eventos que
		 * chamam outras funcoes como cadastro etc.
		 * */
		
		this.container.add(painelHeader.getPanel(), BorderLayout.NORTH);
		
		this.englobaBotoes.add(painelBotoes.getPanel());
		this.englobaLivros.add(painelLivros.getPanel(), BorderLayout.NORTH);
		//this.englobaClientes.setBackground(Color.BLUE);
		this.englobaClientes.add(painelClientes.getPanel(), BorderLayout.CENTER);
		
		
		//this.englobaClientes.setBackground(Color.BLACK);
		this.englobaLivrosEClientes.add(englobaLivros, BorderLayout.NORTH);
		this.englobaLivrosEClientes.add(englobaClientes, BorderLayout.CENTER);
		
		//this.container.add(this.englobaLivros, BorderLayout.CENTER);
		
		
		
		this.container.add(this.englobaLivrosEClientes,  BorderLayout.CENTER);
		this.container.add(this.englobaBotoes, BorderLayout.SOUTH);
		this.container.setVisible(true);
		
		return this.container;
		
	}
}
