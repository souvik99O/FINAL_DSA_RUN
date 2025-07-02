/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();

        q.offer(root);
        TreeNode start=null;
        parentMap.put(root,null);
        
//setting up the back pointers-----------------
        while(!q.isEmpty())
        {
            int len=q.size();
            for(int i=0; i<len; i++)
            {
                
                TreeNode ele= q.poll();
                if(ele==target)
                start=ele;
                
                if(ele.left!=null)
                {
                    q.offer(ele.left);
                    parentMap.put(ele.left,ele);
                }
                if(ele.right!=null)
                {
                    q.offer(ele.right);
                    parentMap.put(ele.right,ele);
                }
            }
        }

        HashSet<TreeNode> visited= new HashSet<>();
        q.offer(start);
        int dis=0;

        while(!q.isEmpty())
        {
            if(dis==k)
            break;
            int len= q.size();
            int flag=0;
            for(int i=0; i<len; i++)
            {
                TreeNode ele= q.poll();
                visited.add(ele);

                if(ele.left!=null && visited.contains(ele.left)==false){
                q.offer(ele.left);  flag=1;}

                if(ele.right!=null && visited.contains(ele.right)==false){
                q.offer(ele.right);  flag=1;}

                TreeNode parent=parentMap.get(ele);

                if( parent!=null && visited.contains(parent)==false){
                q.offer(parent); flag=1;}
            }
            if(flag!=0)
            dis++;

        }

        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            ans.add(q.poll().val);
        }

        return ans;
  
    }
}