/**
 * Problem 8: Middle of the Linked List
 * 
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class MiddleOfLinkedList {
    
    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    public static void main(String[] args) {
        ListNode head1 = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        ListNode middle1 = middleNode(head1);
        assert middle1.val == 3 : "Test 1 failed";
        System.out.println("✓ Test 1 passed: Middle of [1,2,3,4,5] is 3");
        
        ListNode head2 = ListNode.createList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode middle2 = middleNode(head2);
        assert middle2.val == 4 : "Test 2 failed";
        System.out.println("✓ Test 2 passed: Middle of [1,2,3,4,5,6] is 4");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
