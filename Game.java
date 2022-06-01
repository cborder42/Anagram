public class Game{
    private int score;
    private int level;
    private int lives;
    private int length;
    private int hint;
    
    public Game() {
        score = 0;
        level = 1;
        lives = 5;
        length = 3;
        hint = 3;
    }

    public int getLength() {
        return length;
    }
    
    public void incrLength() {
        length++;
    }
    
    public void incrLevel() {
        level++;
    }

    public void incrScore() {
        score+=500;
    }
    
    public int getHint(){
        return hint;
    }
    
    public void decrHint(){
        hint--;
    }

}
