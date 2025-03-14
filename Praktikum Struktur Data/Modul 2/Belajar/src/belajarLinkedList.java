class Node {
    int value;
    int link;

    public Node(int value) {
        this.value = value;
        this.link = null;
    }
}

public class belajarLinkedList {
    public static void main(String[] args) {

        Node start = new Node(8);
        Node middle = new Node(12);
        start.link = middle;

        Node end = new Node(20);
        middle.link = end;

        System.out.println("=== Isi LinkedList ===");
        Node pointer = start;
        while (pointer != null) {
            System.out.println(pointer.value);
            pointer = pointer.link;
        }

    }
}
