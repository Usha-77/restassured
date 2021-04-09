package Testframework.Restassured;

/*import java.util.ArrayList;

import io.restassured.response.Response;

public class weather extends base {
Restassured.baseURI="https://api.twitter.com/1.1/ssearch/";
Response res=given().auth().oauth(prop.getProperty("ConsumerKey"),prop.getProperty("ConsumerSecret"),prop.getProperty("AccessToken"),prop.getProperty("TokenSecret")).
queryparam("q","#Bangalore #Weather").when().
get("tweets.json").then().extract().response();
String response=res.asString();
JsonPath jp=new JsonPath(response);
ArrayList<Object> arr=new ArrayList<>();
arr.addA11(jp.getList("statuses"));
Iterator itr =arr.iterator(;
while(itr.hasNext()) {
	System.out.println(itr.nxt());
}

}*/

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
public class  weather  {
    
    String ConsumerKey="7C1las31LFZ1sqh8VOHkhAI8M";
    String ConsumerSecret="i8cjjdZIbJwcWhDy0oATBfeOztJ7CNAK82YQcUVMfdg0NKOE7p";
    String Token="1366702057093099523-vcxMlPU6tkUOgH6VU80AyhVZXFtqKY";
    String TokenSecret="o7RsPSdjhEUC9jbXU1HgY40uiWewgJE5NdD3obQc5XpRy";
            
@Test
public void Weather() {
        
        RestAssured.baseURI="https://api.twitter.com/1.1/search/";
        Response res=given().auth().oauth(ConsumerKey,ConsumerSecret,Token,TokenSecret).
        queryParam("q","#Bangalore #Weather").when().
        get("tweets.json").then().extract().response();
        
        String responseString=res.asString();
        JsonPath js=new JsonPath(responseString);
        
        ArrayList<Object> arr=new ArrayList<Object>();
        arr.addAll(js.getList("statuses"));
        Iterator itr=arr.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }               
}

 

@DataProvider
public Object[][] location() {
    
    Object loc[][]= new Object[4][2];
    loc[0][0]="India";
    loc[0][1]="23424848";
    loc[1][0]="US";
    loc[1][1]="23424977";    
    loc[2][0]="UK";
    loc[2][1]="23424975";    
    loc[3][0]="ISRAEL";    
    loc[3][1]="23424852";    
    return loc;
                        
}
}
