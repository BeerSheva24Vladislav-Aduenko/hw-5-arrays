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
}


