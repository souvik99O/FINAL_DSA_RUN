class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;
        ListNode front = null;
        ListNode counter = null;
        int count = k;
        ListNode link = head;  // This will point to the tail of first group

        // First group reversal
        while(count != 0) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
            count--;
        }
        head = prev;

        while(temp != null) {
            counter = temp;
            count = 0;
            prev = null;
            
            // Check if we have k nodes
            while(counter != null && count != k) {
                counter = counter.next;
                count++;
            }
            
            if(counter == null && count != k) {
                link.next = temp;  // Connect remaining nodes
                return head;
            }
            
            // CHANGE: Store the current node (will become tail after reversal)
            ListNode groupTail = temp;
            
            // Reverse the k nodes
            while(temp != counter) {
                front = temp.next;
                temp.next = prev;
                prev = temp;
                temp = front;
            }
            
            // CHANGE: Connect previous group's tail to current group's head
            link.next = prev;
            // CHANGE: Update link to current group's tail
            link = groupTail;
        }

        return head;
    }
}
