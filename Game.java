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
    public Game() {
        score = 0;
        level = 1;
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
        int wordLength = 3;
        while (wordLength < 10) {
            System.out.println("Level "+level+":");
            String currentWord = (Word.getWord(wordLength));
            System.out.print(currentWord);
            String scrambledWord = Word.scramble(currentWord);
            System.out.println("Scrambled word: " + scrambledWord);
            System.out.print("Enter in your guess:");
            String guess = scanner.nextLine();
            while(!guess.equals(currentWord)) {
                System.out.print("Try again:");
                guess = scanner.nextLine();
            }
            System.out.print("Correct");
                level++;
                wordLength++;
                score++;
            
            
        }
        scanner.close();
    }



    
}