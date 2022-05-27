import java.util.*;
import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;
import java.net.UnknownHostException;
import java.net.http.*;


public class Word {
 public static void main(String[] args) {
    //  System.out.print(getWord(5));
    //  System.out.print(checkForWord("garbage"));
    //hello
 }

 public static String getWord(int wordLength) {
     String apiUrl = "https://random-word-api.herokuapp.com/word";
     try {
        URL url = new URL(apiUrl+"?length="+wordLength);
        // URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpsURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        // int response = con.getResponseCode();
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
        return clean(word);

     } catch (MalformedURLException e) {
         System.out.println(e);
         return null;
     } catch (IOException e) {
         System.out.println(e);
         return null;
     }
 }

//  public static boolean checkForWord(String word) {
//      String apiUrl = "https://wordsapiv1.p.mashape.com/words/";
//      try {
//         HttpRequest request = HttpRequest.newBuilder()
// 		.uri(URI.create("https://wordsapiv1.p.rapidapi.com/words/hatchback/typeOf"))
// 		.header("X-RapidAPI-Host", "wordsapiv1.p.rapidapi.com")
// 		.header("X-RapidAPI-Key", "da1ecf025amsh6c9c8ed28036583p11fd95jsn2031ab70a216")
// 		.method("GET", HttpRequest.BodyPublishers.noBody())
// 		.build();
//         HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
//         System.out.println(response.body());
//         // URL url = new URL(apiUrl);
//         System.out.print(response);

//         return true;
//      } catch (MalformedURLException e) {
//          System.out.println(e);
//          return false;
//      } catch (IOException e) {
//          System.out.println(e);
//          return false;
//      } catch (InterruptedException e) {
//          return false;
//      }
//  }
//Cleans up word so that it is just the word returned
 public static String clean(String word){
    word = word.substring(2, word.length() -2 );
    return word;
}
//Seperates each letter into a index of the ArrayList
public static ArrayList<String> seperateWord(String word){
    //String cleaned = clean(word);
    ArrayList<String> scrambled = new ArrayList<String>();
    for (int i = 0; i < word.length(); i ++){
        scrambled.add(i, word.substring(i , i+1));
    }
    return scrambled;
}
//Swap method
public static void swap(int i, int j, ArrayList<String> inArray){
    String temp = inArray.get(i);
    inArray.set(i, inArray.get(j));
    inArray.set(j, temp);
}
 
 public static ArrayList<String> scramble(String input){
    ArrayList<String> scrambled =  new ArrayList<String>();
        for (int i = 0; i < input.length(); i++){
            scrambled.add(input.substring(i, i + 1)); 
        }
        for (int k = 0; k < scrambled.size(); k++){
            int location = (int)(Math.random() * scrambled.size());
            String temp = scrambled.get(location);
            int destination = (int)(Math.random() * scrambled.size());
            scrambled.set(location, scrambled.get(destination));
            scrambled.set(destination, temp);
        }
    return scrambled;
 }
 
 public static String listToString(ArrayList<String> scrambled){
        String result = "";
        for (int j = 0; j < scrambled.size(); j++){
            result += scrambled.get(j);
        }
        return result;
}

}
