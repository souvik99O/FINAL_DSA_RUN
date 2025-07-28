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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
        return null;
    PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)->a.val-b.val);
    for(int i=0; i<lists.length;i++)
    {
        if(lists[i]==null)
        continue;
        pq.offer(lists[i]);
    }
    ListNode dummy= new ListNode(-1);
    ListNode newNode =pq.poll();
    if(newNode==null)
    return null;
     if(newNode.next!=null)
     pq.offer(newNode.next);
    dummy.next=newNode;


    while(!pq.isEmpty())
    {
        ListNode node=pq.poll();
        if(node.next!=null)
        pq.offer(node.next);
        newNode.next=node;
        newNode=node;   
    }
    
      return dummy.next;  
    }
}