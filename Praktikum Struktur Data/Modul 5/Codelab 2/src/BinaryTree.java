
public class BinaryTree {

    public Node root;

    public void NewNode(int data) {
        root = NewNode(root, new Node(data));
    }

    private Node NewNode(Node root, Node newData) {
        if (root == null) {
            return newData;
        }

        if (newData.data < root.data) {
            root.left = NewNode(root.left, newData);
        } else {
            root.right = NewNode(root.right, newData);
        }
        return root;
    }

    public void InOrder(Node node) {
        if (node != null) {
            InOrder(node.left);
            System.out.print(node.data + " ");
            InOrder(node.right);
        }
    }

    public void PreOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            PreOrder(node.left);
            PreOrder(node.right);
        }
    }

    public void PostOrder(Node node) {
        if (node != null) {
            PostOrder(node.left);
            PostOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        int[] values = {50, 30, 70, 20, 40, 60, 80, 35, 65};
        for (int value : values) {
            tree.NewNode(value);
        }

        System.out.println("==== Binary Search Tree ====");
        System.out.println("\nPre Order :");
        tree.PreOrder(tree.root);

        System.out.println("\nIn Order :");
        tree.InOrder(tree.root);

        System.out.println("\nPost Order :");
        tree.PostOrder(tree.root);
    }

}
