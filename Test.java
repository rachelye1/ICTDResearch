package app;

import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.*;

import app.SimpleProtoTest.*;

public class Test {
	public static void main(String[] args) throws IOException {
		System.out.println("Hello");
		SimpleProto test = SimpleProto.newBuilder().build();

		//System.out.println("Message" + test.hasMessage());
		
		URL url = new URL("http://localhost:5000/test-http");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		
		int status = con.getResponseCode();
		System.out.println("Response code " + status);
		System.out.println(" Response msg " + con.getResponseMessage());
		Map<String, List<String>> header = con.getHeaderFields();
		System.out.println("Header Fields: ");
		for(String s : header.keySet()) {
			System.out.println(s + " = "+ header.get(s).toString());
		}
		
		System.out.println(" Content type " + con.getContentType());
		System.out.println("Get Content " + con.getContent().toString());
		
		InputStream is = con.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line;
		while((line = reader.readLine()) != null) {
			sb.append(line);
		}
		System.out.println(sb.toString());
		reader.close();
		
		
		int character = reader.read();
		char[] buffer = new char[4096];
		reader.read(buffer);
		
		
		
		
		
		
		
		
		
		
		
		BufferedReader in = new BufferedReader(
				  new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer content = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
				    content.append(inputLine);
				}
				//in.close();
				//System.out.println(inputLine);
				
				//part 10
				/*
				int status2 = con.getResponseCode();
				 
				Reader streamReader = null;
				 
				if (status2 > 299) {
				    streamReader = new InputStreamReader(con.getErrorStream());
				} else {
				    streamReader = new InputStreamReader(con.getInputStream());
				}
				System.out.println(streamReader.read() + streamReader.read());
				*/
	}
	
	
}
