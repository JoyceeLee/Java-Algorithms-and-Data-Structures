/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
 

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points==null || points.length==0)
            return 0;
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
        int dup = 0;
        int max = 1;
        for(int i=0; i<points.length; i++) {
            dup=0;
            map.clear();
            for(int j=i+1; j<points.length; j++) {
                if(points[j].x==points[i].x && points[j].y==points[i].y) {
                    dup++;
                } else if(points[j].x==points[i].x){
                    if(map.containsKey(Double.MAX_VALUE)) {
                        map.put(Double.MAX_VALUE, map.get(Double.MAX_VALUE)+1);
                    } else {
                        map.put(Double.MAX_VALUE, 1);
                    }
                } else {
                    double k = 0.0 + ((double)(points[i].y-points[j].y)) / ((double)(points[i].x-points[j].x)); // +|-0.0
                    if(map.containsKey(k)) {
                        map.put(k, map.get(k)+1);
                    } else {
                        map.put(k, 1);
                    }
                }
            }
            if(1+dup>max) {
                max = 1+dup;
            }
            for(Integer n : map.values()) {
                if(n+1+dup>max) {
                    max = n+1+dup;
                }
            }
        }
        return max;
    }
}
