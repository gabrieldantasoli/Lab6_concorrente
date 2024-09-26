package scenario1;

import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.lang.InterruptedException;

public class printExecuteds implements Runnable {
  private BlockingQueue<Task> executadas;
  private int n;
  // lista executadas

  public printExecuteds(BlockingQueue<Task> executadas, int n) {
    this.executadas = executadas;
    this.n = n;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Map<String, List<Task>> groupedTask = new HashMap<>();

        for (Task task : executadas) {
            groupedTask.computeIfAbsent(task.getId().split("-")[0], k -> new ArrayList<>()).add(task);
        }
    
        System.out.println("Tempo de execução está em MiliSegundos");
        System.out.println("=============");
        for (Map.Entry<String, List<Task>> entry : groupedTask.entrySet()) {
            System.out.println("Producer: " + entry.getKey());

            for (Task task : entry.getValue()) {
                System.out.println("ID: " + task.getId() + ", Tempo Ativa: " + task.tempoAtiva() + ", Tempo Ativa no sistema: " + task.tempoExecucao());
            }
        }
        System.out.println("=============");

        Thread.sleep(5000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

