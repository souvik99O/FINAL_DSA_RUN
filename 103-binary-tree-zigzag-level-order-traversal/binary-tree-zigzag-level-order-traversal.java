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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q= new LinkedList();
        List<List<Integer>> mainList= new ArrayList<>();

        if(root==null)
        return mainList;
        

        q.offer(root);
        int count=1;
        while(!q.isEmpty())
        {
            List<Integer> list = new ArrayList<>();
            int len=q.size();
            for(int i=0; i<len;i++)
            {
                TreeNode ele= q.poll();
                list.add(ele.val);
                if(ele.left!=null) q.offer(ele.left);
                if(ele.right!=null)q.offer(ele.right);
            }
        
            if(count%2==0)
            {
                Collections.reverse(list);
            }
            mainList.add(list);
            count++;
        }

        return mainList;

        
    }
}