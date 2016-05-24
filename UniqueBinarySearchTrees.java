// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

// For example,
// Given n = 3, there are a total of 5 unique BST’s.


public class Solution {
    public int numTrees(int n) {
        int num = 0;
        if(n == 1 || n == 0) return 1;
        else {
            for(int i = 1; i <= n; i++) {
                num = num + numTrees(i-1) * numTrees(n-i);
            }
            return num;
        }
    }
}
