package Assignments.Assignment5;

/**
 * TreeNode class to represent a node in a binary tree
 * 
 * @author Youssef Ali Ahmed
 */
public class TreeNode<T> {
    private T data;
    private TreeNode<T> left, right;

    /**
     * Default constructor
     */
    public TreeNode() {

    }

    /**
     * Default constructor
     * 
     * @param data
     */
    public TreeNode(T data) {
        this.data = data;
    }

    /**
     * Constructor with left and right children
     * 
     * @param data
     * @param l
     * @param r
     */
    public TreeNode(T data, TreeNode<T> l, TreeNode<T> r) {
        this(data);
        left = l;
        right = r;
    }

    /**
     * Copy constructor
     * 
     * @param node
     */
    public TreeNode(TreeNode<T> node) {
        this(node.getData());
        left = node.getLeft();
        right = node.getRight();
    }

    /**
     * Get the data of the node
     * 
     * @return data
     */
    public T getData() {
        return data;
    }

    /**
     * Get the left child of the node
     * 
     * @return left node
     */
    public TreeNode<T> getLeft() {
        return left;
    }

    /**
     * Get the right child of the node
     * 
     * @return right node
     */
    public TreeNode<T> getRight() {
        return right;
    }

    /**
     * Set the left child of the node
     * 
     * @param r to set
     */
    public void setRight(TreeNode<T> r) {
        right = r;
    }

    /**
     * Set the right child of the node
     * 
     * @param l to set
     */
    public void setLeft(TreeNode<T> l) {
        left = l;
    }

    /**
     * Set the data of the node
     * 
     * @param d to set
     */
    public void setData(T d) {
        data = d;
    }
}
