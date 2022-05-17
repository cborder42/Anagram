import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import javax.net.ssl.HttpsURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
public class Word {
 public static void main(String[] args) {
     getWord("https://random-word-api.herokuapp.com/word");
 }

 public static void getWord(String URL) {
     try {
        URL url = new URL(URL);
        HttpURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int response = con.getResponseCode();
        System.out.print(response);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream())
        );
        String inputLine;
        StringBuffer content = new StringBuffer();
        while((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        System.out.print(content);
        in.close();
        con.disconnect();

     } catch (MalformedURLException e) {
         System.out.println(e);
     } catch (IOException e) {
         System.out.println(e);
     }
 }

//  public static 
}