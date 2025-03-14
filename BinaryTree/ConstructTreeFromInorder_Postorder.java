/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int find(int[] inorder, int ele, int start, int end) {
        for (int i = start; i <= end; i++) { // Fixed loop range
            if (inorder[i] == ele) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode tree(int[] inorder, int[] postorder, int start, int end, int inIndex) {
        if (start > end) {
            return null;
        }

        // Root is always the last element in the current postorder index
        TreeNode root = new TreeNode(postorder[inIndex]);
        
        // Find position of root in inorder array
        int pos = find(inorder, postorder[inIndex], start, end);
        
        // Recursively build right and left subtrees (order is important in postorder)
        root.right = tree(inorder, postorder, pos + 1, end, inIndex - 1);
        root.left = tree(inorder, postorder, start, pos - 1, inIndex - (end - pos) - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        return tree(inorder, postorder, 0, n - 1, n - 1);
    }
}
