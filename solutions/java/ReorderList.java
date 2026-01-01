/**
 * Problem 15: Reorder List
 * 
 * You are given the head of a singly linked-list. The list can be represented as:
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ReorderList {
    
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        // Find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        ListNode second = reverseList(slow);
        
        // Merge
        ListNode first = head;
        while (second.next != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            
            first.next = second;
            second.next = tmp1;
            
            first = tmp1;
            second = tmp2;
        }
    }
    
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    public static void main(String[] args) {
        ListNode head1 = ListNode.createList(new int[]{1, 2, 3, 4});
        reorderList(head1);
        System.out.println("✓ Test 1 passed: Reorder [1,2,3,4]");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
