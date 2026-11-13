class AVLNode {
    int key, height;
    AVLNode left, right;

    // Constructor
    AVLNode(int key) {
        this.key = key;
        this.height = 1; // A new node (leaf) always has a height of 1
    }
}

public class AVLTree {

    AVLNode root;

    // returns height of node. 0 if a node does not exist
    int height(AVLNode N) {
        return (N == null) ? 0 : N.height;
    }

    // returns the maximum integer from two integers
    int max(int a, int b) {
        return Math.max(a, b);
    }

    // get balance by the height property
    int getBalance(AVLNode N) {
        return (N == null) ? 0 : (height(N.left) - height(N.right));
    }

    // Right rotation
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right; // Subtree between x and y

        // Perform rotation (make x the new root)
        x.right = y;
        y.left = T2;

        // Update heights (y is lower so its updated first, then x)
        y.height = 1 + max(height(y.left), height(y.right));
        x.height = 1 + max(height(x.left), height(x.right));

        return x;
    }

    // Left rotation
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left; // Subtree between x and y

        // Perform rotation (make y the new root)
        y.left = x;
        x.right = T2;

        // Update heights (x is lower so its updated first, then y)
        x.height = 1 + max(height(x.left), height(x.right));
        y.height = 1 + max(height(y.left), height(y.right));

        return y;
    }

    // Left-Right rotation
    AVLNode leftRightRotate(AVLNode z) {
        z.left = leftRotate(z.left); // Right rotation on the child
        return rightRotate(z);  // Left rotation on the unbalanced node
    }

    // Right-Left rotation
    AVLNode rightLeftRotate(AVLNode y) {
        y.right = rightRotate(y.right); // Left rotation on the child
        return leftRotate(y);  // Right rotation on the unbalanced node
    }

    // Public insert method
    public void insert(int key) {
        root = insert(root, key);
    }

    // Recursive insertion with rebalancing
    private AVLNode insert(AVLNode node, int key) {
        // BST Insertion (Base Case)
        if (node == null) return new AVLNode(key);

        int cmp = Integer.compare(key, node.key);
        if (cmp < 0)
            node.left = insert(node.left, key);
        else if (cmp > 0)
            node.right = insert(node.right, key);
        else
            return node;

        // Update Height of the current node
        node.height = 1 + max(height(node.left), height(node.right));

        // Get balance factor
        int balance = getBalance(node);

        // LL Rotation - Single Right Rotation
        if (balance > 1 && Integer.compare(key, node.left.key) < 0)
            return rightRotate(node);
        // RR Rotation - Single Left Rotation
        if (balance < -1 && Integer.compare(key, node.right.key) > 0)
            return leftRotate(node);
        // LR Rotation
        if (balance > 1 && Integer.compare(key, node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // RL Rotation
        if (balance < -1 && Integer.compare(key, node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node; // Return the unchanged or newly balanced node
    }

    // Traversal methods
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.key);
            inorder(node.right);
        }
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(AVLNode node) {
        if (node != null) {
            System.out.println(node.key);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(AVLNode node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.key);
        }
    }
}