/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * 
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * 
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * 
 * Note:
 * The read function may be called multiple times.
 */
 
 /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] tmp = new char[4];
    private int pt1 = 0, pt2 = 0;
    public int read(char[] buf, int n) {
        int cnt = Math.min(n, pt2-pt1);
        int i = 0;
        
        // Read from tmp
        while (i < cnt) {
            buf[i++] = tmp[pt1++];
        }
        
        if (cnt == n) {
            return n;
        } else {
            while (cnt < n) {
                int k = read4(tmp);
                pt1 = 0;
                pt2 = k;
                while (pt1 < pt2 && cnt < n) {
                    buf[i++] = tmp[pt1++];
                    cnt++;
                }
                if (k < 4) { //Reach the end of file
                    return cnt;
                }
            }
        }
        return cnt;
    }
}
