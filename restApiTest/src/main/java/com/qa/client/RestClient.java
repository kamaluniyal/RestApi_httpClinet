package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	
public void get(String url) throws ClientProtocolException, IOException{
	
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpGet httpGet = new HttpGet(url);	
	CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
	
	//status code 
	int statusCode = httpResponse.getStatusLine().getStatusCode();
	System.out.println("response code:::"+statusCode);
	
	
	//Response json
	String responseString = EntityUtils.toString(httpResponse.getEntity(),"UTF-8");
	JSONObject responseJSON = new JSONObject(responseString);
	System.out.println("response JSON:::"+responseJSON);
	
	
	//All headers
	Header[] headersArray = httpResponse.getAllHeaders(); 
	System.out.println("Header array :::"+headersArray);
	
	Map<String,String> headerMap = new HashMap<String,String>();
	
	for(Header header :headersArray){
		headerMap.put(header.getName(),header.getValue());
	}
	
	System.out.println("Header map :::"+headerMap);
	
	
	
	}	
	
	
	
	
	
	

}
