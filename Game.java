import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.Dimension;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
// import java.beans.PropertyChangeListener;
// import java.beans.PropertyChangeEvent;
import java.awt.*;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.CENTER;


public class Game{
    private int score;
    private int level = 1;
    private int lives = 10;
    private int length = 3;
    
    public Game() {
        score = 0;
        level = 1;
        lives = 5;
    }
    
    public int getLength() {
        return length;
    }
    public void incrLength() {
        length++;
    }

    
    // public void playGame() {
    //     Scanner scanner = new Scanner(System.in);
    //     int wordLength = 3;
    //     while (lives > 0){
    //         System.out.println("Player " + ID);
    //         System.out.println("You have " + lives + " lives");
    //         System.out.println("Level " + level + ":");
    //         String currentWord = Word.getWord(wordLength);
    //         ArrayList<String> scrambled = Word.scramble(currentWord);
    //         String scrambledWord = Word.listToString(scrambled);
    //         while (scrambledWord.equals(currentWord)){
    //             scrambled = Word.scramble(scrambledWord);
    //             scrambledWord = Word.listToString(scrambled);
    //         }
    //         System.out.println("Scrambled word: " + scrambledWord);
    //         System.out.print("Enter your guess: ");
    //         String guess = scanner.nextLine();
    //         while(!guess.equals(currentWord) || !Word.checkForWord(currentWord) && lives > 0) {
    //             lives--;
    //             if (lives > 0){
    //                 System.out.println("Incorrect. You now have " + lives + " lives.");
    //                 System.out.print("Try again: ");
    //                 guess = scanner.nextLine();
    //             }
    //             else {
    //                 System.out.println("Incorrect. You have no lives left, game over.");
    //                 System.out.println("The correct answer is: " + currentWord);
    //             }
    //         }
    //         if (lives > 0){
    //             System.out.println("Correct. Entering next level...");
    //             System.out.println("");
    //             level++;
    //             score += wordLength;
    //             if (wordLength > 10){
    //                 System.out.print("game over");
    //             }
    //         }
    //     }
    //     scanner.close();
    // }
    // public static void hint(String input){
    //    int index = (int)(Math.random() * (input.length() - 1));
    //    for (int i = 0; i < index; i++){
    //       System.out.print("_ ");
    //    }
    //    System.out.print(input.substring(index, index + 1));
    //    for(int k = index; k < input.length(); k++){
    //       System.out.print("_ ");
    //    } 
    // } 
}
