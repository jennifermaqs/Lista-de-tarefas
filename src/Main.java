package src;

public class Main {
    private static GerenciadorDeListas gerenciador = new GerenciadorDeListas();

    public static void main(String[] args) {
        while (true) {
            try {
                menu();
            } catch (MsgException e) {
                IO.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                IO.println("Erro inesperado: " + e.getMessage());
            }
        }
    }

    private static void menu() throws MsgException {
        IO.println("\n|=================================|");
        IO.println("|===========  TO - DO  ===========|");
        IO.println("|.................................|");
        IO.println("|....1. Criar nova lista..........|");
        IO.println("|....2. Ver listas existentes.....|");
        IO.println("|....3. Acessar lista.............|");
        IO.println("|....4. Remover lista.............|");
        IO.println("|....5. Remover listas concluídas.|");
        IO.println("|....0. Sair......................|");
        IO.println("|.................................|");
        IO.println("|=================================|");
        IO.print("\nEscolha: ");

        int opcao = IO.inputInt();
        switch (opcao) {
            case 1:
                criarLista();
                break;
            case 2:
                listarListas();
                break;
            case 3:
                acessarLista();
                break;
            case 4:
                removerLista();
                break;
            case 5:
                removerListasConcluidas();
                break;
            case 0:
                IO.println("Saindo do sistema...");
                 IO.closeScanner();
                System.exit(0);
            default:
                IO.println("Opção inválida!");
        }
    }

    private static void criarLista() {
        IO.print("Digite o título da lista: ");
        String titulo = IO.input();
        ListaDeTarefas novaLista = new ListaDeTarefas(titulo);
        gerenciador.adicionarLista(novaLista);
        IO.println("\nLista criada com sucesso!");
    }

    private static void listarListas() throws MsgException {
        IO.println("\n=== LISTAS DISPONÍVEIS ===");
        gerenciador.exibirListas();
    }

    private static void acessarLista() throws MsgException {
        if (gerenciador.quantidadeListas() == 0) {
            IO.println("Nenhuma lista disponível!");
            return;
        }

        gerenciador.exibirListas();
        IO.print("\nDigite o índice da lista: ");
        int index = IO.inputInt();
        
        if (index < 0 || index >= gerenciador.quantidadeListas()) {
            throw new MsgException("Índice inválido!");
        }

        ListaDeTarefas lista = gerenciador.getLista(index);
        menuLista(lista);
    }

    private static void menuLista(ListaDeTarefas lista) throws MsgException {
        while (true) {
            lista.exibirTarefas();
            IO.println("\n|=================================|");
            IO.println("|========  MENU DA LISTA =========|");
            IO.println("|.................................|");
            IO.println("|....1. Adicionar tarefa..........|");
            IO.println("|....2. Marcar como concluída.....|");
            IO.println("|....3. Desmarcar como concluída..|");
            IO.println("|....4. Remover tarefa............|");
            IO.println("|....5. Remover tarefas concluídas|");
            IO.println("|....0. voltar....................|");
            IO.println("|.................................|");
            IO.println("|=================================|");
            IO.print("\nEscolha: ");

            int opcao = IO.inputInt();
            switch (opcao) {
                case 1:
                    adicionarTarefa(lista);
                    break;
                case 2:
                    marcarConcluida(lista);
                    break;
                case 3:
                    desmarcarConcluida(lista);
                    break;
                case 4:
                    removerTarefa(lista);
                    break;
                case 5:
                    removerConcluidas(lista);
                    break;
                case 0:
                    return;
                default:
                    IO.println("Opção inválida!");
            }
        }
    }

    private static void adicionarTarefa(ListaDeTarefas lista) {
        IO.print("Descrição da tarefa: ");
        String descricao = IO.input();
        Tarefa novaTarefa = new Tarefa(descricao, false);
        lista.addTarefa(novaTarefa);
        IO.println("\nTarefa adicionada!");
    }

    private static void marcarConcluida(ListaDeTarefas lista) throws MsgException {
        if (lista.getTotalTarefas() == 0) {
            IO.println("\nLista vazia!");
            return;
        }
        
        IO.print("Índice da tarefa: ");
        int index = IO.inputInt();
        lista.marcarTarefaConcluida(index);
        IO.println("\nTarefa marcada como concluída!");
    }

    private static void desmarcarConcluida(ListaDeTarefas lista) throws MsgException {
        if (lista.getTotalTarefas() == 0) {
            IO.println("Lista vazia!");
            return;
        }
        
        IO.print("Índice da tarefa: ");
        int index = IO.inputInt();
        lista.desmarcarTarefaConcluida(index);
        IO.println("\nTarefa desmarcada!");
    }

    private static void removerTarefa(ListaDeTarefas lista) throws MsgException {
        if (lista.getTotalTarefas() == 0) {
            IO.println("\nLista vazia!");
            return;
        }
        
        IO.print("Índice da tarefa: ");
        int index = IO.inputInt();
        lista.removerTarefa(index);
        IO.println("\nTarefa removida!");
    }

    private static void removerConcluidas(ListaDeTarefas lista) throws MsgException {
        lista.removerTarefasConcluidas();
        IO.println("\nTarefas concluídas removidas!");
    }

    private static void removerLista() throws MsgException {
        if (gerenciador.quantidadeListas() == 0) {
            IO.println("\nNenhuma lista disponível!");
            return;
        }
        
        gerenciador.exibirListas();
        IO.print("Índice da lista: ");
        int index = IO.inputInt();
        gerenciador.removerLista(index);
        IO.println("\nLista removida!");
    }

    private static void removerListasConcluidas() throws MsgException {
        gerenciador.removerListasConcluidas();
        IO.println("\nListas concluídas removidas!");
    }
}