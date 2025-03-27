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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();
        List<Integer> ans=new ArrayList<>();
        while(root1!=null){
            st1.push(root1);
            root1=root1.left;
        }
        while(root2!=null){
            st2.push(root2);
            root2=root2.left;
        }
        while(!st1.isEmpty() && !st2.isEmpty()){
            if(st1.peek().val>st2.peek().val){
                ans.add(st2.peek().val);
                root2=st2.peek().right;
                st2.pop();
                
            }
            else if(st1.peek().val<st2.peek().val){
                  ans.add(st1.peek().val);
                root1=st1.peek().right;
                
                st1.pop();
              
            }
            else{
                ans.add(st1.peek().val);
                ans.add(st2.peek().val);
                root1=st1.pop().right;
                root2=st2.pop().right;
                
            }
        
            while(root1!=null){
                st1.push(root1);
                root1=root1.left;
            }
            while(root2!=null){
                st2.push(root2);
                root2=root2.left;
            }
        }
        while(!st1.isEmpty()){
            ans.add(st1.peek().val);
            root1=st1.pop().right;
            while(root1!=null){
                st1.push(root1);
                root1=root1.left;
            }
        }
        while(!st2.isEmpty()){
            ans.add(st2.peek().val);
            root2=st2.pop().right;
            while(root2!=null){
                st2.push(root2);
                root2=root2.left;
            }
        }
        return ans;
    }
}
