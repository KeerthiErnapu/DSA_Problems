class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // Find the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Case 1: Node with no child (leaf node)
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2: Node with one child
            else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3: Node with two children
            else {
                // Find the in-order predecessor (rightmost node in left subtree)
                TreeNode pred = root.left;
                while (pred.right != null) {
                    pred = pred.right;
                }
                // Replace root's value with predecessor's value
                root.val = pred.val;
                // Delete the predecessor node recursively
                root.left = deleteNode(root.left, pred.val);
            }
        }
        return root;
    }
}
