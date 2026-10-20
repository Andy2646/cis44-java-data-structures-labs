import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    String name; // Employee name or department title
    GeneralTreeNode parent;
    List children;

    public GeneralTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    // Method to add a child to this node
    public void addChild(GeneralTreeNode child) {
        child.parent = this;
        this.children.add(child);
    }

    /**
     * Performs a preorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit Parent, then visit children)
     */
    public void traversePreorder() {
        // 1. Print this node's name
        System.out.println(this.name + " ");
        // 2. Recursively call traversePreorder on each child
        for (Object child : this.children) {
            GeneralTreeNode node = (GeneralTreeNode) child;
            node.traversePreorder();
        }
    }

    /**
     * Performs a postorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit children, then visit Parent)
     */
    public void traversePostorder() {
        // 1. Recursively call traversePostorder on each child
        for (Object child : this.children) {
            GeneralTreeNode node = (GeneralTreeNode) child;
            node.traversePostorder();
        }
        // 2. Print this node's name
        System.out.println(this.name + " ");
    }
}
