import java.util.concurrent.*;

public class TaskProducer implements Runnable {
    private BlockingQueue<Task> taskQueue;
    private int num;
    private int taskNum;

    public TaskProducer(BlockingQueue<Task> taskQueue, int num) {
        this.taskQueue = taskQueue;
        this.num = num;
        this.taskNum = 0;
    }

    @Override
    public void run() {
        while (true) {
            Task task = new Task("P" + num + "-" + taskNum);
            try {
                taskQueue.put(task);
                Thread.sleep(5000);
                this.taskNum += 1;
                System.out.println("Produced task " + task.getId());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}