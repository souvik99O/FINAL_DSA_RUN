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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
        return false;
        boolean ans=checkSym(root.left,root.right);

        return ans;

        
    }
    public boolean checkSym(TreeNode left, TreeNode right)
    {
        if(left==null && right==null)
        return true;

        if(left==null && right!=null)
        {
            return false;
        }
        if(left!=null && right==null)
        {
            return false;
        }
        if(left.val !=right.val)
        {
            return false;
        }


        boolean l=checkSym(left.left,right.right);
        boolean r=checkSym(left.right,right.left);

        if(l==true && r==true)
        {
            return true;
        }
        return false;
    }
}