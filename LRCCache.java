/**
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
 * 
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 */


class DoubleLinkedListNode {
     public int val;
     public int key;
     public DoubleLinkedListNode pre;
     public DoubleLinkedListNode next;
     public DoubleLinkedListNode(int key, int value) {
          this.val = value;
          this.key = key;
     }
}
public class LRUCache {
     private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
     private DoubleLinkedListNode head;
     private DoubleLinkedListNode end;
     private int capacity;
     private int len;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        len = 0;
    }
   

    public void removeNode(DoubleLinkedListNode node) { // only remove from the double linked list, not form the map
          DoubleLinkedListNode cur = node;
          DoubleLinkedListNode pre = cur.pre;
          DoubleLinkedListNode post = cur.next;
         
          if (pre != null) {
               pre.next = post;
          } else {
               head = post;
          }
 
          if (post != null) {
               post.pre = pre;
          } else {
               end = pre;
          }
     }
 
     public void setHead(DoubleLinkedListNode node) {
          node.next = head;
          node.pre = null;
         
          if (head != null) {
               head.pre = node;
          }
          head = node;
     
          if (end == null) {
               end = node;
          }
     }


    public int get(int key) {
        if (map.containsKey(key)) {
               DoubleLinkedListNode latest = map.get(key);
               removeNode(latest); // only remove from the double linked list, not form the map
               setHead(latest); //
               return latest.val; //
          } else {
               return -1;
          }
    }
    
    public void set(int key, int value) {
          if (map.containsKey(key)) {
               DoubleLinkedListNode oldNode = map.get(key);
               oldNode.val = value;
               removeNode(oldNode); //
               setHead(oldNode); //
          } else {
               DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
               if (len < capacity) {
                    setHead(newNode); //
                    map.put(key, newNode); 
                    len++;
               } else {
                    removeNode(end); //
                    setHead(newNode); //
                    map.put(key, newNode);
               }
          }
    }
}
