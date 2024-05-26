package ejercicio1;

public class StackLink<E> {
    private class Node {
        E data;
        Node next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    public StackLink() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(E item) {
        Node newNode = new Node(item);
        newNode.next = top;
        top = newNode;
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Stack is empty");
        }
        E item = top.data;
        top = top.next;
        return item;
    }

    public E peek() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Stack is empty");
        }
        return top.data;
    }
}

