/**
 *
 */
class DoubleLinkedListNode {
    public int key;
    public int val;
    public DoubleLinkedListNode pre;
    public DoubleLinkedListNode next;
    public DoubleLinkedListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
public class LRUCache {
    private int cap;
    DoubleLinkedListNode head, tail;
    HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
    
    public LRUCache(int capacity) {
        this.cap = capacity;    
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            moveToHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void set(int key, int value) {
        if (map.containsKey(key)) {
            DoubleLinkedListNode node = map.get(key);
            node.val = value;
            moveToHead(node);
        } else {
            DoubleLinkedListNode node = new DoubleLinkedListNode(key, value);
            if (map.size() == this.cap)
                removeTail();
            node.next = head;
            if (head != null)
                head.pre = node;
            head = node;
            if (tail == null)
                tail = node;
            map.put(key, node);
        }
    }
    
    private void removeTail() {
        int del = tail.key;
        tail = tail.pre;
        if (tail != null)
            tail.next = null;
        map.remove(del);
    }
    
    private void moveToHead(DoubleLinkedListNode node) {
        if (node != head) {
            if (node == tail) {
                tail = node.pre;
            } else {
                node.next.pre = node.pre;
            }
            node.pre.next = node.next;
            node.pre = null;
            node.next = head;
            head.pre = node;
            head = node;
        }
    }
}
