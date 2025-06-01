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
    public boolean isPalindrome(ListNode head) {

        
        ListNode f=head;
        ListNode s=head;

//finding the middle element

        while(f.next!=null && f.next.next!=null)
        {
            s=s.next;
            f=f.next.next;
        }



        ListNode prev=null;
        ListNode temp= s.next;
        ListNode front=null;


//reverse 2nd part

        while(temp!=null)
        {
            front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }

//Compare

temp=head;
ListNode temp2= prev;

while(temp!=s.next && temp2!=null)
{
    
    if(temp.val!=temp2.val)
    return false;
    temp=temp.next;
    temp2=temp2.next;

}

return true;




    }
}



