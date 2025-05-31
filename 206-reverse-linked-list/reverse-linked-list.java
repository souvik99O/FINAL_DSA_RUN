/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// APPROACH 1: ITERATIVE (Most common and efficient)
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;  // Store next node
            curr.next = prev;           // Reverse the link
            prev = curr;                // Move prev forward
            curr = next;                // Move curr forward
        }
        
        return prev;  // prev is the new head
    }
}