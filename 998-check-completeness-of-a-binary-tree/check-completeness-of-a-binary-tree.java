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
    public boolean isCompleteTree(TreeNode root) {
       int totalNodes=countTotalNodes(root);
       System.out.println(totalNodes);
       boolean ans=isCBT(root,1,totalNodes);
       return ans;
    }
    int countTotalNodes(TreeNode root)
    {
        if (root==null)
        return 0;

        int left=1+countTotalNodes(root.left);
        int right=countTotalNodes(root.right);


        return left+right;
    }

     public boolean isCBT(TreeNode root,int index, int totalNodes)
    {
        if(root==null)
        return true;

        
        

        if(index>totalNodes)
        {
            return false;
        }


        boolean left=isCBT(root.left,index*2,totalNodes);
        boolean right=isCBT(root.right,index*2+1,totalNodes);

        
        return left && right;

    }
}