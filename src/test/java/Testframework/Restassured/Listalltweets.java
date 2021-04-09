package Testframework.Restassured;
import static io.restassured.RestAssured.given;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;
public class Listalltweets extends base {
	private static Logger log=LogManager.getLogger(twitter.class.getName());
	@Test
	public  void  getuserTweet() throws IOException
	{
		tweet();
		RestAssured.baseURI=prop.getProperty("Host");
		Response res=given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("AccessToken"),prop.getProperty("TokenSecret")).
	when().queryParam("excludes_replies", "true").queryParam("include_rts", "false").get("user_timeline.json").then().assertThat().statusCode(200).extract().response();
String response=res.asString();
log.info(response);
JsonPath js=new JsonPath(response);
List<String> ba=js.getList("text");
log.info(ba);
		
	
	}

}
