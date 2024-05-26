package avltreeActividades;
import exceptions.*;

public class Test {
    public static void main(String[] args) throws ItemDuplicated, ItemNoFound {

        // Caso 1
        AVLTree<Integer> avlTree1 = new AVLTree<>();
        avlTree1.insert(50);
        avlTree1.insert(60);
        avlTree1.insert(55);// Provoca RDI
        avlTree1.insert(57);
        avlTree1.insert(58); // Provoca RDD 
        System.out.println("Caso 1: RDI - RDD");
        System.out.println(avlTree1.toString());
        System.out.println();

        // Caso 2: 
        AVLTree<Integer> avlTree2 = new AVLTree<>();
        avlTree2.insert(50);
        avlTree2.insert(40);
        avlTree2.insert(45); // Provoca RDD
        avlTree2.insert(42);
        avlTree2.insert(41); // Provoca RDI
        System.out.println("Caso 2: RDD - RDI");
        System.out.println(avlTree2.toString());
        System.out.println();

        // Caso 3: 
        AVLTree<Integer> avlTree3 = new AVLTree<>();
        avlTree3.insert(10);
        avlTree3.insert(20);
        avlTree3.insert(30);// Provoca RSI
        avlTree3.insert(5);
        avlTree3.insert(1); // Provoca RSD
        System.out.println("Caso 3: RSI - RSD ");
        System.out.println(avlTree3.toString());
        System.out.println();

        // Caso 4: 
        AVLTree<Integer> avlTree4 = new AVLTree<>();
        avlTree4.insert(15);
        avlTree4.insert(12);
        avlTree4.insert(7); // Provoca RSD
        avlTree4.insert(13);
        avlTree4.insert(14); // Provoca RDD
        System.out.println("Caso 4: RSD - RDD ");
        System.out.println(avlTree4.toString());
        System.out.println();

        // Caso 5: 
        AVLTree<Integer> avlTree5 = new AVLTree<>();
        avlTree5.insert(50);
        avlTree5.insert(60);
        avlTree5.insert(70); // Provoca RSI
        avlTree5.insert(53);
        avlTree5.insert(58); // Provoca RSI
        System.out.println("Caso 5: RSI - RSI");
        System.out.println(avlTree5.toString());
        System.out.println();

        // Caso 6: 
        AVLTree<Integer> avlTree6 = new AVLTree<>();
        avlTree6.insert(90);
        avlTree6.insert(80);
        avlTree6.insert(60); // Provoca RSD
        avlTree6.insert(45);
        avlTree6.insert(55); // Provoca RDD
        System.out.println("Caso 6: RSD y RDD");
        System.out.println(avlTree6.toString());
        System.out.println();

        // Caso 7:
        AVLTree<Integer> avlTree7 = new AVLTree<>();
        avlTree7.insert(1);
        avlTree7.insert(12);
        avlTree7.insert(22); // Provoca RSI
        avlTree7.insert(26);
        avlTree7.insert(24); // Provoca RDI
        System.out.println("Caso 7: RSI - RDI");
        System.out.println(avlTree7.toString());
        System.out.println();

        // Caso 8: 
        AVLTree<Integer> avlTree8 = new AVLTree<>();
        avlTree8.insert(50);
        avlTree8.insert(40);
        avlTree8.insert(30); // Provoca RSD
        avlTree8.insert(35);
        avlTree8.insert(37); // Provoca RSI
        System.out.println("Caso 8: RSD - RSI");
        System.out.println(avlTree8.toString());
        System.out.println();
    }
}
