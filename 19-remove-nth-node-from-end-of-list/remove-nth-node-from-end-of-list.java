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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null||head.next==null)
        return null;

        ListNode temp=head;
        int count=0;  
        while(temp!=null)
        {
            count++;
            temp=temp.next;
        }


        int removeindex=count-n+1;


        if(removeindex==1)
        return head.next;

        
        ListNode prev= null;
        int count2=0;
        temp=head;

        while(temp!=null)
        {
            count2++;
            if(count2==removeindex && removeindex!=count)
            {
                prev.next=temp.next;
                temp.next=null;
                break;

            }
            if(count2==removeindex && removeindex==count)
            {
                prev.next=null;
                temp.next=null;
                break;
            }

            prev=temp;
            temp=temp.next;
        }
return head;
    }
}