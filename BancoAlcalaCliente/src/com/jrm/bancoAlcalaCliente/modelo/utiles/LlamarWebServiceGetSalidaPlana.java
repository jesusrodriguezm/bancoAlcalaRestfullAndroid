package com.jrm.bancoAlcalaCliente.modelo.utiles;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class LlamarWebServiceGetSalidaPlana extends AsyncTask<String, Void, String> {
	HttpResponse response;

	@Override
	protected String doInBackground(String... params) {
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			request.setURI(new URI(params[0]));
			
			response = client.execute(request);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					response.getEntity().getContent()));
			StringBuffer sb = new StringBuffer("");
			String lineaLeida = "";
			while ((lineaLeida = in.readLine()) != null) {
				sb.append(lineaLeida);
			}
			in.close();
			System.out.println(sb.toString());
			return sb.toString();
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
}