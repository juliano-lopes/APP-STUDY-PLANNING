package br.com.julopes.tadsprointer;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.widget.TextView;


import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Context;

import android.text.Html;
import android.webkit.WebView;

import android.widget.Toast;
import android.content.Intent;
import br.com.julopes.tadsprointer.User;
import br.com.julopes.tadsprointer.SolicitationType;
import android.widget.Button;
import android.widget.EditText;
public class DownloadData extends AsyncTask<Void, Void, String> {
private Context context;
//private TextView textView;
private User user;
private String url;
private SolicitationType solicitationType;
private Button btnSalvar;
public DownloadData(Context context, User user, String url, SolicitationType solicitationType){
this.context = context;
this.user = user;
this.url = url;
this.solicitationType = solicitationType;
}


	@Override
	protected String doInBackground(Void... params) {

		HttpURLConnection urlConnection = null;
		BufferedReader reader = null;
		try {
			URL url = new URL(this.url);
			urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.connect();

			InputStream inputStream = urlConnection.getInputStream();

			reader = new BufferedReader(new InputStreamReader(inputStream));

			String linha;
			StringBuffer buffer = new StringBuffer();
			while ((linha = reader.readLine()) != null) {
				buffer.append(linha);
				buffer.append("\n");
			}

			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
			if (urlConnection != null) {
				urlConnection.disconnect();
			}

			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}

		return null;
	}

	@Override
	protected void onPostExecute(String data) {
switch (solicitationType){
case LOGIN:
if(data.trim().equals("erro")){
Toast.makeText(context, "Erro ao efetuar login...", Toast.LENGTH_SHORT).show();
}
else{
String[] userData = data.trim().split("//*//");
user.setName(userData[0]);
Toast.makeText(context, "Login realizado.", Toast.LENGTH_SHORT).show();
Intent i = new Intent(context, MainActivityLogged.class);
context.startActivity(i);
}
break;
case REGISTER:
if(data.trim().equals("ok")){
//tv.setText(user.getName()+", "+user.getEmail()+", "+user.getSenha());
Toast.makeText(context, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
}
else if(data.trim().equals("existe")){
Toast.makeText(context, "Existe usuario com esses dados.", Toast.LENGTH_SHORT).show();
}
else{
Toast.makeText(context, "Erro ao efetuar cadastro...", Toast.LENGTH_SHORT).show();
}
break;
default:

break;
}

	}
}
