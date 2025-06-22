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
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode c= head;
        ListNode f=null;
        ListNode b=null;

        while(c!=null)
        {
            f=c.next;
            c.next=b;
            b=c;
            c=f;
        }
        return b;

    }
}