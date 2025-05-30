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
    public ListNode oddEvenList(ListNode head) {
        ListNode temp=head;
        ListNode dummyO=new ListNode(-1);
        ListNode dummyE=new ListNode(-1);
        ListNode odd=dummyO;
        ListNode even=dummyE;
        int count=0;

        while(temp!=null)
        {

            count++;
            if(count%2==0)
            {
                ListNode newnode = new ListNode(temp.val);
                even.next=newnode;
                even=newnode;
            }
            else
            {
                
                ListNode newnode = new ListNode(temp.val);
                odd.next=newnode;
                odd=newnode;
            }

            temp=temp.next;
        }

        head=dummyO.next;
        odd.next=dummyE.next;

        return head;

        
    }
}