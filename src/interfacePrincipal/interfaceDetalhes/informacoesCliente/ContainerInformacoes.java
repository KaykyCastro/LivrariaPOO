package interfacePrincipal.interfaceDetalhes.informacoesCliente;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;


import javax.swing.BorderFactory;

import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class ContainerInformacoes  {
	private JPanel formatador;
	private JPanel detalhesCliente;
	private JPanel livrosCliente;
	
	private informaçoes informaçoes;
	private alugados alugados;
	

	public void ContainerInformaçoes() {
		this.informaçoes = new informaçoes();
		this.alugados = new alugados();
		//
		this.formatador = new JPanel();
		this.formatador.setLayout(new BorderLayout());
		this.detalhesCliente = new JPanel();
		this.detalhesCliente.setLayout(new BorderLayout());
             
		this.livrosCliente = new JPanel();
		this.livrosCliente.setLayout(new BorderLayout());
		
	}
	public JPanel getPanel() {
		this.detalhesCliente.add(informaçoes.getPanel(), BorderLayout.NORTH);
		this.livrosCliente.add(alugados.getPanel(), BorderLayout.CENTER);
		this.formatador.add(detalhesCliente,BorderLayout.NORTH);
		this.formatador.add(livrosCliente,BorderLayout.CENTER);
		return this.formatador;
	}
}


//-----------------------------------------------
 class informaçoes  {
	private Dimension screenSize;
	public static int screenWidth;  // Largura da tela
    public static int screenHeight;
    
	private JPanel painelDetalhes;
	private JLabel Ltitulo;
	private JLabel LCpf;
	private JLabel LNome;
	private JLabel LEndereco;
	private JLabel LMulta;
	
	private JTextField TCpf;
	private JTextField TNome;
	private JTextField TEndereco;
	private JTextField TMulta;
	private Object dadoscadastro[];
	public informaçoes() {
		this.painelDetalhes = new JPanel();
		//
		this.LCpf = new JLabel("CPF:");
		this.LNome = new JLabel("Nome:") ;
		this.LEndereco = new JLabel("Endereço:");
		this.LMulta = new JLabel("Multa:");
		this.Ltitulo = new JLabel("Cliente:");
				
		//textos
		this.TCpf = new JTextField(15);
		this.TNome= new JTextField(15);
		this.TEndereco = new JTextField(15);
		this.TMulta = new JTextField(15);
		
                
		
		
		
		
	}
	
	public JPanel getPanel() {
		this.painelDetalhes.setLayout(new GridBagLayout());
		GridBagConstraints constante = new GridBagConstraints();
                this.getCadastro();
		constante.gridx = 0;
		constante.gridy = 0;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		this.painelDetalhes.add(Ltitulo, constante);
		
		//
		constante.gridx = 0;
		constante.gridy = 1;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		this.painelDetalhes.add(LCpf, constante);
		//
		constante.gridx = 0;
		constante.gridy = 2;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		this.painelDetalhes.add(TCpf, constante);
		//
		constante.gridx = 5;
		constante.gridy = 1;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		this.painelDetalhes.add(LNome, constante);
		//
		constante.gridx = 5;
		constante.gridy = 2;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		this.painelDetalhes.add(TNome, constante);
		//
		constante.gridx = 0;
		constante.gridy = 3;
		constante.gridwidth = 2;
		constante.gridheight = 1;
		this.painelDetalhes.add(LEndereco, constante);
	
		//
		constante.gridx = 0;
		constante.gridy = 4;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		this.painelDetalhes.add(TEndereco, constante);
		//
		constante.gridx = 5;
		constante.gridy = 3;
		constante.gridwidth = 1;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.RELATIVE;
		
		this.painelDetalhes.add(LMulta, constante);
		//
		constante.gridx = 5;
		constante.gridy = 4;
		constante.gridwidth = 4;
		constante.gridheight = 1;
		constante.fill = GridBagConstraints.RELATIVE;
		this.painelDetalhes.add(TMulta, constante);
		//
		this.painelDetalhes.setBorder(BorderFactory.createEmptyBorder(15, 2, 15, 2));
		this.painelDetalhes.setBackground(Color.WHITE);
		this.painelDetalhes.setVisible(true);
                
		return this.painelDetalhes;
	}
        
        public void getCadastro(){
            //aqui é só uma tentativa de checar se estava tudo certo, o metodo para conseguir as informações
            //o metodo para conseguir as informações especificas deve ser por aqui
            this.dadoscadastro= new Object[]{"123.908.201-22", "Luiz", "Nao", "Sei", "Ta la", "0.0"};
            String t = (String) this.dadoscadastro[0];
            this.TCpf.setText(t);t = (String) this.dadoscadastro[0];
            t = (String) this.dadoscadastro[1];
            this.TNome.setText(t);
            t = (String) this.dadoscadastro[4];
            this.TEndereco.setText(t);
            t = (String) this.dadoscadastro[5];
            this.TMulta.setText(t);
        }
	


}
class alugados {
	private JPanel livrosAlugados;
	public static Object[][] dados;
	public static Object[] colunas = {"Codigo", "Nome", "Autor/Endereco", "Genero", "Status", "Multa"};
	private JScrollPane scroll;
	
	public alugados() {
		
		this.scroll = new JScrollPane();
		this.livrosAlugados = new JPanel();
		
		
		
	}
	public static Object[][] getTabelaAlugados() {
			//exemplo de dados a ser exibido
			Object[][] dados = {
		            {123, "O Principe", "Maquiavel", "Politicas", "Alugado", 0.0},
		            {124, "Diario de Um banana", "Nao sei", "Biografia", "Livre", 1.0},
		            {125, "O Principe", "Maquiavel", "Politicas", "Alugado", 0.0},
		            {128, "O Principe", "Maquiavel", "Politicas", "Alugado", 102.0}
		        };
			return (Object[][]) dados;
			
		}
	public JPanel getPanel() {
		
		alugados.dados = getTabelaAlugados();
		DefaultTableModel modelo = new DefaultTableModel(dados, colunas);
		JTable tabelaAlugados = new JTable(modelo);
		FlowLayout f= new FlowLayout();
		f.setAlignment(FlowLayout.CENTER);
		this.livrosAlugados.setLayout(f);
		
                
                this.scroll.setViewportView(tabelaAlugados);
		this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                this.scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.livrosAlugados.setLayout(new GridLayout());
		this.livrosAlugados.add(scroll,BorderLayout.CENTER);
                this.scroll.setVisible(true);
		return this.livrosAlugados;
	}
	
	
}