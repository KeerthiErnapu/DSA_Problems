import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int Burn(TreeNode root, AtomicInteger time, int start) {
        if (root == null) {
            return 0;
        }
        if (root.val == start) {
            return -1;  // Mark the starting node
        }

        int left = Burn(root.left, time, start);
        int right = Burn(root.right, time, start);

        if (left < 0) {
            time.set(Math.max(time.get(), Math.abs(left) + right));
            return left - 1;
        }
        if (right < 0) {
            time.set(Math.max(time.get(), Math.abs(right) + left));
            return right - 1;
        }
        return 1 + Math.max(left, right);
    }

    public static TreeNode find(TreeNode root, int start){
        if (root == null) {
            return null;
        }
        if (root.val == start) {
            return root;
        }
        TreeNode left = find(root.left, start);
        if (left != null) return left;
        return find(root.right, start);
    }

    public static int height(TreeNode temp){
        if (temp == null) {
            return 0;
        }
        return 1 + Math.max(height(temp.left), height(temp.right));
    }

    public int amountOfTime(TreeNode root, int start) {
        AtomicInteger time = new AtomicInteger(0);
        Burn(root, time, start);
        
        // Find the target node
        TreeNode temp = find(root, start);
        
        // Calculate the height of the target node's subtree
        int h = height(temp) - 1;

        return Math.max(time.get(), h);  // Return the maximum time calculated
    }
}
