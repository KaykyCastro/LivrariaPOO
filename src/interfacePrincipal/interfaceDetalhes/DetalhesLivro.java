package interfacePrincipal.interfaceDetalhes;

import interfacePrincipal.interfaceDetalhes.informacoesCliente.Titulo;
import interfacePrincipal.interfaceDetalhes.informacoesLivro.DescricaoLivro;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class DetalhesLivro {
        
	public static void main(String[] args) throws Exception{
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		    if ("Nimbus".equals(info.getName())) {
		        UIManager.setLookAndFeel(info.getClassName());
		        System.out.println("CHOSEN THIS");
		        break;
		    }
		}
            //utilizei as mesmas configuraçoes de layout da principal
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = screenSize.width;  // Largura da tela
		int screenHeight = screenSize.height;
                
             
    
    
	//aqui estão as declarações do que sera usado depois
	DescricaoLivro infor = new DescricaoLivro();
	Titulo titulo = new Titulo();
	DetalhesBotoes botoes = new DetalhesBotoes ();
	
        //Intanciando a Janela
	JFrame detalhesLiv = new JFrame();
	detalhesLiv.setBackground(Color.lightGray);
	detalhesLiv.setSize((int) Math.floor(screenWidth*0.3), (int)Math.floor(screenHeight*0.65));
        detalhesLiv.setMinimumSize(new Dimension((int) Math.floor(screenWidth*0.3), (int)Math.floor(screenHeight*0.5)));
        detalhesLiv.setLocationRelativeTo(null);
	detalhesLiv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //coloquei um tamanho minimo, pois se não haveria uma desformatação da tela
	
	//container que ira configurar cada parte da janela
	JPanel container = new JPanel();
	
	container.setLayout(new BorderLayout());
	container.setBorder(BorderFactory.createEmptyBorder( (int) Math.ceil(screenHeight*0.008), (int) Math.ceil(screenWidth *0.008), (int) Math.ceil(screenHeight*0.008), (int) Math.ceil(screenWidth*0.008)));
	container.setBackground(Color.lightGray);
	
	container.add(titulo.getPanel(),BorderLayout.NORTH);
	container.add(infor.getPanel(),BorderLayout.CENTER);
	container.add(botoes.getPanelLivros(),BorderLayout.SOUTH);
	
	detalhesLiv.add(container);
	detalhesLiv.setVisible(true);
}
}
