public class HuffmanDecoding {
    void decode(String s, Node root) {
        Node node = root;
        for (char c : s.toCharArray()){
            if (c == '0'){
                node = node.left;
            }else if (c == '1') {
                node = node.right;
            }
            
            if (node.data != 0){
                System.out.print(node.data);
                node = root;
            }
        }
    }
}