/**
* Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
* 
* For example,
* Given height = [2,1,5,6,2,3],
* return 10.
* /

public class Solution {
    public int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<Integer>();
        int max = 0;
        int i = 0;
        while(i<height.length) {
            if(s.isEmpty() || height[s.peek()]<=height[i]) {
                s.push(i);
                i++;
            } else {
                int h = height[s.pop()];
                int w = s.isEmpty()? i : i-s.peek()-1;
                max = Math.max(max, h*w);
            }
        }
        while(!s.isEmpty()) {
            int h = height[s.pop()];
            int w = s.isEmpty()? i : i-s.peek()-1;
            max = Math.max(max, h*w);
        }
        return max;
    }
}
