public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30); // Triggers left rotate

        tree.insert(5);
        tree.insert(4); // Triggers right rotate

        // Triggers left-right rotate
        tree.insert(8);

        // Triggers right-left rotate
        tree.insert(25);

        // Print traversals
        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();

        // verification


        // inorder : 4 - 5 - 8 - 10 - 20 - 25 - 30
        // preorder : 10 - 5 - 4 - 8 - 25 - 20 - 30
        // postorder : 4 - 8 - 5 - 20 - 30 - 25 - 10
        System.out.println("Root: " + tree.root.key);
    }
}
