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

public class formEnviarVoucher extends FragmentActivity {

	Intent recuperaNumeroVoucher;
	String voucher;
	
	//Intent do menu
	Intent intentMenuEnviarVoucher;
	//Intent intentVoltarParaCategoria;
	
	//Variaveis do EditText
	EditText enviarVoucherNome;
	EditText enviarVoucherEmail;
	EditText enviarVoucherNumero;
	Button btEnviarVoucher;
	Button btEnviarVoucherVoltarCategoria;
	
	//Intent intentVoltar;
	
	//
	String enviarvoucherN;
	String enviarvoucherE;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.form_enviar_voucher);
		
		recuperaNumeroVoucher = getIntent();
		
		Bundle numeroVoucher = recuperaNumeroVoucher.getExtras();
		voucher = numeroVoucher.getString("numeroVoucher");
		
		//Pegando os EditText
		enviarVoucherNome = (EditText) findViewById(R.id.enviarVoucherNome);
		enviarVoucherEmail = (EditText) findViewById(R.id.enviarVoucherEmail);
		enviarVoucherNumero = (EditText) findViewById(R.id.enviarVoucherNumero);
		enviarVoucherNumero.setText("Numero do seu Voucher: " + voucher);
		
		btEnviarVoucher = (Button) findViewById(R.id.btEnviarVoucher);
		
		btEnviarVoucher.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				enviarvoucherN = enviarVoucherNome.getText().toString();
				enviarvoucherE = enviarVoucherEmail.getText().toString();
				
				if(enviarvoucherN.trim().equals("")|| enviarvoucherN == null){
					
					Toast.makeText(getApplicationContext(), "Digite o NOME", Toast.LENGTH_SHORT).show();
					
				}else if(enviarvoucherE.trim().equals("") || enviarvoucherE == null){
					
					Toast.makeText(getApplicationContext(), "Digite o Email", Toast.LENGTH_SHORT).show();
					
				}else{

				//Enviando por e-mail
				Intent enviarVoucher = new Intent(Intent.ACTION_SEND);
				enviarVoucher.setType("plain/text");
				enviarVoucher.putExtra(Intent.EXTRA_SUBJECT, "Numero de voucher do: " + enviarVoucherNome.getText().toString());
				enviarVoucher.putExtra(Intent.EXTRA_TEXT, enviarVoucherNumero.getText().toString());
				enviarVoucher.putExtra(Intent.EXTRA_EMAIL, new String[]{enviarVoucherEmail.getText().toString()});        
				startActivity(Intent.createChooser(enviarVoucher,"Escolha a App para envio do e-mail..."));
				
				}
				
			}
		});
		
		
		//Acao de voltat
		btEnviarVoucherVoltarCategoria = (Button) findViewById(R.id.btEnviarVoucherVoltarCategoria);
		btEnviarVoucherVoltarCategoria.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
							
				finish();
				
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
			
			getMenuInflater().inflate(R.menu.menu, menu);
			return true;
		}

		@Override
		public boolean onMenuItemSelected(int panel, MenuItem item) {
			
			switch (item.getItemId()) {
			case R.id.idMenuPrincipal:
				intentMenuEnviarVoucher = new Intent(formEnviarVoucher.this, MainActivity.class);
				intentMenuEnviarVoucher.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentMenuEnviarVoucher);
				finish();
				break;

			case R.id.idMenuCategoria:
				intentMenuEnviarVoucher = new Intent(formEnviarVoucher.this, Categoria.class);
				intentMenuEnviarVoucher.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentMenuEnviarVoucher);
				break;
				
			case R.id.idMenuQuemSomos:
				intentMenuEnviarVoucher = new Intent(formEnviarVoucher.this, QuemSomos.class);
				intentMenuEnviarVoucher.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentMenuEnviarVoucher);
				break;
				
			case R.id.idMenuContato:
				intentMenuEnviarVoucher = new Intent(formEnviarVoucher.this, Contato.class);
				intentMenuEnviarVoucher.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentMenuEnviarVoucher);
				break;
			
			}
			return true;
		}

}
