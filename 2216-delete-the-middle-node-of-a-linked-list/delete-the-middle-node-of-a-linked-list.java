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
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow= head;
        ListNode slowPrevious=null;
        ListNode fast=head;

        if(head.next==null)
        {
            return null;
        }
        if(head.next.next==null)
        {
            head.next=null;
            return head;
        }


        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slowPrevious=slow;
            slow=slow.next;
        }

        //evn case--------------------------
        if(fast.next!=null)
        {
            slowPrevious=slow;
            slow=slow.next;
        }

        slowPrevious.next=slow.next;
        slow.next=null;

    
     return head;
    }
}




        
    
