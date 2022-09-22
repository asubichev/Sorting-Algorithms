package org.utd.sortinganalysis;

import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) 
    {
        /**TODO:
         * Split populate into four functions:
         *          * In Order
         *          * Reverse Order
         *          * Almost Order (70-80% in order)
         *          * Random Order <--currently hardcoded
         * 
         * Create functions to call different sorts
         *          * Insertion
         *          * Selection
         *          * Quick
         *          * Merge
         *          * Heap
         *          * Radix
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
        final int ARRAY_SIZE = 3;
        int[] list = new int[ARRAY_SIZE];

        prIntList(list);

        //populate list randomly
        populate(list, 0);

        prIntList(list);

        //call sort
        MergeSort.mergeSort(list);

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
                break;
            case(2)://Reverse Order
                break;
            case(3)://Almost Order
                break;
            case(4)://Random Order
                for(int i = 0; i < list.length; i++)
                {
                    int randomNum = ThreadLocalRandom.current().nextInt(0, 101); //nextInt(min, max)
                    list[i] = randomNum;
                }
                break;
            default:
                break;

        }
    }


}
