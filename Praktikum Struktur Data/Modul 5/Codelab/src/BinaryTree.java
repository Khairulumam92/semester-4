
public class BinaryTree {

    public Node root;

    public BinaryTree() {
        root = null;
    }

    public void addRoot(int data) {
        root = new Node(data);
    }

    // Traversal preorder (root, left, right)
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Traversal inorder (left, root, right)
    public void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    // Traversal postorder (left, right, root)
    public void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.addRoot(73);
        tree.root.left = new Node(14);
        tree.root.right = new Node(91);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(62);
        tree.root.right.left = new Node(28);

        System.out.println("Preorder traversal:");
        tree.preOrder(tree.root);

        System.out.println("\nInorder traversal:");
        tree.inOrder(tree.root);

        System.out.println("\nPostorder traversal:");
        tree.postOrder(tree.root);
    }

}
