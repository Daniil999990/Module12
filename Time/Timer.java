package Time;

import java.util.TimerTask;

public class Timer {
    private static int seconds = 0;
    private static final java.util.Timer timer = new java.util.Timer();

    public static void main(String[] args) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seconds++;
                System.out.println("Час, що минув: " + seconds + " секунд");
            }
        }, 0, 1000);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Минуло 5 секунд");
            }
        }, 0, 5000);
    }
}
