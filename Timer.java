import java.util.*;
import java.util.concurrent.TimeUnit;

public class Timer{
    //https://stackoverflow.com/questions/10820033/make-a-simple-timer-in-java

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        int x = 0;
        while(x < 61){
            try {
                TimeUnit.SECONDS.sleep(1);
                x++;
                long elapsedTime = System.currentTimeMillis() - startTime;
                long elapsedSeconds = elapsedTime / 1000;
                long secondsDisplay = elapsedSeconds % 60;
                long minutesDisplay = elapsedSeconds / 60;
                String time = minutesDisplay + ":" + secondsDisplay;
                if (time.length() != 4){
                    System.out.println(minutesDisplay + ":0" + secondsDisplay);
                }
                else{
                    System.out.println(time);
                }

            } 
            catch(InterruptedException e) {
                System.out.println("Got Interrupted!");
            
            
            }

            }
    }
}