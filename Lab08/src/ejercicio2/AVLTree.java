package ejercicio2;
import exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AVLTree<E extends Comparable<E>> extends BSTree<E> {

    class NodeAVL extends Node {

        protected int bf;  // balance factor

        public NodeAVL(E data) {
            super(data);
            this.bf = 0;
        }

        public NodeAVL(E data, Node left, Node right) {
            super(data, left, right);
            this.bf = 0;
        }

        @Override
        public String toString() {
            return data.toString() + " (bf: " + bf + ")";
        }
    }

    private boolean height;

    @Override
    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        this.root = insert(x, (NodeAVL) this.root);
    }

    protected NodeAVL insert(E x, NodeAVL node) throws ItemDuplicated {
        NodeAVL fat = node;
        if (node == null) {
            this.height = true;
            fat = new NodeAVL(x);
        } else {
            int resC = node.data.compareTo(x);
            if (resC == 0) {
                throw new ItemDuplicated(x + " ya se encuentra en el arbol...");
            }
            if (resC < 0) {
                fat.right = insert(x, (NodeAVL) node.right);
                if (this.height) {
                    switch (fat.bf) {
                        case -1:
                            fat.bf = 0;
                            this.height = false;
                            break;
                        case 0:
                            fat.bf = 1;
                            this.height = true;
                            break;
                        case 1: // bf = 2
                            fat = balanceToLeft(fat);
                            this.height = false;
                            break;
                    }
                }
            } else {
                fat.left = insert(x, (NodeAVL) node.left);
                if (this.height) {
                    switch (fat.bf) {
                        case 1:
                            fat.bf = 0;
                            this.height = false;
                            break;
                        case 0:
                            fat.bf = -1;
                            this.height = true;
                            break;
                        case -1: // bf = -2
                            fat = balanceToRight(fat);
                            this.height = false;
                            break;
                    }
                }
            }
        }
        return fat;
    }

    private NodeAVL balanceToLeft(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.right;
        switch (hijo.bf) {
            case 1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSL(node);
                break;
            case -1:
                NodeAVL nieto = (NodeAVL) hijo.left;
                switch (nieto.bf) {
                    case -1:
                        node.bf = 0;
                        hijo.bf = 1;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case 1:
                        node.bf = -1;
                        hijo.bf = 0;
                        break;
                }
                nieto.bf = 0;
                node.right = rotateSR(hijo);
                node = rotateSL(node);
        }
        return node;
    }

    private NodeAVL balanceToRight(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.left;
        switch (hijo.bf) {
            case -1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSR(node);
                break;
            case 1:
                NodeAVL nieto = (NodeAVL) hijo.right;
                switch (nieto.bf) {
                    case 1:
                        node.bf = -1;
                        hijo.bf = 0;
                        break;
                    case 0:
                        node.bf = 0;
                        hijo.bf = 0;
                        break;
                    case -1:
                        node.bf = 0;
                        hijo.bf = 1;
                        break;
                }
                nieto.bf = 0;
                node.left = rotateSL(hijo);
                node = rotateSR(node);
        }
        return node;
    }

    private NodeAVL rotateSL(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.right;
        node.right = p.left;
        p.left = node;
        node = p;
        return node;
    }

    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.left;
        node.left = p.right;
        p.right = node;
        node = p;
        return node;
    }

    @Override
    public String toString() {
        List<String> nodeList = new ArrayList<>();
        inOrderTraversal(root, nodeList);
        return Arrays.toString(nodeList.toArray());
    }

    private void inOrderTraversal(BSTree<E>.Node node, List<String> nodeList) {
        if (node == null) {
            return;
        }

        inOrderTraversal(node.left, nodeList);
        nodeList.add(node.toString());
        inOrderTraversal(node.right, nodeList);
    }

    private NodeAVL rotacionSI(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.right;
        node.right = p.left;
        p.left = node;
        node.bf = calcularBF(node);
        p.bf = calcularBF(p);
        return p;
    }

    private NodeAVL rotacionSD(NodeAVL node) {
        NodeAVL p = (NodeAVL) node.left;
        node.left = p.right;
        p.right = node;
        node.bf = calcularBF(node);
        p.bf = calcularBF(p);
        return p;
    }

    @Override
    public void remove(E x) {
        this.root = remove(x, (NodeAVL) this.root);
    }

    protected NodeAVL remove(E x, NodeAVL node) {
        if (node == null) {
            return node;
        }

        if (x.compareTo(node.data) < 0) {
            node.left = remove(x, (NodeAVL) node.left);
        } else if (x.compareTo(node.data) > 0) {
            node.right = remove(x, (NodeAVL) node.right);
        } else {
            if (node.left == null && node.right == null) {
                // Caso 1: Sin hijos
                node = null;
            } else if (node.left == null || node.right == null) {
                // Caso 2: Con un hijo
                NodeAVL temp;
                if (node.left != null) {
                    temp = (NodeAVL) node.left;
                } else {
                    temp = (NodeAVL) node.right;
                }
                node = temp;
            } else {
                // Caso 3: Con dos hijos
                NodeAVL temp = encontrarSucesor((NodeAVL) node.right);
                node.data = temp.data;
                node.right = remove(temp.data, (NodeAVL) node.right);
            }
        }

        if (node == null) {
            return node;
        }
        node.bf = calcularBF(node);

        if (node.bf < -1) {
            if (calcularBF((NodeAVL) node.left) <= 0) {
                return rotacionSD(node);
            } else {
                node.left = rotacionSI((NodeAVL) node.left);
                return rotacionSD(node);
            }
        }

        if (node.bf > 1) {
            if (calcularBF((NodeAVL) node.right) >= 0) {
                return rotacionSI(node);
            } else {
                node.right = rotacionSD((NodeAVL) node.right);
                return rotacionSI(node);
            }
        }
        return node;
    }

    private NodeAVL encontrarSucesor(NodeAVL node) {
        NodeAVL actual = node;
        while (actual.left != null) {
            actual = (NodeAVL) actual.left;
        }
        return actual;
    }

    private int calcularBF(NodeAVL node) {
        if (node == null) {
            return 0;
        }
        return height((NodeAVL) node.right) - height((NodeAVL) node.left);
    }

    private int height(NodeAVL node) {
        if (node == null) {
            return 0;
        }
        return Math.max(height((NodeAVL) node.left), height((NodeAVL) node.right)) + 1;
    }

}
