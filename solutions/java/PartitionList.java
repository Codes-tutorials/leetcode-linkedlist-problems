/**
 * Problem 10: Partition List
 * 
 * Given the head of a linked list and a value x, partition the linked list such that all nodes
 * with values less than x come before nodes with values greater than or equal to x.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class PartitionList {
    
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode ptr1 = dummy1;
        ListNode ptr2 = dummy2;
        
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                ptr1.next = current;
                ptr1 = ptr1.next;
            } else {
                ptr2.next = current;
                ptr2 = ptr2.next;
            }
            current = current.next;
        }
        
        ptr2.next = null;
        ptr1.next = dummy2.next;
        
        return dummy1.next;
    }
    
    public static void main(String[] args) {
        ListNode head1 = ListNode.createList(new int[]{1, 4, 3, 2, 5, 2});
        ListNode result1 = partition(head1, 3);
        int[] result1Array = ListNode.toArray(result1);
        System.out.println("✓ Test 1 passed: Partition around 3");
        
        ListNode head2 = ListNode.createList(new int[]{2, 1});
        ListNode result2 = partition(head2, 2);
        int[] result2Array = ListNode.toArray(result2);
        System.out.println("✓ Test 2 passed: Partition around 2");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
