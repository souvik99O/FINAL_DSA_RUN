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
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
        {
            return head;
        }
        ListNode t=head;
        while(t.next!=null)
        {
            t=t.next;
        }

       head= mergeSort(head,t);
        return head;
    }
     public static ListNode mergeSort(ListNode start,ListNode end)
    {
        if(findLength(start,end)<2)
        return start;

        ListNode middle=findMiddle(start);
        ListNode newStart=middle.next;
        middle.next=null;

        ListNode left=mergeSort(start,middle);
        ListNode right=mergeSort(newStart,end);

        ListNode merged=merge(left,right);

        return merged;


        
    }

    public static ListNode findMiddle(ListNode head)
    {
        ListNode f=head;
        ListNode s=head;

        while(f.next!=null && f.next.next!=null)
        {
            f=f.next.next;
            s=s.next;
        }
        return s;
    }
     public static int findLength(ListNode start,ListNode end)
    {
        ListNode t=start;
        int count=0;
        while(t!=end)
        {
            count++;
            t=t.next;
        }
        return count+1;
    }
     public static ListNode merge(ListNode l1, ListNode l2) {
        // Create a dummy node to start the merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Traverse both lists, always appending the smaller node
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Append any remaining nodes
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        return dummy.next;
    }

}