package telran.util;

import java.util.Comparator;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class Arrays {
public static int search(int[] array, int key) {
    int index = 0;
    while(index < array.length && key != array[index]) {
        index++;
    }
    return index == array.length ? -1 : index;
}

public static int[] add(int[] array, int number) {
    int [] res = java.util.Arrays.copyOf(array, array.length + 1);
    res[array.length] = number;
    return res;
}

public static int[] insert(int[] ar, int index, int number) {
    int[] res = new int[ar.length + 1];
    System.arraycopy( ar, 0, res, 0, index );
    res[index] = number;
    System.arraycopy( ar, index, res, index + 1, ar.length - index );
    return res;
}

public static int[] remove(int[] numbers, int index) {
    int[] res = new int [numbers.length-1];
    System.arraycopy(numbers, 0, res, 0, index);
    System.arraycopy( numbers, index + 1, res, index, numbers.length - index - 1 );
    return res;
}

private static boolean pushMaxAtEnd(int[] array, int length) {
    boolean res = true;
    for(int i = 0; i < length; i++) {
        if ( array[i] > array[i + 1]) {
            res = false;
            swap(array, i, i + 1);
        }
    }
    return res;
}

private static void swap(int[] array, int i, int j) {
   int tmp = array[i];
   array[i] = array[j];
   array[j] = tmp;
}   

public static void sort(int[] array) {
    int length = array.length ;
    boolean flSorted = false;
    while(!flSorted) {
        length--;
      flSorted = pushMaxAtEnd(array, length);
    }
}


public static int binarySearch(int[] ar, int key) {
    int left = 0;
    int right = ar.length - 1;
    int middle = (left + right) / 2;
        while (left <= right && ar[middle] != key) {
            if (key < ar[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
    return left > right ? -(left + 1) : middle;
}

// Option insertSorted #1
public static int[] insertSorted(int[] arSorted, int number) {
    int insertIndex = binarySearch(arSorted, number);
    if (insertIndex < 0) {
        insertIndex = -insertIndex - 1;
    }
    return insert(arSorted, insertIndex, number);
}

// Option insertSorted #2
public static int[] insertSortedByFor(int[] arSorted, int number) {
    int n = arSorted.length;
    int [] newArray = new int [n + 1];
    int insertIndex = binarySearch(arSorted, number);
    if (insertIndex < 0) {
        insertIndex = -(insertIndex + 1);
    }
    for( int i = 0; i < insertIndex; i++ ) {
        newArray[i] = arSorted[i];
    }
    newArray[insertIndex] = number;
    for (int i= insertIndex; i < n; i++) {
        newArray[i + 1] = arSorted[i];
    }
    
    return newArray;
}

public static boolean isOneSwap(int[] array) {
    boolean res = false;
    int index1 = -1;
    int index2 = 0;
    index1 = getFirstIndex(array);
    if (index1 > -1) {
        index2 = getSecondIndex(array, index1);
        res = isOneSwapCheck(array, index1, index2);
    }
    return res;

}

private static boolean isOneSwapCheck(int[] array, int index1, int index2) {
    swap(array, index1, index2);
    boolean res = isArraySorted(array);
    swap(array, index2, index1); 
    return res;
}

private static boolean isArraySorted(int[] array) {
    int index = 1;
    while (index < array.length && array[index] >= array[index - 1]) {
        index++;
    }
    return index == array.length;
}

private static int getSecondIndex(int[] array, int index1) {
    int index = array.length - 1;
    int lowBorder = index1 + 1;
    while (index > lowBorder && array[index] >= array[index1]) {
        index--;
    }
    return index;
}

private static int getFirstIndex(int[] array) {
    int index = 0;
    int limit = array.length - 1;
    while(index < limit && array[index] <= array[index + 1]) {
        index++;
    }
    return index == limit ? -1 : index;
}

public static <T> void sort (T[] array, Comparator<T> comparator) {
    int length = array.length;
    boolean flSorted = false;
    do{
        length--;
        flSorted = true;
        for (int i = 0; i < length; i++) {
          if(comparator.compare(array[i], array[i + 1]) > 0) {
             swap(array, i, i+1);
             flSorted = false;
        }
    
        }
    } while(!flSorted);
}

private static <T> void swap(T[] array, int i, int j) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
    }


    public static <T> int binarySearch(T[] array, T key, Comparator<T> comp) {
        int left = 0;
        int right = array.length - 1;
        int middle = (left + right) / 2; 
        while (left <= right && comp.compare(array[middle], key) != 0) {
            if (comp.compare(array[middle], key) > 0) { 
                right = middle - 1;
            } else {
                left = middle + 1;
            }
            middle = (left + right) / 2;
        }
        return left > right ? -(left + 1) : middle;
        }

    public static <T> T[] insert(T [] array, int index, T item) {
        T[] res = java.util.Arrays.copyOf(array, array.length + 1);
        System.arraycopy(array, index, res, index + 1, array.length - index);
        res[index] = item;
         return res;
    } 

    public static <T> T[] find (T [] array, Predicate<T> predicate) {
        T[] result = java.util.Arrays.copyOf(array, 0);
        for (int i = 0; i < array.length; i++) {                             
            if (predicate.test(array[i])) {
                result = insert(result, result.length, array[i]);
            }
        }
        return result;

    }   
    // public static <T> T[] removeIf(T[] array, Predicate<T> predicate) {
    //     T[] result = java.util.Arrays.copyOf(array, 0);
    //     for (int i = 0; i < array.length; i++) {                      
    //         if (!predicate.test(array[i])) {
    //             result = insert(result, result.length, array[i]);
    //         }
    //     }
    //     return result;
    // }

    public static <T> T[] removeIf(T[] arr, Predicate<T> predicate){
        return find(arr, predicate.negate());
    }
    
    @SuppressWarnings("unchecked")
    public static <T> int binarySearch(T[] array, T key) {
        return binarySearch(array, key, (Comparator<T>) Comparator.naturalOrder());
    }



}



