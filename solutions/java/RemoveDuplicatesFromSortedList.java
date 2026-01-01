/**
 * Problem 9: Remove Duplicates from Sorted List
 * 
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class RemoveDuplicatesFromSortedList {
    
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head1 = ListNode.createList(new int[]{1, 1, 2});
        ListNode result1 = deleteDuplicates(head1);
        int[] expected1 = {1, 2};
        assert java.util.Arrays.equals(ListNode.toArray(result1), expected1) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: [1,1,2] -> [1,2]");
        
        ListNode head2 = ListNode.createList(new int[]{1, 1, 2, 2, 2});
        ListNode result2 = deleteDuplicates(head2);
        int[] expected2 = {1, 2};
        assert java.util.Arrays.equals(ListNode.toArray(result2), expected2) : "Test 2 failed";
        System.out.println("✓ Test 2 passed: [1,1,2,2,2] -> [1,2]");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
