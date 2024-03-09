import org.w3c.dom.Node;

public class LargestBST {
   public static class Node {
          int val;
          Node left;
          Node right;
       Node() {}
       Node(int val) { this.val = val; }
       Node(int val, Node left, Node right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
     
    class NodeValue {
        int min;
        int max;
        int size;
        boolean isBST;
        NodeValue() {
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;
            isBST = true;
            size = 0;
        }
    }

   
        public int largestBSTSubtree(Node root) {
            return largestBSTSubtreeHelper(root).size;
        }

        public NodeValue largestBSTSubtreeHelper(Node root) {
            if (root == null) {
                return new NodeValue();
            }
            NodeValue left = largestBSTSubtreeHelper(root.left);
            NodeValue right = largestBSTSubtreeHelper(root.right);

            NodeValue result = new NodeValue();
            if (left.max > root.val || right.min <= root.val || !left.isBST || !right.isBST) {
                result.size = Math.max(left.size, right.size);
                result.isBST = false;
                return result;
            }
            result.min = root.left != null ? left.min:root.val;
            result.max = root.right != null ? right.max:root.val;
            result.size = left.size + right.size+1;
            result.isBST = true;
            return result;
        }


    public static void main(String args[]){
        LargestBST lbi = new LargestBST();
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(8);
        root.right = new Node(15);
        root.right.left = new Node(7);

        int largestBSTSize = lbi.largestBSTSubtree(root);
        System.out.println("Size of largest BST  is " + largestBSTSize);
        assert largestBSTSize == 8;
    }
    
}
