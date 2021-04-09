package Testframework.Restassured;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.*;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Testframework.Restassured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class twitter extends base {
	private static Logger log=LogManager.getLogger(twitter.class.getName());
	 	@Test
	public void getTweet() throws IOException {
		tweet();
		RestAssured.baseURI=prop.getProperty("Host");
		Response res=given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("AccessToken"),prop.getProperty("TokenSecret")).
				queryParam("count",1)
				.when().get("/home_timeline.json").then().extract().response();
		
		String response=res.asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		String id=js.get("id").toString();
		log.info( id);
		//System.out.println(id);
		String text=js.get("text").toString();
		//System.out.println(text);
	log.info(text);
	 	}



@Test
public void createandDeletetweet() throws IOException {
	tweet();
	RestAssured.baseURI=prop.getProperty("Host");
	Response res=given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("AccessToken"),prop.getProperty("TokenSecret")).
			queryParam("status","Iam learning APItesting using Restassured Java #Qualitest23")
			.when().post("/update.json").then().extract().response();
	
	String response=res.asString();
	System.out.println(response);
	JsonPath js=new JsonPath(response);
	String id=js.get("id").toString();
	System.out.println(id);
	String text=js.get("text").toString();
	System.out.println(text);
	
	
	given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("AccessToken"), prop.getProperty("TokenSecret")).
	when().post("/destroy/"+id+".json").then().assertThat().statusCode(200);

}



}