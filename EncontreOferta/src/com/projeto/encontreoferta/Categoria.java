package com.projeto.encontreoferta;

import java.util.List;

import pacote_controller.CategoriaController;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Categoria extends FragmentActivity {
	
	//Definindo as Variaveis	
	private List<CategoriaController> categorias;
	
	//Definindos as INTENTs
	Intent intentCategoriaSelecionada;
	Intent intentMenuCategoria;

	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.categoria);
				
		//Crio um objeto categorias a partir da classe CategoriaDAO()
		categorias = new CategoriaDAO().getListaCategoria();
		
		//Crio um objeto adapterCategorias a partir da classe CategoriaAdapter, com passagem de dois parametros
		//THIS(é a ACTIVITY em questão) e categorias (quem é uma lista)
		CategoriaAdapter adapterCategorias = new CategoriaAdapter(this, categorias);
		
		//Seto a LISTVIEW a uma variavel: listaCategoria
		ListView listaCategoria = (ListView) findViewById(R.id.idListaCategoria);
		//Seto o adapter (adapterCategorias) a LISTVIEW(listaCategoria)
		listaCategoria.setAdapter(adapterCategorias);
		
		//Crio a ação do clique da LISTVIEW(listaCategoria)
		listaCategoria.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int posicao, long id) {			
				
				intentCategoriaSelecionada = new Intent(Categoria.this, TipoCategoria.class);
				intentCategoriaSelecionada.putExtra("CategoriaSelecionada", categorias.get(posicao));
				startActivity(intentCategoriaSelecionada);
				
				
				
			}
			
			
		});
		//
		
		
		//inseridno a logo ENCONTRE OFERTA
		ActionBar ab =  getActionBar();
		ab.setIcon(R.drawable.logo_icon);
		//inseridno a logo ENCONTRE OFERTA
	}
	
	
	
	
	//MENU
		@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			super.onCreateOptionsMenu(menu);
						
			//pego o menu XML e aciono ele.
			getMenuInflater().inflate(R.menu.menu, menu);
			return true;
		}

		//Metodo de seleção do menu.
		@Override
		public boolean onMenuItemSelected(int panel, MenuItem item) {
			//Verifico qual opção foi clicada no menu, crio uma INTENT e direciono para a tela da opção escolhida.
			switch (item.getItemId()) {
			
			case R.id.idMenuHistorico:
				intentMenuCategoria = new Intent(Categoria.this, Historico.class);
				intentMenuCategoria.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentMenuCategoria);
				break;
			
			case R.id.idMenuPrincipal:
				intentMenuCategoria = new Intent(Categoria.this, MainActivity.class);
				intentMenuCategoria.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentMenuCategoria);
				break;

			case R.id.idMenuCategoria:
				intentMenuCategoria = new Intent(Categoria.this, Categoria.class);
				intentMenuCategoria.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentMenuCategoria);
				break;
				
			case R.id.idMenuQuemSomos:
				intentMenuCategoria = new Intent(Categoria.this, QuemSomos.class);
				intentMenuCategoria.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentMenuCategoria);
				break;
				
			case R.id.idMenuContato:
				intentMenuCategoria = new Intent(Categoria.this, Contato.class);
				intentMenuCategoria.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentMenuCategoria);
				break;
			
			}
			return true;
		}//
	
	

}
