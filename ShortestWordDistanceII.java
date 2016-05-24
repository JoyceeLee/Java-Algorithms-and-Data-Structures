/**
 * The only difference is now you are given the list of words and your method will be called repeatedly many 
 * times with different parameters. How would you optimize it?
 */
public class WordDistance {
    private HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();

    public WordDistance(String[] words) {
        for (int i=0; i<words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0, j = 0;
        int dist = Integer.MAX_VALUE;
        while (i<list1.size() && j<list2.size()) {
            int p1 = list1.get(i);
            int p2 = list2.get(j);
            dist = Math.min(dist, Math.abs(p2-p1));
            if (p1 < p2) i++;
            else j++;
        }
        return dist;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
