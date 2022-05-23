import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.*;
import javax.swing.JTextField;
import java.awt.Dimension;


public class Game{
    private int score;
    private int level;
    private int lives;
    private int ID;
    private int wordLength;
    private static int numPlayers = 1;
    
    public Game() {
        score = 0;
        level = 1;
        lives = 3;
        wordLength = 3;
        ID = numPlayers;
        numPlayers++        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FrameDemo");
        // Constructor to make title text and set it horizontally center
        JLabel title = new JLabel("Anagram", JLabel.CENTER);
        frame.add(title);
        //set vertical position top
        title.setVerticalAlignment(JLabel.TOP);
        // title.setFont(new Font("Serif", Font.PLAIN, 20));
        JPanel textPanel = new JPanel();
        JTextField textField = new JTextField(5);
        textPanel.setPreferredSize(new Dimension(250, 50));
        textPanel.add(textField);
        frame.add(textPanel);

        frame.pack();
        frame.setVisible(true);


        //JTextField textField = new JTextField(1);
        //textField.addActionListener(this);
        


        // frame.getContentPane().add(emptyLabel, BorderLayout.Center);
    }
    
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
            System.out.println("Player " + ID);
            System.out.println("You have " + lives + " lives");
            System.out.println("Level " + level + ":");
            String currentWord = Word.getWord(wordLength);
            ArrayList<String> scrambled = Word.scramble(currentWord);
            String scrambledWord = Word.listToString(scrambled);
            System.out.println("Scrambled word: " + scrambledWord);
            System.out.print("Enter your guess:");
            String guess = scanner.nextLine();
            while(!guess.equals(currentWord)) {
                lives--;
                if (lives > 0){
                    System.out.println("Incorrect. You now have " + lives + " lives.");
                    System.out.print("Try again:");
                    guess = scanner.nextLine();
                }
                else {
                    System.out.println("Incorrect. You have no lives left, game over.");
                }
            }
            if (lives > 0){
                System.out.print("Correct. Entering next level...");
                level++;
                score += wordLength;
                if (wordLength < 10){
                    wordLength++;
                }
            }
        scanner.close();
    }



    
}
