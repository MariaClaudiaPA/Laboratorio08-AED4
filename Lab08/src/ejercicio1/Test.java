package ejercicio1;
import exceptions.*;

public class Test {
    public static void main(String[] args) {
        
        try {
            BSTree<Integer> bst = new BSTree<>(); //Arbol BST
            long inicioBSTinsert = System.currentTimeMillis();
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);
            long finBSTinsert = System.currentTimeMillis();

            System.out.println("BSTree:");
            System.out.println("Tiempo de inserci�n en BST: " + (finBSTinsert - inicioBSTinsert) + " ms");
            long inicioBSTheight = System.currentTimeMillis();
            System.out.println("Altura del �rbol BST: " + bst.height());
            long finBSTheight = System.currentTimeMillis();
            System.out.println("Tiempo de c�lculo de altura en BST: " + (finBSTheight - inicioBSTheight) + " ms");
            System.out.println("N�mero de nodos en el �rbol BST: " + bst.countNodes());
            long inicioBSTsearch = System.currentTimeMillis();
            System.out.println("Resultado de b�squeda en BST: " + bst.search(40)); 
            long finBSTsearch = System.currentTimeMillis();
            System.out.println("Tiempo de b�squeda en BST: " + (finBSTsearch - inicioBSTsearch) + " ms");
            System.out.println();

            AVLTree<Integer> avl = new AVLTree<>(); //Arbol AVL
            long inicioAVLinsert = System.currentTimeMillis();
            avl.insert(50);
            avl.insert(30);
            avl.insert(70);
            avl.insert(20);
            avl.insert(40);
            avl.insert(60);
            avl.insert(80);
            long finAVLinsert = System.currentTimeMillis();

            System.out.println("\nAVLTree:");
            System.out.println("Tiempo de inserci�n en AVL: " + (finAVLinsert - inicioAVLinsert) + " ms");
            long inicioAVLheight = System.currentTimeMillis();
            System.out.println("Altura del �rbol AVL: " + avl.height());
            long finAVLheight = System.currentTimeMillis();
            System.out.println("Tiempo de c�lculo de altura en AVL: " + (finAVLheight - inicioAVLheight) + " ms");
            System.out.println("N�mero de nodos en el �rbol AVL: " + avl.countNodes());

            long inicioAVLsearch = System.currentTimeMillis();
            System.out.println("Resultado de b�squeda en AVL: " + avl.search(40)); // Prueba de b�squeda en AVL
            long finAVLsearch = System.currentTimeMillis();
            System.out.println("Tiempo de b�squeda en AVL: " + (finAVLsearch - inicioAVLsearch) + " ms");

        } catch (ItemDuplicated | ItemNoFound e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
