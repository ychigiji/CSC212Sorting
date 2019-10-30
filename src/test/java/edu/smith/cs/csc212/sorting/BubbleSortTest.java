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
public class BubbleSortTest {
	@Test
	public void testBubbleSort() {
		// See if the data can be reversed:
		ListADT<Integer> sortMe = new JavaList<>();
		for (int y : SortTestingHelpers.data) {
			sortMe.addBack(y);
		}
		BubbleSort.sort(sortMe);
		Assert.assertTrue(SortTestingHelpers.checkSorted(sortMe, SortTestingHelpers.data.length));
		
		Random rand = new Random(13);
		// For good measure, let's shuffle it and sort it again to see if that works, too.
		SortTestingHelpers.shuffle(sortMe, rand);
		BubbleSort.sort(sortMe);
		Assert.assertTrue(SortTestingHelpers.checkSorted(sortMe, SortTestingHelpers.data.length));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), SortTestingHelpers.data.length);
	}
	
	@Test
	public void testClassBubbleSort() {
		// See if the data can be reversed:
		List<Integer> data = Arrays.asList(35, 88, 11, 47, 14, 24, 41, 62, 27);
		ListADT<Integer> sortMe = new JavaList<>(data);
		
		BubbleSort.sort(sortMe);
		Assert.assertTrue(SortTestingHelpers.checkSorted(sortMe, data.size()));
		
		// check it is the original size
		Assert.assertEquals(sortMe.size(), 9);

	}
	
	@Test
	public void testSlice() {
		// This test is for me: testing that slicing given in the starter code works.
		
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
