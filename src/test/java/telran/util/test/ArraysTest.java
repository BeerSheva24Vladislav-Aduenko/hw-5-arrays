package telran.util.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static telran.util.Arrays.*;

public class ArraysTest {
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
    //TODO
    // inserted the number into the middle of array
    int newNumber = 5;
    int index = 3;
    int[] expected = { 10, 7, 12, newNumber, -4, 13, 3, 14 };
    assertArrayEquals(expected, insert(numbers, index, newNumber));

    //TODO
    // inserted the number into the beginning of array
    int newNumber2 = 15;
    int index2 = 0;
    int[] expected2 = {newNumber2, 10, 7, 12, -4, 13, 3, 14 };
    assertArrayEquals(expected2, insert(numbers, index2, newNumber2));

    //TODO
    // inserted the number into the end of array
    int newNumber3 = 16;
    int index3 = numbers.length;
    int[] expected3 = { 10, 7, 12, -4, 13, 3, 14, newNumber3 };
    assertArrayEquals(expected3, insert(numbers, index3, newNumber3));

    //TODO
    // inserted the number by negative index of array
    int newNumber4 = 0;
    int index4 = -2;
    assertThrowsExactly(java.lang.ArrayIndexOutOfBoundsException.class, () -> insert(numbers, index4, newNumber4));
}

@Test
void removeTest(){
    //TODO
    // removed the number from the middle of array
    int index = 3;
    int[] expected = { 10, 7, 12, 13, 3, 14 };
    assertArrayEquals(expected, remove(numbers, index));

    //TODO
    // removed the number from the beginning of array
    int index2 = 0;
    int[] expected2 = { 7, 12, -4, 13, 3, 14  };
    assertArrayEquals(expected2, remove(numbers, index2));

    //TODO
    // removed the number from the end of array
    int index3 = numbers.length - 1;
    int[] expected3 = { 10, 7, 12, -4, 13, 3 };
    assertArrayEquals(expected3, remove(numbers, index3));

    //TODO
    // removed the number by negative index of array
    int index4 = -2;
    assertThrowsExactly(java.lang.ArrayIndexOutOfBoundsException.class, () -> remove(numbers, index4));
}

}


    
    
