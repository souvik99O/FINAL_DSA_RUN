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
 class pair{
    TreeNode node;
    int index;
    pair(TreeNode node, int index)
    {
        this.node=node;
        this.index=index;
    }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<pair> q= new LinkedList<>();
        
        List<List<pair>> mainList = new LinkedList<>();

        int ind=0;
        pair p=new pair(root,ind);
        q.offer(p);

        while(!q.isEmpty())
        {
            List<pair> list = new LinkedList<>();
            int len= q.size();
            for(int i=0; i<len; i++)
            {
                p= q.poll();
                if(p.node.left!=null) q.offer(new pair(p.node.left,p.index*2+1));
                if(p.node.right!=null) q.offer(new pair(p.node.right,p.index*2+2));
                list.add(p);
            }
            mainList.add(list);
        }
        int maxWidth=Integer.MIN_VALUE;
        for(int i=0; i<mainList.size();i++)
        {
            List <pair> templist=mainList.get(i);
            int width= (templist.get(templist.size()-1).index -templist.get(0).index)+1;
            maxWidth=Math.max(maxWidth,width);
        }

        return maxWidth;



       

        
    }
}