package Testframework.Restassured;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class base {
	public Properties prop;
	public void tweet() throws IOException {
	prop=new Properties();
	FileInputStream fis=new FileInputStream("C:\\Users\\intern 8\\eclipse-workspace\\Restassured\\src\\main\\java\\Testframework\\Restassured\\data.properties");
	prop.load(fis);
}
	public void Listtoelement(List abc)
    {
    String s=abc.toString();
    String result=s.substring(2,s.length()-2);
    String arr[]=result.split(",");
    for(int i=0;i<6;i++)
    {
        System.out.println(arr[i]);
    }
}
}