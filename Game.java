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
// import java.beans.PropertyChangeListener;
// import java.beans.PropertyChangeEvent;
import java.awt.*;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.CENTER;


public class Game{
    private int score;
    private int level = 1;
    private int lives = 10;
    private int ID;
    private static int numPlayers = 1;
    
    
    public Game() {
        score = 0;
        level = 1;
        lives = 5;
        ID = numPlayers;
        numPlayers++;
    }

    public static void main(String[] args) {
        //Main Frame Initializer
        JFrame frame = new JFrame("FrameDemo");
        frame.setSize(10,10);
        frame.setTitle("One Word Anagram");
        // frame.setLocationRelativeTo(null);

        //Font creator
        Font fontTitle = new Font("Sans Serif", Font.BOLD, 50);
        Font fontUnscramble = new Font("Sans Serif", Font.BOLD, 37);
        Font enterGuess = new Font("Sans Serif", Font.BOLD, 24);
        
        //Section 1 (layout Label)
        JPanel panel = new JPanel();
        JLabel label = new JLabel("One Word Anagrams");
        panel.add(label);
        frame.add(panel);
        label.setFont(fontTitle);
        
        //Section 1 (TextLabel)
        panel.setPreferredSize(new Dimension(250, 50));
        JTextField textField = new JTextField(10);
        JLabel textLabel = new JLabel("Enter guess:");
        textLabel.setText("Enter guess:");
        textLabel.setFont(enterGuess);
        textField.setFont(enterGuess);
        panel.add(textLabel);
        panel.add(textField);

        JLabel scrambled = new JLabel("EATRG");
        // String currentWord = Word.getWord(3);
        // scrambled.setText(Word.listToString(Word.scramble(currentWord)));
        scrambled.setFont(fontUnscramble);
        panel.add(scrambled);

        //Layout Manager
        GroupLayout layout = new GroupLayout(panel);
            panel.setLayout(layout);
            layout.setAutoCreateGaps(true);
            layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createParallelGroup(CENTER)  
                    .addComponent(label)
                    .addComponent(scrambled)
                    .addComponent(textField));
                    // .addComponent(textField, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE));
                    
                    
        layout.setVerticalGroup(layout.createSequentialGroup()
                    .addComponent(label)
                    .addComponent(scrambled)
                    .addComponent(textField));
                    // .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE));

        // layout.linkSize(SwingConstants.HORIZONTAL, label, scrambled, textField);
        // layout.linkSize(SwingConstants.VERTICAL, label, scrambled, textField);
       

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        


        //JTextField textField = new JTextField(1);
        //textField.addActionListener(this);
        


        // frame.getContentPane().add(emptyLabel, BorderLayout.Center);
        
        // boolean a = false;
        // boolean b = true;
        // if (a && b){
        //     System.out.println("hello");
        //     System.out.println("This will not run");
        // }

        // boolean yes = false;
        // boolean no = false;
        // if (yes || no){
        //     System.out.println("something is wrong");
        // }
        
    }
    
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int wordLength = 3;
        while (lives > 0){
            System.out.println("Player " + ID);
            System.out.println("You have " + lives + " lives");
            System.out.println("Level " + level + ":");
            String currentWord = Word.getWord(wordLength);
            ArrayList<String> scrambled = Word.scramble(currentWord);
            String scrambledWord = Word.listToString(scrambled);
            while (scrambledWord.equals(currentWord)){
                scrambled = Word.scramble(scrambledWord);
                scrambledWord = Word.listToString(scrambled);
            }
            System.out.println("Scrambled word: " + scrambledWord);
            System.out.print("Enter your guess: ");
            String guess = scanner.nextLine();
            while(!guess.equals(currentWord) || !Word.checkForWord(currentWord) && lives > 0) {
                lives--;
                if (lives > 0){
                    System.out.println("Incorrect. You now have " + lives + " lives.");
                    System.out.print("Try again: ");
                    guess = scanner.nextLine();
                }
                else {
                    System.out.println("Incorrect. You have no lives left, game over.");
                    System.out.println("The correct answer is: " + currentWord);
                }
            }
            if (lives > 0){
                System.out.println("Correct. Entering next level...");
                System.out.println("");
                level++;
                score += wordLength;
                if (wordLength > 10){
                    System.out.print("game over");
                }
            }
        }
        scanner.close();
    }
    public static void hint(String input){
       int index = (int)(Math.random() * (input.length() - 1));
       for (int i = 0; i < index; i++){
          System.out.print("_ ");
       }
       System.out.print(input.substring(index, index + 1));
       for(int k = index; k < input.length(); k++){
          System.out.print("_ ");
       } 
    }


    

    
    

   


    
}
