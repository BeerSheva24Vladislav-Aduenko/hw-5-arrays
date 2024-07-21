package telran.util.test;

import java.util.Comparator;

public class ComparatorEvenOddSort implements Comparator<Integer> {

    @Override
    public int compare(Integer first, Integer second) {
        return isEven(first) && !isEven(second) ? -1 :
               !isEven(first) && isEven(second) ? 1 :
               isEven(first) && isEven(second) ? first.compareTo(second) :
               second.compareTo(first);
    }
    
    private boolean isEven(int number) {
        return number % 2 == 0;
    }

}
