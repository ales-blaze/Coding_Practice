package Sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortTest {
    InsertionSort sort;

    @Before
    public void setUp() throws Exception {
        sort = new InsertionSort();
    }

    @Test
    public void sortTest() {
        //Given
        int[] unsorted = {3,7,4,4,6,5,8};
        int[] expectedSorted = {3,4,4,5,6,7,8};
        //When
        int[] sorted = sort.Sort(unsorted);
        //Then
        assertArrayEquals(expectedSorted , sorted);

    }
}