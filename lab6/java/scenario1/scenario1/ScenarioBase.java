
package scenario1;

import java.util.concurrent.*;

import scenario1.*;

public class ScenarioBase {
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public static void main(String[] args) {
        System.out.println("Scenario Base of Lab06 Initializing!");

        BlockingQueue<Task> taskQueue = new LinkedBlockingQueue<>();
        BlockingQueue<Task> taskExecuteds = new LinkedBlockingQueue<>();

        ExecutorService executorProdutorService = Executors.newFixedThreadPool(5);

        ExecutorService executorNodeService = Executors.newFixedThreadPool(3);

        ExecutorService executorExecutedService = Executors.newFixedThreadPool(1);

        for (int i =0; i < 5; i++) {
            executorProdutorService.execute(new TaskProducer(taskQueue, i));
        }

        for (int i = 0; i < 3; i ++) {
            executorNodeService.execute(new Node(taskQueue, taskExecuteds));
        }

        executorExecutedService.execute((new printExecuteds(taskExecuteds, 5)));
    }
}
