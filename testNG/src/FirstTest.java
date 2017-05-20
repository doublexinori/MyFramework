import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.testng.reporters.jq.Main;

import net.sf.json.JSONObject;

public class FirstTest {
	public static String loadJson (String url) {  
        StringBuilder json = new StringBuilder();                  
        try {  
            URL urlObject = new URL(url);  
            URLConnection uc = urlObject.openConnection();  
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"utf-8"));  
            String inputLine = null;  
            while ( (inputLine = in.readLine()) != null) {  
                json.append(inputLine);  
            }  
            in.close();  
        } catch (MalformedURLException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return json.toString();  
    } 
	public static void main(String[] args){
		String url = "https://service-app-prod-web-usw2.cs-htc.com/api/serviceapp/v1/apps?c=US&l=en"; //写上自己的url链接即可，我的就不公布了哈~  
        String json = loadJson(url);  //获得json字符串
//        System.out.println(json);   //检测是否正确获得        
        JSONObject jsonObject=JSONObject.fromObject(json);
        System.out.println(jsonObject.get("id"));  
	}
}
