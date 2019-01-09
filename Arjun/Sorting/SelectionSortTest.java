package Sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionSortTest {
    SelectionSort sort;
    @Before
    public void setUp() throws Exception {
        sort = new SelectionSort();
    }

    @Test
    public void sortTest() {
        //Given
        int[] unsorted = {3,7,4,4,5,6,8};
        int[] expectedSort = {3,4,4,5,6,7,8};
        //When
        int[] sorted = sort.sort(unsorted);
        //Then
        assertArrayEquals(expectedSort, sorted);
    }
}