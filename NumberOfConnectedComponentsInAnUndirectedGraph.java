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
        if (n <= 1) return n; 
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


Solution 2. DFS
public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) return n;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new LinkedList<Integer>());
        }
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<Integer>();
        
        int cnt = 0; 
        for (int i = 0; i < n; i++) {
            if (visited.add(i)) {
                dfsFind(i, visited, map);
                cnt++;
            }
        }
        return cnt;
    }
    private void dfsFind(int i, Set<Integer>visited, Map<Integer, List<Integer>> map) {
        for (int j : map.get(i)) {
            if(visited.add(j)) {
                dfsFind(j, visited, map);
            }
        }
    }
}
