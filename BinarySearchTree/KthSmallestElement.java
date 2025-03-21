import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public void inorder(TreeNode root, AtomicInteger k, AtomicInteger ans){
        if(root == null) return;
        
        inorder(root.left, k, ans);
        
        if(k.decrementAndGet() == 0) {  // Decrement k and check if it is zero
            ans.set(root.val);
            return;
        }
        
        inorder(root.right, k, ans);
    }

    public int kthSmallest(TreeNode root, int k) {
        AtomicInteger ans = new AtomicInteger(0);
        AtomicInteger kWrapper = new AtomicInteger(k); // Wrap k in AtomicInteger
        inorder(root, kWrapper, ans);
        return ans.get();
    }
}
