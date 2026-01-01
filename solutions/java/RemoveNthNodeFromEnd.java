/**
 * Problem 4: Remove Nth Node From End of List
 * 
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * 
 * Time Complexity: O(n) - two passes through the list
 * Space Complexity: O(1) - only use constant extra space
 */

public class RemoveNthNodeFromEnd {
    
    /**
     * Remove the nth node from the end of the list.
     * 
     * @param head the head of the linked list
     * @param n the position from the end to remove
     * @return the head of the modified list
     * 
     * Approach:
     * 1. Use two pointers with n nodes gap between them
     * 2. Move both pointers until fast reaches the end
     * 3. Remove the node by adjusting the next pointer
     * 4. Handle edge case where head is removed
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Create a dummy node to handle edge case of removing head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }
        
        // Move both pointers until fast reaches the end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Remove the nth node
        slow.next = slow.next.next;
        
        return dummy.next;
    }
    
    // Test cases
    public static void main(String[] args) {
        // Test case 1: Remove middle node
        ListNode head1 = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = removeNthFromEnd(head1, 2);
        int[] expected1 = {1, 2, 3, 5};
        assert java.util.Arrays.equals(ListNode.toArray(result1), expected1) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: Remove 2nd from end");
        
        // Test case 2: Remove head
        ListNode head2 = ListNode.createList(new int[]{1});
        ListNode result2 = removeNthFromEnd(head2, 1);
        assert result2 == null : "Test 2 failed";
        System.out.println("✓ Test 2 passed: Remove head (single node)");
        
        // Test case 3: Remove first node
        ListNode head3 = ListNode.createList(new int[]{1, 2});
        ListNode result3 = removeNthFromEnd(head3, 2);
        int[] expected3 = {2};
        assert java.util.Arrays.equals(ListNode.toArray(result3), expected3) : "Test 3 failed";
        System.out.println("✓ Test 3 passed: Remove first node");
        
        // Test case 4: Remove last node
        ListNode head4 = ListNode.createList(new int[]{1, 2});
        ListNode result4 = removeNthFromEnd(head4, 1);
        int[] expected4 = {1};
        assert java.util.Arrays.equals(ListNode.toArray(result4), expected4) : "Test 4 failed";
        System.out.println("✓ Test 4 passed: Remove last node");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
