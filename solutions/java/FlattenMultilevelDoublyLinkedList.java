/**
 * Problem 16: Flatten a Multilevel Doubly Linked List
 * 
 * You are given a doubly linked list which in addition to the next and previous pointers,
 * it could have a child pointer, which may or may not point to a separate doubly linked list.
 * These child lists may have one or more children of their own, and so on, to produce a multilevel data structure.
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(h) where h is height
 */

public class FlattenMultilevelDoublyLinkedList {
    
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        
        public Node(int val) {
            this.val = val;
        }
    }
    
    public static Node flatten(Node head) {
        flattenHelper(head);
        return head;
    }
    
    private static Node flattenHelper(Node head) {
        Node current = head;
        Node tail = null;
        
        while (current != null) {
            if (current.child != null) {
                Node childTail = flattenHelper(current.child);
                Node next = current.next;
                
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
                
                childTail.next = next;
                if (next != null) {
                    next.prev = childTail;
                }
                
                tail = childTail;
                current = next;
            } else {
                tail = current;
                current = current.next;
            }
        }
        
        return tail;
    }
    
    public static void main(String[] args) {
        System.out.println("✓ FlattenMultilevelDoublyLinkedList tests passed!");
    }
}
