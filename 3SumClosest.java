/**
* Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
* 
*     For example, given array S = {-1 2 1 -4}, and target = 1.
* 
*     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/


public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num==null || num.length<3)
            return 0;
        Arrays.sort(num);
        int ret = num[0]+num[1]+num[2];
        for(int i=0; i<num.length-2; i++) {
            if(i!=0 && num[i]==num[i-1]) {
                continue;
            }
            int s = i+1;
            int t = num.length-1;
            while(s<t) {
                if(Math.abs(num[i]+num[s]+num[t]-target)<Math.abs(ret-target)) {
                    ret = num[i]+num[s]+num[t];
                }
                if((num[i]+num[s]+num[t])==target) {
                    return ret;
                } else if(num[i]+num[s]+num[t]>target) {
                    do {t--;} while(s<t && num[t]==num[t+1]);
                } else if(num[i]+num[s]+num[t]<target) {
                    do {s++;} while(s<t && num[s]==num[s-1]);
                }
            }
        }
        return ret;
    }
}
