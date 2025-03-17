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
 *morris inorder traversal with space complexity O(1)
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<>();
        while(root!=null){
            TreeNode temp=root.left;
            if(temp==null){
                ans.add(root.val);
                root=root.right;
            }
            else{
                while(temp.right!=null && temp.right!=root){
                    temp=temp.right;
                }
                if(temp.right==root){
                    temp.right=null;
                    ans.add(root.val);
                    root=root.right;
                }
                else{
                    temp.right=root;
                    root=root.left;
                }
            }
        }
        return ans;

    }
}
