import java.util.ArrayList;
import java.util.Scanner;

public class Game{
    private int score;
    private int level;
    public Game() {
        score = 0;
        level = 1;
    }
    
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int wordLength = 3;
        while (wordLength < 10) {
            System.out.println("Level "+level+":");
            String currentWord = (Word.getWord(wordLength));
            System.out.print(currentWord);
            ArrayList<String> scrambledWord = Word.scramble(currentWord);
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