package src;

public class GerenciadorDeListas {
    private LinkedList<ListaDeTarefas> listas;

    public GerenciadorDeListas() {
        listas = new LinkedList<>();
    }

    public void adicionarLista(ListaDeTarefas lista) {
        listas.add(lista);
    }

    public void removerLista(int index) throws MsgException {
        listas.remove(index);
    }

    public void removerListasConcluidas() throws MsgException {
        LinkedList<ListaDeTarefas> novasListas = new LinkedList<>();
        for (int i = 0; i < listas.getSize(); i++) {
            ListaDeTarefas lista = listas.obter(i);
            if (!lista.todasTarefasConcluidas()) {
                novasListas.add(lista);
            }
        }
        listas = novasListas;
    }

    public ListaDeTarefas obterLista(int index) throws MsgException {
        return listas.obter(index);
    }

    public int quantidadeListas() {
        return listas.getSize();
    }

    public void exibirListas() throws MsgException {
        if (listas.getSize() == 0) {
            IO.println("Nenhuma lista foi criada!");
            return;
        }
        
        for (int i = 0; i < listas.getSize(); i++) {
            ListaDeTarefas lista = listas.obter(i);
            IO.println(i + " - " + lista.getTitulo() + " (" + lista.qntdTarefasPendentes() + " pendentes)");
        }
    }      
}
