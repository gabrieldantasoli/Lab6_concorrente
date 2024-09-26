import java.util.concurrent.*;

import scenario1.Task;
import scenario1.TaskProducer;

public class ScenarioBase {

    public static void main(String[] args) {
        System.out.println("Scenario Base of Lab06 Initializing!");

        BlockingQueue<Task> taskQueue = new LinkedBlockingQueue<>();

        TaskProducer producer1 = new TaskProducer(taskQueue);

        Thread producerThread = new Thread(producer);
    }
}
