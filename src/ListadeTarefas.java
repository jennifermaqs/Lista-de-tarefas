package src;

public class ListaDeTarefas {
    private String titulo;
    private LinkedList<Tarefa> tarefas;

    public ListaDeTarefas(String titulo) {
        this.titulo = titulo;
        this.tarefas = new LinkedList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void addTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    public void removerTarefa(int index) throws MsgException {
        tarefas.remove(index);
    }

    public void marcarTarefaConcluida(int index) throws MsgException {
        Tarefa tarefa = tarefas.obter(index);
        tarefa.marcar();
    }

    public void desmarcarTarefaConcluida(int index) throws MsgException {
        Tarefa tarefa = tarefas.obter(index);
        tarefa.desmarcar();
    }

    public void removerTarefasConcluidas() throws MsgException {
        LinkedList<Tarefa> novasTarefas = new LinkedList<>();
        for (int i = 0; i < tarefas.getSize(); i++) {
            Tarefa tarefa = tarefas.obter(i);
            if (!tarefa.isConcluida()) {
                novasTarefas.add(tarefa);
            }
        }
        tarefas = novasTarefas;
    }

    public void exibirTarefas() throws MsgException {
     //TODO
    }

    public int qntdTarefasPendentes() throws MsgException {
        int count = 0;
        for (int i = 0; i < tarefas.getSize(); i++) {
            if (!tarefas.obter(i).isConcluida()) {
                count++;
            }
        }
        return count;
    }

    public boolean todasTarefasConcluidas() throws MsgException {
        for (int i = 0; i < tarefas.getSize(); i++) {
            if (!tarefas.obter(i).isConcluida()) {
                return false;
            }
        }
        return true;
    }

    public int getTotalTarefas() {
        return tarefas.getSize();
    }

}













