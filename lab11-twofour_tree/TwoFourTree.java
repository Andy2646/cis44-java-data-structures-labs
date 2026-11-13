import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Simplified node structure
class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    // Check if node is full (3 keys)
    public boolean isFull() {
        return keys.size() == 3;
    }

    // Find correct child to descend for a given key
    public TwoFourNode getNextChild(int key) {
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    // Insert a key into this node (assume node not full)
    public void insertKey(int key) {
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // 1. Descend to the leaf node
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        // 2. Insert key in leaf
        node.insertKey(key);

        // 3. Handle overflow by splitting
        while (node != null && node.keys.size() > 3) {
            if (node == root) {
                root = new TwoFourNode();
                root.children.add(node);
                node.parent = root;
            }

            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        // TODO: Implement split logic
        // 1. Create a new right node
        TwoFourNode u = node.parent;

        // 2. Promote middle key to parent
        int midKey = node.keys.remove(2);

        // 3. Move keys and children appropriately
        TwoFourNode v_double_Prime = new TwoFourNode();
        v_double_Prime.parent = u;
        v_double_Prime.keys.add(node.keys.remove(2));

        if (!node.isLeaf()) {
            v_double_Prime.children.add(node.children.remove(3));
            v_double_Prime.children.add(node.children.remove(3));

            v_double_Prime.children.get(0).parent = v_double_Prime;
            v_double_Prime.children.get(1).parent = v_double_Prime;
        }
        // 4. Update parent pointers
        int i = 0;
        while (i < u.keys.size() && Integer.compare(midKey, u.keys.get(i)) > 0) {
            i++;
        }
        u.keys.add(i, midKey);
        u.children.add(i + 1, v_double_Prime);

        System.out.println("Splitting node with keys: " + node.keys);
    }

    // Inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) {
                    inorder(node.children.get(i));
                }
                System.out.print(node.keys.get(i) + " ");
            }
            if (i < node.children.size()) {
                inorder(node.children.get(i));
            }
        }
    }
}