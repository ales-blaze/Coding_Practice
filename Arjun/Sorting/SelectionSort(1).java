package Sorting;

public class SelectionSort {
    public static void sort(int array[]){
        for(int index = 0 ; index < array.length - 1 ; index++){
            int temp = array[index];
            int smallestIndex = index;
            for(int fasterIndex = index + 1 ; fasterIndex < array.length ; fasterIndex++){
//                int smallestIndex  = fasterIndex;
                if(array[fasterIndex] < array[smallestIndex]){
                    smallestIndex  = fasterIndex;
                }
            }
            array[index] = array[smallestIndex];
            array[smallestIndex] = temp;
        }
    }
}
class TestSelectionSort{
    public static void main(String[] args) {
        int array[] = {5,2,4,6,1,3};
        SelectionSort.sort(array);
        for(int number : array){
            System.out.print(number + " ");
        }
    }
}
