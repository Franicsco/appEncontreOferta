package com.projeto.encontreoferta;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipoCategoriaDescricao extends FragmentActivity{
	
	//Definindo as Variaveis
	TextView btGerarVoucher;
	EditText Email;
	TextView btEnviarVoucher;	
	String numeroVoucher = "1234qwer";	
	
	String VerificaEmail;
	
	//Crio as Intent
	Intent intentMenuTipoCategoriaDescricao;
	
	//Crio o objeto Logado
	UsuarioLogado logado = new UsuarioLogado();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tipo_categoria_descricao);
		
		//Deixo o EditText Oculto
		Email = (EditText) findViewById(R.id.enviarEmailVoucher);
		Email.setVisibility(View.INVISIBLE);
		
		//Deixo o TextView Oculto
		btEnviarVoucher = (TextView) findViewById(R.id.btEnviarVoucherEmail);
		btEnviarVoucher.setVisibility(View.INVISIBLE);
		
		//Setando o Botão (GERAR VOUCHER) na variavel btGerarVoucher
		btGerarVoucher = (TextView) findViewById(R.id.btGerarVoucher);
		//Acao do Clique no botão GERAR VOUCHER
		btGerarVoucher.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(logado.getUsuarioLogado() != null){
				//Mostro o Numero o Voucher no Proprio botao GERAR VOUCHER
				btGerarVoucher.setBackgroundColor(Color.BLACK);
				btGerarVoucher.setText("Numero: " + numeroVoucher);
				//Deixo visivel o Campo E-mail
				Email.setVisibility(View.VISIBLE);
				Email.setEnabled(false);
				//Seto o e-mail do usuario que esta logado			
				Email.setText(String.valueOf(logado.getUsuarioLogado().toString()));
				
				}else{
					//Mostro o Numero o Voucher no Proprio botao GERAR VOUCHER
					btGerarVoucher.setBackgroundColor(Color.BLACK);
					btGerarVoucher.setText("Numero: " + numeroVoucher);
					//Deixo visivel o Campo E-mail
					Email.setVisibility(View.VISIBLE);
				}
				
				//
				
				//Deixo visivel o Botão de Enviar o Voucher por e-mail
				btEnviarVoucher.setVisibility(View.VISIBLE);
				
				//Acao do Clique no botão ENVIAR				
				btEnviarVoucher.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						
						
						//Referencia: http://stackoverflow.com/questions/24969894/android-email-validation-on-edittext
						//Verifica se o e-mail e valido
						
						//Pego a String
						String stringEmail = Email.getText().toString().trim();
						VerificaEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
						
						if(stringEmail.matches(VerificaEmail)){
												
							//Enviando por e-mail
							Intent itEmail = new Intent(Intent.ACTION_SEND);
							itEmail.setType("plain/text");
							itEmail.putExtra(Intent.EXTRA_SUBJECT, "Numero do Voucher ");
							itEmail.putExtra(Intent.EXTRA_TEXT, numeroVoucher);
							itEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{stringEmail});        
							startActivity(Intent.createChooser(itEmail,"Escolha a App para envio do e-mail..."));
							
						}else{
							Toast.makeText(getApplicationContext(), "E-mail inválido", Toast.LENGTH_LONG).show();
						}
						
						
					}
				});
				
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
					intentMenuTipoCategoriaDescricao = new Intent(TipoCategoriaDescricao.this, Historico.class);
					intentMenuTipoCategoriaDescricao.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuTipoCategoriaDescricao);
					break;
				
				case R.id.idMenuPrincipal:
					intentMenuTipoCategoriaDescricao = new Intent(TipoCategoriaDescricao.this, MainActivity.class);
					intentMenuTipoCategoriaDescricao.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuTipoCategoriaDescricao);
					break;

				case R.id.idMenuCategoria:
					intentMenuTipoCategoriaDescricao = new Intent(TipoCategoriaDescricao.this, Categoria.class);
					intentMenuTipoCategoriaDescricao.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuTipoCategoriaDescricao);
					break;
					
				case R.id.idMenuQuemSomos:
					intentMenuTipoCategoriaDescricao = new Intent(TipoCategoriaDescricao.this, QuemSomos.class);
					intentMenuTipoCategoriaDescricao.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuTipoCategoriaDescricao);
					break;
					
				case R.id.idMenuContato:
					intentMenuTipoCategoriaDescricao = new Intent(TipoCategoriaDescricao.this, Contato.class);
					intentMenuTipoCategoriaDescricao.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(intentMenuTipoCategoriaDescricao);
					break;
				
				}
				return true;
			}//

}
