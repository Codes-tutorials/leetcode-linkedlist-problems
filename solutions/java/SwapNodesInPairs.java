/**
 * Problem 13: Swap Nodes in Pairs
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class SwapNodesInPairs {
    
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            prev = first;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head1 = ListNode.createList(new int[]{1, 2, 3, 4});
        ListNode result1 = swapPairs(head1);
        int[] expected1 = {2, 1, 4, 3};
        assert java.util.Arrays.equals(ListNode.toArray(result1), expected1) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: Swap pairs in [1,2,3,4]");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
