/**
 * Problem 20: Add Two Numbers
 * 
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 * 
 * Time Complexity: O(max(n, m))
 * Space Complexity: O(max(n, m))
 */

public class AddTwoNumbers {
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        // Test case 1: 342 + 465 = 807
        ListNode l1 = ListNode.createList(new int[]{2, 4, 3});
        ListNode l2 = ListNode.createList(new int[]{5, 6, 4});
        ListNode result = addTwoNumbers(l1, l2);
        int[] expected = {7, 0, 8};
        assert java.util.Arrays.equals(ListNode.toArray(result), expected) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: 342 + 465 = 807");
        
        // Test case 2: 9999999 + 9999 = 10009998
        ListNode l3 = ListNode.createList(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l4 = ListNode.createList(new int[]{9, 9, 9, 9});
        ListNode result2 = addTwoNumbers(l3, l4);
        int[] expected2 = {8, 9, 9, 9, 0, 0, 0, 1};
        assert java.util.Arrays.equals(ListNode.toArray(result2), expected2) : "Test 2 failed";
        System.out.println("✓ Test 2 passed: 9999999 + 9999 = 10009998");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
