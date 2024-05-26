package lab08;

public interface LinkBST<E> {
	void insert(E x) throws ItemDuplicated;
	void remove(E x) throws ItemNoFound;
	E search(E x) throws ItemNoFound;
	boolean isEmpty();
}
