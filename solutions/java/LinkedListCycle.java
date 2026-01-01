/**
 * Problem 3: Linked List Cycle
 * 
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again
 * by continuously following the next pointer.
 * 
 * Time Complexity: O(n) - Floyd's cycle detection
 * Space Complexity: O(1) - only use two pointers
 */

public class LinkedListCycle {
    
    /**
     * Detect if a linked list has a cycle using Floyd's algorithm.
     * 
     * @param head the head of the linked list
     * @return true if cycle exists, false otherwise
     * 
     * Approach:
     * 1. Use two pointers: slow (moves 1 step) and fast (moves 2 steps)
     * 2. If there's a cycle, fast will eventually catch up to slow
     * 3. If fast reaches null, there's no cycle
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            // If fast reaches null, there's no cycle
            if (fast == null || fast.next == null) {
                return false;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
    
    /**
     * Detect cycle using HashSet (alternative approach).
     */
    public static boolean hasCycleHashSet(ListNode head) {
        java.util.Set<ListNode> visited = new java.util.HashSet<>();
        ListNode current = head;
        
        while (current != null) {
            if (visited.contains(current)) {
                return true;
            }
            visited.add(current);
            current = current.next;
        }
        
        return false;
    }
    
    /**
     * Create a linked list with a cycle for testing.
     */
    private static ListNode createListWithCycle(int[] values, int cyclePos) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleNode = null;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            if (i == cyclePos) {
                cycleNode = current.next;
            }
            current = current.next;
        }
        
        // Create cycle
        if (cycleNode != null) {
            current.next = cycleNode;
        }
        
        return head;
    }
    
    // Test cases
    public static void main(String[] args) {
        // Test case 1: List with cycle
        ListNode head1 = createListWithCycle(new int[]{3, 2, 0, -4}, 1);
        assert hasCycle(head1) == true : "Test 1 failed";
        System.out.println("✓ Test 1 passed: List with cycle detected");
        
        // Test case 2: List without cycle
        ListNode head2 = ListNode.createList(new int[]{1, 2});
        assert hasCycle(head2) == false : "Test 2 failed";
        System.out.println("✓ Test 2 passed: List without cycle detected");
        
        // Test case 3: Single node without cycle
        ListNode head3 = new ListNode(1);
        assert hasCycle(head3) == false : "Test 3 failed";
        System.out.println("✓ Test 3 passed: Single node without cycle");
        
        // Test case 4: Single node with cycle (points to itself)
        ListNode head4 = new ListNode(1);
        head4.next = head4;
        assert hasCycle(head4) == true : "Test 4 failed";
        System.out.println("✓ Test 4 passed: Single node with self-cycle detected");
        
        // Test case 5: Empty list
        ListNode head5 = null;
        assert hasCycle(head5) == false : "Test 5 failed";
        System.out.println("✓ Test 5 passed: Empty list has no cycle");
        
        // Test case 6: HashSet approach
        ListNode head6 = createListWithCycle(new int[]{3, 2, 0, -4}, 1);
        assert hasCycleHashSet(head6) == true : "Test 6 failed";
        System.out.println("✓ Test 6 passed: HashSet approach works");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
