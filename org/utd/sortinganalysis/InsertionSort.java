package org.utd.sortinganalysis;

public class InsertionSort {
	/**The method for sorting the numbers */
	public static int[] insertionSort(int[] list) {
		int comparison = 0;
		int movement = 0;
		for (int i = 1; i < list.length; i++) {
			/** Insert list[i] into a sorted sublist list[0..i-1] so that 
			 * 	list[0..i] is sorted
			 */
			int currentElement = list[i];
			int k;
			for (k = i-1; k>= 0 && list[k] > currentElement; k--, comparison++) {
				movement++;//moving previous element one over
				list[k+1] = list[k];
			}
			
			//insert the current element into list[k + 1]
			//moving element into [k+1]
			if(list[k+1] != currentElement)//this is tecnically a comparison, but it's not part of the algo, so I'm not counting it
				movement++;
			list[k + 1] = currentElement;
			
		}
		//I believe I HAVE to use "new" here, since
		//I'm not sure if there's a way to just return [elem1, elem2]
		return (new int[]{comparison, movement});
	}
}
