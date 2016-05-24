/**
* The set [1,2,3,…,n] contains a total of n! unique permutations.
* 
* By listing and labeling all of the permutations in order,
* We get the following sequence (ie, for n = 3):
* 
* "123"
* "132"
* "213"
* "231"
* "312"
* "321"
* Given n and k, return the kth permutation sequence.
* 
* Note: Given n will be between 1 and 9 inclusive.
* /


public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for(int i=1; i<=n; i++) {
            numList.add(i);
        }
        k--;
        int mod = 1;
        for(int i=1; i<=n; i++) {
            mod *= i;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            mod /= (n-i);
            int idx = k / mod;
            k %= mod;
            sb.append(numList.get(idx));
            numList.remove(idx);
        }
        return sb.toString();
    }
}
