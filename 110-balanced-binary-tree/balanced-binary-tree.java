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
// class Solution {
//     public int maxDepth(TreeNode root) {
//         if(root==null)
//         return 0;

//         return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
//     }
//     public boolean isBalanced(TreeNode root) {
//         if(root==null)
//         return true;

//         int left= maxDepth(root.left);
//         int right= maxDepth(root.right);
//         if(Math.abs(left-right)>1)
//         return false;

//         boolean lefty=isBalanced(root.left);
//         boolean righty=isBalanced(root.right);

//         if(lefty==false|| righty==false)
//         return false;
        
        
//         return true;

        
//     }
class Solution {
    public boolean isBalanced(TreeNode root) {
    int ans=check(root);
    return ans==-1?false:true; 
    }
    public int check(TreeNode root)
    {
        if(root==null)
        return 0;

        int left=check(root.left);
        int right=check(root.right);

        if(Math.abs((left)-(right))>1)
        return -1; 

        if(left==-1||right==-1)
        return -1;
        else
        return 1+Math.max(left,right);
    }
}