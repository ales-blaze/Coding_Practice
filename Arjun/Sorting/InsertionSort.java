package Sorting;

public class InsertionSort {
    public int[] Sort(int[] unsorted){
        //assuming that the first element is already sorted.
        int sortedRangeEndIndex = 1;

        while(sortedRangeEndIndex < unsorted.length){
            //Comparsion
            if (unsorted[sortedRangeEndIndex] < unsorted[sortedRangeEndIndex - 1 ]) {
                //find the index for the number to sort it
                int positionToInsert = FindElementIndex(unsorted,sortedRangeEndIndex);
                //insert it at that position to sort the array
                Insert(unsorted ,positionToInsert , sortedRangeEndIndex);
            }
            //else wise just go through the element
            sortedRangeEndIndex++;
        }
        return unsorted;
    }

    private void Insert(int[] unsorted, int positionToInsert, int sortedRangeEndIndex) {
        int temporary = unsorted[positionToInsert];
        unsorted[positionToInsert] = unsorted[sortedRangeEndIndex];

        for(int index = sortedRangeEndIndex ; index > positionToInsert ; index--){
            unsorted[sortedRangeEndIndex] = unsorted[sortedRangeEndIndex - 1];
        }

        unsorted[positionToInsert + 1] = temporary;
    }

    private int FindElementIndex(int[] unsorted, int sortedRangeEndIndex) {
        for(int index = 0; index < sortedRangeEndIndex ; index++){
            if (unsorted[sortedRangeEndIndex] < unsorted[index]) {
                return index;
            }
        }
        return -1;
    }

}
