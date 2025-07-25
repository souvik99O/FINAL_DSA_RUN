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
            List<Integer> list= new ArrayList<>();
            int size=q.size();
            for(int i=0; i<size;i++)
            {
                TreeNode ele=q.poll();
                list.add(ele.val);
                if(ele.left!=null)
                {
                    q.offer(ele.left);
                }
                if(ele.right!=null)
                {
                    q.offer(ele.right);
                }
            }
            mainList.add(list);
        }

        return mainList;
        
    }
}