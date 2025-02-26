package interfacePrincipal.interfaceDetalhes.informacoesCliente;

import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
 public class Titulo {
	private JPanel headerL;
	private JPanel headerR;
	private JPanel header;
	private JLabel txtTitulo;
	private JLabel iconeUFC;
	private JLabel tDetalhes;
	
	public Titulo() {
		// TODO Auto-generated constructor stub
		this.headerL = new JPanel();
		this.headerR = new JPanel();
		this.header = new JPanel();
		txtTitulo = new JLabel();
		tDetalhes = new JLabel();
		txtTitulo.setText("Livraria");
		tDetalhes.setText("Detalhes");
		Font f = new Font("Teste", 3, 20);
		txtTitulo.setFont(f);
		tDetalhes.setFont(f);
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
		FlowLayout f2 = new FlowLayout();
		fl.setAlignment(FlowLayout.RIGHT);
		f2.setAlignment(FlowLayout.LEFT);
		//Adicionando componentes a header
		
		this.headerR.add(txtTitulo);
		this.headerR.add(iconeUFC);
		
		this.headerR.setLayout(fl);
		this.headerL.add(tDetalhes);
		this.headerL.setLayout(f2);
		
                //utilizei a formatação da principal aqui, adicionando umais algumas cois e formatações
                //para ficar claro que a aba de detalhes está aberta
                
		//this.headerR.setBorder(BorderFactory.createEmptyBorder((int) Math.ceil(informaçoes.screenHeight*0.008), 0, (int) Math.ceil(informaçoes.screenHeight*0.008), 0));
		//this.headerL.setBorder(BorderFactory.createEmptyBorder((int) Math.ceil(informaçoes.screenHeight*0.008), 0, (int) Math.ceil(informaçoes.screenHeight*0.008), 0));
		this.header.setLayout(new BorderLayout());
		this.header.add(headerL,BorderLayout.WEST);
		this.header.add(headerR,BorderLayout.EAST);
		this.header.setVisible(true);
		return this.header;
		
	}
}
