import java.util.Arrays;

/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Shih Hsuan Lin
 */
public class RecursionFun {

	// Complete recursive method combinations that returns from n choose k.
	// This method is described in 17_SimpleRecursion.pptx.
	public int combinations(int n, int k) {
		if (k == 1)
			return n;
		if (n == k)
			return 1;
		return combinations(n - 1, k - 1) + combinations(n - 1, k);
	}

	// Complete recursive method intWithCommas that returns the argument as a String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		// TODO: Implement this method using recursion. Do not use a loop
		if (n > 999) {
			if (n % 1000 < 10)
				return "" + intWithCommas(n / 1000) + "," + "00" + n % 1000;
			if (n % 1000 < 100)
				return "" + intWithCommas(n / 1000) + "," + "0" + n % 1000;
			return "" + intWithCommas(n / 1000) + "," + n % 1000;
		} else
			return "" + n;
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length - 1);
	}

	private void reverseArray(int[] x, int index, int len) {
		// TODO: Complete this method with a recursive algorithm.
		// Do NOT use a loop.
		if (index >= len)
			return;
		int temp = x[index];
		x[index] = x[len];
		x[len] = temp;
		reverseArray(x, index + 1, len - 1);
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		return arrayRange(a, 0, a[0], a[0]);
	}

	private int arrayRange(int[] a, int index, int max, int min) {
		if (index == a.length) {
			if (index == 0)
				return 0;
			else
				return max - min;
		} else {
			return arrayRange(a, index + 1, Math.max(a[index], max), Math.min(a[index], min));
		}
	}

	// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		// Need to send down 0 to keep track of the index
		if (nums.length <= 1)
			return true;
		if (nums[nums.length - 1] < nums[nums.length - 2])
			return false;
		return isSorted(Arrays.copyOfRange(nums, 0, nums.length - 1));
	}

	// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		if (strs.length == 0)
			return false;
		if (strs[strs.length - 1].equals(search))
			return true;
		return found(search, Arrays.copyOfRange(strs, 0, strs.length - 1));
	}
}
