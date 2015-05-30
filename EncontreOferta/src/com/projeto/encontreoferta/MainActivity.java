package com.projeto.encontreoferta;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {
	
	//Definindo as Variaveis
	TextView categoria;	
	TextView contato;		
	TextView quemSomos;
	TextView login;
	
	
	
	//Definindo as INTENTS
	Intent intentCategoria;
	Intent intentContato;
	Intent intentQuemSomos;
	Intent intentLogin;
	Intent intentHistorico;
	
	//Criando objeto Usuario
	UsuarioLogado usuario = new UsuarioLogado();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Setando o TEXTVIEW(BOTAO CATEGORIA) na variavel CATEGORIA.
		categoria = (TextView) findViewById(R.id.principalCategoria);
		//Executando a ação de clique do botão categoria.
		categoria.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Crio a INTENT(intentCategoria) e seto a acao de ir para a tela CATEGORIA.CLASS. 
				intentCategoria = new Intent(MainActivity.this, Categoria.class);
				startActivity(intentCategoria);
				
			}
		});
		//
		
		//Setando o TEXTVIEW(BOTAO CONTATO) na variavel CONTATO.
		contato = (TextView) findViewById(R.id.principalContato);
		//Executando a ação de clique do botão contato.
		contato.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Crio a INTENT(intentContato) e seto a acao de ir para a tela CONTATO.CLASS. 
				intentContato = new Intent(MainActivity.this, TipoCategoriaDescricao.class);
				startActivity(intentContato);
				
			}
		});//
		
		
		//Setando o TEXTVIEW(BOTAO QUEM SOMOS) na variavel QUEMSOMOS.
		quemSomos = (TextView) findViewById(R.id.principalQuesomos);
		//Executando a ação de clique do botão quemSomos.
		quemSomos.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Crio a INTENT(intentQuemSomos) e seto a acao de ir para a tela QUEMSOMOS.CLASS. 
				intentQuemSomos = new Intent(MainActivity.this, QuemSomos.class);
				startActivity(intentQuemSomos);
				
			}
		});
		
		
		/*Verifica se o usuario esta logado, se estiver
		 * Faz o botão de acessar conta sumir da tela inicial*/
		if(usuario.getUsuarioLogado() != null){
			
			login = (TextView) findViewById(R.id.principalLogin);
			login.setVisibility(View.INVISIBLE);
		
				
		}
		else{
			//Se o usuario não estiver logado, apresenta o botão de ACESSAR CONTA na Tela inicial.
			
			//Setando o TEXTVIEW(BOTAO ACESSAR) na variavel LOGIN.
			login = (TextView) findViewById(R.id.principalLogin);
			//Executando a ação de clique do botão ACESSAR.
			login.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					//Crio a INTENT(intentLogin) e seto a acao de ir para a tela LOGIN.CLASS. 
					intentLogin = new Intent(MainActivity.this, Login.class);
					startActivity(intentLogin);
					
				}
			});
			
		}
		
		
		
		//inserindo a logo ENCONTRE OFERTA
		ActionBar ab =  getActionBar();
		ab.setIcon(R.drawable.logo_icon);
		//inseridno a logo ENCONTRE OFERTA
		
	}

	//MENU
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		
		/*MenuItem principal = menu.add(0, 0, 0, "Principal");
		principal.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
		
		MenuItem categoria = menu.add(0, 1, 1, "Categoria");
		categoria.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
		
		MenuItem quemSomos = menu.add(0, 2, 2, "Quem Somos");
		quemSomos.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
				
		MenuItem contato = menu.add(0, 3, 3, "Contato");
		contato.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);
		*/
		
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
			intentHistorico = new Intent(MainActivity.this, Historico.class);
			intentHistorico.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentHistorico);
			break;
		
		case R.id.idMenuPrincipal:			
			break;

		case R.id.idMenuCategoria:
			intentCategoria = new Intent(MainActivity.this, Categoria.class);
			intentCategoria.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentCategoria);
			break;
			
		case R.id.idMenuQuemSomos:
			intentQuemSomos = new Intent(MainActivity.this, QuemSomos.class);	
			intentQuemSomos.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentQuemSomos);
			break;
		
		case R.id.idMenuContato:			
			intentContato = new Intent(MainActivity.this, Contato.class);	
			intentContato.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentContato);
			break;
		
		}//
		return true;
	
		
	}
//
	
}
