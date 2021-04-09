package Testframework.Restassured;



import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import io.restassured.path.json.JsonPath;

 

public class Username extends base{

	String ConsumerKey="7C1las31LFZ1sqh8VOHkhAI8M";
    String ConsumerSecret="i8cjjdZIbJwcWhDy0oATBfeOztJ7CNAK82YQcUVMfdg0NKOE7p";
    String Token="1366702057093099523-vcxMlPU6tkUOgH6VU80AyhVZXFtqKY";
    String TokenSecret="o7RsPSdjhEUC9jbXU1HgY40uiWewgJE5NdD3obQc5XpRy";
@Test
public void displayusername_tweet() throws IOException {

RestAssured.baseURI="https://api.twitter.com/1.1/search/";
Response res=given().auth().oauth(ConsumerKey,ConsumerSecret,Token,TokenSecret).
queryParam("q", "#Qualitest").when().
get("tweets.json").then().extract().response();
String response=res.asString();
JsonPath jp=new JsonPath(response);
ArrayList<Object> arr=new ArrayList<Object>();
ArrayList<Object> arr1=new ArrayList<Object>();
arr.addAll(jp.getList("statuses.text"));
arr1.addAll(jp.getList("statuses.user.name"));

Iterator itr=arr.iterator();
Iterator itr1=arr1.iterator();

while(itr.hasNext())
{
System.out.println("Tweet:"+itr.next()+" UserName"+itr1.next());
}

}
}