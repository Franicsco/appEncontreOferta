package com.projeto.encontreoferta;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public class Historico extends FragmentActivity{
	
	//Definindo as Variaveis	
	Intent intentMenuHistorico;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.historico);
		
		
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
					intentMenuHistorico = new Intent(Historico.this, Historico.class);
					intentMenuHistorico.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuHistorico);
					break;
				
				case R.id.idMenuPrincipal:
					intentMenuHistorico = new Intent(Historico.this, MainActivity.class);
					intentMenuHistorico.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuHistorico);
					break;

				case R.id.idMenuCategoria:
					intentMenuHistorico = new Intent(Historico.this, Categoria.class);
					intentMenuHistorico.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuHistorico);
					break;
					
				case R.id.idMenuQuemSomos:
					intentMenuHistorico = new Intent(Historico.this, QuemSomos.class);
					intentMenuHistorico.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuHistorico);
					break;
					
				case R.id.idMenuContato:
					intentMenuHistorico = new Intent(Historico.this, Contato.class);
					intentMenuHistorico.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuHistorico);
					break;
				
				}
				return true;
			}//

}
