/**
 * Problem 1: Reverse Linked List
 * 
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * 
 * Time Complexity: O(n) - visit each node once
 * Space Complexity: O(1) - only use constant extra space
 */

public class ReverseLinkedList {
    
    /**
     * Reverse a linked list iteratively.
     * 
     * @param head the head of the linked list
     * @return the head of the reversed list
     * 
     * Approach:
     * 1. Use three pointers: prev, current, next
     * 2. Traverse the list and reverse the direction of each link
     * 3. Move pointers forward until we reach the end
     * 4. Return prev as the new head
     */
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            // Store next node before we change current.next
            ListNode next = current.next;
            
            // Reverse the link
            current.next = prev;
            
            // Move prev and current one step forward
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    /**
     * Reverse a linked list recursively.
     * 
     * @param head the head of the linked list
     * @return the head of the reversed list
     */
    public static ListNode reverseListRecursive(ListNode head) {
        // Base case: empty list or single node
        if (head == null || head.next == null) {
            return head;
        }
        
        // Recursively reverse the rest of the list
        ListNode newHead = reverseListRecursive(head.next);
        
        // Reverse the link between current and next
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
    
    // Test cases
    public static void main(String[] args) {
        // Test case 1: Normal list
        ListNode head1 = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        ListNode reversed1 = reverseList(head1);
        int[] expected1 = {5, 4, 3, 2, 1};
        assert java.util.Arrays.equals(ListNode.toArray(reversed1), expected1) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: [1,2,3,4,5] reversed = [5,4,3,2,1]");
        
        // Test case 2: Single node
        ListNode head2 = ListNode.createList(new int[]{1});
        ListNode reversed2 = reverseList(head2);
        int[] expected2 = {1};
        assert java.util.Arrays.equals(ListNode.toArray(reversed2), expected2) : "Test 2 failed";
        System.out.println("✓ Test 2 passed: [1] reversed = [1]");
        
        // Test case 3: Two nodes
        ListNode head3 = ListNode.createList(new int[]{1, 2});
        ListNode reversed3 = reverseList(head3);
        int[] expected3 = {2, 1};
        assert java.util.Arrays.equals(ListNode.toArray(reversed3), expected3) : "Test 3 failed";
        System.out.println("✓ Test 3 passed: [1,2] reversed = [2,1]");
        
        // Test case 4: Empty list
        ListNode head4 = null;
        ListNode reversed4 = reverseList(head4);
        assert reversed4 == null : "Test 4 failed";
        System.out.println("✓ Test 4 passed: null reversed = null");
        
        // Test case 5: Recursive version
        ListNode head5 = ListNode.createList(new int[]{1, 2, 3});
        ListNode reversed5 = reverseListRecursive(head5);
        int[] expected5 = {3, 2, 1};
        assert java.util.Arrays.equals(ListNode.toArray(reversed5), expected5) : "Test 5 failed";
        System.out.println("✓ Test 5 passed: Recursive reverse works");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
