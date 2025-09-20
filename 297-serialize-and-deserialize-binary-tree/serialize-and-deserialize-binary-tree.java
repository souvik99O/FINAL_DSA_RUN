/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    int i=0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        if (root == null)
            return "N,";

        String left = serialize(root.left);
        String right = serialize(root.right);

        return root.val+ "," + left + right;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        String[] nodes= data.split(",");
        TreeNode ans =deserializeHelper(nodes);
        return ans;
        
    }

    public TreeNode deserializeHelper(String [] nodes)
    {
         if(nodes[i].equals("N"))
        {
            i++;
            return null;
        }

        TreeNode newNode= new TreeNode(Integer.parseInt(nodes[i]));
        i++;
        newNode.left=deserializeHelper(nodes);
        newNode.right=deserializeHelper(nodes);
        return newNode;  
    }

}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));