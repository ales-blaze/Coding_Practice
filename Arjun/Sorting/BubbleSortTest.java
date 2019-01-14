package Sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleSortTest {
    BubbleSort sort ;
    @Before
    public void setUp() throws Exception {
        sort = new BubbleSort();
    }

    @Test
    public void SortingTest(){
        //Given
        int unsorted[] = {3 ,7 ,4 ,4 ,6 ,5 ,8};
        int expectedSortedArray[] = {3 ,4 ,4 ,5 ,6 ,7 ,8};

        //When
        int sorted[] = sort.Bubble(unsorted);

        //Then
        assertArrayEquals(expectedSortedArray , sorted);

    }
}