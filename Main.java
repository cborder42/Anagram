import javax.swing.border.EmptyBorder;

import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.CENTER;
import static java.awt.Image.SCALE_SMOOTH;

public class Main {

public static void main(String[] args){
    // Game n1 = new Game();
    Main.GUI();
}
public static void GUI(){
        //Main Frame Initializer
        JFrame frame = new JFrame("One Word Anagram");
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
        Font hint = new Font("Sans Serif", Font.PLAIN, 20);
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
        JLabel hintCounter = new JLabel("Hints: " + game.getHint() + "  ");
        JLabel scoreCounter = new JLabel("Score: " + game.getScore() + "  ");
        hintCounter.setBorder(new EmptyBorder(0, 50, 0, 50));
        levelCounter.setFont(counters);
        hintCounter.setFont(counters);
        scoreCounter.setFont(counters);
        
        //Section 2 (JTextField)
        JTextField textField = new JTextField();
        textField.setForeground(Color.LIGHT_GRAY);
        textField.setFont(hint);
        // textField.setSize(50, 20);

        //Section 3(JButtons)
        JButton hintButton = new JButton("Hint");
        ImageIcon guessIcon = new ImageIcon("./guessbutton.png");
        
        // hintButton.setBackground(Color.green);
        JButton enterGuessButton = new JButton(guessIcon);
        enterGuessButton.setOpaque(true);
        enterGuessButton.setBorderPainted(false);
        // enterGuessButton.setSize(50,20);
        
        // Labels
        JLabel wrongResponse = new JLabel(" ");
        JLabel correctResponse = new JLabel("Correct!");
        JLabel hintResponse = new JLabel(" ");
        correctResponse.setForeground(Color.green);
        wrongResponse.setForeground(Color.red);
        wrongResponse.setFont(hint);
        correctResponse.setFont(hint);
        hintResponse.setFont(hint);

        //Layout Manager
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
            .addComponent(title)
            .addGroup(layout.createSequentialGroup()
                .addComponent(levelCounter)
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
                        if (checkWord(word.getWord(), guess)){
                            game.incrLevel();
                            levelCounter.setText("Level: " + game.getLevel() + "  ");
                            layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                .addComponent(title)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(levelCounter)
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
                            frame.pack();
                            panel.setVisible(true);
                            panel.revalidate();
                            panel.repaint();
                        
                            game.incrLength();
                            word.update(game.getLength());
                            scrambled.setText(Word.spaceOut(word.getScrambledWord()));
                        }
                        else {
                            wrongResponse.setText("Incorrect");
                            layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                .addComponent(title)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(levelCounter)
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
                        if (checkWord(word.getWord(), guess)){
                            game.incrLevel();
                            levelCounter.setText("Level: " + game.getLevel() + "  ");
                            layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                .addComponent(title)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(levelCounter)
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
                            frame.pack();
                            panel.setVisible(true);
                            panel.revalidate();
                            panel.repaint();
                        
                            game.incrLength();
                            word.update(game.getLength());
                            scrambled.setText(Word.spaceOut(word.getScrambledWord()));
                        }
                        else {
                            wrongResponse.setText("Incorrect");
                            layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                                .addComponent(title)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(levelCounter)
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
        }});
// HINT
        hintButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (game.getHint() > 0){
                    hintResponse.setText("First letter of the word: " + word.getWord().substring(0, 1));
                    game.decrHint();
                    hintCounter.setText("Hints " + game.getHint() + "  ");
                    layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                        .addComponent(title)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(levelCounter)
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
