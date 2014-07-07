Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


import java.util.*;


public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if(lists==null || lists.size()==0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(),
        new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                if(l1.val>l2.val) return 1;
                else if(l1.val<l2.val) return -1;
                else return 0;
            }
        });
        for(ListNode list : lists) {
            if(list!=null)
                pq.offer(list);
        }
        ListNode prehead = new ListNode(-1);
        ListNode run = prehead;
        while(!pq.isEmpty()) {
            run.next = pq.poll();
            run = run.next;
            if(run.next!=null) { // 
                pq.offer(run.next);
            }
        }
        return prehead.next;
    }
}
