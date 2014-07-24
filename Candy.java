/**
There are N children standing in a line. Each child is assigned a rating value.

You are giving candies to these children subjected to the following requirements:

Each child must have at least one candy.
Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

tips : higher, so equals could be 0
e.g. ratings = {2, 1, 1, 0}, candy = {1, 0, 1, 0}
       ratings = {0, 1, 1, 2}, candy = {0, 1, 0, 1}
*/


public class Solution {
    public int candy(int[] ratings) {
        if(ratings==null || ratings.length==0)
            return 0;
        int len = ratings.length;
        int[] candy = new int[len];
        
        // left scan
        for(int i=0; i<len; i++) {
            candy[i] = (i==0||ratings[i]<=ratings[i-1]) ? 1 : candy[i-1]+1;
        }
        // right scan
        for(int i=len-2; i>=0; i--) {
            if(ratings[i+1]<ratings[i] && candy[i+1]+1>candy[i]) {
                candy[i] = candy[i+1]+1;
            }
        }
        int sum = 0;
        for(int i=0; i<len; i++) {
            sum += candy[i];
        }
        return sum;
    }
}
