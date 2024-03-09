import com.sun.source.tree.Tree;

import javax.swing.tree.TreeNode;

public class InorderPostorder {
    static int index = 0;
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        index = postorder.length-1;
        return constructNode(postorder, inorder, 0, inorder.length-1);
    }

    public static TreeNode constructNode(int[] postorder, int[] inorder, int start, int end) {
        if (start > end) return null;
        if ( start == end) return new TreeNode(inorder[start]);
        int x = search(inorder, postorder[index--]);
        if (x == -1) return null;
        TreeNode root = new TreeNode(inorder[x]);
        root.left = constructNode(postorder, inorder, start, x-1);
        root.right = constructNode(postorder, inorder, x+1, end);
        return root;
    }

    public static int search(int[] arr, int element) {
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] postorder = {2,1,4,3};
        int[] inorder = {1,2,3,4};
        TreeNode root = buildTree(inorder, postorder);
        printTree(root);
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val+" ");
        printTree(root.right);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


