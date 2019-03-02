package Sorting;

public class InsertionSort {
    public static void sortRecursive(int array[] , int lenth){
        //base case to cancel out the subroutine callin'
        if(lenth <= 1){
            return;
        }

        sortRecursive(array , lenth--);

        int last = array[lenth - 1];
        int sorter = lenth - 2;

        while(sorter >= 0 && array[sorter] > last){
            array[sorter + 1] = array[sorter];
            sorter--;
        }
        array[sorter + 1] = last;
        //process to do on other cases
    }

    public static void sort(int array[]){
        for(int index = 1 ; index < array.length ; index++){
            int key = array[index];
            int sorter = index - 1;
            while(sorter >= 0 && array[sorter] > key){
                array[sorter + 1] = array[sorter];
                sorter--;
            }
            array[sorter + 1] = key;
        }
    }
}

class TestInsertionSort{
    public static void main(String[] args) {
        int array[] = {5,2,4,6,1,3};
        InsertionSort.sortRecursive(array , array.length);
//        InsertionSort.sort(array);
        for(int number : array){
            System.out.print(number + " ");
        }
    }
}
