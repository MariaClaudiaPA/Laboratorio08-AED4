package ejercicio2;
import exceptions.*;

public class Test {
    public static void main(String[] args) {
        AVLTree<Integer> avl1 = new AVLTree<>();
        AVLTree<Integer> avl2 = new AVLTree<>();
        
        try {
            avl1.insert(10);
            avl1.insert(5);
            avl1.insert(11);
            avl1.insert(3);
            avl1.insert(8);
 
            avl1.remove(11);
            avl1.remove(8);

            avl2.insert(45);
            avl2.insert(35);
            avl2.insert(75);
            avl2.insert(25);
            avl2.insert(55);
            avl2.insert(65);
            avl2.insert(85);

            avl2.remove(35);

            System.out.println("¡rbol AVL 1:");
            System.out.println(avl1.toString());

            System.out.println("\n¡rbol AVL 2:");
            System.out.println(avl2.toString());
        } catch (ItemDuplicated e) {
            System.out.println("Error al insertar o eliminar un elemento: " + e.getMessage());
        }
    }
}
