package pacote_controller;

import java.io.Serializable;

//Crio a classe CategoriaController  que implementa a interface Serializable
public class CategoriaController implements Serializable {
	
	//Defino as Variaveis
	private int id;
	private String nomeCategoria;
	
	//Crio o metodo construtor com 2 parametros
	public CategoriaController(int id, String nomeCategoria) {
		super();
		this.id = id;
		this.nomeCategoria = nomeCategoria;
	}

	//Crio os GETS e SET
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNomeCategoria() {
		return nomeCategoria;
	}


	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	
	
	
	

}
