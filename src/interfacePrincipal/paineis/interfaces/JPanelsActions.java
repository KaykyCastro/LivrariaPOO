package interfacePrincipal.paineis.interfaces;

import javax.swing.JPanel;

public interface JPanelsActions {
	
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
	public abstract JPanel getPanel();
}
