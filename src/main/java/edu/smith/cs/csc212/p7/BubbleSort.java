package edu.smith.cs.csc212.p7;

import java.util.List;

public class BubbleSort {
	public static boolean isSorted(List<Integer> items) {
		for (int i=0; i<items.size()-1; i++) {
			if (items.get(i) >= items.get(i+1)) {
				return false;
			}
		}
		return true;
	}
	
	public static void swap(List<Integer> items, int i, int j) {
		int tmp = items.get(i);
		items.set(i,  items.get(j));
		items.set(j, tmp);
	}
	public static void bubbleSort(List<Integer> input) {
		int N = input.size();
		
		System.out.println("Sorting: "+input);

		while(true) {
			boolean sorted = true;
			for (int i=0; i<N-1; i++) {
				if (input.get(i) >= input.get(i+1)) {
					swap(input, i, i+1);
					sorted = false;
				}
			}
			if (!sorted) {
				break;
			}
			N = N - 1;
		}
	}
}
