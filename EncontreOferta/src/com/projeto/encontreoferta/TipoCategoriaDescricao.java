package com.projeto.encontreoferta;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import android.app.ActionBar;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipoCategoriaDescricao extends FragmentActivity implements OnClickListener{
	
	//Definindo as Variaveis para enviar e-mail
	javax.mail.Session sessao = null;
	ProgressDialog pDialog = null;
	Context context = null;
	
	//Definindo as Variaveis
	TextView btGerarVoucher;
	EditText Email;
	TextView btEnviarVoucher;	
	String numeroVoucher = "1234qwer";	
	
	String VerificaEmail;
	String stringEmail;
	
	
	
	//Crio as Intent
	Intent intentMenuTipoCategoriaDescricao;
	
	//Crio o objeto Logado
	UsuarioLogado logado = new UsuarioLogado();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tipo_categoria_descricao);
		
		context = this;
		
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
					
					
					
					
				}
				else{
					//Mostro o Numero o Voucher no Proprio botao GERAR VOUCHER
					btGerarVoucher.setBackgroundColor(Color.BLACK);
					btGerarVoucher.setText("Numero: " + numeroVoucher);
					//Deixo visivel o Campo E-mail
					Email.setVisibility(View.VISIBLE);


					btEnviarVoucher.setVisibility(View.VISIBLE);
					btEnviarVoucher.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							try{
								//Referencia: http://stackoverflow.com/questions/24969894/android-email-validation-on-edittext
								//Verifica se o e-mail e valido
								
								//Pego a String
								stringEmail = Email.getText().toString().trim();
								//Expressão regular para verifica se o e-mail é valido
								VerificaEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
								//Verigico se o email é valido
								if(stringEmail.matches(VerificaEmail)){
									
									//Definindo a configuracao SMTP
									Properties pro = new Properties();					
									pro.put("mail.smtp.host", "smtp.gmail.com");
									pro.put("mail.smtp.socketFactory.port", "465");
									pro.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
									pro.put("mail.smtp.auth", "true");
									pro.put("mail.smtp.port", "465");
									
									sessao = javax.mail.Session.getDefaultInstance(pro, new Authenticator() {
										protected PasswordAuthentication getPasswordAuthentication(){
											return new PasswordAuthentication("comercialencontreoferta@gmail.com", "encontreoferta123");
											
										}
									});
									
									pDialog = ProgressDialog.show(context, "", "Enviando E-mail...", true);
									Retorno retorno = new Retorno();
									retorno.execute();
									
								}else{
									Toast.makeText(getApplicationContext(), "E-mail inválido", Toast.LENGTH_LONG).show();
								}
								}catch(Exception e){
									
								}
							
						}
					});
				}
				
			}
		});
		
		//inseridno a logo ENCONTRE OFERTA
		ActionBar ab =  getActionBar();
		ab.setIcon(R.drawable.logo_icon);
		//inseridno a logo ENCONTRE OFERTA	
		
	}
	
	//Não uso
	@Override
	public void onClick(View v) {		
	}
	//Não uso
	
	
	//Definindo o E-mail - DE: comercialencontreoferta@gmail.com PARA: (E-mail que o usuario digitar)
	class Retorno extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... params) {
			
			try{
				
				Message mensagem = new MimeMessage(sessao);
				mensagem.setFrom(new InternetAddress("comercialencontreoferta@gmail.com"));
				mensagem.setRecipients(Message.RecipientType.TO, InternetAddress.parse(stringEmail));
				mensagem.setSubject("Numero do Voucher");
				mensagem.setContent("O numerdo do seu voucher é: " + numeroVoucher, "text/html; charset=utf-8");
				
				Transport.send(mensagem);
				
			}catch(MessagingException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
			return null;
		}
		
		//Deixo os campos limpos assim que o e-mail é enviado
		@Override
		protected void onPostExecute(String result) {
			pDialog.dismiss();
			btGerarVoucher.setText("");
			Email.setText("");
			
			Toast.makeText(getApplicationContext(), "Mensagem enviada", Toast.LENGTH_LONG).show();
		}
		
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
