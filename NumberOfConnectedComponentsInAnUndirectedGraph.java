/*
Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.

Example 1:
     0          3
     |          |
     1 --- 2    4
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:
     0           4
     |           |
     1 --- 2 --- 3
Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:
You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
 
Solution 1. Union Find
public class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int[] e : edges) {
            int root1 = findRoot(e[0], root);
            int root2 = findRoot(e[1], root);
            if (root1 != root2) {
                root[root2] = root1;
                n--;
            }
        }
        return n;
    }
    private int findRoot(int i, int[] root) {
        while (root[i] != i) {
            root[i] = root[root[i]]; // optional, path compress
            i = root[i];
        }
        return i;
    }
}
