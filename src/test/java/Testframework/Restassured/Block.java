package Testframework.Restassured;





import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.IOException;
import io.restassured.path.json.JsonPath;
public class Block extends base {
	String ConsumerKey="7C1las31LFZ1sqh8VOHkhAI8M";
    String ConsumerSecret="i8cjjdZIbJwcWhDy0oATBfeOztJ7CNAK82YQcUVMfdg0NKOE7p";
    String Token="1366702057093099523-vcxMlPU6tkUOgH6VU80AyhVZXFtqKY";
    String TokenSecret="o7RsPSdjhEUC9jbXU1HgY40uiWewgJE5NdD3obQc5XpRy";

@Test
public void block_user() throws IOException {
RestAssured.baseURI="https://api.twitter.com/1.1/blocks/";
Response res=given().auth().oauth(ConsumerKey,ConsumerSecret,Token,TokenSecret).
queryParam("id","1365152181725188101").when().post("create.json").then().extract().response();
String response=res.asString();
JsonPath jp=new JsonPath(response);
String name=jp.get("name");
System.out.println(name);
}

 

}