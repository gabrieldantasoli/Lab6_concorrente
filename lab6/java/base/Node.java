import java.util.concurrent.*;

import scenario1.Task;

import java.util.Random;
import java.lang.InterruptedException;

public class Node implements Runnable {
  private BlockingQueue<Task> taskQueue;
  private int num;
  // lista executadas

  public Node(BlockingQueue<Task> taskQueue, int num) {
    this.taskQueue = taskQueue;
    this.num = num;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Task task = taskQueue.take();
        System.out.println("Node " + Thread.currentThread().getName() + " is executing task " + task.getId());
        task.execute();
        System.out.println("Task " + task.getId() + " completed by Node " + Thread.currentThread().getName());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
