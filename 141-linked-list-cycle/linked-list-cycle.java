/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

//brute force using hash sets---------------------------------------      
        // if(head==null || head.next==null )
        // {
        //     return false;
        // }

        // HashSet<ListNode> set= new HashSet<>();
        // ListNode temp=head;
        
        // while(temp!=null)
        // {
        //     if(set.contains(temp)){
        //     return true;
        //     }
            
        //     set.add(temp);
        //     temp=temp.next;
        // }
        // return false;
//brute force using hash sets--------------------------------------- 

//Little more optimized---------------------------------------------

    if(head==null || head.next==null )
    {
        return false;
    }

    ListNode temp=head;

    while(temp!=null)
    {
        if(temp.val==-50265)
        return true;
        temp.val=-50265;
        temp=temp.next;
    }
    return false;

    }
}