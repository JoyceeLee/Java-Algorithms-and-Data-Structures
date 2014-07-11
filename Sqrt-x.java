// Implement int sqrt(int x).

// Compute and return the square root of x.


public class Solution {
    public int sqrt(int x) {
        long low = 0;
        long high = x/2+1;
        while(low<=hight) {
            long mid = (low+high)/2;
            long sqr = mid * mid;
            if(sqr==x) return (int)mid;
            else if(sqr<x) low = mid+1;
            else high = mid-1;
        }
        return (int)high;
    ｝
｝
    
    
