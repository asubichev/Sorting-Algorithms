package org.utd.sortinganalysis;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) 
    {
        /**TODO:
         * Have the sorts return comparisons and movements
         * 
         * Implement timing function: http://www.baeldung.com/java-measure-elapsed-time
         * Increase sizes of lists from 3-5 to 5-15k
         * Implement user input to control:
         *          * Order
         *          * List Size
         *          * Sort Type
         * 
         * Create output control:
         *          * 3 input variables
         *          * Comparisons
         *          * Movements
         *          * Total time
        */
        final int ARRAY_SIZE = 20;
        int[] list = new int[ARRAY_SIZE];

        //populate list randomly
        populate(list, 3);

        prIntList(list);

        //call sort
        sort(list, 5);

        prIntList(list);
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
        int[] stat = {0, 0};
        switch(which)
        {
            case(1):
                InsertionSort.insertionSort(list);
                break;
            case(2):
                SelectionSort.selectionSort(list);
                break;
            case(3):
                QuickSort.quickSort(list);
                break;
            case(4):
                MergeSort.mergeSort(list);
                break;
            case(5):
                Integer[] boxing = Arrays.stream(list).boxed().toArray(Integer[]::new);
                HeapSort.heapSort(boxing);
                for(int i = 0; i < boxing.length; i++) { list[i] = boxing[i]; }
                //couldn't really figure out a better approach, but in the end it's still O(N) so w/e
                //System.arraycopy(boxing, 0, list, 0, boxing.length);
                break;
            case(6):
                RadixSort.radixsort(list, 0);
                break;
            default:
                throw new IllegalArgumentException(which + "is not associated with a valid sort");
        }
        return stat;
    }
}
