package ejercicio3;
import exceptions.*;

public class QueueLink<E> implements Queue<E> {

    private Node<E> first;
    private Node<E> last;

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    @Override
    public void enqueue(E x) {
        Node<E> aux = new Node<>(x);
        if (isEmpty()) {
            this.first = aux;
        } else {
            this.last.setNext(aux);
        }
        this.last = aux;
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Vacio");
        } else {
            E ele = first.getDate();
            first = first.getNext();
            return ele;
        }

    }

    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Vacio");
        } else {
            return last.getDate();
        }
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Vacio");
        } else {
            return first.getDate();
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cola:  ");
        Node<E> current = this.first;
        while (current != null) {
            sb.append(current.getDate()).append(" ");
            current = current.getNext();
        }
        return sb.toString();
    }
}
