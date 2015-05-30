package com.projeto.encontreoferta;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Cadastrar extends FragmentActivity{
	
	//Definindo as Variaveis
	Intent intentMenuCadastrar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cadastrar);
		
		
		
		
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
				case R.id.idMenuPrincipal:
					intentMenuCadastrar = new Intent(Cadastrar.this, MainActivity.class);
					intentMenuCadastrar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuCadastrar);
					break;

				case R.id.idMenuCategoria:
					intentMenuCadastrar = new Intent(Cadastrar.this, Categoria.class);
					intentMenuCadastrar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuCadastrar);
					break;
					
				case R.id.idMenuQuemSomos:
					intentMenuCadastrar = new Intent(Cadastrar.this, QuemSomos.class);
					intentMenuCadastrar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuCadastrar);
					break;
					
				case R.id.idMenuContato:
					intentMenuCadastrar = new Intent(Cadastrar.this, Contato.class);
					intentMenuCadastrar.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuCadastrar);
					break;
				
				}
				return true;
			}//

}
