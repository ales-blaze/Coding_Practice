package Sorting;

public class QuickSort {
//    int[] array = {4,6,234,867,234,2,41,23};
    public int[] quickSort(int array[] , int start , int end) {
        //base case
        if (start >= end) return array;

        int pIndex = partition(array, start, end);
        quickSort(array, start, pIndex - 1);
        quickSort(array, pIndex + 1, end);
        return array;
    }
    private int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pIndex = start;

        for(int index = start ; index < end ;index++){
            if(array[index] <= pivot){
                int temp = array[index];
                array[index] = array[pIndex];
                array[pIndex] = temp;
                pIndex++;
            }
        }
        int temp = array[end];
        array[end] = array[pIndex];
        array[pIndex] = temp;
        return pIndex;
    }

    public static void main(String[] args) {
        QuickSort obj = new QuickSort();
        int[] array = {4,6,234,867,1110,2,41,23};
        array =  obj.quickSort(array , 0 , array.length -1 );
        for(int index = 0 ; index < array.length ;index++)
        System.out.print(array[index] + " ");
    }
}
