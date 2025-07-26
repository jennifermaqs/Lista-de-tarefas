package src;

public class Tarefa {
    private String texto;
    private boolean concluida;

    public Tarefa(String texto, boolean concluida) {
        this.texto = texto;
        this.concluida = concluida;
    }

    public String getTexto() {
        return texto;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void marcar() {
        this.concluida = true;
    }

    public void desmarcar() {
        this.concluida = false;
    }

    @Override
    public String toString() {
        return (concluida ? "[X] " : "[ ] ") + texto;
    }
}