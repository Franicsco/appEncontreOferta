package com.projeto.encontreoferta;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class QuemSomos extends FragmentActivity{
	
	//Definindo as Variaveis
	TextView descricaoQuemSomos;
	ImageView logoEncontreOferta;
	Intent intentMenuQuemSomos;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quemsomos);
		
		
		//Convertendo a Imagem para BitMap
		Bitmap bm = BitmapFactory.decodeResource(this.getResources(), R.drawable.logo);
		//Redimencionado a imagem ( ,W,H)
		bm = bm.createScaledBitmap(bm, 550, 300, true);
		//Setando o IMAGEVIEW(ONDE SERA INSERIDO A IMG DA LOGO) na variavel logoEncontreOferta.
		logoEncontreOferta = (ImageView) findViewById(R.id.idImagemLogo);
		//Seto a imagem.
		logoEncontreOferta.setImageBitmap(bm);
		
		//Setando o TEXTVIEW(ONDE SERA O TEXTO DA EMPRESA) na variavel descricaoQuemSomos.
		descricaoQuemSomos = (TextView) findViewById(R.id.idDescricaoQuemSomos);
		//Seto o texto sobre a empresa
		descricaoQuemSomos.setText("O projeto Encontre Oferta tem como objetivo auxiliar "
				+ "o usuário a adquirir descontos em sites de empresas parceiras, dos mais "
				+ "variados ramos de atuação, com grande diversidade de produtos e publico "
				+ "alvo também diversificado, auxiliado pelo sistema de busca ou navegando "
				+ "nas diversas categorias para encontrar os cupons desejados.\n\n"
				+ "Criado com intuito de auxiliar os usuários de e-commerce a "
				+ "conseguir desconto em suas compras, com comodidade e praticidade, "
				+ "já que o sistema funciona tanto via navegador quanto nos smartphones com sistema operacional Android.\n\n"
				+ "O projeto Encontre Oferta foi idealizado como um portal de anúncios, com o objetivo de ser um canal de "
				+ "integração entre empresas que querem divulgar suas promoções e, clientes que estão em busca de bons preços"
				+ " e vantagens, para adquirir tais produtos e serviços. Inicialmente o escopo são os usuários da internet, que "
				+ "acessam os sites das principais lojas varejistas de todo o país e também realizam comparações de acordo com o "
				+ "seu perfil, afim, de obter cada vez mais benefícios e comodidade durante a compra.");
		
		
		//inseridno a logo ENCONTRE OFERTA
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
				case R.id.idMenuPrincipal:
					intentMenuQuemSomos = new Intent(QuemSomos.this, MainActivity.class);
					intentMenuQuemSomos.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuQuemSomos);
					break;

				case R.id.idMenuCategoria:
					intentMenuQuemSomos = new Intent(QuemSomos.this, Categoria.class);
					intentMenuQuemSomos.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuQuemSomos);
					break;
					
				case R.id.idMenuQuemSomos:
					intentMenuQuemSomos = new Intent(QuemSomos.this, QuemSomos.class);
					intentMenuQuemSomos.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuQuemSomos);
					break;
					
				case R.id.idMenuContato:
					intentMenuQuemSomos = new Intent(QuemSomos.this, Contato.class);
					intentMenuQuemSomos.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuQuemSomos);
					break;
				
				}
				return true;
			}//
	
	

}
