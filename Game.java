import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.*;
import javax.swing.JTextField;
import java.awt.Dimension;
// import java.beans.PropertyChangeListener;
// import java.beans.PropertyChangeEvent;
import java.awt.*;


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
        lives = 5;
        wordLength = 3;
        ID = numPlayers;
        numPlayers++;
    }

    public static void main(String[] args) {

        //Section 1
        JFrame frame = new JFrame("FrameDemo");
        JPanel panel = new JPanel(new GridBagLayout());
        JLabel label = new JLabel();

        label.setText("Anagrams");
        panel.add(label);
        frame.add(panel);
        frame.setSize(300,300);
        
        Font font = new Font("Serif", Font.PLAIN, 50);
        label.setFont(font);
        
        //Section 2
        //JPanel textPanel = new JPanel();
    
        panel.setPreferredSize(new Dimension(250, 50));
        JTextField textField = new JTextField(5);
        JLabel textLabel = new JLabel("Enter guess:");
        textLabel.setLabelFor(textField);
        panel.add(textLabel);
        panel.add(textField);
        frame.add(panel);

        // JLabel scrambled = new JLabel();
        // String currentWord = Word.getWord(3);
        // scrambled.setText(Word.listToString(Word.scramble(currentWord)));
        // scrambled.add(panel);

        frame.pack();
        frame.setVisible(true);
        


        //JTextField textField = new JTextField(1);
        //textField.addActionListener(this);
        


        // frame.getContentPane().add(emptyLabel, BorderLayout.Center);
        
        boolean a = false;
        boolean b = true;
        if (a && b){
            System.out.println("hello");
            System.out.println("This will not run");
        }

        boolean yes = false
        boolean no = false
        if (a || b){
            System.out.println(something is wrong);
        }
        
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
