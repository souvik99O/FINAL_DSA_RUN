/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    //     Stack<Integer> stA= new Stack<Integer>();
    //     Stack<Integer> stB= new Stack<Integer>();

    //     ListNode tempA= headA;
    //     ListNode tempB= headB;

    //     while(tempA!=null || tempB!=null)
    //     {
    //         if(tempA!=null)
    //         {
    //             stA.push(tempA.val);
    //             tempA=tempA.next;
    //         }
    //         if(tempB!=null)
    //         {
    //             stB.push(tempB.val);
    //             tempB=tempB.next;
    //         }

    //     }  


    //     tempA= headA;
    //     tempB= headB;

    //     while(tempA!=null || tempB!=null)
    //     {
    //         if(stA.peek()==stB.peek() && (tempA.val==stA.peek()||tempB.val==stA.peek()))
    //         break;
    //         if(stA.peek()==stB.peek())
    //         {
    //             stA.pop();
    //             stB.pop();
    //         }
    //         if(tempA!=null)
    //         tempA=tempA.next;
    //         if(tempB!=null)
    //         tempB=tempB.next;
    //     }

    //     if(tempA!=null && tempA.val==stA.peek())
    //     return tempA;
    //     if(tempB!=null && tempB.val==stA.peek()) 
    //     return tempB;

        

    // return null;

    ListNode f=null;
    ListNode s=null;
    ListNode tempA= headA;
    ListNode tempB= headB;
    int lenA=0;int lenB=0;

    if(headA==headB)
    return headA;

    while(tempA!=null || tempB!=null){
            {
                if(tempA!=null)
                {
                    lenA++;
                    tempA=tempA.next;
                }
                if(tempB!=null)
                {
                    lenB++;
                    tempB=tempB.next;
                }

            }
    }

    System.out.println(lenA); 
    System.out.println(lenB);

    if(lenA>lenB)
    {
        f=headA;
        s=headB;
    }
    else
    {
        f=headB;
        s=headA;
    }

    int diff= Math.abs(lenA-lenB);
    System.out.println(diff);

    while(diff!=0)
    {
        f=f.next;
        diff--;
    }

    while(f!=null && s!=null )
    {
        if(f==s)
        break;

        f=f.next;
        s=s.next;
    }

    
    return f;

    }
}