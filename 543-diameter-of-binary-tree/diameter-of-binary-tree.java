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
    int max= 0;
    public int diameterOfBinaryTree(TreeNode root) {
       diam(root);
       return max;
    }


    public int diam(TreeNode root)
    {
           if(root==null)
            return 0;
        

        int left=diam(root.left);
        int right=diam(root.right);
        max=Math.max(max,left+right);
        return 1+Math.max(left,right);
    }
}