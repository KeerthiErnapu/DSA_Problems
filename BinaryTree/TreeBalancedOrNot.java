import java.util.concurrent.atomic.AtomicBoolean;

class Solution {
    public int height(TreeNode root, AtomicBoolean valid) {
        if (root == null) {
            return 0;
        }

        int l = height(root.left, valid);
        int r = height(root.right, valid);

        if (Math.abs(l - r) > 1) {
            valid.set(false);
        }

        return 1 + Math.max(l, r);
    }

    public boolean isBalanced(TreeNode root) {
        AtomicBoolean valid = new AtomicBoolean(true);
        height(root, valid);
        return valid.get();
    }
}
