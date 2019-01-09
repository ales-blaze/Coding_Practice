package Sorting;

public class SelectionSort {

    public int[] sort(int[] unsorted){
        for(int sortedRangeIndex = 0; sortedRangeIndex < unsorted.length ;sortedRangeIndex++){
            int smallestNumberIndex = findSmallestNumberIndex(unsorted , sortedRangeIndex);
            swap(unsorted, sortedRangeIndex, smallestNumberIndex);
        }
        return unsorted;
    }

    private void swap(int[] unsorted , int left , int right) {
        if(left != right){
            int temporary = unsorted[left];
            unsorted[left] = unsorted[right];
            unsorted[right] = temporary;
        }
    }

    private int findSmallestNumberIndex(int[] unsorted, int smallestNumberIndex) {
        int smallestNumber = unsorted[smallestNumberIndex];
        for(int index = smallestNumberIndex + 1 ; index < unsorted.length ; index++){
            if(smallestNumber > unsorted[index]){
                smallestNumberIndex = index;
                break;
            }
        }
        return smallestNumberIndex;
    }
}
