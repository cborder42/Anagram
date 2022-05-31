import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import static javax.swing.GroupLayout.Alignment.CENTER;

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
        Font fontTitle = new Font("Sans Serif", Font.BOLD, 37);
        Font fontUnscramble = new Font("Sans Serif", Font.BOLD, 37);
        Font enterGuess = new Font("Sans Serif", Font.PLAIN, 24);
        Font hint = new Font("Sans Serif", Font.PLAIN, 20);
        
        //Section 1 (JLabel)
        JLabel title = new JLabel("One Word Anagram");
        title.setFont(fontTitle);
        JLabel instruction = new JLabel("Enter guess:");
        instruction.setFont(enterGuess);
        JLabel levelCounter = new JLabel("Level: ");
        JLabel hintCounter = new JLabel("Hint: ");
        JLabel scoreCounter = new JLabel("Score: ");
        
        
        
        //Section 2 (JTextField)
        JTextField textField = new JTextField();
        textField.setForeground(Color.LIGHT_GRAY);
        textField.setFont(enterGuess);

        //Section 3(JButtons)
        JButton hintButton = new JButton("Hint");
        hintButton.setBackground(Color.green);
        JButton enterGuessButton = new JButton("Enter");
        enterGuessButton.setBackground(Color.green);


        Game game = new Game();
        Word word = new Word(game.getLength());
        JLabel scrambled = new JLabel(Word.spaceOut(word.getScrambledWord()));
        // String currentWord = Word.getWord(3);
        // scrambled.setText(Word.listToString(Word.scramble(currentWord)));
        scrambled.setFont(fontUnscramble);

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
                .addComponent(textField, 0, 200, GroupLayout.PREFERRED_SIZE))
            .addComponent(enterGuessButton)
            .addComponent(hintButton));
                    
                    
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(title)
            .addGroup(layout.createParallelGroup(CENTER)
                .addComponent(levelCounter)
                .addComponent(hintCounter)
                .addComponent(scoreCounter))
            .addComponent(scrambled)
            .addGroup(layout.createParallelGroup(CENTER)
                .addComponent(textField, 0, 25, GroupLayout.PREFERRED_SIZE))
            .addComponent(enterGuessButton)
            .addComponent(hintButton));   

        textField.setForeground(Color.black);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel wrongResponse = new JLabel("Incorrect");
        JLabel correctResponse = new JLabel("Correct!");
        correctResponse.setForeground(Color.green);
        wrongResponse.setForeground(Color.red);

        //Method to check when the ENTER Key is Pressed
        textField.addActionListener(new ActionListener(){ 
            public void actionPerformed(ActionEvent e){
                String guess = textField.getText();
                layout.setAutoCreateGaps(true);
                layout.setAutoCreateContainerGaps(true); 
                    if(checkWord(word.getWord(), guess)){
                        layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                            .addComponent(title)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(levelCounter)
                                .addComponent(hintCounter)
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField, 0, 200, GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(textField, 0, 25, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(correctResponse)
                            .addComponent(hintButton));
                        
                        //UPDATING LOGIC
                        panel.remove(wrongResponse);
                        frame.pack();
                        panel.setVisible(true);
                        panel.revalidate();
                        panel.repaint();
                        
                        game.incrLength();
                        word.update(game.getLength());
                        scrambled.setText(Word.spaceOut(word.getScrambledWord()));
                }
                else {
                    layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                            .addComponent(title)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(levelCounter)
                                .addComponent(hintCounter)  
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField, 0, 200, GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(textField, 0, 25, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(wrongResponse)
                            .addComponent(hintButton));

                        panel.remove(correctResponse);
                        frame.pack();
                        panel.setVisible(true);
                        panel.revalidate();
                        panel.repaint();

                }   
            }});

        enterGuessButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String guess = textField.getText();
                layout.setAutoCreateGaps(true);
                layout.setAutoCreateContainerGaps(true); 
                    if(checkWord(word.getWord(), guess)){
                        layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                            .addComponent(title)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(levelCounter)
                                .addComponent(hintCounter)
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField, 0, 200, GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(textField, 0, 25, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(correctResponse)
                            .addComponent(hintButton));
                        
                        //UPDATING LOGIC
                        panel.remove(wrongResponse);
                        frame.pack();
                        panel.setVisible(true);
                        panel.revalidate();
                        panel.repaint();
                        
                        game.incrLength();
                        word.update(game.getLength());
                        scrambled.setText(Word.spaceOut(word.getScrambledWord()));
                }
                else {
                    layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                            .addComponent(title)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(levelCounter)
                                .addComponent(hintCounter)  
                                .addComponent(scoreCounter))
                            .addComponent(scrambled)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textField, 0, 200, GroupLayout.PREFERRED_SIZE))
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
                                .addComponent(textField, 0, 25, GroupLayout.PREFERRED_SIZE))
                            .addComponent(enterGuessButton)
                            .addComponent(wrongResponse)
                            .addComponent(hintButton));

                        panel.remove(correctResponse);
                        frame.pack();
                        panel.setVisible(true);
                        panel.revalidate();
                        panel.repaint();
                }
        }});

    hintButton.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
            System.out.println("It Works");
            }});
    }

public static boolean checkWord(String word, String guess) {
    if (word.equals(guess)) {
        return true;
    } 
    else {
        return false;
    }

}
}