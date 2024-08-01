import java.io.Serializable;
import java.util.Scanner;

/**
 * BinaryTree.java:
 *
 * @param <E> data type of the tree.
 **
 * @author
 * @version 1.0
 */
public class BinaryTree<E>  {




    /**
     * Default constructor
     */


    /**
     * Constructor, assigns the node to the root of the tree.
     *
     * @param root node being assigned to the root.
     */


    /**
     * Tree constructor, builds a tree by adding two existing trees root node to the
     * left and right nodes of a new root node. The root node is created from the data passed
     * to method.
     *
     * @param data to be assigned to the root node.
     * @param leftTree tree being added to left side of the tree.
     * @param rightTree tree being added to the right side of the tree.
     */


    /**
     * Returns the subtree to the left of the root. Returns null if the tree is empty
     * or there is no left subtree.
     *
     * @return the left subtree of the root node.
     */


    /**
     * Returns the subtree to the right of the root. Returns null if the tree is empty
     * or there is no right subtree.
     *
     * @return the right subtree if the root node.
     */



    /**
     * Checks to see if the current node is a leaf.
     *
     * @return boolean if the node is a leaf.
     */



    /**
     * Returns the roots node data value.
     *
     * @return data of root node.
     */



    /**
     * Returns a representation of the tree where each subtree is indented by the number of its depth.
     * Calls preOrderTraverse to recursively traverse the tree.
     *
     * @return String representation of the tree.
     */


    /**
     * Recursively traverse the tree and adds to the string.
     *
     * @param node current node in the tree.
     * @param depth depth of the node in the tree.
     * @param sb String representation of the tree.
     */


    /**
     * Reconstructs the tree created by the toString method. Returns a new binary tree
     * constructed by the tree constructor.
     *
     * @param scan scanner used to read a file.
     * @return BinaryTree constructed from the read file.
     */






    /**
     * Tree node represents data in a binary tree.
     * @param <E> data type of the binary tree.
     */
//    protected static class Node<E>  {
//
//    }
}
