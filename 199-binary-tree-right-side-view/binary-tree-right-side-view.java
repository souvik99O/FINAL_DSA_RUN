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
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> q= new LinkedList();
        List<Integer> finalItems= new ArrayList<>();

        List<List<Integer>> mainList= new ArrayList<>();
        if(root==null)
        return finalItems;
        

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
            mainList.add(list);
            count++;
        }
      for(List<Integer> itemList: mainList)
      {
        finalItems.add(itemList.get(itemList.size()-1));
      }
      return finalItems;

        
    }
}