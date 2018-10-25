public class LevelOrderTraversal {
    public static void levelOrder(Node root) {
        LinkedList<Node> next = new LinkedList<>();
        next.add(root);
        Node node;
        System.out.print (root.data + " ");
        while (!next.isEmpty()){
            node = next.remove();
            if (node.left != null){
                System.out.print(node.left.data + " ");
                next.add(node.left);
            }
            if (node.right != null){
                System.out.print(node.right.data + " ");
                next.add(node.right);
            }
        }
    }
}