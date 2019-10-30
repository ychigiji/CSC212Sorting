package edu.smith.cs.csc212.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import edu.smith.cs.csc212.sorting.BubbleSort;
import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;

@SuppressWarnings("javadoc")
public class TestSorting {
	/**
	 * This is useful for testing whether sort algorithms work!
	 * @param items - the list of integers.
	 * @return true if it is sorted, false if not.
	 */
	private static boolean checkSorted(ListADT<Integer> items, int originalSize) {
		Assert.assertEquals(originalSize, items.size());
		for (int i=0; i<items.size()-1; i++) {
			if (items.getIndex(i) > items.getIndex(i+1)) {
				System.err.println("items out of order: "+items.getIndex(i)+", "+items.getIndex(i+1) + " at index="+i);
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Here's some data!
	 */
	private static int[] data = {9,8,7,6,5,4,4,3,2,1};
	
	private static <T> void shuffle(ListADT<T> list, Random rand) {
		for (int i=list.size()-1; i>=1; i--) {
			int j = rand.nextInt(i+1);
			BubbleSort.swap(list, i, j);
		}
	}
	
	@Test
	public void testBubbleSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : data) {
			sortMe.addBack(y);
		}
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe, data.length));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		shuffle(sortMe, rand);
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe, data.length));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), data.length);
	}
	
	@Test
	public void testClassBubbleSort() {
		// See if the data can be reversed:
		List<Integer> data = Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27);
		ListADT<Integer> sortMe = new JavaList<>(data);
		
		BubbleSort.bubbleSort(sortMe);
		Assert.assertTrue(checkSorted(sortMe, data.size()));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), 9);

	}
	
	@Test
	public void testSlice() {
		ListADT<Integer> sortMe = new JavaList<>(Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27));
		int mid = sortMe.size()/2;
		ListADT<Integer> leftSlice = sortMe.slice(0, mid);
		ListADT<Integer> rightSlice = sortMe.slice(mid, sortMe.size());
		
		Assert.assertEquals(leftSlice.toJava(), Arrays.asList(35, 88, 11, 47));
		Assert.assertEquals(rightSlice.toJava(), Arrays.asList(14, 24, 41, 62, 27));
		
		Assert.assertEquals(14, (int) rightSlice.removeFront());
		Assert.assertEquals(4, rightSlice.size());
		Assert.assertEquals(27, (int) rightSlice.removeBack());
		Assert.assertEquals(3, rightSlice.size());
	}


}
