package ejercicio3;

import exceptions.*;

public class Test {

    public static void main(String[] args) throws ItemNoFound {
        try {
            AVLTree<Integer> avlTree = new AVLTree<>();

            avlTree.insert(39);
            avlTree.insert(27);
            avlTree.insert(50);
            avlTree.insert(18);
            avlTree.insert(35);
            avlTree.insert(46);
            avlTree.insert(87);
            avlTree.insert(7);
            avlTree.insert(24);

            System.out.println("In-Order");
            System.out.println(avlTree);

            System.out.println("Amplitud de AVL Tree:");
            avlTree.amplitudRecorrido();
        } catch (ExceptionIsEmpty | ItemDuplicated e) {
            System.out.println("Error" + e.getMessage());
        }
    }
}
