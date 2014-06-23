// Given a non-negative number represented as an array of digits, plus one to the number.
// The digits are stored such that the most significant digit is at the head of the list.


public class Solution {
    public int[] plusOne(int[] digits) {
        int add = 1;
        for(int i=digits.length-1; i>=0; i--) {
            int tmp = digits[i];
            digits[i] = (tmp+add)%10;
            add = (tmp+add)/10;
            if(add==0) return digits;
        }
        int[] ret = new int[digits.length+1];
        ret[0] = 1;
        System.arraycopy(digits, 0, ret, 1, digits.length);
        return ret;
    }
}
