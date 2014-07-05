/**
* Given a collection of numbers that might contain duplicates, return all possible unique permutations.
* 
* For example,
* [1,1,2] have the following unique permutations:
* [1,1,2], [1,2,1], and [2,1,1].
* /


public class Solution {    
    public List<List<Integer>> permuteUnique(int[] num) {    
       List<List<Integer>> ret = new ArrayList<List<Integer>>();
       List<Integer> cur = new ArrayList<Integer>();
       Arrays.sort(num);
       boolean[] visited = new boolean[num.length];
       permuteImp(ret, cur, visited, num);
       return ret;
    }    
    private void permuteImp(List<List<Integer>> ret, List<Integer> cur, boolean[] visited, int[] num){    
       if(cur.size()==num.length) {
           ret.add(new ArrayList<Integer>(cur));
           return;
       }
       for(int i=0; i<num.length; i++) {
           if(!visited[i]) {
               cur.add(num[i]);
               visited[i] = true;
               permuteImp(ret, cur, visited, num);
               visited[i] = false;
               cur.remove(cur.size()-1);
               while(i+1<num.length && num[i]==num[i+1])
                   i++;
           }
       }
    }    
}    
