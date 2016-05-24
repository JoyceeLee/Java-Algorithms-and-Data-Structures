// Reverse digits of an integer.

// Example1: x = 123, return 321
// Example2: x = -123, return -321


public class Solution {
    public int reverse(int x) {
        int re = 0;
        while(x!=0){
            re = re*10+x%10;
            x = x / 10;
        }
        return re;
    }
}
