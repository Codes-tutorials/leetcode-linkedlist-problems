/**
 * Problem 18: LRU Cache
 * 
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * 
 * Time Complexity: O(1) for both get and put
 * Space Complexity: O(capacity)
 */

public class LRUCache {
    
    static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int capacity;
    private java.util.Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new java.util.HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            
            if (cache.size() > capacity) {
                Node removed = tail.prev;
                removeNode(removed);
                cache.remove(removed.key);
            }
        }
    }
    
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assert cache.get(1) == 1 : "Test 1 failed";
        System.out.println("✓ Test 1 passed: LRU Cache get");
        
        cache.put(3, 3);
        assert cache.get(2) == -1 : "Test 2 failed";
        System.out.println("✓ Test 2 passed: LRU Cache eviction");
        
        System.out.println("\nAll tests passed! ✓");
    }
}
