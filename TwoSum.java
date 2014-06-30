/**
* Given an array of integers, find two numbers such that they add up to a specific target number.
* 
* The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
* 
* You may assume that each input would have exactly one solution.
* 
* Input: numbers={2, 7, 11, 15}, target=9
* Output: index1=1, index2=2
* /


public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = {-1, -1};
        if(numbers==null || numbers.length==0)
            return ret;
        int len = numbers.length;
        int[] sorted = new int[len];
        System.arraycopy(numbers, 0, sorted, 0, len);
        Arrays.sort(sorted);
        
        int idx1 = 0;
        int idx2 = len-1;
        while(idx1<idx2) {
            if(sorted[idx1]+sorted[idx2]==target) {
                for(int i=0; i<len; i++) {
                    if(numbers[i]==sorted[idx1] || numbers[i]==sorted[idx2]) {
                        if(ret[0]==-1) {
                            ret[0] = i+1;
                        } else {
                            ret[1] = i+1;
                            break;
                        }
                    }
                }
                break;
            } else if(sorted[idx1]+sorted[idx2]>target) {
                do{idx2--;} while(sorted[idx2]==sorted[idx2+1]);
            } else if(sorted[idx1]+sorted[idx2]<target) {
                do{idx1++;} while(sorted[idx1]==sorted[idx1-1]);
            }
        }
        return ret;
    }
}
