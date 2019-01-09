package Sorting;

public class BubbleSort {

    /**
     * This swaps two elements in the array ,
     * using a temporary variable.
     *
     * @param unsorted ,takes an array.
     * @param left ,index of the array less than the right.
     * @param right ,incrementation of left value by 1.
     */
    private void Swap(int[] unsorted , int left , int right){
        if(left!= right){
            int temp = unsorted[left];
            unsorted[left] = unsorted[right];
            unsorted[right] = temp;
        }
    }

    /**
     * Performs BubbleSort on the given array.
     *
     * @param array
     * @return return the sorted array
     */
    public int[] Bubble(int array[]){
        //Uses SWAP Flag to execute number of the passes.
        //one pass sorts one number(i.e. takes the largest possible number to the rightmost side possible for the array)
        boolean swapped = false;
        do{
            swapped = false;
            //index cna not be zero as index
            for(int index = 1; index < array.length ; index++ ){
                if(array[index-1] > array[index]){
                    Swap(array, index - 1 , index);
                    swapped = true;
                }
            }
        }while(swapped != false);
        return array;
    }
}
