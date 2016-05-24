/*
 * We have an array arr[0 . . . n-1]. We should be able to
 * 1. Find the sum of first i elements.
 * 2. Change value of a specified element of the array arr[i] = x where 0 <= i <= n-1.
 *
 * To do both tasks in O(Logn) time.
 */
 
 // The advantages of Binary Indexed Tree over Segment are, requires less space and very easy to implement
 
 public class BITree {
	private int[] bitree;
	
	public BITree (int[] arr) {
		bitree = new int[arr.length+1];
		
		for (int i = 0; i < arr.length; i++) {
			updateBIT(arr.length, i, arr[i]);
		}
	}
	
	public void updateBIT(int n, int i, int val) {
		i += 1;
		
		while (i <= n) {
			bitree[i] += val;
			i += i & (-i);
		}
	}
	
	// return sum of arr[0...i]
	public int getSum(int i) {
		int sum = 0;
		i+= 1;
		
		while (i > 0) {
			sum += bitree[i];
			i -= i & (-i);
		}
		return sum;
	}
}
