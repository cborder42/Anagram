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
        hint = 5;
    }

    public int getLength(){
        return length;
    }
    
    public void incrLength(){
        length++;
    }
    
    public void decrLength(){
        length-= 4;
    }
    
    public int getLives(){
        return lives;
    }
    
    public void decrLives(){
        lives--;
    }
    
    public int getLevel(){
        return level;
    }
    
    public void incrLevel(){
        level++;
    }
    
    public int getScore(){
        return score;
    }

    public void incrScore(int input){
        score+=input;
    }
    
    public int getHint(){
        return hint;
    }
    
    public void decrHint(){
        hint--;
    }
    
    public void reset(){
        score = 0;
        level = 1;
        lives = 5;
        length = 3;
        hint = 5;
    }

}
