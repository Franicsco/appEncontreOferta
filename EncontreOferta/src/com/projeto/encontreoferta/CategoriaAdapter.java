package com.projeto.encontreoferta;

import java.util.List;

import pacote_controller.CategoriaController;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//Crio uma Classe que estende o BaseAdapter, classe base para criação de Adapter, assim vou criar meu ADAPTER personalizado
public class CategoriaAdapter extends BaseAdapter {
	
	//Defino as variaveis
	private List<CategoriaController> categorias;
	private Activity activityCategorias;
	
	//Crio o metodo Construtor
	public CategoriaAdapter(Activity activityCategorias, List<CategoriaController> categorias) {
		
		this.categorias = categorias;
		this.activityCategorias = activityCategorias;
	}

	//Crio o metodo getCount()
	@Override
	public int getCount() {		
		return categorias.size();
	}
	
	//Crio o metodo getItem()
	@Override
	public Object getItem(int posicao) {		
		return categorias.get(posicao);
	}
	
	//Crio o metodo getItemId()
	@Override
	public long getItemId(int posicao) {		
		return categorias.get(posicao).getId();
	}

	@Override
	public View getView(int posi, View v, ViewGroup parent) {
		//Crio uma view a partir do arquivo de layout categoria_menu
		View viewCategorias = this.activityCategorias.getLayoutInflater().inflate(R.layout.categoria_menu, null);
		
		//Obtenho o objeto a partir de uma posição
		CategoriaController cate = categorias.get(posi);
		
		//Seto o TextVIEW a variavel btCategorias 
		TextView btCategorias = (TextView) viewCategorias.findViewById(R.id.idCategoriasMenu);
		//Seto o nome da categoria
		btCategorias.setText(cate.getNomeCategoria());
		
		return viewCategorias;
	}
	
	
	
	

}
