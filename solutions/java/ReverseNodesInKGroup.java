/**
 * Problem 14: Reverse Nodes in K-Group
 * 
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

public class ReverseNodesInKGroup {
    
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (true) {
            ListNode kth = prev;
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                if (kth == null) return dummy.next;
            }
            
            ListNode nextGroup = kth.next;
            ListNode current = prev.next;
            ListNode next = null;
            
            for (int i = 0; i < k; i++) {
                next = current.next;
                current.next = kth.next;
                kth.next = current;
                current = next;
            }
            
            ListNode temp = prev.next;
            prev.next = kth;
            prev = temp;
        }
    }
    
    public static void main(String[] args) {
        ListNode head1 = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        ListNode result1 = reverseKGroup(head1, 2);
        int[] expected1 = {2, 1, 4, 3, 5};
        assert java.util.Arrays.equals(ListNode.toArray(result1), expected1) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: Reverse K-Group with k=2");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
