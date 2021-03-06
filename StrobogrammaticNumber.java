/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic
 */ 
// 0-0, 1-1, 6-9, 8-8
public class Solution {
    public boolean isStrobogrammatic(String num) {
        int i = 0, j = num.length()-1;
        while (i <= j) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(j);
            if (c1==c2) {
                if (c1=='0' || c1=='1' || c1=='8') {
                    i++;
                    j--;
                } else {
                    return false;
                }
            } else {
                if (c1=='6' && c2=='9') {
                    i++;
                    j--;
                } else if (c1=='9' && c2=='6') {
                    i++;
                    j--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
