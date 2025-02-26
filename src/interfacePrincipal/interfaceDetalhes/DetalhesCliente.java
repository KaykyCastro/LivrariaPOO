package interfacePrincipal.interfaceDetalhes;

import interfacePrincipal.interfaceDetalhes.informacoesCliente.Titulo;
import interfacePrincipal.interfaceDetalhes.informacoesCliente.ContainerInformacoes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
public class DetalhesCliente extends JFrame {
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException{
		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		    if ("Nimbus".equals(info.getName())) {
		        UIManager.setLookAndFeel(info.getClassName());
		        System.out.println("CHOSEN THIS");
		        break;
		    }
		}
                
            
            
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = screenSize.width;  // Largura da tela
    int screenHeight = screenSize.height;
   
    ContainerInformacoes infor = new ContainerInformacoes();
	
	
	Titulo titulo = new Titulo();
	DetalhesBotoes botoes = new DetalhesBotoes ();
	
        //criando a janela de clientes
	 JFrame detalhesClie = new JFrame();
	detalhesClie.setBackground(Color.lightGray);
	detalhesClie.setSize((int) Math.floor(screenWidth*0.3), (int)Math.floor(screenHeight*0.65));
        detalhesClie.setMinimumSize(new Dimension((int) Math.floor(screenWidth*0.3), (int)Math.floor(screenHeight*0.5)));
        detalhesClie.setLocationRelativeTo(null);
	detalhesClie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // também coloquei uma parte da do monitor como referência aqui
        //um tamo minimo também foi adicionado para não ter deformações
	
	
	
	JPanel container = new JPanel();
	container.setLayout(new BorderLayout());
	container.setBorder(BorderFactory.createEmptyBorder( (int) Math.ceil(screenHeight*0.008), (int) Math.ceil(screenWidth *0.008), (int) Math.ceil(screenHeight*0.008), (int) Math.ceil(screenWidth*0.008)));
	container.setBackground(Color.lightGray);
	
	container.add(titulo.getPanel(),BorderLayout.NORTH);
	container.add(infor.getPanel(),BorderLayout.CENTER);
	container.add(botoes.getPanelClientes(),BorderLayout.SOUTH);
	
	detalhesClie.add(container);
	detalhesClie.setVisible(true);
	
}
}
