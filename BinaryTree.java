import java.io.Serializable;
import java.util.Scanner;

/**
 * BinaryTree.java:
 *
 * @param <E> data type of the tree.
 */
public class BinaryTree<E> implements Serializable {
    protected Node<E> root;

    /**
     * Default constructor
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * Constructor, assigns the node to the root of the tree.
     *
     * @param root node being assigned to the root.
     */
    public BinaryTree(Node<E> root) {
        this.root = root;
    }

    /**
     * Tree constructor, builds a tree by adding two existing trees root node to the
     * left and right nodes of a new root node. The root node is created from the data passed
     * to method.
     *
     * @param data to be assigned to the root node.
     * @param leftTree tree being added to left side of the tree.
     * @param rightTree tree being added to the right side of the tree.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
        root = new Node<>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    /**
     * Returns the subtree to the left of the root. Returns null if the tree is empty
     * or there is no left subtree.
     *
     * @return the left subtree of the root node.
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<>(root.left);
        } else {
            return null;
        }
    }

    /**
     * Returns the subtree to the right of the root. Returns null if the tree is empty
     * or there is no right subtree.
     *
     * @return the right subtree if the root node.
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<>(root.right);
        } else {
            return null;
        }
    }

    /**
     * Checks to see if the current node is a leaf.
     *
     * @return boolean if the node is a leaf.
     */
    public boolean isLeaf() {
        return root == null || (root.left == null && root.right == null);
    }

    /**
     * Returns the roots node data value.
     *
     * @return data of root node.
     */
    public E getData() {
        if (root != null) {
            return root.data;
        } else {
            return null;
        }
    }

    /**
     * Returns a representation of the tree where each subtree is indented by the number of its depth.
     * Calls preOrderTraverse to recursively traverse the tree.
     *
     * @return String representation of the tree.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, 1, sb);
        return sb.toString();
    }

    /**
     * Recursively traverse the tree and adds to the string.
     *
     * @param node current node in the tree.
     * @param depth depth of the node in the tree.
     * @param sb String representation of the tree.
     */
    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
        for (int i = 1; i < depth; i++) {
            sb.append("  ");
        }
        if (node == null) {
            sb.append("null\n");
        } else {
            sb.append(node.data).append("\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }

    /**
     * Reconstructs the tree created by the toString method. Returns a new binary tree
     * constructed by the tree constructor.
     *
     * @param scan scanner used to read a file.
     * @return BinaryTree constructed from the read file.
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan) {
        String data = scan.nextLine().trim();
        if (data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<>(data, leftTree, rightTree);
        }
    }

    /**
     * Tree node represents data in a binary tree.
     * @param <E> data type of the binary tree.
     */
    protected static class Node<E> implements Serializable {
        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        public Node(E data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}