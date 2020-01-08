package edu.smith.cs.csc212.sorting;
import me.jjfoley.adt.ListADT;
import me.jjfoley.adt.impl.JavaList;


/**
 * BubbleSort is a simple sort that is O(n^2).
 * @author yolandanyasha
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
			
			for (int i=0; i < N-1; i++) {
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

	public static ListADT<Integer> insertionSort(ListADT<Integer> input){
		/**
		 * 
		 * @param input the list to be sorted
		 * @return  sortedList
		 */
		int N = input.size();
		ListADT<Integer> sortedList = new JavaList<>();
		ListADT<Integer> mylist = input;
		
//			System.out.println("unsorted is " + mylist.toString());
			 for(int i=0;i<N;i++){
				 boolean found = false;
				 int value = mylist.getIndex(i);
				 for(int j = 0; j < sortedList.size(); j++) { 
					 if ( value < sortedList.getIndex(j)) {
						 sortedList.addIndex(j, value);
						 found = true;
						 break;
					 }	 
				 }
				 if (!found) {
					sortedList.addBack(value);
		          }       
			 }
			 return sortedList;
		}
	private static void insertSorted(ListADT<Integer> items, int num) {
	    for (int i = 0; i < items.size(); i++) {
	        if (items.getIndex(i) >= num) {
	            items.addIndex(i, num);
	            // found where it goes, stop looking!
	            return;
	        }
	    }
	}
	public static ListADT<Integer> insertioSort(ListADT<Integer> items) {
	    ListADT<Integer> output = new JavaList<>();
	    for (int i=0; i<items.size(); i++) {
	        insertSorted(output, items.getIndex(i));
	        System.out.println(i+": "+output);
	    }
	    return output;
	}
	public static void selectionSort(ListADT<Integer> mylist) {
		
		 /**
		  * 
		  */
//		System.out.println("select unsorted = " + mylist.toString());
		int N = mylist.size();
		int min = 0; // assume first element 
		boolean sorted = true; 
		while(sorted) {
			int minValue = mylist.getIndex(min);
			int minIndex = min;
			for (int j = min; j< N; j++) {
				if (mylist.getIndex(j) < minValue){
					minValue = mylist.getIndex(j);
					minIndex = j;
				}	
			}
			mylist.swap(min,minIndex);
			min++;
			if (min==N) {
				break;
			}
		}
//		System.out.println("select sorted = " + mylist.toString());
	}

	public  static ListADT<Integer> recursiveMergeSort(ListADT<Integer> mylist) {
	//System.out.println("unsorted = "+mylist.toString());
	if (mylist.size()==1) {
		return mylist;
	}
	int midpoint = mylist.size()/2;
	ListADT<Integer> left = mylist.slice(0,  midpoint);
	ListADT<Integer> right = mylist.slice( midpoint, mylist.size());
	left = recursiveMergeSort(left);
	right = recursiveMergeSort(right);
	return combineHelper(left, right);
	}
	
	public  static ListADT<Integer> iterativeMergeSort(ListADT<Integer> mylist) {
		int N = mylist.size();
		DoublyLinkedList<ListADT<Integer>> queue = new DoublyLinkedList<>();
		
		for(int i: mylist) {
			ListADT<Integer> number = new JavaList<>();
			number.addFront(i);
			queue.addBack(number);
		}
		for(int i =0; i< N; i++) {
			if(queue.size()==1) {
				break;
			}
			ListADT<Integer> A = queue.removeFront();
			ListADT<Integer> B = queue.removeBack();
			ListADT<Integer> C = combineHelper(A,B);
			queue.addBack(C);
		}
	return queue.getFront();
	}
	
	public static ListADT<Integer> combineHelper(ListADT<Integer> list1, ListADT<Integer>list2){
		ListADT<Integer> sortedList = new JavaList<>();
		boolean sort = true;
		
		while (sort) {
			int list1Value = list1.getIndex(0);
			int list2Value = list2.getIndex(0);
			
			if (list1Value < list2Value) {
				sortedList.addBack(list1Value);
				list1.removeFront();
			}
			else {
				sortedList.addBack(list2Value);
				list2.removeFront();	
			}
			if(list1.isEmpty() || list2.isEmpty()) {
				sort = false;	
			}
		}
		if (!list1.isEmpty()&&list2.isEmpty()) {
			sortedList.addAll(list1);
		}
		else if(!list2.isEmpty()&&list1.isEmpty()) {
			sortedList.addAll(list2);
		}
		//System.out.println("sorted = " + sortedList.toString());
		return sortedList;
	}
}
	

