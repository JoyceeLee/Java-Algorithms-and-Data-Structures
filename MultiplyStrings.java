/**
* Given two numbers represented as strings, return multiplication of the numbers as a string.
* 
* Note: The numbers can be arbitrarily large and are non-negative.
*/


public class Solution {
    public String multiply(String num1, String num2) {
        if(num1==null || num1.length()==0 || num2==null || num2.length()==0) {
            return null;
        }
        StringBuilder ret = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int[] nums = new int[len1+len2];
        int carry = 0;
        
        for(int i=len2-1; i>=0; i--) {
            int a = num1.charAt(i)-'0';
            for(int j=len1-1; j>=0; j--) {
                int b = num2.charAt(j)-'0';
                nums[i+j+1] += a*b+carry;
                carry = nums[i+j+1] / 10;
                nums[i+j+1] %= 10;
            }
            nums[i] += carry;
            carry = 0;
        }
        
        int i=0;
        while(i<nums.length-1 && nums[i]==0) {
            i++;
        }
        while(i<nums.length) {
            ret.append(nums[i]);
            i++;
        }
        return ret.toString();
    }
}
