package scenario1;

import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.lang.InterruptedException;
import java.time.LocalDateTime;

public class Node implements Runnable {
  private BlockingQueue<Task> taskQueue;
  private BlockingQueue<Task> executadas;
  // lista executadas

  public Node(BlockingQueue<Task> taskQueue, BlockingQueue<Task> executadas) {
    this.taskQueue = taskQueue;
    this.executadas = executadas;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Task task = taskQueue.take();
        task.setInicioExecucao(LocalDateTime.now());
        task.execute();
        task.setFimExecuxao(LocalDateTime.now());
        this.executadas.add(task);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
