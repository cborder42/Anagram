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
        Font fontTitle = new Font("Sans Serif", Font.BOLD, 50);
        Font fontUnscramble = new Font("Sans Serif", Font.BOLD, 37);
        Font enterGuess = new Font("Sans Serif", Font.BOLD, 24);
        
        //Section 1 (layout Label)
        JLabel label = new JLabel("One Word Anagrams");
        label.setFont(fontTitle);
        
        
        //Section 2 (TextField + Action Listener)
        JTextField textField = new JTextField();
        textField.setFont(enterGuess);

        JLabel instruction = new JLabel("Enter guess:");
        instruction.setFont(enterGuess);

        Game game = new Game();
        Word word = new Word(game.getLength());
        JLabel scrambled = new JLabel(word.getScrambledWord());
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
                        
                        //UPDATING LOGIC
                        panel.remove(wrongResponse);
                        frame.pack();
                        panel.setVisible(true);
                        panel.revalidate();
                        panel.repaint();
                        game.incrLength();
                        word.update(game.getLength());
                        scrambled.setText(word.getScrambledWord());
                }
                else{
                    layout.setHorizontalGroup(layout.createParallelGroup(CENTER)
                            .addComponent(label)
                            .addComponent(scrambled)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(instruction)
                                .addComponent(textField, 0, 200, GroupLayout.PREFERRED_SIZE))
                            .addComponent(wrongResponse));
                    
                        layout.setVerticalGroup(layout.createSequentialGroup()
                            .addComponent(label)
                            .addComponent(scrambled)
                            .addGroup(layout.createParallelGroup(CENTER)
                                .addComponent(instruction)
                                .addComponent(textField, 0, 25, GroupLayout.PREFERRED_SIZE))
                            .addComponent(wrongResponse));

                        panel.remove(correctResponse);
                        frame.pack();
                        panel.setVisible(true);
                        panel.revalidate();
                        panel.repaint();

                }  

                
            }
        });
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