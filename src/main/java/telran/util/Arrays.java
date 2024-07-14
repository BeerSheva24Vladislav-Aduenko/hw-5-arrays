package telran.util;

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
    int low = 0;
    int high = ar.length - 1;
    while (low <= high) {
        int mid = (low + high) / 2;
        if (ar[mid] == key) {
            return mid;
        } else if (ar[mid] < key) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
  
    return -(low + 1);
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

public static boolean isOneSwap(int [] array) {
    int firstWrongIndex = -1;
    for (int i = 0; i < array.length - 1; i++) {
        if (array[i] > array[i + 1]) {
            if (firstWrongIndex == -1) {
                firstWrongIndex = i;
            } else {
                return false;
            }
        }
    }
    if (firstWrongIndex == -1) {
        return false;
    }
    if (firstWrongIndex == 0) {
        int temp = array[0];
        array[0] = array[1];
        array[1] = temp;
    } else if (firstWrongIndex == array.length - 1) {
        int temp = array[array.length - 1];
        array[array.length - 1] = array[array.length - 2];
        array[array.length - 2] = temp;
    } else {
        int temp = array[firstWrongIndex];
        array[firstWrongIndex] = array[firstWrongIndex + 1];
        array[firstWrongIndex + 1] = temp;
    }
    for (int i = 0; i < array.length - 1; i++) {
        if (array[i] > array[i + 1]) {
            return false;
        }
    }
    return true;
}


}


