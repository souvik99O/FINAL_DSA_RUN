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

 //RECURSIVE ----------------------------------------------------------

// class Solution {
//     List<Integer> list = new ArrayList<>();
//     public List<Integer> preorderTraversal(TreeNode root) {

//         if(root==null)
//         return list;

//         list.add(root.val);
//         List<Integer> left=preorderTraversal(root.left);
//         List<Integer> right=preorderTraversal(root.right);
//         return list;
//     }
// }

//IERATIVE USING STACK-------------------------------------------
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)
        return list;
        Stack<TreeNode> st= new Stack<>();
        st.push(root);
        while(!st.empty())
        {
            TreeNode printElement=st.pop();
            list.add(printElement.val);

            if(printElement.right!=null)
            st.push(printElement.right);

            if(printElement.left!=null)
            st.push(printElement.left);
        }
        return list;

    }
}