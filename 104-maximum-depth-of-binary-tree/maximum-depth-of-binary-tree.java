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

 //USING LEVEL ORDER ------------------------------------------
// class Solution {
//     public int maxDepth(TreeNode root) {
//         Queue<TreeNode> q = new LinkedList<>();
//         if(root==null)
//         return 0;
//         q.offer(root);
//         int level=0;
//         while(!q.isEmpty())
//         {
//             level++;
//             int len=q.size();
//             for(int i=0; i<len ;i++)
//             {
//                 TreeNode ele= q.poll();
//                 if(ele.left!=null)q.offer(ele.left);
//                 if(ele.right!=null)q.offer(ele.right);
            
//             }
//         }

//         return level;     
//     }
// }

//USING Recursion---------------------------
class Solution {
    public int maxDepth(TreeNode root) {

         if(root==null)
        {
            return 0;
        }

        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return 1+Math.max(left,right);

    }
}