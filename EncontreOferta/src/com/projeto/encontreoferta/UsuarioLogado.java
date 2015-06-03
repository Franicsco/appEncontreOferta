package com.projeto.encontreoferta;

//Crio essa classe para o usuario que esta logado
public class UsuarioLogado {
	
	public static String UsuarioLogado = null;
	
	public UsuarioLogado() {
		
	}

	public UsuarioLogado(String usuarioLogado) {
		super();
		UsuarioLogado = usuarioLogado;
	}

	public String getUsuarioLogado() {
		return UsuarioLogado;
	}

	public void setUsuarioLogado(String usuarioLogado) {
		UsuarioLogado = usuarioLogado;
	}
	
	

}
