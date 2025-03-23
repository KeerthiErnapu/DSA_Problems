#using the method range from INTMIN to INTMAX 
import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public TreeNode bst(int[] preorder, AtomicInteger index, int lower, int upper) {
        if (index.get() == preorder.length || preorder[index.get()] < lower || preorder[index.get()] > upper) {
            return null;
        }

        int val = preorder[index.getAndIncrement()];
        TreeNode root = new TreeNode(val);
        root.left = bst(preorder, index, lower, val);
        root.right = bst(preorder, index, val, upper);
        
        return root;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        AtomicInteger index = new AtomicInteger(0);
        return bst(preorder, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
