#height based on no.of nodes
class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        if (node == null)
            return 0;
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

# height based on no.of edges
class Solution {
    // Function to find the height of a binary tree.
    int height(Node node) {
        if (node == null)
            return -1;
        
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
}


  
