package scenario1;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Random;

public class Task {
    String id;
    LocalDateTime criacao;
    LocalDateTime inicioExecucao;
    LocalDateTime fimExecuxao;

    public Task(String id) {
        this.id = id;
        this.criacao = LocalDateTime.now();
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

    public LocalDateTime getCriacao() {
        return criacao;
    }

    public LocalDateTime getFimExecuxao() {
        return fimExecuxao;
    }

    public LocalDateTime getInicioExecucao() {
        return inicioExecucao;
    }

    public void setInicioExecucao(LocalDateTime inicioExecucao) {
        this.inicioExecucao = inicioExecucao;
    }

    public void setFimExecuxao(LocalDateTime fimExecuxao) {
        this.fimExecuxao = fimExecuxao;
    }

    public long tempoAtiva() {
        Duration duracao = Duration.between(criacao, fimExecuxao);
        return duracao.toMillis();
    }

    public long tempoExecucao() {
        Duration duracao = Duration.between(inicioExecucao, fimExecuxao);
        return duracao.toMillis();
    }
}
