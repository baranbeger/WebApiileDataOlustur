package com.baran.deneme1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import java.net.HttpURLConnection;

public class Main {
	public static void main(String[] args) {
		//http://localhost:8080/WebApi1/webapi/liste/p1
		
		try {
			URL url=new URL("http://localhost:8080/WebApi1/webapi/liste/p1");
			HttpURLConnection con=(HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");
			
			if(con.getResponseCode() !=200) {
				throw new RuntimeException("Basarisiz: "+con.getResponseCode());
			}
			
			BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
			String results=br.readLine();
			System.out.println(results);
			System.out.println("hay");
			con.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
