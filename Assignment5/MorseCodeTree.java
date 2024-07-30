package Assignments.Assignment5;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

import org.junit.platform.engine.support.hierarchical.Node;

import Assignments.Assignment5.TreeNode;
import Assignments.Assignment5.Interfaces.LinkedConverterTreeInterface;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
    private TreeNode<String> root = new TreeNode<>("");

    public MorseCodeTree() {
        buildTree();
    }

    /**
     * Returns a reference to the root
     * 
     * @return reference to root
     */
    public TreeNode<String> getRoot() {
        return root;
    }

    /**
     * sets the root of the Tree
     * 
     * @param newNode a TreeNode<String> that will be the new root
     */
    public void setRoot(TreeNode<String> newNode) {
        root = new TreeNode<>(newNode);
    }

    /**
     * Adds result to the correct position in the tree based on the code This method will call the recursive method addNode
     * 
     * @param code the code for the new node to be added
     */

    public void insert(String code, String result) {
        addNode(root, code, result);
    }

    /**
     * This is a recursive method that adds element to the correct position in the tree based on the code.
     * 
     * @param root   the root of the tree for this particular recursive instance of addNode
     * @param code   the code for this particular recursive instance of addNode
     * @param letter the data of the new TreeNode to be added
     */
    public void addNode(TreeNode<String> root, String code, String letter) {
        if (code.length() == 1) {
            if (code.charAt(0) == '.') {
                root.getLeft().setData(letter);
            } else {
                root.getRight().setData(letter);
            }
        } else {
            if (code.charAt(0) == '.') {
                addNode(root.getLeft(), code.substring(1, code.length()), letter);
            } else {
                addNode(root.getRight(), code.substring(1, code.length()), letter);
            }
        }
    }

    /**
     * Fetch the data in the tree based on the code This method will call the recursive method fetchNode
     * 
     * @param code the code that describes the traversals within the tree
     * @return the result that corresponds to the code
     */
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    /**
     * This is the recursive method that fetches the data of the TreeNode that corresponds with the code
     * 
     * @param root the root of the tree for this particular recursive instance of addNode
     * @param code the code for this particular recursive instance of fetchNode
     * @return the data corresponding to the code
     */
    public String fetchNode(TreeNode<String> root, String code) {
        if (code.length() == 1) {
            if (code.charAt(0) == '.') {
                return root.getLeft().getData();
            } else {
                return root.getRight().getData();
            }
        } else if (code.charAt(0) == '.') {
            return fetchNode(root.getLeft(), code.substring(1));
        } else if (code.charAt(0) == '-') {
            return fetchNode(root.getRight(), code.substring(1));
        }
        return "";
    }

    /**
     * This operation is not supported for a LinkedConverterTree
     * 
     * @param data data of node to be deleted
     * @return reference to the current tree
     * @throws UnsupportedOperationException
     */
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * This operation is not supported for a LinkedConverterTree
     * 
     * @return reference to the current tree
     * @throws UnsupportedOperationException
     */
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    /**
     * This method builds the LinkedConverterTree by inserting letter in it's appropriate position based on morse code.
     */
    public void buildTree() {
        HashMap<String, String> alpha = makeAlphabet();
        buildEmptyTree(4, root);

        for (Map.Entry<String, String> entry : alpha.entrySet()) {
            insert(entry.getValue(), entry.getKey());
        }
    }

    /**
     * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order Used for testing to
     * make sure tree is built correctly
     * 
     * @return an ArrayList of the items in the linked Tree
     */
    public ArrayList<String> toArrayList() {
        ArrayList<String> arr = new ArrayList<>();
        LNRoutputTraversal(root, arr);
        return arr;
    }

    /**
     * The recursive method to put the contents of the linked converter tree in an ArrayList<String> LNR (Inorder)
     * 
     * @param root the root of the tree for this particular recursive instance
     * @param list the ArrayList that will hold the contents of the tree in LNR order
     */
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root != null) {
            LNRoutputTraversal(root.getLeft(), list);
            list.add(root.getData());
            LNRoutputTraversal(root.getRight(), list);
        }
    }

    /**
     * Builds a complete tree based on the height set.
     * 
     * @param height
     * @param root
     */
    public void buildEmptyTree(int height, TreeNode<String> root) {
        if (height == 0) {
            return;
        }
        root.setLeft(new TreeNode<>());
        root.setRight(new TreeNode<>());
        buildEmptyTree(height - 1, root.getLeft());
        buildEmptyTree(height - 1, root.getRight());
    }

    /**
     * Returns a map of morse code to alphabet
     * 
     * @return HashMap<String, String> key is morse code, value is letter
     */
    public HashMap<String, String> makeAlphabet() {
        HashMap<String, String> alpha = new HashMap<>();
        alpha.put("a", ".-");
        alpha.put("b", "-...");
        alpha.put("c", "-.-.");
        alpha.put("d", "-..");
        alpha.put("e", ".");
        alpha.put("f", "..-.");
        alpha.put("g", "--.");
        alpha.put("h", "....");
        alpha.put("i", "..");
        alpha.put("j", ".---");
        alpha.put("k", "-.-");
        alpha.put("l", ".-..");
        alpha.put("m", "--");
        alpha.put("n", "-.");
        alpha.put("o", "---");
        alpha.put("p", ".--.");
        alpha.put("q", "--.-");
        alpha.put("r", ".-.");
        alpha.put("s", "...");
        alpha.put("t", "-");
        alpha.put("u", "..-");
        alpha.put("v", "...-");
        alpha.put("w", ".--");
        alpha.put("x", "-..-");
        alpha.put("y", "-.--");
        alpha.put("z", "--..");
        return alpha;
    }

}
