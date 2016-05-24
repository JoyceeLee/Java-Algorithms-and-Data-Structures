/**
* Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
* 
* If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
* 
* The replacement must be in-place, do not allocate extra memory.
* 
* Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
* 1,2,3 → 1,3,2
* 3,2,1 → 1,2,3
* 1,1,5 → 1,5,1
* /


public class Solution {
    public void nextPermutation(int[] num) {
        int idx = num.length-1;
        while(idx>0 && num[idx-1]>=num[idx]) {
            idx--;
        }
        if(idx>0) {
            idx--; //
            int next = num.length-1;
            while(next>idx && num[next]<=num[idx]) {
                next--;
            }
            int swap = num[next];
            num[next] = num[idx];
            num[idx] = swap;
            idx++; //
        }
        int end = num.length-1;
        while(idx<end) {
            int tmp = num[end];
            num[end] = num[idx];
            num[idx] = tmp;
            end--;
            idx++;
        }
    }
}
