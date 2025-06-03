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

// public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        // Alternative Stack-based Approach----------------------------------------------------------------
        /*
        Stack<Integer> stA = new Stack<Integer>();
        Stack<Integer> stB = new Stack<Integer>();
        
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        // Push all values from both lists into respective stacks
        while(tempA != null || tempB != null) {
            if(tempA != null) {
                stA.push(tempA.val);
                tempA = tempA.next;
            }
            if(tempB != null) {
                stB.push(tempB.val);
                tempB = tempB.next;
            }
        }
        
        // Reset pointers to traverse lists again
        tempA = headA;
        tempB = tempB;
        
        // Find intersection by comparing stack tops with current nodes
        while(tempA != null || tempB != null) {
            if(stA.peek() == stB.peek() && (tempA.val == stA.peek() || tempB.val == stA.peek()))
                break;
            if(stA.peek() == stB.peek()) {
                stA.pop();
                stB.pop();
            }
            if(tempA != null)
                tempA = tempA.next;
            if(tempB != null)
                tempB = tempB.next;
        }
        
        if(tempA != null && tempA.val == stA.peek())
            return tempA;
        if(tempB != null && tempB.val == stA.peek())
            return tempB;
        
        return null;
        */
        
        // Current Implementation (Two-Pointer Approach)
        // Implementation goes here...
//     }
// }

// Alternative Stack-based Approach----------------------------------------------------------------





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
        if(headA == headB) 
            return headA;
        
        ListNode tempA = headA;
        ListNode tempB = headB;
        int lenA = 0, lenB = 0;
        
        // Calculate lengths of both lists
        while(tempA != null || tempB != null) {
            if(tempA != null) {
                lenA++;
                tempA = tempA.next;
            }
            if(tempB != null) {
                lenB++;
                tempB = tempB.next;
            }
        }
        
        // Set pointers: f for longer list, s for shorter list
        ListNode f = (lenA > lenB) ? headA : headB;
        ListNode s = (lenA > lenB) ? headB : headA;
        
        // Advance the longer list by the difference
        int diff = Math.abs(lenA - lenB);
        while(diff != 0) {
            f = f.next;
            diff--;
        }
        
        // Find intersection point
        while(f != null && s != null) {
            if(f == s)
                break;
            f = f.next;
            s = s.next;
        }
        
        return f;
    }
}
    