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
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Contato extends FragmentActivity implements OnClickListener{
	
	//Definindo as Variaveis para enviar e-mail
	javax.mail.Session sessao = null;
	ProgressDialog pDialog = null;
	Context context = null;

	
	//Definindo as Variaveis
	Button btContatoEnviarEmail;
	EditText contatoNome;
	EditText contatoEmail;
	EditText contatoMSG;
	
	String contatoVerificaEmail;
	String contatoN;
	String contatoE;
	String contatoM;
	
	//Definindo as INTENTs
	Intent intentMenuContato;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contato);
		
		context = this;
		
		//Setando o BUTTON(BOTAO ENVIAR) na variavel btContatoEnviarEmail.
		btContatoEnviarEmail = (Button) findViewById(R.id.btContatoEnviarEmail);
		
		//Seto os EDITETEXTs nas variais: contatoNome, contatoEmail e contatoMSG
		contatoNome = (EditText) findViewById(R.id.contatoNome);
		contatoEmail = (EditText) findViewById(R.id.contatoEmail);
		contatoMSG = (EditText) findViewById(R.id.contatoMSG);
		
		btContatoEnviarEmail.setOnClickListener(this);
		
		//inseridno a logo ENCONTRE OFERTA
		ActionBar ab =  getActionBar();
		ab.setIcon(R.drawable.logo_icon);
		//inseridno a logo ENCONTRE OFERTA
		
		
	}
	//Referencia: https://www.youtube.com/watch?v=UNPFWCNMJPU
	// http://www.javaexperience.com/android/SendEmail.rar
	@Override
	public void onClick(View v) {
		
		//Pego sua STRING e seto nas variais: contatoN, contatoE e contatoM
		contatoN = contatoNome.getText().toString().trim();
		contatoE = contatoEmail.getText().toString().trim();
		contatoM = contatoMSG.getText().toString().trim();
		
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		
		sessao = javax.mail.Session.getDefaultInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("comercialencontreoferta@gmail.com", "encontreoferta123");
			}
		});
		
		pDialog = ProgressDialog.show(context, "", "Enviando E-mail...", true);
		
		RetornoFeedTask retorno = new RetornoFeedTask();
		retorno.execute();
	}
	
	//Referencia: https://www.youtube.com/watch?v=UNPFWCNMJPU
	// http://www.javaexperience.com/android/SendEmail.rar
	class RetornoFeedTask extends AsyncTask<String, Void, String>{

		@Override
		protected String doInBackground(String... params) {
			
			try{
				Message mensagem = new MimeMessage(sessao);
				mensagem.setFrom(new InternetAddress("comercialencontreoferta@gmail.com"));
				mensagem.setRecipients(Message.RecipientType.TO, InternetAddress.parse("siteencontreoferta@gmail.com"));
				mensagem.setSubject("Contato de: " + contatoN);
				mensagem.setContent(contatoE + "\n\n" + contatoM, "text/html; charset=utf-8");
				
				Transport.send(mensagem);
				
			}catch(MessagingException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return null;
		}
		
		//Referencia: https://www.youtube.com/watch?v=UNPFWCNMJPU
		// http://www.javaexperience.com/android/SendEmail.rar
		@Override
		protected void onPostExecute(String result) {
			pDialog.dismiss();
			contatoNome.setText("");
			contatoEmail.setText("");
			contatoMSG.setText("");
			
			Toast.makeText(getApplicationContext(), "Mensagem enviada", Toast.LENGTH_LONG).show();
		}
		
		
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
			
			/*case R.id.idMenuHistorico:
				intentMenuContato = new Intent(Contato.this, Historico.class);
				intentMenuContato.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentMenuContato);
				break;*/
			
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
