/**
 * ListNode - Basic node structure for linked list problems
 * 
 * This class represents a single node in a singly linked list.
 * Each node contains an integer value and a reference to the next node.
 */

public class ListNode {
    public int val;
    public ListNode next;
    
    /**
     * Constructor with value only
     * @param val the value to store in this node
     */
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
    
    /**
     * Constructor with value and next node
     * @param val the value to store in this node
     * @param next the next node in the list
     */
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    
    /**
     * Create a linked list from an array of values
     * @param values array of integer values
     * @return the head of the created linked list
     */
    public static ListNode createList(int[] values) {
        if (values == null || values.length == 0) {
            return null;
        }
        
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        
        return head;
    }
    
    /**
     * Convert a linked list to an array for easy comparison
     * @param head the head of the linked list
     * @return array representation of the linked list
     */
    public static int[] toArray(ListNode head) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        ListNode current = head;
        
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    
    /**
     * Print a linked list for debugging
     * @param head the head of the linked list
     */
    public static void printList(ListNode head) {
        ListNode current = head;
        System.out.print("List: ");
        
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    /**
     * Get the length of a linked list
     * @param head the head of the linked list
     * @return the length of the list
     */
    public static int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        
        while (current != null) {
            length++;
            current = current.next;
        }
        
        return length;
    }
    
    /**
     * Check if two linked lists are equal
     * @param head1 head of first list
     * @param head2 head of second list
     * @return true if lists are equal, false otherwise
     */
    public static boolean isEqual(ListNode head1, ListNode head2) {
        ListNode current1 = head1;
        ListNode current2 = head2;
        
        while (current1 != null && current2 != null) {
            if (current1.val != current2.val) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        
        return current1 == null && current2 == null;
    }
}
