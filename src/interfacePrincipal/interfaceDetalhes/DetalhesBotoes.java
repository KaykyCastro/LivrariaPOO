package interfacePrincipal.interfaceDetalhes;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class DetalhesBotoes {
	private JPanel botaoR;
	private JPanel botaoL;
	private JPanel botoes;
	private JButton btSalvarAlteracoesLivros;
        private JButton btSalvarAlteracoesClientes;
	private JButton btVoltar;
	public DetalhesBotoes() {
		this.botoes = new JPanel();
		this.botaoR = new JPanel();
		this.botaoL = new JPanel();
		this.btSalvarAlteracoesLivros = new JButton("Salvar Alterações");
                this.btSalvarAlteracoesClientes = new JButton("Salvar Alterações");
		this.btVoltar = new JButton("Voltar");
		
		Cursor c = new Cursor(Cursor.HAND_CURSOR);
                this.btSalvarAlteracoesLivros.setCursor(c);
		this.btSalvarAlteracoesClientes.setCursor(c);
		this.btVoltar.setCursor(c);
	}
	
	public JPanel getPanelLivros() {
		FlowLayout f1 = new FlowLayout();
		FlowLayout f2 = new FlowLayout();
		f1.setAlignment(FlowLayout.RIGHT);
		f2.setAlignment(FlowLayout.LEFT);
		this.botaoR.setLayout(f1);
		this.botaoL.setLayout(f2);
		
		this.botaoR.add(btSalvarAlteracoesLivros);
		this.botaoL.add(btVoltar);
		
		this.botoes.setLayout(new BorderLayout());
		this.botoes.add(botaoL,BorderLayout.WEST);
		this.botoes.add(botaoR,BorderLayout.EAST);
		this.botoes.setVisible(true);
                this.btSalvarAlteracoesLivros.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btSalvarAlteracoesLivros();
			}
		});
                
                this.btVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btVoltar();
			}
		});
		return this.botoes;
	}
        public JPanel getPanelClientes() {
		FlowLayout f1 = new FlowLayout();
		FlowLayout f2 = new FlowLayout();
		f1.setAlignment(FlowLayout.RIGHT);
		f2.setAlignment(FlowLayout.LEFT);
		this.botaoR.setLayout(f1);
		this.botaoL.setLayout(f2);
		
		this.botaoR.add(btSalvarAlteracoesClientes);
		this.botaoL.add(btVoltar);
		
		this.botoes.setLayout(new BorderLayout());
		this.botoes.add(botaoL,BorderLayout.WEST);
		this.botoes.add(botaoR,BorderLayout.EAST);
		this.botoes.setVisible(true);
                
                this.btSalvarAlteracoesClientes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btSalvarAlteracoesClientes();
			}
		});
                this.btVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btVoltar();
			}
		});
		return this.botoes;
	}
        
        public void btSalvarAlteracoesLivros(){
            //metodos dos botoes
        }
	public void btSalvarAlteracoesClientes(){
            
        }
        public void btVoltar(){
            
        }
}
