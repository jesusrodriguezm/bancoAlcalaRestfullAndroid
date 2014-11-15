package com.jrm.bancoAlcalaCliente.modelo.utiles;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import android.os.AsyncTask;

public class LlamarWebServiceGetJSON extends AsyncTask<String, Void, JSONObject> {
	HttpResponse response;

	@Override
	protected JSONObject doInBackground(String... params) {
		try {
			HttpClient client = new DefaultHttpClient();
			HttpGet request = new HttpGet();
			request.setURI(new URI(params[0]));
			request.addHeader("accept", "application/json");
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

			JSONObject jsonObject = new JSONObject(sb.toString());

			return jsonObject;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}
}
