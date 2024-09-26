import java.util.Random;

public class Task {
    String id;

    public Task(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void execute() {
        try {
            // generating a number between 1000 and 15000
            long execDuration = 100 + (long) (new Random().nextFloat() * (1500 - 100));
            Thread.sleep(execDuration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
