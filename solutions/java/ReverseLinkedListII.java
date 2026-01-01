/**
 * Problem 11: Reverse Linked List II
 * 
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ReverseLinkedListII {
    
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        ListNode current = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode head1 = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = reverseBetween(head1, 2, 4);
        int[] expected1 = {1, 4, 3, 2, 5};
        assert java.util.Arrays.equals(ListNode.toArray(result1), expected1) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: Reverse between 2 and 4");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
