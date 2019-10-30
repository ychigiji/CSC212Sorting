package edu.smith.cs.csc212.sorting;

import me.jjfoley.adt.ListADT;

/**
 * BubbleSort is a simple sort that is O(n^2).
 * @author jfoley
 *
 */
public class BubbleSort {
	/**
	 * Bubble Sort is done! And it is easy to do in-place (without creating a new list!)
	 * @param input - the list to be sorted.
	 */
	public static void sort(ListADT<Integer> input) {
		int N = input.size();
		
		while(true) {
			boolean sorted = true;
			for (int i=0; i<N-1; i++) {
				if (input.getIndex(i) > input.getIndex(i+1)) {
					input.swap(i, i+1);
					sorted = false;
				}
			}
			if (sorted) {
				break;
			}
			N = N - 1;
		}
	}
}
