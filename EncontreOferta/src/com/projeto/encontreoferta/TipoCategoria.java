package com.projeto.encontreoferta;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class TipoCategoria extends FragmentActivity {
	
	//Definindo as Variaveis
	Intent intentMenuTipoCategoria;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tipo_categoria);		
		
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
			intentMenuTipoCategoria = new Intent(TipoCategoria.this, Historico.class);
			intentMenuTipoCategoria.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentMenuTipoCategoria);
			break;
		
		case R.id.idMenuPrincipal:
			intentMenuTipoCategoria = new Intent(TipoCategoria.this, MainActivity.class);
			intentMenuTipoCategoria.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentMenuTipoCategoria);
			break;

		case R.id.idMenuCategoria:
			intentMenuTipoCategoria = new Intent(TipoCategoria.this, Categoria.class);
			intentMenuTipoCategoria.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentMenuTipoCategoria);
			break;
			
		case R.id.idMenuQuemSomos:
			intentMenuTipoCategoria = new Intent(TipoCategoria.this, QuemSomos.class);
			intentMenuTipoCategoria.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentMenuTipoCategoria);
			break;
			
		case R.id.idMenuContato:
			intentMenuTipoCategoria = new Intent(TipoCategoria.this, Contato.class);
			intentMenuTipoCategoria.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentMenuTipoCategoria);
			break;
		
		}
		return true;
	}//
	
}
