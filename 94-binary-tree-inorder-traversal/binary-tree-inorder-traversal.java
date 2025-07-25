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
//RECURSIVE -----------------------------------------------------
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
     if(root==null)
     return list;
     inorderTraversal(root.left);
     list.add(root.val);
     inorderTraversal(root.right);

     return list;

    }
}

// ITERATIVE ------------------------------------------------------
// class Solution {

//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> list = new ArrayList<>();
//         Stack<TreeNode> st = new Stack<>();

//         TreeNode temp = root;
//         while (true) {
//             if (temp != null) {
//                 st.push(temp);
//                 temp = temp.left;

//             } else {
//                 if (st.empty())
//                     break;
//                 temp = st.pop();
//                 list.add(temp.val);
//                 temp = temp.right;
//             }

//         }
//         return list;
//     }
//}