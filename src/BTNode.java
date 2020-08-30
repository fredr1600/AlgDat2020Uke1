public class BTNode {

    public static class Node{
        Node parent;
        Node left_child;
        Node right_child;
        char value;

        public Node(char value){
            this.value = value;
        }

        Node grandParent(){
            return this.parent.parent;
        }
    }

    public static void main(String[] args) {

        char [] a = {'a', 'b', 'c', 'd', 'f', 'g'};

        Node root = new Node(a[0]);
        root.left_child = new Node(a[1]);
        root.right_child = new Node(a[2]);

        root.left_child = new Node(a[3]);
        root.right_child = new Node(a[4]);

        root.left_child = new Node(a[5]);
        root.right_child = new Node(a[6]);


    }
}
