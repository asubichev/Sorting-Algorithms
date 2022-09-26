package org.utd.sortinganalysis;

public class SelectionSort {
	/** The method for sorting the numbers */
	public static int[] selectionSort(int[] list) { //int[] list?
		int comparison = 0;
		int movement = 0;
		for (int i = 0; i < list.length -1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;
			
			for (int j = i+1; j < list.length; j++) {
				comparison++;
				if (currentMin > list[j]) {
					movement++;
					currentMin = list[j];
					currentMinIndex = j;
				}
			}
			
			//	Swap list[i] wiht list[currentMinIndex] if necessary
			comparison++;
			if (currentMinIndex != i) {
				movement++;
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
			}
		}
		return (new int[]{comparison, movement}); 
	}
}
