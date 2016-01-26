/**
 */

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int tmp = 0;
        int ans = 0;
        char[] nbuf = new char[4];
        while((tmp = read4(nbuf)) != 0) {
            for(int i = 0; i < tmp; i++) {
                if(ans == n) return ans;
                buf[ans++] = nbuf[i];
            }
        }
        return ans;
    }
}
