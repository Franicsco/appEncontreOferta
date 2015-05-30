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
import android.widget.TextView;
import android.widget.Toast;

public class Login extends FragmentActivity{
	
	//Definindo as Variaveis
	EditText loginEmail;
	EditText loginSenha;
	Button btAcessar;
	TextView btCadastrese;
	
	String Email;
	String Senha;
	
	String VerificaEmail;
	String VerificaSenha;
	
	Intent intentMenuLogin;
	Intent intentIrCadastrar;
	Intent CadastroComSucesso;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		//Setando os EditeText Button e TextView nas variaveis criadas
		loginEmail = (EditText) findViewById(R.id.loginEmail);
		loginSenha = (EditText) findViewById(R.id.loginSenha);
		btAcessar = (Button) findViewById(R.id.btAcessar);
		btCadastrese = (TextView) findViewById(R.id.idCadastrese);
		
		
		
		//Acao ao Clicar no botao ACESSAR(btAcesar).
		btAcessar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				//Referencia: http://stackoverflow.com/questions/24969894/android-email-validation-on-edittext
				//Verifica se o e-mail e valido
				Email = loginEmail.getText().toString().trim();
				VerificaEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				
				if(Email.matches(VerificaEmail)){
					//Toast.makeText(getApplicationContext(), "Cadastro efetuado com sucesso", Toast.LENGTH_LONG).show();					
					CadastroComSucesso = new Intent(Login.this, MainActivity.class);
					UsuarioLogado logado = new UsuarioLogado(Email);					
					startActivity(CadastroComSucesso);
					
				}else{
					Toast.makeText(getApplicationContext(), "Login inválido", Toast.LENGTH_LONG).show();
				}
			}
		});//
		
		//Acao ao Clicar no Texto CADASTRE-SE(btCadastrese)
		btCadastrese.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				intentIrCadastrar = new Intent(Login.this, Cadastrar.class);
				startActivity(intentIrCadastrar);
				
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
		case R.id.idMenuPrincipal:
			intentMenuLogin = new Intent(Login.this, MainActivity.class);
			intentMenuLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentMenuLogin);
			break;

		case R.id.idMenuCategoria:
			intentMenuLogin = new Intent(Login.this, Categoria.class);
			intentMenuLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentMenuLogin);
			break;
			
		case R.id.idMenuQuemSomos:
			intentMenuLogin = new Intent(Login.this, QuemSomos.class);
			intentMenuLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentMenuLogin);
			break;
			
		case R.id.idMenuContato:
			intentMenuLogin = new Intent(Login.this, Contato.class);
			intentMenuLogin.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentMenuLogin);
			break;
		
		}
		return true;
	}//

}
