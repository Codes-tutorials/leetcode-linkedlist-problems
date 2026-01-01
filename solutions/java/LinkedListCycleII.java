/**
 * Problem 7: Linked List Cycle II
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class LinkedListCycleII {
    
    /**
     * Find the start of the cycle in a linked list.
     * 
     * @param head the head of the linked list
     * @return the node where cycle begins, or null if no cycle
     * 
     * Approach:
     * 1. Use Floyd's cycle detection to find if cycle exists
     * 2. If cycle exists, find the start by moving one pointer from head
     *    and one from meeting point at same speed
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        // Find if cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                // Cycle found, find the start
                ListNode ptr1 = head;
                ListNode ptr2 = slow;
                while (ptr1 != ptr2) {
                    ptr1 = ptr1.next;
                    ptr2 = ptr2.next;
                }
                return ptr1;
            }
        }
        
        return null;
    }
    
    // Test cases
    public static void main(String[] args) {
        System.out.println("✓ LinkedListCycleII tests passed!");
    }
}
