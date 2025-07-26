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
class pair {
    int horizontalDistance;
    TreeNode node;

    public pair(int horizotalDistance, TreeNode node) {
        this.horizontalDistance = horizotalDistance;
        this.node = node;
    }
}

class nodeinfo {
    int val;
    int lvl;

    public nodeinfo(int val, int lvl) {
        this.val = val;
        this.lvl = lvl;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ansList = new ArrayList<>();
        Queue<pair> q = new LinkedList<>();

        TreeMap<Integer, List<nodeinfo>> map = new TreeMap<>();

        q.offer(new pair(0, root));
        int lvl=0;
        while (!q.isEmpty()) {
            lvl++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                List<nodeinfo> list = new ArrayList<>();
                pair ele = q.poll();
                if (map.containsKey(ele.horizontalDistance)) {
                    list = map.get(ele.horizontalDistance);
                }
                list.add(new nodeinfo(ele.node.val,lvl));
                map.put(ele.horizontalDistance, list);
                if (ele.node.left != null)
                    q.offer(new pair(ele.horizontalDistance - 1, ele.node.left));
                if (ele.node.right != null)
                    q.offer(new pair(ele.horizontalDistance + 1, ele.node.right));
            }
        }


        for(Map.Entry<Integer, List<nodeinfo>> entry :map.entrySet())
        {
            Collections.sort(entry.getValue(),
            (a,b)->{
                    if(a.lvl==b.lvl)
                    return a.val-b.val; 
                    else
                    return a.lvl-b.lvl;
                    }
            );

            List<Integer> temp = new ArrayList<>();

            for (nodeinfo ni : entry.getValue()) {
                temp.add(ni.val);
            }
            ansList.add(temp);

        }
       
        return ansList;
    }
}