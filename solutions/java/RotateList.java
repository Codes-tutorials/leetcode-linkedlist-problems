/**
 * Problem 12: Rotate List
 * 
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class RotateList {
    
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        
        int length = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        
        k = k % length;
        if (k == 0) return head;
        
        ListNode current = head;
        for (int i = 0; i < length - k - 1; i++) {
            current = current.next;
        }
        
        ListNode newHead = current.next;
        current.next = null;
        tail.next = head;
        
        return newHead;
    }
    
    public static void main(String[] args) {
        ListNode head1 = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = rotateRight(head1, 2);
        int[] expected1 = {4, 5, 1, 2, 3};
        assert java.util.Arrays.equals(ListNode.toArray(result1), expected1) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: Rotate right by 2");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
