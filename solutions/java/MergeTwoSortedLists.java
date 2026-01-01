/**
 * Problem 2: Merge Two Sorted Lists
 * 
 * Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the two lists.
 * 
 * Time Complexity: O(n + m) - visit each node once
 * Space Complexity: O(1) - only use constant extra space
 */

public class MergeTwoSortedLists {
    
    /**
     * Merge two sorted linked lists.
     * 
     * @param list1 head of first sorted list
     * @param list2 head of second sorted list
     * @return head of merged sorted list
     * 
     * Approach:
     * 1. Create a dummy node to simplify the process
     * 2. Compare nodes from both lists
     * 3. Attach the smaller node to the result
     * 4. Move the pointer of the list from which we took the node
     * 5. Attach remaining nodes from non-empty list
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to simplify the process
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Traverse both lists and merge
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        // Attach remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        return dummy.next;
    }
    
    /**
     * Recursive approach to merge two sorted lists.
     */
    public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        // Base cases
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        // Recursive case
        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
    }
    
    // Test cases
    public static void main(String[] args) {
        // Test case 1: Both lists have elements
        ListNode list1_1 = ListNode.createList(new int[]{1, 2, 4});
        ListNode list2_1 = ListNode.createList(new int[]{1, 3, 4});
        ListNode merged1 = mergeTwoLists(list1_1, list2_1);
        int[] expected1 = {1, 1, 2, 3, 4, 4};
        assert java.util.Arrays.equals(ListNode.toArray(merged1), expected1) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: [1,2,4] + [1,3,4] = [1,1,2,3,4,4]");
        
        // Test case 2: One list is empty
        ListNode list1_2 = null;
        ListNode list2_2 = ListNode.createList(new int[]{0});
        ListNode merged2 = mergeTwoLists(list1_2, list2_2);
        int[] expected2 = {0};
        assert java.util.Arrays.equals(ListNode.toArray(merged2), expected2) : "Test 2 failed";
        System.out.println("✓ Test 2 passed: null + [0] = [0]");
        
        // Test case 3: Both lists empty
        ListNode list1_3 = null;
        ListNode list2_3 = null;
        ListNode merged3 = mergeTwoLists(list1_3, list2_3);
        assert merged3 == null : "Test 3 failed";
        System.out.println("✓ Test 3 passed: null + null = null");
        
        // Test case 4: Different lengths
        ListNode list1_4 = ListNode.createList(new int[]{1, 2, 3, 4, 5});
        ListNode list2_4 = ListNode.createList(new int[]{1, 3});
        ListNode merged4 = mergeTwoLists(list1_4, list2_4);
        int[] expected4 = {1, 1, 2, 3, 3, 4, 5};
        assert java.util.Arrays.equals(ListNode.toArray(merged4), expected4) : "Test 4 failed";
        System.out.println("✓ Test 4 passed: Different length lists merged");
        
        // Test case 5: Recursive version
        ListNode list1_5 = ListNode.createList(new int[]{1, 2, 4});
        ListNode list2_5 = ListNode.createList(new int[]{1, 3, 4});
        ListNode merged5 = mergeTwoListsRecursive(list1_5, list2_5);
        int[] expected5 = {1, 1, 2, 3, 4, 4};
        assert java.util.Arrays.equals(ListNode.toArray(merged5), expected5) : "Test 5 failed";
        System.out.println("✓ Test 5 passed: Recursive merge works");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
