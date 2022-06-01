import java.util.*;
import java.io.*;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;
import javax.script.ScriptEngineFactory;
import javax.swing.text.Position;

import java.net.UnknownHostException;
import java.net.http.*;


public class Word {
    private String word;
    private String scrambledWord;

    public Word(int length) {
        word = getWordFromFile(length);
        scrambledWord = listToString(scramble(word));
    }

    public static void main(String[] args) { //  System.out.print(getWord(9));
        spaceOut("hello");
        checkForWord("Hello");
        //  System.out.print(checkForWord("garbage"));
        //hello
    }
    public String getWord(){
        return word;
    }

    public String getScrambledWord(){
        return scrambledWord;
    }

    public void update(int length) {
        word = getWordFromFile(length);
        scrambledWord = listToString(scramble(word));
    }
    

 //EasyMode 
 public static ArrayList<String> getAllWords() {
    File file = new File("./words.txt");

    try {
        BufferedReader br = new BufferedReader(new FileReader(file));
        ArrayList<String> words = new ArrayList<>();
        String st;
        while ((st = br.readLine()) != null) {
        words.add(st);
        }
        br.close();
        return words;
    }catch(Exception e){
        System.out.print(e);
        return null;
    }
}
 public static String getWordFromFile(int wordLength) {
    ArrayList<String> words = getAllWords();
    ArrayList<String> possibleWords = new ArrayList<>();
    for (int i = 0; i < words.size(); i++) {
        if (words.get(i).length() == wordLength) {
            possibleWords.add(words.get(i));
        }
    }
    int randomIndex = (int) (Math.random() * possibleWords.size());
    return possibleWords.get(randomIndex);
 }
    // public static boolean checkForWord(String word) {
    // ArrayList<String> words = getAllWords();
    // for (int i = 0; i < words.size(); i++) {
    //     if (words.get(i).equals(word)) {
    //         return true;
    //     }
    // }
    // return false;
    // }


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

public static String getFirstLetterHint(String word) {
    return word.substring(0, 1);

}

public static String spaceOut(String scrambledWord) {
    String spacedOutWord = "";
    for (int i = 0; i < scrambledWord.length(); i++) {
            spacedOutWord = spacedOutWord + scrambledWord.substring(i, i+1) + " ";
    }
    return spacedOutWord;

}

public static boolean checkForWord(String word) {
     String apiUrl = "https://api.dictionaryapi.dev/api/v2/entries/en/";
     try {
        HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(apiUrl+word))
        .method("GET", HttpRequest.BodyPublishers.noBody())
        .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
         if (response.body().indexOf(word) == -1){
             return false;
         }
     } 
     catch (MalformedURLException e) {
         System.out.println(e);
     } catch (IOException e) {
         System.out.println(e);
     } catch (InterruptedException e) {
         System.out.println(e);
     }
     return true;
 }
	
public static boolean checkCharacters(String first, String second){
    first = first.toLowerCase();
    second = second.toLowerCase();
    ArrayList<String> firstWord = new ArrayList<String>();
        for (int i = 0; i < first.length(); i++){
            firstWord.add(first.substring(i, i + 1)); 
        }
    ArrayList<String> secondWord = new ArrayList<String>();
        for (int j = 0; j < second.length(); j++){
            secondWord.add(second.substring(j, j + 1)); 
        }
    for (int f = 0; f < firstWord.size(); f++){
        for (int s = 0; s < secondWord.size(); s++){
            if (firstWord.get(f).equals(secondWord.get(s))){
                secondWord.remove(s);
            }
        }
    }
    if(secondWord.size() == 0){
        return true;
    }
    return false;
}

}
