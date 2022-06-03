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

    public static void getResponse(ArrayList<Object> components, String input, int color){
        JFrame frame = (JFrame) components.get(0);
        JPanel panel = (JPanel) components.get(1);
        GroupLayout layout = (GroupLayout) components.get(2);
        Game game = (Game) components.get(3);
        Word word = (Word) components.get(4);
        JLabel scrambled = (JLabel) components.get(5);
        JLabel title = (JLabel) components.get(6);
        JLabel levelCounter = (JLabel) components.get(7);
        JLabel livesCounter = (JLabel) components.get(8);
        JLabel hintCounter = (JLabel) components.get(9);
        JLabel scoreCounter = (JLabel) components.get(10);
        JTextField textField = (JTextField) components.get(11);
        JButton hintButton = (JButton) components.get(12);
        JButton enterGuessButton = (JButton) components.get(13);
        JButton startButton = (JButton) components.get(14);
        JLabel response = (JLabel) components.get(15);
        JLabel hintResponse = (JLabel) components.get(16);
        JLabel blankResponse = (JLabel) components.get(17);
        JLabel correctWord = (JLabel) components.get(18);
        
        if (color == 0){
            response.setForeground(Color.red);
        }
        if (color == 1){
            response.setForeground(Color.green);
        }
        response.setText(input);
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
            .addComponent(response)
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
            .addComponent(response)
            .addComponent(hintResponse));
                        
        frame.pack();
        panel.setVisible(true);
        panel.revalidate();
        panel.repaint();
    }
        
    public static void start(ArrayList<Object> components){
        JFrame frame = (JFrame) components.get(0);
        JPanel panel = (JPanel) components.get(1);
        GroupLayout layout = (GroupLayout) components.get(2);
        Game game = (Game) components.get(3);
        Word word = (Word) components.get(4);
        JLabel scrambled = (JLabel) components.get(5);
        JLabel title = (JLabel) components.get(6);
        JLabel levelCounter = (JLabel) components.get(7);
        JLabel livesCounter = (JLabel) components.get(8);
        JLabel hintCounter = (JLabel) components.get(9);
        JLabel scoreCounter = (JLabel) components.get(10);
        JTextField textField = (JTextField) components.get(11);
        JButton hintButton = (JButton) components.get(12);
        JButton enterGuessButton = (JButton) components.get(13);
        JButton startButton = (JButton) components.get(14);
        JLabel response = (JLabel) components.get(15);
        JLabel hintResponse = (JLabel) components.get(16);
        JLabel blankResponse = (JLabel) components.get(17);
        JLabel correctWord = (JLabel) components.get(18);
        
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
            .addComponent(response)
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
            .addComponent(response)
            .addComponent(startButton));
        
        panel.remove(textField);
        panel.remove(hintResponse);
        panel.remove(enterGuessButton);
        panel.remove(hintButton);
        frame.pack();
        panel.setVisible(true);
        panel.revalidate();
        panel.repaint();
    }

    public static void GUI(){
        //Main Frame Initializer
        JFrame frame = new JFrame("Anagram");
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        frame.add(panel);
        frame.setLocationRelativeTo(null);

        //Font creator
        Font fontTitle = new Font("Sans Serif", Font.BOLD, 30);
        Font fontUnscramble = new Font("Sans Serif", Font.BOLD, 37);
        Font enterGuess = new Font("Sans Serif", Font.PLAIN, 33);
        Font blank = new Font("Sans Serif", Font.PLAIN, 45);
        Font counters = new Font("Sans Serif", Font.PLAIN, 20);
        
        //Create objects
        Game game = new Game();
        Word word = new Word(game.getLength());
        JLabel scrambled = new JLabel(" ");
        scrambled.setFont(fontUnscramble);
        
        //Section 1 (JLabel)
        JLabel title = new JLabel("Anagram");
        title.setFont(fontTitle);
        JLabel levelCounter = new JLabel("               ");
        JLabel livesCounter = new JLabel("               ");
        JLabel hintCounter = new JLabel("               ");
        JLabel scoreCounter = new JLabel("               ");
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

        //Section 3 (JButtons)
        JButton hintButton = new JButton("First Letter Hint");
        ImageIcon guessIcon = new ImageIcon("./guessbutton.png");
        JButton enterGuessButton = new JButton(guessIcon);
        enterGuessButton.setOpaque(true);
        enterGuessButton.setBorderPainted(false);
        JButton startButton = new JButton("Start Game");
        
        //Labels
        JLabel response = new JLabel("Caelen Y., Nathan L., Nathaniel L., Tony W., Victor C.");
        JLabel hintResponse = new JLabel(" ");
        JLabel blankResponse = new JLabel(" ");
        JLabel correctWord = new JLabel("Game by: ");
        response.setForeground(Color.black);
        response.setFont(counters);
        hintResponse.setFont(counters);
        blankResponse.setFont(blank);
        correctWord.setFont(enterGuess);
        
        //word collector
        ArrayList<String> allWords = new ArrayList<String>();
        
        //components
        ArrayList<Object> components = new ArrayList<Object>(Arrays.asList(frame, panel,
        layout, game, word, scrambled, title, levelCounter, livesCounter, hintCounter, 
        scoreCounter, textField, hintButton, enterGuessButton, startButton, response, 
        hintResponse, blankResponse, correctWord));

        //Layout Manager
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        start(components);
            
        textField.setForeground(Color.black);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//start button
        startButton.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                game.reset();
                word.update(game.getLength());
                scrambled.setText(Word.spaceOut(word.getScrambledWord()));
                response.setText(" ");
                levelCounter.setText("Level: " + game.getLevel() + "  ");
                livesCounter.setText("Lives: " + game.getLives() + "  ");
                hintCounter.setText("Hints: " + game.getHint() + "  ");
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
                    .addComponent(response)
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
                    .addComponent(response)
                    .addComponent(hintButton));   
                
                panel.remove(blankResponse);
                panel.remove(correctWord);
                panel.remove(startButton);
                frame.pack();
                panel.setVisible(true);
                panel.revalidate();
                panel.repaint();
            }});

// Enter key
        textField.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                String guess = textField.getText();
                textField.setText("");
                layout.setAutoCreateGaps(true);
                layout.setAutoCreateContainerGaps(true); 
                if (guess.equals("")){
                    getResponse(components, "Please enter a guess...", 0);
                }
                else if (!Word.checkCharacters(word.getWord(), guess)){
                    getResponse(components, "Please only use the characters given.", 0);
                }
                else if (guess.length() < 3){
                    getResponse(components, "Please enter more than two letters", 0);
                }
                else if(Word.checkForWord(guess)){
                    if (checkWord(word.getWord(), guess)){
                        response.setText("Correct!");
                        response.setForeground(Color.green);
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
                            .addComponent(response)
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
                            .addComponent(response)
                            .addComponent(hintButton));
                
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
                        allWords.add(guess);
                        game.incrScore(guess.length() * game.getLevel() * 10);
                        scoreCounter.setText("Score: " + game.getScore() + "  ");
                        getResponse(components, "That is a word, but not the original one.", 1);
                    }
                    else {
                        getResponse(components, "You already guessed this word.", 1);
                    }
                }
                else if (allWords.indexOf(guess) == -1){
                    game.decrLives();
                    livesCounter.setText("Lives: " + game.getLives() + "  ");
                    allWords.add(guess);
                    if (game.getLives() > 0){
                        getResponse(components, "Incorrect. Lives - 1", 0);
                    }
                    else{
                        response.setText("GAME OVER");
                        response.setForeground(Color.red);
                        startButton.setText("Restart Game");
                        correctWord.setText("Correct Word: " + word.getWord());
                        start(components);                                    
                        for (int i = 0; i < allWords.size(); i++){
                            allWords.remove(0);
                        }
                    }   
                }      
                else{
                    getResponse(components, "You already guessed this word.", 0);
                }
            }
        });

// EnterGuess Button
        enterGuessButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String guess = textField.getText();
                textField.setText("");
                layout.setAutoCreateGaps(true);
                layout.setAutoCreateContainerGaps(true); 
                if (guess.equals("")){
                    getResponse(components, "Please enter a guess...", 0);
                }
                else if (!Word.checkCharacters(word.getWord(), guess)){
                    getResponse(components, "Please only use the characters given.", 0);
                }
                else if (guess.length() < 3){
                    getResponse(components, "Please enter more than two letters", 0);
                }
                else if(Word.checkForWord(guess)){
                    if (checkWord(word.getWord(), guess)){
                        response.setText("Correct!");
                        response.setForeground(Color.green);
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
                            .addComponent(response)
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
                            .addComponent(response)
                            .addComponent(hintButton));
                
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
                        allWords.add(guess);
                        game.incrScore(guess.length() * game.getLevel() * 10);
                        scoreCounter.setText("Score: " + game.getScore() + "  ");
                        getResponse(components, "That is a word, but not the original one.", 1);
                    }
                    else {
                        getResponse(components, "You already guessed this word.", 1);
                    }
                }
                else if (allWords.indexOf(guess) == -1){
                    game.decrLives();
                    livesCounter.setText("Lives: " + game.getLives() + "  ");
                    allWords.add(guess);
                    if (game.getLives() > 0){
                        getResponse(components, "Incorrect. Lives - 1", 0);
                    }
                    else{
                        response.setText("GAME OVER");
                        response.setForeground(Color.red);
                        startButton.setText("Restart Game");
                        correctWord.setText("Correct Word: " + word.getWord());
                        start(components);                                    
                        for (int i = 0; i < allWords.size(); i++){
                            allWords.remove(0);
                        }
                    }   
                }      
                else{
                    getResponse(components, "You already guessed this word.", 0);
                }
            }
        });
                                
// HINT
        hintButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (game.getHint() > 0){
                    hintResponse.setText("First letter: " + word.getWord().substring(0, 1));
                    game.decrHint();
                    hintCounter.setText("Hints: " + game.getHint() + "  ");
                    getResponse(components, " ", 0);
                
                    panel.remove(hintButton);
                    frame.pack();
                    panel.setVisible(true);
                    panel.revalidate();
                    panel.repaint();
                } else {
                    hintResponse.setText("You don't have any hints left!");
                    getResponse(components, " ", 0);
                
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
        } else {
            return false;
        }
    }
    
    
}
