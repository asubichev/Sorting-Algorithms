package org.utd.sortinganalysis;
import java.io.*;
import java.util.*;

class RadixSort {

	private static int comparisons = 0;
	private static int movements = 0;

	//looks like minimal comparisons/movements, but there are a lot of modifications to count[]

	static int getMax(int arr[], int n) {
		int mx = arr[0];
		comparisons+=n;
		for (int i = 1; i < n; i++)
		{
			if (arr[i] > mx) { movements++; mx = arr[i]; }
		}
		return mx;
	}

	static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % 10]++;
		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++)
			count[i] += count[i - 1];
		// Build the output array
		for (i = n - 1; i >= 0; i--) {
			movements++;
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}
		movements+=n;
		for (i = 0; i < n; i++)
			arr[i] = output[i];
	}

	static void radixsort(int arr[], int n) { // Find the maximum number to know number of digits
		int m = getMax(arr, n);
		for (int exp = 1; m / exp > 0; exp *= 10)
			countSort(arr, n, exp);
	}

	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	public static int getComparisons() { return comparisons; }
	public static int getMovement() { return movements; }
	
	// public static void main(String[] args) {
	// 	int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
	// 	int n = arr.length;
	// 	radixsort(arr, n);
	// 	print(arr, n);
	// }
	
}