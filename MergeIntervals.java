/**
* Given a collection of intervals, merge all overlapping intervals.
* 
* For example,
* Given [1,3],[2,6],[8,10],[15,18],
* return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */


public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<Interval>();
        if(intervals==null || intervals.size()==0)
            return ret;
        PriorityQueue<Interval> que = new PriorityQueue<Interval>(intervals.size(),
            new Comparator<Interval>() {
                public int compare(Interval a, Interval b) {
                    if(a.start>b.start) return 1;
                    else if(a.start<b.start) return -1;
                    else return 0;
                }
            }
        );
        que.addAll(intervals);
        Interval tmp = que.poll();
        while(!que.isEmpty()) {
            if(tmp.end<que.peek().start) {
                ret.add(tmp);
                tmp = que.poll();
            } else {
                tmp.end = Math.max(tmp.end, que.peek().end);
                que.poll();
            }
        }
        ret.add(tmp);
        return ret;
    }
}
