package ru.practics.learning;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Main {
	
	public static void main(String[] args) throws Exception {
		
		Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress("192.168.6.2",3128));
		
		Authenticator.setDefault(new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				if(getRequestorType() == Authenticator.RequestorType.PROXY) {
					return new PasswordAuthentication("sk", "s1r2g3".toCharArray());
	            } else {
	            	return super.getPasswordAuthentication();
	            }
			}
		});

		URL url = new URL("http://mclarenf-1.com/");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);

		String response = connection.getResponseMessage();
		System.out.println(response);
		String request = connection.getRequestMethod();
		System.out.println(request);
		
		Map<String,List<String>> fields = connection.getHeaderFields();
		Set<String> keys = fields.keySet();
		for(String key: keys) {
			System.out.println(key + " : " + fields.get(key));
		}
		
		System.out.println(connection.getContentType());

		InputStreamReader isr = new InputStreamReader(connection.getInputStream());
		BufferedReader in = new BufferedReader(isr);
		while(in.ready()) {
			System.out.println(in.readLine());
		}
		in.close();

	}
	
}
