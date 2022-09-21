import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;

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
        ArrayList<Integer> list = new ArrayList<>();

        //populate list randomly
        for(int i = 0; i < ARRAY_SIZE; i++)
        {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 101); //nextInt(min, max)
            list.add(randomNum); //adds a random value
        }

        prIntList(list);

        //stack overflow going crazy
        //converting list to array
        int[] sortit = list.stream().filter(t -> t != null).mapToInt(t -> t).toArray();
        MergeSort.mergeSort(sortit);

        //following sort, add elements back into ArrayList
        list.clear();
        for(int i = 0; i < sortit.length; i++)
        {
            list.add(sortit[i]);
        }

        prIntList(list);
    }

    public static void prIntList(ArrayList<Integer> coll)
    {
        for(int x: coll)
        {
            System.out.println(x);
        }
        System.out.println("------------");
    }


}
