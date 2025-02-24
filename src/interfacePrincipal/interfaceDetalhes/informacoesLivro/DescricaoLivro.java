package interfacePrincipal.interfaceDetalhes.informacoesLivro;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.util.ArrayList;

import javax.swing.BorderFactory;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DescricaoLivro {
    
    //Nessa parte eu reutilizei parte do codigo da interface principal, assim vai ficar com a mesma formatação
	
		private JPanel painelLivros;
                private JPanel formatadorLivros;
                private JPanel painelDiscricao;
                private JPanel formatadorDescricao;
                private JPanel formatadorfinal;
                
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
		
                private JScrollPane scroll;
		public DescricaoLivro() {
			//instancia o painel
			this.painelLivros = new JPanel();
			this.painelDiscricao = new JPanel();
                        this.painelDiscricao.setLayout(new BorderLayout());
                        this.formatadorLivros = new JPanel();
                        this.formatadorLivros.setLayout(new BorderLayout());
                         this.formatadorDescricao = new JPanel();
                        this.formatadorDescricao.setLayout(new BorderLayout());
                        this.formatadorfinal = new JPanel();
                        this.formatadorfinal.setLayout(new BorderLayout());
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
			this.areaDescricao =  new JTextArea(15,15);
			//this.areaDescricao.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 13));
			//cria objetos de caixa de selecao combo
			this.selecaoTipo =  new JComboBox<String>();
			setDadosTipo();
			
			this.selecaoGenero = new JComboBox<String>();
			setDadosGenero();
			/*
			 * Temos que popular os dados dessa selecao de tipo
			 * por enquanto eu mesmo populei
			 * */
                        this.scroll = new JScrollPane();
                        //scroll para descrição
		}
		
		
		
		/*
		 * Aqui esta, fique a vontade para buscar dados a sua maneira ou modificar as 
		 * funcoes abaixo
		 * */
		public boolean setDadosTipo(){
			ArrayList<String> tipos = new ArrayList<String>();
			
			//Aqui deveriamos buscar os dados a partir de uma funcao
			//Mas eu coloquei manualmente
			tipos.add((String) "Tipo 1");
			tipos.add((String) "Tipo 2");
			tipos.add((String) "Tipo 3");
			
			
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
				JOptionPane.showMessageDialog(null, "Nao ha tipos, esta vazio!");
				return false;
			}
			
			return true;
		}
		public boolean setDadosGenero(){
			ArrayList<String> generos = new ArrayList<String>();
			
			//Aqui deveriamos buscar os dados a partir de uma funcao
			//Mas eu coloquei manualmente
			generos.add((String) "Genero 1");
			generos.add((String) "Genero 2");
			generos.add((String) "Genero 3");
			
			
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
		
		
		
		
		public JPanel getPanelDados() {
			this.painelLivros.setLayout(new GridBagLayout());
			GridBagConstraints constante = new GridBagConstraints();
			
			
			//Adiciona itens de componentes
			// ||||||||||
//			constante.gridx = 0;
//			constante.gridy = 0;
//			constante.gridwidth = 8;
//			constante.gridheight = 1;
//			constante.fill = GridBagConstraints.RELATIVE;
//			this.painelLivros.add(new JLabel(" "), constante);
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
			
			
			
//			constante.gridx = 0;
//			constante.gridy = 8;
//			constante.gridwidth = 8;
//			constante.gridheight = 1;
//			constante.fill = GridBagConstraints.RELATIVE;
//			this.painelLivros.add(new JLabel(" "), constante);
//			
			this.painelLivros.setBorder(BorderFactory.createEmptyBorder(15, 2, 15, 2));
			this.painelLivros.setBackground(Color.WHITE);
			this.painelLivros.setVisible(true);
			return this.painelLivros;
		}
                
                public JPanel getPanelDescricao(){
                 getDados();
                this.scroll.setViewportView(areaDescricao);
		this.scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                this.scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
                    this.painelDiscricao.add(scroll);
                    
                    
                    return this.painelDiscricao;
                    
                    
                }
                public void getDados(){
                    // adicionar um metodo aqui para pegar as informações especificas do 
                    String t = "AQUI TEM UMA DESCRIÇÂO DE LIVRO FENOMENAL :P";
                    this.areaDescricao.setText(t);
                }
                
               public JPanel getPanel(){
                   
                   this.formatadorLivros.add(getPanelDados(), BorderLayout.NORTH);
                   this.formatadorDescricao.add(getPanelDescricao(),BorderLayout.CENTER);
                   this.formatadorfinal.add(formatadorLivros,BorderLayout.NORTH);
                   this.formatadorfinal.add(painelDiscricao, BorderLayout.CENTER);
                   
                   return this.formatadorfinal;
               }
}
