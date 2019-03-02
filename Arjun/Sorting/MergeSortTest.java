package Sorting;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void TestSplit(){
        int[] A = {10 , 7  , 2 ,70 ,1 ,6};
        int[] E = {1,2,6,7,10,70};
        MergeSort.split(A);
        assertArrayEquals(E , A);
    }
}