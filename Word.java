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
     System.out.print(getWord(5));
    //hello
 }

 public static String getWord(int wordLength) {
     String apiUrl = "https://random-word-api.herokuapp.com/word";
     try {
        URL url = new URL(apiUrl+"?length="+wordLength);
        // URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int response = con.getResponseCode();
        // System.out.print(response);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream())
        );
        String inputLine;
        StringBuffer content = new StringBuffer();
        while((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        con.disconnect();
        String word = content.toString();
        return word;

     } catch (MalformedURLException e) {
         System.out.println(e);
         return null;
     } catch (IOException e) {
         System.out.println(e);
         return null;
     }
 }
//Cleans up word so that it is just the word returned
 public static String clean(String word){
    word = word.substring(2, word.length() -2 );
    return word;
}

public static ArrayList<String> seperateWord(String word){
    String cleaned = clean(word);
    ArrayList<String> scrambled = new ArrayList<String>();
    for (int i = 0; i < cleaned.length(); i ++){
        scrambled.add(i, cleaned.substring(i , i+1));
    }
    return scrambled;
}

public static void swap(int i, int j, ArrayList<String> inArray){
    String temp = inArray.get(i);
    inArray.set(i, inArray.get(j));
    inArray.set(j, temp);
}

public static ArrayList<String>scramble(String word){
    ArrayList<String> scrambled = seperateWord(word);
    for(int i = 0; i < scrambled.size(); i++){
        int random = (int) (Math.random()*(scrambled.size()));
        swap(i, random, scrambled);
    }

    
    return scrambled;
}

// public static ArrayList<String> scrambled(String word){
//     String original = word;
//     word = seperateWord(word);
//     ArrayList<String> scrambled =  new ArrayList<String>();
//     for (int i = 0; i < word.length(); i++){
//         scrambled.add(i, word.substring(i, i + 1)); 
//     }
//     for (int k = 0; k < scrambled.size(); k++){
//         String temporary = scrambled.get(k);
//         int newest = (int)(Math.random() * scrambled.size()+1);
//         scrambled.set(k, scrambled.get(newest));
//         scrambled.set(newest, temporary);

//     }

//     return scrambled;
// }    

    
//  public static 
}
