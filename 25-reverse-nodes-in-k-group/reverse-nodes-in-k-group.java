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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp=head;
        ListNode prev=null;
        ListNode front=null;
        ListNode counter=null;
        int count=k;
        ListNode link=head;

        while(count!=0)
        {
            front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;

            count--;
        }
        head=prev;




        while(temp!=null){
            counter=temp;
            count=0;
            prev=null;
            
             
            while(counter!=null && count!=k)
            {
                counter=counter.next;
                count++;
            }
            if(counter==null && count!=k)
            {
                link.next = temp; 
                return head;
            }

            ListNode groupstail=temp;

            while(temp!=counter)
            {
                front=temp.next;
                temp.next=prev;
                prev=temp;
                temp=front;
            }

            link.next=prev;
            link=groupstail;
        }

    return head;
        
    }
}