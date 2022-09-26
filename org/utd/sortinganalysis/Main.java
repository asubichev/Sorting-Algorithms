package org.utd.sortinganalysis;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) 
    {
        /**TODO:
         * QuickSort check comparisons, should be like MergeSort
         * or maybe it's right
         * 
         * Implement user input to control:
         *          * Order
         *          * List Size
         *          * Sort Type
         * 
         * Increase sizes of lists from 3-5 to 5-15k
         * 
         * Create output control:
         *          * 3 input variables
         *          * Comparisons
         *          * Movements
         *          * Total time
        */
        final int ARRAY_SIZE = 20;
        int[] list = new int[ARRAY_SIZE];

        int listOrder = 0;
        int listSize = 0;
        int sortType = 0;
        System.out.print("1.InOrder\n2.ReverseOrder\n3.AlmostOrder\n4.RandomOrder\n");
        System.out.print("Please pick the order of the list: ");

        //stdin
        //listOrder = stdin

        System.out.print("\n1.5000\n2.15000\n3.50000\n");
        System.out.print("Please select the size of the list: ");

        //stdin
        //listSize = stdin

        System.out.print("\n1.Insertion Sort\n2.Selection Sort\n3.Quick Sort\n4.Merge Sort\n5.Heap Sort\n6.Radix Sort\n");
        System.out.print("Please select the sorting algorithm to sort with: ");

        //stdin
        //sortType = stdin
    }

    public static void prIntList(int[] coll)
    {
        for(int x: coll)
        {
            System.out.println(x);
        }
        System.out.println("------------");
    }

    public static void populate(int[] list, int which)
    {
        //array passed by reference
        switch(which){
            case(1)://In Order
                for(int i = 0; i < list.length; i++)
                {
                    //increment by [0,17)
                    int randomNum = ThreadLocalRandom.current().nextInt(0,17);
                    if( i == 0 ){ list[i] = randomNum; }
                    else{ list[i] = list[i-1] + randomNum; }
                }
                break;
            case(2)://Reverse Order//TODO: get this straight
                int randStart = ThreadLocalRandom.current().nextInt(100, 201);//TODO:start around 100,000 for real code
                for(int i = 0; i < list.length; i++)
                {
                    //decrement by [10,33)
                    int randomNum = ThreadLocalRandom.current().nextInt(10,33);
                    if( i == 0 ){ list[i] = randStart - randomNum; }
                    else{ list[i] = list[i-1] - randomNum; }
                }
                break;
            case(3)://Almost Order
                populate(list, 1);//populates in order first
                for(int i = 0; i < list.length; i++)
                {
                    int randomNum = ThreadLocalRandom.current().nextInt(0,101);
                    if(randomNum <= 30) //30 percent chance to mess it up
                    {
                        list[i] = randomNum;
                    }
                }
                break;
            case(4)://Random Order
                for(int i = 0; i < list.length; i++)
                {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, 101); //nextInt(min, max)
                    list[i] = randomNum;
                }
                break;
            default:
                throw new IllegalArgumentException(which + " is not associated with a valid sort");
        }
    }

    public static int[] sort(int[] list, int which)
    {
        int[] stats = {0,0,0};//comp,mvmt,time(ms)
        long start;
        long finish;
        switch(which)
        {
            case(1):
                start = System.nanoTime();
                stats = InsertionSort.insertionSort(list);
                finish = System.nanoTime();
                break;
            case(2):
                start = System.nanoTime();
                stats = SelectionSort.selectionSort(list);
                finish = System.nanoTime();
                break;
            case(3):
                start = System.nanoTime();
                QuickSort.quickSort(list);
                finish = System.nanoTime();
                stats[0] = QuickSort.getComparisons();
                stats[1] = QuickSort.getMovements();
                //TODO: perhaps I should reset static vars to 0 here
                break;
            case(4):
                start = System.nanoTime();
                MergeSort.mergeSort(list);
                finish = System.nanoTime();
                stats[0] = MergeSort.getComparisons();
                stats[1] = MergeSort.getMovements();
                break;
            case(5):
                Integer[] boxing = Arrays.stream(list).boxed().toArray(Integer[]::new);
                start = System.nanoTime();
                HeapSort.heapSort(boxing);
                finish = System.nanoTime();
                for(int i = 0; i < boxing.length; i++) { list[i] = boxing[i]; }
                stats[0] = Heap.getComparisons();
                stats[1] = Heap.getMovements();
                //couldn't really figure out a better approach, but in the end it's still O(N) so w/e
                //System.arraycopy(boxing, 0, list, 0, boxing.length);
                break;
            case(6):
                start = System.nanoTime();
                RadixSort.radixsort(list, 0);
                finish = System.nanoTime();
                stats[0] = RadixSort.getComparisons();
                stats[1] = RadixSort.getMovements();
                break;
            default:
                throw new IllegalArgumentException(which + "is not associated with a valid sort");
        }
        stats[2] = Math.toIntExact(finish - start);
        System.out.println("ns elapsed: " + stats[2]);//convert to x.xx * 10^6
        return stats;
    }
}
