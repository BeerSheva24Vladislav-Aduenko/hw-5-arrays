package telran.util.test;

import java.util.Comparator;

public class ComparatorInt implements Comparator<Integer> {

    @Override
    public int compare(Integer arg0, Integer arg1) {
        return arg0.compareTo(arg1) ;
    }
    

}
