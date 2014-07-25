// Divide two integers without using multiplication, division and mod operator.


public class Solution {
    public int divide(int dividend, int divisor) {
       long a = Math.abs((long)dividend);
       long b = Math.abs((long)divisor);
       long ret = 0;
       while(a>=b) {
           long c = b;
           for(int i=0; a>=c; i++, c<<=1) {
               a -= c;
               ret += 1<<i;
           }
       }
       return ((dividend ^ divisor)>>31) == 1 ? (int)-ret:(int)ret;
    }
}
