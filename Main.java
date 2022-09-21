import java.math.*;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) 
    {
        Heap<Integer> eff = new Heap<>();

        int howmany = 8;
        for(int i = 0; i < howmany; i++)
        {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 101); //nextInt(min, max)
            eff.add(randomNum); //adds a random value
        }

        for(int i = 0; i < eff.getSize(); i++)
        {
            System.out.println(i);
        }

        System.out.println(eff);
    }
}
