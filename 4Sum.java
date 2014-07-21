/**
* Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
* 
* Note:
* Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
* The solution set must not contain duplicate quadruplets.
*     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
* 
*     A solution set is:
*     (-1,  0, 0, 1)
*     (-2, -1, 1, 2)
*     (-2,  0, 0, 2)
*/


public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(num==null || num.length<4) {
            return ret;
        }
        Arrays.sort(num);
        for(int i=0; i<num.length-3; i++) {
            if(i!=0 && num[i]==num[i-1]) {
                continue;
            }
            for(int j=i+1; j<num.length-2; j++) {
                if(j!=i+1 && num[j]==num[j-1]) {
                    continue;
                }
                int s = j+1;
                int t = num.length-1;
                while(s<t) {
                    if(num[i]+num[j]+num[s]+num[t]==target) {
                        List<Integer> tmp = new ArrayList<Integer>();
                        tmp.add(num[i]);
                        tmp.add(num[j]);
                        tmp.add(num[s]);
                        tmp.add(num[t]);
                        ret.add(tmp);
                        do{s++;} while(s<t && num[s]==num[s-1]);
                        do{t--;} while(s<t && num[t]==num[t+1]);
                    } else if(num[i]+num[j]+num[s]+num[t]>target) {
                        do{t--;} while(s<t && num[t]==num[t+1]);
                    } else if(num[i]+num[j]+num[s]+num[t]<target) {
                        do{s++;} while(s<t && num[s]==num[s-1]);
                    }
                }
            }
        }
        return ret;
    }
}
