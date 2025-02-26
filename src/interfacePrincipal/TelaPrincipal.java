package interfacePrincipal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import InformaçoesCliente.ContainerInformacoes;
import interfacePrincipal.interfaceDetalhes.DetalhesBotoes;
import interfacePrincipal.interfaceDetalhes.informacoesCliente.Titulo;
import interfacePrincipal.livraria.exceptions.ClienteJaExisteException;
import interfacePrincipal.livraria.exceptions.ClienteNaoExisteException;
import interfacePrincipal.paineis.ContainerCROUD;
import interfacePrincipal.paineis.ContainerPesquisa;

public class TelaPrincipal {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, FileNotFoundException, IOException, ClienteNaoExisteException, UnsupportedOperationException, ClienteJaExisteException {
		//Muda os estilos de icone para nimbus do Windows atraves de uma
		//Procura entre as UIs instaladas disponiveis
		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		    if ("Nimbus".equals(info.getName())) {
		        UIManager.setLookAndFeel(info.getClassName());
		        System.out.println("CHOSEN THIS");
		        break;
		    }
		}
		ContainerCROUD PainelCroud = new ContainerCROUD();
		
		JPanel container = new JPanel();
		//container.setLayout(new GridBagLayout());
		container.setLayout(new BorderLayout());
		//container.setBackground(Color.CYAN);
		
		
		
		
		JPanel containerFinalPesquisas = new JPanel();
		containerFinalPesquisas.setLayout(new BorderLayout());
		
		ContainerPesquisa  containerP = new ContainerPesquisa();
		//FlowLayout fl = new FlowLayout();
		
		
		//instancia a tela inicial e utilidades
		JFrame frame = new JFrame();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		
		 // Obtém o tamanho da tela
        int screenWidth = screenSize.width;  // Largura da tela
        int screenHeight = screenSize.height; // Altura da tela
		
      //Configura Janela
      	frame.setSize((int) Math.floor(screenWidth*0.95), (int)Math.floor(screenHeight*0.9));
      	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	frame.setLocationRelativeTo(null);//Centraliza
      	frame.setResizable(true);
      	frame.setBackground(Color.lightGray);
      	frame.setMinimumSize(new Dimension((int) Math.floor(screenWidth*0.61), (int)Math.floor(screenHeight*0.9)));
      	//Eu especifiquei um tamanho minimo pra janela 61% da tela na horizontal
      	
      	//frame.setLayout(new GridLayout(1,2));
        
		//Instancia containers
	   
	    
	    
	    //adiciona a frame principal
      	//gbc.gridx = 0;
        //gbc.gridy = 0;
      	containerFinalPesquisas.add(containerP.retPanel(), BorderLayout.NORTH);
      	/*
      	 * Aqui basicamente tem container dentro de container pra 
      	 * fazer o flowLayout funcionar da maneira que eu queria, 
      	 * nao era necessario tanto, tanto que a Croud e uma prova disso.
      	 * 
      	 * */
      	JPanel painelBiblioteca = new JPanel();
      	painelBiblioteca.setLayout(new BorderLayout());
      	painelBiblioteca.setBackground(Color.WHITE);
      	painelBiblioteca.add(containerP.retPainelBiblioteca(), BorderLayout.NORTH);
      	
      	JScrollPane scroll = new JScrollPane(painelBiblioteca, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
      	
      	containerFinalPesquisas.add(scroll);
      	//containerFinalPesquisas.setBackground(Color.orange);
      	containerFinalPesquisas.setBorder(BorderFactory.createEmptyBorder( (int) Math.ceil(screenHeight*0.008), (int) Math.ceil(screenWidth *0.008), (int) Math.ceil(screenHeight*0.008), (int) Math.ceil(screenWidth*0.008)));
      	//Esta e a adicao do painel da esquerda
      	//Configura conteiner e posix
      	
      	container.add(PainelCroud.getPanel());
      	container.add(containerFinalPesquisas, BorderLayout.WEST);
        
        //teste
        
        //aux.setPreferredSize(new Dimension(screenWidth/3, screenHeight));
        
      	container.setBorder(BorderFactory.createEmptyBorder( (int) Math.ceil(screenHeight*0.008), (int) Math.ceil(screenWidth *0.008), (int) Math.ceil(screenHeight*0.008), (int) Math.ceil(screenWidth*0.008)));//cima esq baixo direita
	    container.setBackground(Color.WHITE);
      	
	    frame.add(container);
	    
	    /*
	     * Nao adicionar nada diretamente no frame novamente
	     * */
	    //frame.add();
	    //frame.pack();
	    frame.setVisible(true);
	    
		
	    
	    
	}

}
