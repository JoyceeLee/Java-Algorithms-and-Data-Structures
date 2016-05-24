/**
* Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
* 
* Note:
* Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
* The solution set must not contain duplicate triplets.
*     For example, given array S = {-1 0 1 2 -1 -4},
* 
*     A solution set is:
*     (-1, 0, 1)
*     (-1, -1, 2)
*/ 


public class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(num==null || num.length==0) {
            return ret;
        }
        Arrays.sort(num);
        for(int i=0; i<num.length-2; i++) {
            if(i!=0 && num[i]==num[i-1])
                continue;
            int s = i+1;
            int t = num.length-1;
            while(s<t) {
                if(num[i]+num[s]+num[t]==0) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(num[i]);
                    tmp.add(num[s]);
                    tmp.add(num[t]);
                    ret.add(tmp);
                    do{s++;} while(s<num.length && num[s]==num[s-1]);
                    do{t--;} while(t>-1 && num[t]==num[t+1]);
                } else if(num[i]+num[s]+num[t]<0) {
                    do{s++;} while(s<num.length && num[s]==num[s-1]);
                } else if(num[i]+num[s]+num[t]>0) {
                    do{t--;} while(t>-1 && num[t]==num[t+1]);
                }
            }
        }
        return ret;
    }
}
