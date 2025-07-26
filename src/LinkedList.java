package src;

public class LinkedList<T> {
    private Node<T> inicio;
    private int size;

    public LinkedList() {
        inicio = null;
        size = 0;
    }

    public void add(T value) {
        Node<T> novoNo = new Node<>(value);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            Node<T> atual = inicio;
            while (atual.getNext() != null) {
                atual = atual.getNext();
            }
            atual.setNext(novoNo);
        }
        size++;
    }

    public void insert(int index, T value) throws MsgException {
        if (index < 0 || index > size) {
            throw new MsgException("Índice inválido");
        }

        if (index == 0) {
            Node<T> novoNo = new Node<>(value);
            novoNo.setNext(inicio);
            inicio = novoNo;
        } else {
            Node<T> anterior = obterNo(index - 1);
            Node<T> novoNo = new Node<>(value);
            novoNo.setNext(anterior.getNext());
            anterior.setNext(novoNo);
        }
        size++;
    }

    public void remove(int index) throws MsgException  {
        if (index < 0 || index >= size) {
            throw new MsgException("Índice inválido");
        }

        if (index == 0) {
            inicio = inicio.getNext();
        } else {
            Node<T> anterior = obterNo(index - 1);
            anterior.setNext(anterior.getNext().getNext());
        }
        size--;
    }

    public T obter(int index) throws MsgException {
        return obterNo(index).getValue();
    }

    private Node<T> obterNo(int index) throws MsgException {
        if (index < 0 || index >= size) {
            throw new MsgException("Índice inválido");
        }
        if (size == 0) { 
            throw new MsgException("Lista vazia");
        }

        Node<T> atual = inicio;
        for (int i = 0; i < index; i++) {
            if (atual == null) {
                throw new MsgException("Lista inconsistente.");
            }
            atual = atual.getNext();
        }
        return atual;
    }

    public int getSize() {
        return size;
    }

    public boolean estaVazia() {
        return size == 0;
    }
    
    public void clear() {
        inicio = null;
        size = 0;
    }
}