package org.utd.sortinganalysis;
public class HeapSort {
	/** Heap sort method */
	public static <E extends Comparable<E>> int[] heapSort(E[] list) {
		//	Create a Heap of integers
		Heap<E> heap = new Heap<>();
		
		//	Add elements to the heap
		for (int i = 0; i < list.length; i++)
			heap.add(list[i]);
		
		//	Remove elements from the heap
		for (int i = list.length -1; i >= 0; i--)
			list[i] = heap.remove();

		return (new int[]{Heap.getComparisons(), Heap.getMovement()});
	}
	
	
 	/**	A test method */
	// public static void main(String[] args) {
	// 	Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
	// 	heapSort(list);
	// 	for(int i = 0; i < list.length; i++)
	// 		System.out.println(list[i] + " ");
	// }
	
}
