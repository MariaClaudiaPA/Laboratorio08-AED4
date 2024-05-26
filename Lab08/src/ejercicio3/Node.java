package ejercicio3;

public class Node<T>{
	private T date;
	private Node<T> next;
	
	public Node(T date) {
		this.date = date;
		this.next = null;
	}

	public T getDate() {
		return date;
	}

	public void setDate(T date) {
		this.date = date;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
}
