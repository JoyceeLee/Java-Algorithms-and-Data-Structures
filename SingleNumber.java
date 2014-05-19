// Given an array of integers, every element appears twice except for one. Find that single one.
// Note:
// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?


public class Solution {
    public int singleNumber(int[] A) {
        int len = A.length;
        int sing = A[0];
        if(len>1)
        {
            for(int i = 1;i<len;i++)
            {
                sing = sing ^ A[i]; // "^"
            }
        }
        return sing;
    }
}