/**
 * Problem 19: Merge K Sorted Lists
 * 
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * Time Complexity: O(nk log k)
 * Space Complexity: O(k)
 */

public class MergeKSortedLists {
    
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        java.util.PriorityQueue<ListNode> minHeap = new java.util.PriorityQueue<>(
            (a, b) -> a.val - b.val
        );
        
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;
            
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.createList(new int[]{1, 4, 5});
        lists[1] = ListNode.createList(new int[]{1, 3, 4});
        lists[2] = ListNode.createList(new int[]{2, 6});
        
        ListNode result = mergeKLists(lists);
        int[] expected = {1, 1, 2, 3, 4, 4, 5, 6};
        assert java.util.Arrays.equals(ListNode.toArray(result), expected) : "Test 1 failed";
        System.out.println("✓ Test 1 passed: Merge K sorted lists");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
