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
        JFrame frame = new JFrame("One Word Anagram");
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        frame.add(panel);
        frame.setSize(10,10);
        frame.setLocationRelativeTo(null);

        //Font creator
        Font fontTitle = new Font("Sans Serif", Font.BOLD, 50);
        Font fontUnscramble = new Font("Sans Serif", Font.BOLD, 37);
        Font enterGuess = new Font("Sans Serif", Font.BOLD, 24);
        
        //Section 1 (layout Label)
        JLabel label = new JLabel("One Word Anagrams");
        JLabel wrongResponse = new JLabel("Incorrect");
        JLabel correctResponse = new JLabel("Correct!");
        correctResponse.setForeground(Color.green);
        wrongResponse.setForeground(Color.red);
        label.setFont(fontTitle);
        
        
        //Section 2 (TextField + Action Listener)
        JTextField textField = new JTextField();
        textField.setFont(enterGuess);

        JLabel instruction = new JLabel("Enter guess:");
        instruction.setFont(enterGuess);

        JLabel scrambled = new JLabel("EATRG");
        // String currentWord = Word.getWord(3);
        // scrambled.setText(Word.listToString(Word.scramble(currentWord)));
        scrambled.setFont(fontUnscramble);

        //Layout Manager
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                .addComponent(label)
                .addComponent(scrambled)
            .addGroup(layout.createSequentialGroup()
                .addComponent(instruction)
                .addComponent(textField, 0, 200, GroupLayout.PREFERRED_SIZE)));
                    
                    
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(label)
                .addComponent(scrambled)
            .addGroup(layout.createParallelGroup(CENTER)
                .addComponent(instruction)
                .addComponent(textField, 0, 25, GroupLayout.PREFERRED_SIZE)));   

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Method to check when the ENTER Key is Pressed
        textField.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                // String guess = textField.getText();
                // System.out.println(guess);
                // layout.setAutoCreateGaps(true);
                // layout.setAutoCreateContainerGaps(true);

                // layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                //     .addComponent(label)
                //     .addComponent(scrambled)
                // .addGroup(layout.createSequentialGroup()
                //     .addComponent(instruction)
                //     .addComponent(textField, 0, 200, GroupLayout.PREFERRED_SIZE))
                // .addComponent(wrongResponse));
                    
                    
                // layout.setVerticalGroup(layout.createSequentialGroup()
                //     .addComponent(label)
                //     .addComponent(scrambled)
                //     .addGroup(layout.createParallelGroup(CENTER)
                //         .addComponent(instruction)
                //         .addComponent(textField, 0, 25, GroupLayout.PREFERRED_SIZE))
                //     .addComponent(wrongResponse));
                    
                
                // frame.pack();
                // panel.setVisible(true);
                // panel.revalidate();
                // panel.repaint();
                
                layout.setAutoCreateGaps(true);
                layout.setAutoCreateContainerGaps(true);

                layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                    .addComponent(label)
                    .addComponent(scrambled)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(instruction)
                    .addComponent(textField, 0, 200, GroupLayout.PREFERRED_SIZE))
                .addComponent(correctResponse));
                    
                    
                layout.setVerticalGroup(layout.createSequentialGroup()
                    .addComponent(label)
                    .addComponent(scrambled)
                    .addGroup(layout.createParallelGroup(CENTER)
                        .addComponent(instruction)
                        .addComponent(textField, 0, 25, GroupLayout.PREFERRED_SIZE))
                    .addComponent(correctResponse));
                    
                
                frame.pack();
                panel.setVisible(true);
                panel.revalidate();
                panel.repaint();
            }
        });
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

// // boolean a = false;
//         // boolean b = true;
//         // if (a && b){
//         //     System.out.println("hello");
//         //     System.out.println("This will not run");
//         // }

//         // boolean yes = false;
//         // boolean no = false;
//         // if (yes || no){
//         //     System.out.println("something is wrong");
//         // }   
}
