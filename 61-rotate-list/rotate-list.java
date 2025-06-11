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
    public ListNode rotateRight(ListNode head, int k) {
        // int count=k;
        // ListNode tail= head;
        // ListNode prev=null;
        // if(head==null|| head.next==null)
        // {
        //     return head;
        // }

        // while(count!=0)
        // {
        //     while(tail.next!=null){
        //     prev=tail;
        //     tail=tail.next;
        //     }
        //     tail.next=head;
        //     head=tail;
        
        //     count--;
        // }
        // return head;

        int len=0;
        ListNode temp=head;

        if(head==null ||head.next==null)
        return head;

        while(temp!=null)
        {
            temp=temp.next;
            len++;
        }
        if (k==len)
        return head;
        if(k>len)
        k=(k%len);
        System.out.println(len);

        //revers len-k group
        temp=head;
        ListNode prev=null;
        ListNode front=head;
        int group1=len-k;
        ListNode link=head;

        while(group1!=0)
        {
                front=temp.next;
                temp.next=prev;
                prev=temp;
                temp=front;
                group1--;
        }
        head=prev;

        //revers next k group
        prev=null;
        front=head;
        int group2=k;
        ListNode grouptail=temp;

        while(group2!=0)
        {
                front=temp.next;
                temp.next=prev;
                prev=temp;
                temp=front;
                group2--;
        }

        link.next=prev;
        link=grouptail;

     //revers full list
     temp=head;
     prev=null;
     front=head;
     while(temp!=null)
        {
            front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        head=prev;


    return head;








        
    }
}