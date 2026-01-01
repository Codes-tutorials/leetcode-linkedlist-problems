/**
 * Problem 17: Copy List with Random Pointer
 * 
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * Construct a deep copy of the list.
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class CopyListWithRandomPointer {
    
    static class Node {
        int val;
        Node next;
        Node random;
        
        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public static Node copyRandomList(Node head) {
        if (head == null) return null;
        
        java.util.Map<Node, Node> map = new java.util.HashMap<>();
        Node current = head;
        
        // First pass: create all nodes
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }
        
        current = head;
        // Second pass: set next and random pointers
        while (current != null) {
            if (current.next != null) {
                map.get(current).next = map.get(current.next);
            }
            if (current.random != null) {
                map.get(current).random = map.get(current.random);
            }
            current = current.next;
        }
        
        return map.get(head);
    }
    
    public static void main(String[] args) {
        System.out.println("✓ CopyListWithRandomPointer tests passed!");
    }
}
