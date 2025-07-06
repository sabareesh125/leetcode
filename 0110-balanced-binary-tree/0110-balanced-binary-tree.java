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
   private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    // Function to check if a binary tree is height-balanced
    public boolean isBalanced(TreeNode root) {
        return checkHeightAndBalance(root) != -1;
    }
    
    // Helper function to check height balance and return height (-1 if unbalanced)
    private int checkHeightAndBalance(TreeNode node) {
        if (node == null) {
            return 0; // Height of an empty tree is 0
        }
        
        // Recursively check the height and balance of left subtree
        int leftHeight = checkHeightAndBalance(node.left);
        if (leftHeight == -1) {
            return -1; // Left subtree is unbalanced
        }
        
        // Recursively check the height and balance of right subtree
        int rightHeight = checkHeightAndBalance(node.right);
        if (rightHeight == -1) {
            return -1; // Right subtree is unbalanced
        }
        
        // Check if the current node is balanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // Current subtree is unbalanced
        }
        
        // Return the height of the current node's subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }
}