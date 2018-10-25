/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
    int data;
    Node left;
    Node right;
     }
*/

// First Try
public class IsThisBST {
    boolean checkBST1(Node root) {
        if (root.left != null && root.left.data > root.data){
            if (checkBST(root.left))
            {
                return false;
            }
        }
        if (root.right != null && root.right.data < root.data){
            if (checkBST(root.right)){
                return false;
            }
        }
        return true;
    }

    // Second Try
    boolean checkBST2(Node root) {
        LinkedList<Node> next = new LinkedList<>();
        next.add(root);
        Node node;
        while (!next.isEmpty()){
            node = next.remove();
            if (node.left != null){
                Node left = node.left;
                if (left.data > node.data){
                    return false;
                }
                next.add(left);
            }
            if (node.right != null){
                Node right = node.right;
                if (right.data < node.data){
                    return false;
                }
                next.add(right);
            }
        }
        return true;
    }
}
