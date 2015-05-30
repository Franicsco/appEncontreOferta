package com.projeto.encontreoferta;

import java.util.ArrayList;
import java.util.List;

import pacote_controller.CategoriaController;

////Esta classe é responsavel por gerar a lista de Categorias
public class CategoriaDAO {
	
	//Crio metodo lista
	public List<CategoriaController> getListaCategoria(){
		
		//crio um objeto ArrayList a partir da classe CategoriaController
		List<CategoriaController> categoria = new ArrayList<CategoriaController>();
		
		//Seto as categorias na classe CategoriaController
		categoria.add(new CategoriaController(1, "Informática"));
		categoria.add(new CategoriaController(2, "Eletrodomésticos"));
		categoria.add(new CategoriaController(3, "Telefonia"));
		categoria.add(new CategoriaController(4, "Eletrônicos"));
		
		return categoria;
	}

}
