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
//     List<TreeNode> preorderList =new ArrayList<>();
//     public void flatten(TreeNode root) {
//         preorder(root);
//         for(int i=0; i<preorderList.size()-1; i++)
//         {
//             preorderList.get(i).left=null;
//             preorderList.get(i).right=preorderList.get(i+1);
//         }
        
//     }
//     public void preorder(TreeNode root)
//     {
//         if(root==null)
//         return;
        
//         preorderList.add(root);
//         preorder(root.left);
//         preorder(root.right);

//     }
// }

class Solution {
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        
        if(root==null)
        return;

        flatten(root.right);
        flatten(root.left);

        root.left=null;
        root.right=prev;
        prev=root;
        
    }
   
}