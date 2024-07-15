package telran.util.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

import java.util.Random;

public class ArraysTest {
private static final int N_ELEMENTS = 1000;
int[] numbers = { 10, 7, 12, -4, 13, 3, 14 };

@Test 
    void searchTest(){
        assertEquals(0, search(numbers, 10));
        assertEquals(6, search(numbers, 14));
        assertEquals(3, search(numbers, -4));
        assertEquals(-1, search(numbers, 100));
    }
@Test
void addTest(){
   int newNumber = 100;
   int[] expected = { 10, 7, 12, -4, 13, 3, 14, newNumber };
   assertArrayEquals(expected, add(numbers, newNumber));
}   

@Test
void insertTest(){
    // inserted the number into the middle of array
    int newNumber = 5;
    int index = 3;
    int[] expected = { 10, 7, 12, newNumber, -4, 13, 3, 14 };
    assertArrayEquals(expected, insert(numbers, index, newNumber));

    // inserted the number into the beginning of array
    int newNumber2 = 15;
    int index2 = 0;
    int[] expected2 = {newNumber2, 10, 7, 12, -4, 13, 3, 14 };
    assertArrayEquals(expected2, insert(numbers, index2, newNumber2));

    // inserted the number into the end of array
    int newNumber3 = 16;
    int index3 = numbers.length;
    int[] expected3 = { 10, 7, 12, -4, 13, 3, 14, newNumber3 };
    assertArrayEquals(expected3, insert(numbers, index3, newNumber3));

    // inserted the number by negative index of array
    int newNumber4 = 0;
    int index4 = -2;
    assertThrowsExactly(java.lang.ArrayIndexOutOfBoundsException.class, () -> insert(numbers, index4, newNumber4));
}

@Test
void removeTest(){
    // removed the number from the middle of array
    int index = 3;
    int[] expected = { 10, 7, 12, 13, 3, 14 };
    assertArrayEquals(expected, remove(numbers, index));

    // removed the number from the beginning of array
    int index2 = 0;
    int[] expected2 = { 7, 12, -4, 13, 3, 14  };
    assertArrayEquals(expected2, remove(numbers, index2));


    // removed the number from the end of array
    int index3 = numbers.length - 1;
    int[] expected3 = { 10, 7, 12, -4, 13, 3 };
    assertArrayEquals(expected3, remove(numbers, index3));

    // removed the number by negative index of array
    int index4 = -2;
    assertThrowsExactly(java.lang.ArrayIndexOutOfBoundsException.class, () -> remove(numbers, index4));
}


// @Test
// void pushMaxAtEndTest(){
//     // { 10, 7, 12, -4, 13, 3, 14 } - numbers
//     int [] testNumber = java.util.Arrays.copyOf(numbers, numbers.length);
//     pushMaxAtEnd(testNumber);
//     assertEquals(14, testNumber[testNumber.length - 1]);
//     assertEquals(13, testNumber[testNumber.length - 2]);
//     testNumber = new int[] {20, -10, 10, -17};
//     pushMaxAtEnd(testNumber);
//     assertEquals(20, testNumber[testNumber.length - 1]);
//     assertEquals(-17, testNumber[testNumber.length - 2]);
//     assertEquals(10, testNumber[testNumber.length - 3]);
// }

@Test
void sortTest(){
    int [] testNumbers = java.util.Arrays.copyOf(numbers, numbers.length); 
    int [] expected = {-4, 3, 7, 10, 12, 13, 14 };
    sort(testNumbers);
    assertArrayEquals(expected, testNumbers);
}

@Test 
void sortTestRandomArray(){
    int[] array = getRandomArray(N_ELEMENTS);
    int limit = array.length -1 ;
    sort(array);
    for (int i = 0; i < limit; i++) {
        assertTrue(array[i]<=array[i+1]);
    }
}
private int[] getRandomArray(int nElements) {
    int [] res = new int [nElements];
    Random random = new Random();
    for(int i = 0; i < nElements; i++) {
        res[i] = random.nextInt();
    }
    return res;
}

@Test
void binarySearchTest() {
    int[] testArray = {-4, -2, 0, 2, 4, 6, 8, 10, 12, 14};
    int key = 8;
    assertEquals(6, binarySearch(testArray, key));

    int key2 = 7;
    assertEquals(-7, binarySearch(testArray, key2));

    int key3 = -4;
    assertEquals(0, binarySearch(testArray, key3));

    int key4 = 14;
    assertEquals(9, binarySearch(testArray, key4));

    int[] testArray2 = {1, 3, 5 ,-3, -5, 12, 8, 17, 14, 21, 13, -41};
    sort (testArray2);
    int key5 = -5;
    assertEquals(1, binarySearch(testArray2, key5));
}

@Test
void insertSortedTest() {
    int[] testArray = {-4, -2, 0, 2, 4, 6, 8, 10, 12, 14};
    int key = 9;
    int[] expectedArray = {-4, -2, 0, 2, 4, 6, 8, 9, 10, 12, 14};
    assertArrayEquals(expectedArray, insertSorted(testArray, key));

    int[] testArray2 = {1, 3, 5, 7, 9};
    int key2 = 0;
    int[] expectedArray2 = {0, 1, 3, 5, 7, 9};
    assertArrayEquals(expectedArray2, insertSorted(testArray2, key2));

    int key3 = 10;
    int[] expectedArray3 = {-4, -2, 0, 2, 4, 6, 8, 10, 10, 12, 14};
    assertArrayEquals(expectedArray3, insertSorted(testArray, key3));

    int[] testArray3 = {5};
    int key4 = 3;
    int[] expectedArray4 = {3, 5};
    assertArrayEquals(expectedArray4, insertSorted(testArray3, key4));

    int key5 = -41;
    int[] expectedArray5 = {-41, -4, -2, 0, 2, 4, 6, 8, 10, 12, 14};
    assertArrayEquals(expectedArray5, insertSorted(testArray, key5));
}


@Test
void insertSortedByForTest() {
    int[] testArray = {-4, -2, 0, 2, 4, 6, 8, 10, 12, 14};
    int key = 9;
    int[] expectedArray = {-4, -2, 0, 2, 4, 6, 8, 9, 10, 12, 14};
    assertArrayEquals(expectedArray, insertSortedByFor(testArray, key));

    int[] testArray2 = {1, 3, 5, 7, 9};
    int key2 = 0;
    int[] expectedArray2 = {0, 1, 3, 5, 7, 9};
    assertArrayEquals(expectedArray2, insertSortedByFor(testArray2, key2));

    int key3 = 10;
    int[] expectedArray3 = {-4, -2, 0, 2, 4, 6, 8, 10, 10, 12, 14};
    assertArrayEquals(expectedArray3, insertSortedByFor(testArray, key3));

    int[] testArray3 = {5};
    int key4 = 3;
    int[] expectedArray4 = {3, 5};
    assertArrayEquals(expectedArray4, insertSortedByFor(testArray3, key4));

    int key5 = -41;
    int[] expectedArray5 = {-41, -4, -2, 0, 2, 4, 6, 8, 10, 12, 14};
    assertArrayEquals(expectedArray5, insertSortedByFor(testArray, key5));
}

@Test
    void isOneSwapTest() {
        assertFalse(isOneSwap(new int[]{1, 2, 3, 4, 5}));
        assertTrue(isOneSwap(new int[]{1, 5, 3, 4, 2}));
        assertTrue(isOneSwap(new int[]{1, 2, 3, 5, 4}));
        assertFalse(isOneSwap(new int[]{3, 3, 3, 3}));
        assertTrue(isOneSwap(new int[]{1, 2, 3, 4, 6, 5, 7, 8, 9, 10}));
        assertTrue(isOneSwap(new int[]{-5, -4, -2, -3, -1, 0, 1, 2, 3, 4, 5}));
        assertFalse(isOneSwap(new int[]{1, 2, 13, 4, 5, 4, 4, 20}));
         int [] ar = {1, 2, 13, 4, 4, 4, 4, 20};
        assertTrue(isOneSwap(ar));
        assertFalse(isOneSwap(new int[]{1,2,3,5,6,4,7,9,8}));
    }

}

    
    
