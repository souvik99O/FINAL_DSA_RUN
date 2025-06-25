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
//     public boolean isBalanced(TreeNode root) {

//         if(root==null)
//         {
//             return true;
//         }
//         int flag=0;


        

//         boolean left=isBalanced(root.left);

//         int check=Math.abs(maxDepth(root.left)-maxDepth(root.right));
//         if(check<=1)
//         flag=1;
//         else 
//         flag=0;
        
//         boolean right=isBalanced(root.right);

//         if(left == true && right ==true && flag==1)
//         return true;
//         else
//         return false;
        
        




        
//     }
//      public int maxDepth(TreeNode root) {

//         if(root==null)
//         return 0;

//         int left=maxDepth(root.left);
//         int right=maxDepth(root.right);
//         int MaxDepth=1+ Math.max(left,right);
//         return MaxDepth;
//     }
// }
class Solution {
    public boolean isBalanced(TreeNode root) {

        if(maxDepth(root)>-1)
        return true;
        else
        return false;
        
    }
     public int maxDepth(TreeNode root) {

        if(root==null)
        return 0;

        int left=maxDepth(root.left);
        int right=maxDepth(root.right);

        if(left==-1 || right == -1)
        return -1;

        if(Math.abs(left-right)>1)
        return -1;

        int MaxDepth=1+ Math.max(left,right);
        return MaxDepth;
    }
}