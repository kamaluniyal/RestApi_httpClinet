package com.qa.tests;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.client.RestClient;

import restApiTest.base.TestBase;

public class GetResponse extends TestBase{
	RestClient client ;
	String endPoint , serviceURL , apiURL ;
	
	@BeforeClass
	public void init(){
		TestBase base = new TestBase();
		client = new RestClient();
		endPoint=prop.getProperty(endPoint);
		serviceURL=prop.getProperty(serviceURL);
		apiURL = endPoint + serviceURL;	
		
	}
	
	@Test
	public void verifApi() throws ClientProtocolException, IOException{
		client.get(apiURL);
	}
	

	
}
