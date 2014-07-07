// A linked list is given such that each node contains an additional random pointer 
// which could point to any node in the list or null.

// Return a deep copy of the list.


/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode run = head;
        while(run!=null) {
            map.put(run, new RandomListNode(run.label));
            run = run.next;
        }
        run = head;
        RandomListNode first = null;
        RandomListNode cur = null;
        while(run!=null) {
            if(first==null) {
                first = map.get(run);
                cur = first;
            } else {
                cur.next = map.get(run);
                cur = cur.next;
            }
            if(run.random!=null) {
                cur.random = map.get(run.random);
            }
            run = run.next;
        }
        return first;
    }
}
