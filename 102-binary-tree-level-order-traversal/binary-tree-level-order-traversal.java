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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> mainList= new ArrayList<>();
        if(root==null)
        return mainList;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            List<Integer> subList=new ArrayList<>();
            int len=q.size();
            for(int i=0; i<len;i++)
            {
                
               TreeNode n=q.poll();
               if (n!=null)
               {
               if(n.left!=null) q.offer(n.left);
               if(n.right!=null) q.offer(n.right);
               subList.add(n.val);
               }
            }
            mainList.add(subList);
        }

      return mainList;  
    }
}