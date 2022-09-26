package org.utd.sortinganalysis;
public class QuickSort {
	private static int comparisons = 0;
	private static int movements = 0;

	public static void quickSort(int[] list) {
		comparisons = 0;
		movements = 0;
		quickSort(list, 0, list.length-1);
	}
	
	public static void quickSort(int[] list, int first, int last) {
		comparisons++;
		if (last > first) {
			int pivotIndex = partition(list, first, last);
			quickSort(list, first, pivotIndex -1);
			quickSort(list, pivotIndex + 1, last);
		}
	}
	
	/** Partition the array list[first..last] */
	public static int partition(int[] list, int first, int last) {
		int pivot = list[first]; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; //Index for backward search
		
		comparisons++;
		while (high > low) {
			// Search forward from left
			comparisons+=2;
			while (low <= high && list[low] <= pivot) { comparisons+=2; low++; }
			
			// Search backward from right
			comparisons+=2;
			while (low <= high && list[high] > pivot) { comparisons+=2; high--; }
			
			//	Swap two elements in the list
			comparisons++;
			if (high > low) {
				movements++;
				int temp = list[high];
				list[high] = list[low];
				list[low] = temp;
			}
		}
		
		comparisons+=2;
		while (high > first && list[high] >= pivot) { comparisons+=2; high--; }
		
		//	Swap pivot with list[high]
		comparisons++;
		if (pivot > list[high]) {
			movements++;
			list[first] = list[high];
			list[high] = pivot; 
			return high;
		}
		else {
			return first;
		}
	}

	public static int getComparisons() { return comparisons; }
	public static int getMovements() { return movements; }
	
}
