/**
 * Problem 6: Intersection of Two Linked Lists
 * 
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 * 
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */

public class IntersectionOfTwoLinkedLists {
    
    /**
     * Find intersection of two linked lists.
     * 
     * @param headA head of first list
     * @param headB head of second list
     * @return the intersection node or null
     * 
     * Approach:
     * 1. Get lengths of both lists
     * 2. Move the pointer of longer list ahead by the difference
     * 3. Move both pointers together until they meet
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        
        // Move the pointer of longer list ahead
        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }
        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }
        
        // Move both pointers together
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
    
    private static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    
    // Test cases
    public static void main(String[] args) {
        // Test case 1: Lists with intersection
        ListNode common = ListNode.createList(new int[]{8, 4, 5});
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = common;
        
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = common;
        
        ListNode intersection = getIntersectionNode(headA, headB);
        assert intersection.val == 8 : "Test 1 failed";
        System.out.println("✓ Test 1 passed: Found intersection");
        
        // Test case 2: No intersection
        ListNode headA2 = ListNode.createList(new int[]{2, 6, 4});
        ListNode headB2 = ListNode.createList(new int[]{1, 5});
        ListNode intersection2 = getIntersectionNode(headA2, headB2);
        assert intersection2 == null : "Test 2 failed";
        System.out.println("✓ Test 2 passed: No intersection");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
