import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.CENTER;
import static java.awt.Image.SCALE_SMOOTH;

import java.util.*;

public class Main {

public static void main(String[] args){
    GUI();
}
public static void GUI(){
        //Main Frame Initializer
        JFrame frame = new JFrame("Anagram");
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        frame.add(panel);
        // frame.setSize(10,10);
        frame.setLocationRelativeTo(null);

        //Font creator
        Font fontTitle = new Font("Sans Serif", Font.BOLD, 30);
        Font fontUnscramble = new Font("Sans Serif", Font.BOLD, 37);
        Font enterGuess = new Font("Sans Serif", Font.PLAIN, 24);
        Font blank = new Font("Sans Serif", Font.PLAIN, 45);
        Font counters = new Font("Sans Serif", Font.PLAIN, 20);
        
        //Create objects
        Game game = new Game();
        Word word = new Word(game.getLength());
        JLabel scrambled = new JLabel(Word.spaceOut(word.getScrambledWord()));
        scrambled.setFont(fontUnscramble);
        
        //Section 1 (JLabel)
        JLabel title = new JLabel("Anagram");
        title.setFont(fontTitle);
        JLabel instruction = new JLabel("Enter guess:");
        instruction.setFont(enterGuess);
        JLabel levelCounter = new JLabel("Level: " + game.getLevel() + "  ");
        JLabel livesCounter = new JLabel("Lives: " + game.getLives() + "  ");
        JLabel hintCounter = new JLabel("Hints: " + game.getHint() + "  ");
        JLabel scoreCounter = new JLabel("Score: " + game.getScore() + "  ");
        levelCounter.setBorder(new EmptyBorder(0, 50, 0, 0));
        hintCounter.setBorder(new EmptyBorder(0, 25, 0, 50));
        livesCounter.setBorder(new EmptyBorder(0, 50, 0, 25));
        scoreCounter.setBorder(new EmptyBorder(0, 0, 0, 50));
        levelCounter.setFont(counters);
        livesCounter.setFont(counters);
        hintCounter.setFont(counters);
        scoreCounter.setFont(counters);
        
        //Section 2 (JTextField)
        JTextField textField = new JTextField();
        textField.setForeground(Color.LIGHT_GRAY);
        textField.setFont(counters);

        //Section 3(JButtons)
        JButton hintButton = new JButton("First Letter Hint");
        ImageIcon guessIcon = new ImageIcon("./guessbutton.png");
        JButton enterGuessButton = new JButton(guessIcon);
        enterGuessButton.setOpaque(true);
        enterGuessButton.setBorderPainted(false);
        JButton startButton = new JButton("Restart");
        startButton.setPreferredSize(new Dimension(50, 50));
        
        //Labels
        JLabel wrongResponse = new JLabel(" ");
        JLabel correctResponse = new JLabel("Correct!");
        JLabel hintResponse = new JLabel(" ");
        JLabel blankResponse = new JLabel(" ");
        JLabel correctWord = new JLabel(" ");
        correctResponse.setForeground(Color.green);
        wrongResponse.setForeground(Color.red);
        wrongResponse.setFont(counters);
        correctResponse.setFont(counters);
        hintResponse.setFont(counters);
        blankResponse.setFont(blank);
        correctWord.setFont(fontTitle);
        
        //word collector
        ArrayList<String> allWords = new ArrayList<String>();

        //Layout Manager
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
            .addComponent(title)
            .addGroup(layout.createSequentialGroup()
                .addComponent(levelCounter)
                .addComponent(livesCounter)
                .addComponent(hintCounter)
                .addComponent(scoreCounter))
            .addComponent(scrambled)
            .addGroup(layout.createSequentialGroup()
                .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
            .addComponent(enterGuessButton)
            .addComponent(wrongResponse)
            .addComponent(hintButton));
                    
                    
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(title)
            .addGroup(layout.createParallelGroup(CENTER)
                .addComponent(levelCounter)
                .addComponent(livesCounter)
                .addComponent(hintCounter)
                .addComponent(scoreCounter))
            .addComponent(scrambled)
            .addGroup(layout.createParallelGroup(CENTER)
                .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
            .addComponent(enterGuessButton)
            .addComponent(wrongResponse)
            .addComponent(hintButton));   

        textField.setForeground(Color.black);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// Enter key
        textField.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                String guess = textField.getText();
                textField.setText("");
                layout.setAutoCreateGaps(true);
                layout.setAutoCreateContainerGaps(true); 
                if (guess.equals("")){
                    wrongResponse.setText("Please enter a guess...");
                        layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                            .addComponent(title)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(levelCounter)
                                .addComponent(livesCounter)
                                .addComponent(hintCounter)  
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(wrongResponse)
                            .addComponent(hintResponse));
                    
                        layout.setVerticalGroup(layout.createSequentialGroup()
                            .addComponent(title)
                            .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(levelCounter)
                                .addComponent(livesCounter)
                                .addComponent(hintCounter)
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(wrongResponse)
                            .addComponent(hintResponse));

                    panel.remove(correctResponse);
                    frame.pack();
                    panel.setVisible(true);
                    panel.revalidate();
                    panel.repaint();
                }
                else if (guess.length() < 3){
                    wrongResponse.setText("Please enter more than two letters");
                        layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                            .addComponent(title)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(levelCounter)
                                .addComponent(livesCounter)
                                .addComponent(hintCounter)  
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(wrongResponse)
                            .addComponent(hintResponse));
                    
                        layout.setVerticalGroup(layout.createSequentialGroup()
                            .addComponent(title)
                            .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(levelCounter)
                                .addComponent(livesCounter)
                                .addComponent(hintCounter)
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(wrongResponse)
                            .addComponent(hintResponse));

                    panel.remove(correctResponse);
                    frame.pack();
                    panel.setVisible(true);
                    panel.revalidate();
                    panel.repaint();
                }
                else {
                    if (!Word.checkCharacters(word.getWord(), guess)){
                        wrongResponse.setText("Please only use the characters given.");
                        layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                            .addComponent(title)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(levelCounter)
                                .addComponent(livesCounter)
                                .addComponent(hintCounter)  
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(wrongResponse)
                            .addComponent(hintResponse));
                    
                        layout.setVerticalGroup(layout.createSequentialGroup()
                            .addComponent(title)
                            .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(levelCounter)
                                .addComponent(livesCounter)
                                .addComponent(hintCounter)
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(wrongResponse)
                            .addComponent(hintResponse));

                        panel.remove(correctResponse);
                        frame.pack();
                        panel.setVisible(true);
                        panel.revalidate();
                        panel.repaint();
                    } 
                    else {
                        if(Word.checkForWord(guess)){
                            if (checkWord(word.getWord(), guess)){
                                correctResponse.setText("Correct!");
                                game.incrLevel();
                                levelCounter.setText("Level: " + game.getLevel() + "  ");
                                game.incrScore(guess.length() * game.getLevel() * 10);
                                scoreCounter.setText("Score: " + game.getScore() + "  ");
                                layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                    .addComponent(title)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(correctResponse)
                                    .addComponent(hintButton));
                    
                                layout.setVerticalGroup(layout.createSequentialGroup()
                                    .addComponent(title)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(correctResponse)
                                    .addComponent(hintButton));
                        
                                panel.remove(wrongResponse);
                                panel.remove(hintResponse);
                                hintResponse.setText(" ");
                                frame.pack();
                                panel.setVisible(true);
                                panel.revalidate();
                                panel.repaint();
                                
                                if (game.getLength() < 12){
                                    game.incrLength();
                                } else{
                                    game.decrLength();
                                }
                                word.update(game.getLength());
                                scrambled.setText(Word.spaceOut(word.getScrambledWord()));
                                
                                for (int i = 0; i < allWords.size(); i++){
                                    allWords.remove(0);
                                }
                            }
                            else if (allWords.indexOf(guess) == -1){
                                correctResponse.setText("That is a word, but not the original one.");
                                allWords.add(guess);
                                game.incrScore(guess.length() * game.getLevel() * 10);
                                scoreCounter.setText("Score: " + game.getScore() + "  ");
                                layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                    .addComponent(title)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(correctResponse)
                                    .addComponent(hintResponse));
                    
                                layout.setVerticalGroup(layout.createSequentialGroup()
                                    .addComponent(title)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(correctResponse)
                                    .addComponent(hintResponse));
                        
                                panel.remove(wrongResponse);
                                frame.pack();
                                panel.setVisible(true);
                                panel.revalidate();
                                panel.repaint();
                            }
                            else {
                                correctResponse.setText("You already guessed this word.");
                                layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                    .addComponent(title)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(correctResponse)
                                    .addComponent(hintResponse));
                    
                                layout.setVerticalGroup(layout.createSequentialGroup()
                                    .addComponent(title)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(correctResponse)
                                    .addComponent(hintResponse));
                        
                                panel.remove(wrongResponse);
                                frame.pack();
                                panel.setVisible(true);
                                panel.revalidate();
                                panel.repaint();
                            }
                        }
                        else {
                            if (allWords.indexOf(guess) == -1){
                                game.decrLives();
                                livesCounter.setText("Lives: " + game.getLives() + "  ");
                                allWords.add(guess);
                                if (game.getLives() > 0){
                                    wrongResponse.setText("Incorrect");
                                    layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(title)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(levelCounter)
                                            .addComponent(livesCounter)
                                            .addComponent(hintCounter)  
                                            .addComponent(scoreCounter))
                                        .addComponent(scrambled)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(enterGuessButton)
                                        .addComponent(wrongResponse)
                                        .addComponent(hintResponse));
                     
                                    layout.setVerticalGroup(layout.createSequentialGroup()
                                        .addComponent(title)
                                        .addGroup(layout.createParallelGroup(CENTER)
                                            .addComponent(levelCounter)
                                            .addComponent(livesCounter)
                                            .addComponent(hintCounter)
                                            .addComponent(scoreCounter))
                                        .addComponent(scrambled)
                                        .addGroup(layout.createParallelGroup(CENTER)
                                            .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(enterGuessButton)
                                        .addComponent(wrongResponse)
                                        .addComponent(hintResponse));

                                    panel.remove(correctResponse);
                                    frame.pack();
                                    panel.setVisible(true);
                                    panel.revalidate();
                                    panel.repaint();
                                }
                                else{
                                    wrongResponse.setText("GAME OVER");
                                    correctWord.setText("Correct Word: " + word.getWord());
                                    layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(title)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(levelCounter)
                                            .addComponent(livesCounter)
                                            .addComponent(hintCounter)  
                                            .addComponent(scoreCounter))
                                        .addComponent(scrambled)
                                        .addComponent(blankResponse)
                                        .addComponent(correctWord)
                                        .addComponent(wrongResponse)
                                        .addComponent(startButton));
                    
                                    layout.setVerticalGroup(layout.createSequentialGroup()
                                        .addComponent(title)
                                        .addGroup(layout.createParallelGroup(CENTER)
                                            .addComponent(levelCounter)
                                            .addComponent(livesCounter)
                                            .addComponent(hintCounter)
                                            .addComponent(scoreCounter))
                                        .addComponent(scrambled)
                                        .addComponent(blankResponse)
                                        .addComponent(correctWord)
                                        .addComponent(wrongResponse)
                                        .addComponent(startButton));
                                        
                                    panel.remove(textField);
                                    panel.remove(correctResponse);
                                    panel.remove(hintResponse);
                                    panel.remove(enterGuessButton);
                                    panel.remove(hintButton);
                                    frame.pack();
                                    panel.setVisible(true);
                                    panel.revalidate();
                                    panel.repaint();
                                    
                                    for (int i = 0; i < allWords.size(); i++){
                                        allWords.remove(0);
                                    }
                                }         
                            }
                            else{
                                wrongResponse.setText("You already guessed this word.");
                                layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                    .addComponent(title)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(wrongResponse)
                                    .addComponent(hintResponse));
                    
                                layout.setVerticalGroup(layout.createSequentialGroup()
                                    .addComponent(title)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(wrongResponse)
                                    .addComponent(hintResponse));
                        
                                panel.remove(correctResponse);
                                frame.pack();
                                panel.setVisible(true);
                                panel.revalidate();
                                panel.repaint();
                            }
                        }
                    }
                }
        }});

// EnterGuess Button
        enterGuessButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String guess = textField.getText();
                textField.setText("");
                layout.setAutoCreateGaps(true);
                layout.setAutoCreateContainerGaps(true); 
                if (guess.equals("")){
                    wrongResponse.setText("Please enter a guess...");
                        layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                            .addComponent(title)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(levelCounter)
                                .addComponent(livesCounter)
                                .addComponent(hintCounter)  
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(wrongResponse)
                            .addComponent(hintResponse));
                    
                        layout.setVerticalGroup(layout.createSequentialGroup()
                            .addComponent(title)
                            .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(levelCounter)
                                .addComponent(livesCounter)
                                .addComponent(hintCounter)
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(wrongResponse)
                            .addComponent(hintResponse));

                    panel.remove(correctResponse);
                    frame.pack();
                    panel.setVisible(true);
                    panel.revalidate();
                    panel.repaint();
                }
                else if (guess.length() < 3){
                    wrongResponse.setText("Please enter more than two letters");
                        layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                            .addComponent(title)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(levelCounter)
                                .addComponent(livesCounter)
                                .addComponent(hintCounter)  
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(wrongResponse)
                            .addComponent(hintResponse));
                    
                        layout.setVerticalGroup(layout.createSequentialGroup()
                            .addComponent(title)
                            .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(levelCounter)
                                .addComponent(livesCounter)
                                .addComponent(hintCounter)
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(wrongResponse)
                            .addComponent(hintResponse));

                    panel.remove(correctResponse);
                    frame.pack();
                    panel.setVisible(true);
                    panel.revalidate();
                    panel.repaint();
                }
                else {
                    if (!Word.checkCharacters(word.getWord(), guess)){
                        wrongResponse.setText("Please only use the characters given.");
                        layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                            .addComponent(title)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(levelCounter)
                                .addComponent(livesCounter)
                                .addComponent(hintCounter)  
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(wrongResponse)
                            .addComponent(hintResponse));
                    
                        layout.setVerticalGroup(layout.createSequentialGroup()
                            .addComponent(title)
                            .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(levelCounter)
                                .addComponent(livesCounter)
                                .addComponent(hintCounter)
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(wrongResponse)
                            .addComponent(hintResponse));

                        panel.remove(correctResponse);
                        frame.pack();
                        panel.setVisible(true);
                        panel.revalidate();
                        panel.repaint();
                    } 
                    else {
                        if(Word.checkForWord(guess)){
                            if (checkWord(word.getWord(), guess)){
                                correctResponse.setText("Correct!");
                                game.incrLevel();
                                levelCounter.setText("Level: " + game.getLevel() + "  ");
                                game.incrScore(guess.length() * game.getLevel() * 10);
                                scoreCounter.setText("Score: " + game.getScore() + "  ");
                                layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                    .addComponent(title)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(correctResponse)
                                    .addComponent(hintButton));
                    
                                layout.setVerticalGroup(layout.createSequentialGroup()
                                    .addComponent(title)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(correctResponse)
                                    .addComponent(hintButton));
                        
                                panel.remove(wrongResponse);
                                panel.remove(hintResponse);
                                hintResponse.setText(" ");
                                frame.pack();
                                panel.setVisible(true);
                                panel.revalidate();
                                panel.repaint();
                                
                                if (game.getLength() < 12){
                                    game.incrLength();
                                } else{
                                    game.decrLength();
                                }
                                word.update(game.getLength());
                                scrambled.setText(Word.spaceOut(word.getScrambledWord()));
                                
                                for (int i = 0; i < allWords.size(); i++){
                                    allWords.remove(0);
                                }
                            }
                            else if (allWords.indexOf(guess) == -1){
                                correctResponse.setText("That is a word, but not the original one.");
                                allWords.add(guess);
                                game.incrScore(guess.length() * game.getLevel() * 10);
                                scoreCounter.setText("Score: " + game.getScore() + "  ");
                                layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                    .addComponent(title)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(correctResponse)
                                    .addComponent(hintResponse));
                    
                                layout.setVerticalGroup(layout.createSequentialGroup()
                                    .addComponent(title)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(correctResponse)
                                    .addComponent(hintResponse));
                        
                                panel.remove(wrongResponse);
                                frame.pack();
                                panel.setVisible(true);
                                panel.revalidate();
                                panel.repaint();
                            }
                            else {
                                correctResponse.setText("You already guessed this word.");
                                layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                    .addComponent(title)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(correctResponse)
                                    .addComponent(hintResponse));
                    
                                layout.setVerticalGroup(layout.createSequentialGroup()
                                    .addComponent(title)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(correctResponse)
                                    .addComponent(hintResponse));
                        
                                panel.remove(wrongResponse);
                                frame.pack();
                                panel.setVisible(true);
                                panel.revalidate();
                                panel.repaint();
                            }
                        }
                        else {
                            if (allWords.indexOf(guess) == -1){
                                game.decrLives();
                                livesCounter.setText("Lives: " + game.getLives() + "  ");
                                allWords.add(guess);
                                if (game.getLives() > 0){
                                    wrongResponse.setText("Incorrect");
                                    layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(title)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(levelCounter)
                                            .addComponent(livesCounter)
                                            .addComponent(hintCounter)  
                                            .addComponent(scoreCounter))
                                        .addComponent(scrambled)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(enterGuessButton)
                                        .addComponent(wrongResponse)
                                        .addComponent(hintResponse));
                     
                                    layout.setVerticalGroup(layout.createSequentialGroup()
                                        .addComponent(title)
                                        .addGroup(layout.createParallelGroup(CENTER)
                                            .addComponent(levelCounter)
                                            .addComponent(livesCounter)
                                            .addComponent(hintCounter)
                                            .addComponent(scoreCounter))
                                        .addComponent(scrambled)
                                        .addGroup(layout.createParallelGroup(CENTER)
                                            .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(enterGuessButton)
                                        .addComponent(wrongResponse)
                                        .addComponent(hintResponse));

                                    panel.remove(correctResponse);
                                    frame.pack();
                                    panel.setVisible(true);
                                    panel.revalidate();
                                    panel.repaint();
                                }
                                else{
                                    wrongResponse.setText("GAME OVER");
                                    correctWord.setText("Correct Word: " + word.getWord());
                                    layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(title)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(levelCounter)
                                            .addComponent(livesCounter)
                                            .addComponent(hintCounter)  
                                            .addComponent(scoreCounter))
                                        .addComponent(scrambled)
                                        .addComponent(blankResponse)
                                        .addComponent(correctWord)
                                        .addComponent(wrongResponse)
                                        .addComponent(startButton));
                    
                                    layout.setVerticalGroup(layout.createSequentialGroup()
                                        .addComponent(title)
                                        .addGroup(layout.createParallelGroup(CENTER)
                                            .addComponent(levelCounter)
                                            .addComponent(livesCounter)
                                            .addComponent(hintCounter)
                                            .addComponent(scoreCounter))
                                        .addComponent(scrambled)
                                        .addComponent(blankResponse)
                                        .addComponent(correctWord)
                                        .addComponent(wrongResponse)
                                        .addComponent(startButton));
                                        
                                    panel.remove(textField);
                                    panel.remove(correctResponse);
                                    panel.remove(hintResponse);
                                    panel.remove(enterGuessButton);
                                    panel.remove(hintButton);
                                    frame.pack();
                                    panel.setVisible(true);
                                    panel.revalidate();
                                    panel.repaint();
                                    
                                    for (int i = 0; i < allWords.size(); i++){
                                        allWords.remove(0);
                                    }
                                }         
                            }
                            else{
                                wrongResponse.setText("You already guessed this word.");
                                layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                    .addComponent(title)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(wrongResponse)
                                    .addComponent(hintResponse));
                    
                                layout.setVerticalGroup(layout.createSequentialGroup()
                                    .addComponent(title)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(levelCounter)
                                        .addComponent(livesCounter)
                                        .addComponent(hintCounter)
                                        .addComponent(scoreCounter))
                                    .addComponent(scrambled)
                                    .addGroup(layout.createParallelGroup(CENTER)
                                        .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(enterGuessButton)
                                    .addComponent(wrongResponse)
                                    .addComponent(hintResponse));
                        
                                panel.remove(correctResponse);
                                frame.pack();
                                panel.setVisible(true);
                                panel.revalidate();
                                panel.repaint();
                            }
                        }
                    }
                }
        }});
                
// HINT
        hintButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (game.getHint() > 0){
                    hintResponse.setText("First letter: " + word.getWord().substring(0, 1));
                    game.decrHint();
                    hintCounter.setText("Hints: " + game.getHint() + "  ");
                    layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                        .addComponent(title)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(levelCounter)
                            .addComponent(livesCounter)
                            .addComponent(hintCounter)
                            .addComponent(scoreCounter))
                        .addComponent(scrambled)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                        .addComponent(enterGuessButton)
                        .addComponent(hintResponse));
                    
                    
                    layout.setVerticalGroup(layout.createSequentialGroup()
                        .addComponent(title)
                        .addGroup(layout.createParallelGroup(CENTER)
                            .addComponent(levelCounter)
                            .addComponent(livesCounter)
                            .addComponent(hintCounter)
                            .addComponent(scoreCounter))
                        .addComponent(scrambled)
                        .addGroup(layout.createParallelGroup(CENTER)
                            .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                        .addComponent(enterGuessButton)
                        .addComponent(hintResponse));
                
                    panel.remove(correctResponse);
                    panel.remove(wrongResponse);
                    panel.remove(hintButton);
                    frame.pack();
                    panel.setVisible(true);
                    panel.revalidate();
                    panel.repaint();
                } else {
                    hintResponse.setText("You don't have any hints left!");
                    layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                        .addComponent(title)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(levelCounter)
                            .addComponent(livesCounter)
                            .addComponent(hintCounter)
                            .addComponent(scoreCounter))
                        .addComponent(scrambled)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(textField, 0, 305, GroupLayout.PREFERRED_SIZE))
                        .addComponent(enterGuessButton)
                        .addComponent(hintResponse));
                    
                    
                    layout.setVerticalGroup(layout.createSequentialGroup()
                        .addComponent(title)
                        .addGroup(layout.createParallelGroup(CENTER)
                            .addComponent(levelCounter)
                            .addComponent(livesCounter)
                            .addComponent(hintCounter)
                            .addComponent(scoreCounter))
                        .addComponent(scrambled)
                        .addGroup(layout.createParallelGroup(CENTER)
                            .addComponent(textField, 0, 45, GroupLayout.PREFERRED_SIZE))
                        .addComponent(enterGuessButton)
                        .addComponent(hintResponse));
                
                    panel.remove(correctResponse);
                    panel.remove(wrongResponse);
                    panel.remove(hintButton);
                    frame.pack();
                    panel.setVisible(true);
                    panel.revalidate();
                    panel.repaint();                
                }
            }
        });
    
    }
    // END OF METHOD

public static boolean checkWord(String word, String guess) {
    if (word.equals(guess)) {
        return true;
    } 
    else {
        return false;
    }

}
}
