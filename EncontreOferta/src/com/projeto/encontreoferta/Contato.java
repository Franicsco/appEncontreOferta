package com.projeto.encontreoferta;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Contato extends FragmentActivity{
	
	//Definindo as Variaveis
	Button btContatoEnviarEmail;
	EditText contatoNome;
	EditText contatoEmail;
	EditText contatoMSG;	
	Intent intentMenuContato;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contato);
		
		
		//Setando o BUTTON(BOTAO ENVIAR) na variavel btContatoEnviarEmail.
		btContatoEnviarEmail = (Button) findViewById(R.id.btContatoEnviarEmail);
		//Executando a ação de clique do botão btContatoEnviarEmail.
		btContatoEnviarEmail.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//Seto os EDITETEXTs nas variais: contatoNome, contatoEmail e contatoMSG
				contatoNome = (EditText) findViewById(R.id.contatoNome);
				contatoEmail = (EditText) findViewById(R.id.contatoEmail);
				contatoMSG = (EditText) findViewById(R.id.contatoMSG);
				
				//Pego sua STRING e seto nas variais: contatoN, contatoE e contatoM
				String contatoN = contatoNome.getText().toString();
				String contatoE = contatoEmail.getText().toString();
				String contatoM = contatoMSG.getText().toString();
				
				//Faço uma verificação dos campos, caso estejam vazio, um TOAST é apresentado na tela.
				if(contatoN.trim().equals("")|| contatoN == null){
					
					Toast.makeText(getApplicationContext(), "Digite o NOME", Toast.LENGTH_SHORT).show();
					
				}else if(contatoE.trim().equals("") || contatoE == null){
					
					Toast.makeText(getApplicationContext(), "Digite o Email", Toast.LENGTH_SHORT).show();
					
				}else if(contatoM.trim().equals("") || contatoM == null){
					
					Toast.makeText(getApplicationContext(), "Digite a Mensagem", Toast.LENGTH_SHORT).show();
				}				
				else{

				//Enviando por e-mail
				Intent itEmail = new Intent(Intent.ACTION_SEND);
				itEmail.setType("plain/text");
				itEmail.putExtra(Intent.EXTRA_SUBJECT, "Contato de: " + contatoNome.getText().toString());
				itEmail.putExtra(Intent.EXTRA_TEXT, contatoMSG.getText().toString());
				itEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{contatoEmail.getText().toString()});        
				startActivity(Intent.createChooser(itEmail,"Escolha a App para envio do e-mail..."));
				
				}
				
			}
		});
		
		
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
				intentMenuContato = new Intent(Contato.this, MainActivity.class);
				intentMenuContato.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentMenuContato);
				break;

			case R.id.idMenuCategoria:
				intentMenuContato = new Intent(Contato.this, Categoria.class);
				intentMenuContato.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentMenuContato);
				break;
				
			case R.id.idMenuQuemSomos:
				intentMenuContato = new Intent(Contato.this, QuemSomos.class);
				intentMenuContato.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentMenuContato);
				break;
				
			case R.id.idMenuContato:
				intentMenuContato = new Intent(Contato.this, Contato.class);
				intentMenuContato.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentMenuContato);
				break;
			
			}
			return true;
		}//
	

}
