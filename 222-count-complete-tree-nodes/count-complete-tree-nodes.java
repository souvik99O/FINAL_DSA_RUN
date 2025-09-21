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
//     int count =0;
//     public int countNodes(TreeNode root) {
//         int ans=count(root);
//         return ans;
        
//     }
//     public int count(TreeNode root)
//     {
//         if(root==null)
//         return 0;

        
//         int left=count(root.left);
//         int right=count(root.right);

//         return 1+left+right;
//     }
// }


//O(log^2 n)

class Solution {
    int count =0;
    public int countNodes(TreeNode root) {
        if(leftHieght(root)==rightHieght(root))
        {
            return (int)Math.pow(2,leftHieght(root))-1;
        }
        else
        {
            if(root==null)
            return 0;
            return 1+countNodes(root.left)+countNodes(root.right);
        }
    }
    public int leftHieght(TreeNode root)
    {
        int depth=0;

        
        while(root!=null)
        {
            depth++;
            root=root.left;
        }

        return depth;
    }
    public int rightHieght(TreeNode root)
    {
        int depth=0;

        
        while(root!=null)
        {
            depth++;
            root=root.right;
        }

        return depth;
    }
}