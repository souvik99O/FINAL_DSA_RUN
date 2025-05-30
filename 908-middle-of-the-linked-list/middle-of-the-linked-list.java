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
    public ListNode middleNode(ListNode head) {
        ListNode temp=head;
        int len=0;
        while(temp!=null)
        {
            len++;
            temp=temp.next;
        }

        

        int even=0;
        int odd=0;
        int count=0;
        int middle=(len/2)+1;
        System.out.println(len);
        System.out.println(middle);
       

        temp=head;
        while(temp!=null)
        {
            count++;
            if(count==middle)
            {
                break;
            }
            temp=temp.next;
        }

        return temp;
        
    }
}