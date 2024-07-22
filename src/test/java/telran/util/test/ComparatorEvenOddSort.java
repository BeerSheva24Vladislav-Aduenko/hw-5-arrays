package telran.util.test;

import java.util.Comparator;

public class ComparatorEvenOddSort implements Comparator<Integer> {

@Override
    public int compare(Integer o1, Integer o2) {
        int evenOddComparison = Integer.compare(o1 % 2, o2 % 2);
        
        return evenOddComparison != 0 ? evenOddComparison : 
           Integer.compare(o1, o2) * (o1 % 2 == 0 ? 1 : -1);
    }
}
