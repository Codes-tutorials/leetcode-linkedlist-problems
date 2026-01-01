/**
 * Problem 5: Palindrome Linked List
 * 
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * 
 * Time Complexity: O(n) - traverse list multiple times
 * Space Complexity: O(1) - only use constant extra space (excluding recursion stack)
 */

public class PalindromeLinkedList {
    
    /**
     * Check if a linked list is a palindrome.
     * 
     * @param head the head of the linked list
     * @return true if palindrome, false otherwise
     * 
     * Approach:
     * 1. Find the middle of the list using slow/fast pointers
     * 2. Reverse the second half
     * 3. Compare first half with reversed second half
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        // Find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        ListNode secondHalf = reverseList(slow);
        
        // Compare
        ListNode first = head;
        ListNode second = secondHalf;
        while (second != null) {
            if (first.val != second.val) {
                return false;
            }
            first = first.next;
            second = second.next;
        }
        
        return true;
    }
    
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    
    // Test cases
    public static void main(String[] args) {
        // Test case 1: Palindrome
        ListNode head1 = ListNode.createList(new int[]{1, 2, 2, 1});
        assert isPalindrome(head1) == true : "Test 1 failed";
        System.out.println("✓ Test 1 passed: [1,2,2,1] is palindrome");
        
        // Test case 2: Not palindrome
        ListNode head2 = ListNode.createList(new int[]{1, 2});
        assert isPalindrome(head2) == false : "Test 2 failed";
        System.out.println("✓ Test 2 passed: [1,2] is not palindrome");
        
        // Test case 3: Single node
        ListNode head3 = new ListNode(1);
        assert isPalindrome(head3) == true : "Test 3 failed";
        System.out.println("✓ Test 3 passed: Single node is palindrome");
        
        // Test case 4: Odd length palindrome
        ListNode head4 = ListNode.createList(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9});
        assert isPalindrome(head4) == true : "Test 4 failed";
        System.out.println("✓ Test 4 passed: Long palindrome");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
