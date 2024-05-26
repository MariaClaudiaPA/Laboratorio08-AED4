package lab08;

public class Test {

	    public static void main(String[] args) throws ItemDuplicated, ItemNoFound{
	        AVLTree<Integer> avlTree = new AVLTree<>();

	        // Caso de Prueba 1: Rotación Simple a la Derecha (RSR)
	        System.out.println("Caso de Prueba 1: RSR");
	        avlTree.insert(10);
	        avlTree.insert(20);
	        avlTree.insert(30);
	        System.out.println(avlTree.toString());
	        System.out.println();

	        // Caso de Prueba 2: Rotación Simple a la Izquierda (RSL)
	        System.out.println("Caso de Prueba 2: RSL");
	        avlTree = new AVLTree<>();
	        avlTree.insert(30);
	        avlTree.insert(20);
	        avlTree.insert(10);
	        System.out.println(avlTree.toString());
	        System.out.println();

	        // Caso de Prueba 3: Rotación Doble a la Derecha (RDR)
	        System.out.println("Caso de Prueba 3: RDR");
	        avlTree = new AVLTree<>();
	        avlTree.insert(10);
	        avlTree.insert(30);
	        avlTree.insert(20);
	        System.out.println(avlTree.toString());
	        System.out.println();

	        // Caso de Prueba 4: Rotación Doble a la Izquierda (RDL)
	        System.out.println("Caso de Prueba 4: RDL");
	        avlTree = new AVLTree<>();
	        avlTree.insert(30);
	        avlTree.insert(10);
	        avlTree.insert(20);
	        System.out.println(avlTree.toString());
	        System.out.println();

	        // Caso de Prueba 5: RSR y RSL
	        System.out.println("Caso de Prueba 5: RSR y RSL");
	        avlTree = new AVLTree<>();
	        avlTree.insert(10);
	        avlTree.insert(20);
	        avlTree.insert(30);
	        avlTree.insert(40);
	        avlTree.insert(50);
	        System.out.println(avlTree.toString());
	        System.out.println();

	        // Caso de Prueba 6: RDR y RDL
	        System.out.println("Caso de Prueba 6: RDR y RDL");
	        avlTree = new AVLTree<>();
	        avlTree.insert(50);
	        avlTree.insert(30);
	        avlTree.insert(40);
	        avlTree.insert(20);
	        avlTree.insert(10);
	        System.out.println(avlTree.toString());
	        System.out.println();

	        // Caso de Prueba 7: RSR y RDL
	        System.out.println("Caso de Prueba 7: RSR y RDL");
	        avlTree = new AVLTree<>();
	        avlTree.insert(10);
	        avlTree.insert(20);
	        avlTree.insert(30);
	        avlTree.insert(15);
	        avlTree.insert(12);
	        System.out.println(avlTree.toString());
	        System.out.println();

	        // Caso de Prueba 8: RDR y RSL
	        System.out.println("Caso de Prueba 8: RDR y RSL");
	        avlTree = new AVLTree<>();
	        avlTree.insert(30);
	        avlTree.insert(10);
	        avlTree.insert(20);
	        avlTree.insert(25);
	        avlTree.insert(27);
	        System.out.println(avlTree.toString());
	        
	     // Creación de los árboles BST y AVL
	        BSTree<Integer> bstTree1 = new BSTree<>();
	        AVLTree<Integer> avlTree1 = new AVLTree<>();

	        // Inserción de 1000 elementos
	        for (int i = 0; i < 50; i++) {
	            bstTree1.insert(i);
	            avlTree1.insert(i);
	        }

	        // Búsqueda de un elemento
	        int elementToSearch = 35;

	        // Medición del tiempo de búsqueda en el árbol BST
	        long startTimeBST = System.nanoTime();
	        bstTree1.search(elementToSearch);
	        long endTimeBST = System.nanoTime();
	        long durationBST = endTimeBST - startTimeBST;
	        System.out.println("Tiempo de búsqueda en árbol BST: " + durationBST + " ns");

	        // Medición del tiempo de búsqueda en el árbol AVL
	        long startTimeAVL2 = System.nanoTime();
	        avlTree1.search(elementToSearch);
	        long endTimeAVL2 = System.nanoTime();
	        long durationAVL2 = endTimeAVL2 - startTimeAVL2;
	        System.out.println("Tiempo de búsqueda en árbol AVL: " + durationAVL2 + " ns");
	        
	     // Creación de los árboles BST y AVL
	        BSTree<Integer> bstTree2 = new BSTree<>();
	        AVLTree<Integer> avlTree2 = new AVLTree<>();

	        // Inserción de 1000 elementos
	        for (int i = 0; i < 50; i++) {
	            bstTree2.insert(i);
	            avlTree2.insert(i);
	        }

	        // Cálculo de la altura
	        long startTimeBST1 = System.nanoTime();
	        int heightBST1 = bstTree2.height();
	        long endTimeBST1 = System.nanoTime();
	        long durationBST1 = endTimeBST1 - startTimeBST1;
	        System.out.println("Altura del árbol BST: " + heightBST1);
	        System.out.println("Tiempo de cálculo de altura en árbol BST: " + durationBST1 + " ns");

	        long startTimeAVL3 = System.nanoTime();
	        int heightAVL3 = avlTree2.height();
	        long endTimeAVL3 = System.nanoTime();
	        long durationAVL3 = endTimeAVL3 - startTimeAVL3;
	        System.out.println("Altura del árbol AVL: " + heightAVL3);
	        System.out.println("Tiempo de cálculo de altura en árbol AVL: " + durationAVL3 + " ns");
	    }
}
