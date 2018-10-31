package edu.smith.cs.csc212.p7;

import java.util.List;

public class TestSorting {
	/**
	 * This is useful for testing whether sort algorithms work!
	 * @param items - the list of integers.
	 * @return true if it is sorted, false if not.
	 */
	private static boolean isSorted(List<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.get(i) >= items.get(i+1)) {
				return false;
			}
		}
		return true;
	}
	
	@Test
	public void testBubbleSort() {
		
	}
	
}
