import java.util.*;
import java.util.concurrent.TimeUnit;

public class Timer{
    //https://stackoverflow.com/questions/10820033/make-a-simple-timer-in-java
    //DON'T TOUCH MY TIMER CLASS @EVERYONE

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis() + 300;
        System.out.println(endTime);
        System.out.println(startTime);
        int x = 0;
        while(x < 5){
            try {
                TimeUnit.SECONDS.sleep(1);
                x++;
                long elapsedTime = System.currentTimeMillis() - startTime;
                long elapsedTime2 = System.currentTimeMillis() - endTime;
                long elapsedSeconds = elapsedTime2 / 1000;
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
                System.out.println("Timer Failed");
            
            }

        }
    }
}