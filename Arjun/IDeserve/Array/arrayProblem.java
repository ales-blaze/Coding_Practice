package Array;

public class arrayProblem {
    private int array[] = {1,2,4,4,5,5,5,7,9,9};
    private final static boolean FLAG = true;
    public arrayProblem(){

    }
    public  arrayProblem(int sizeOfArray){
        array = new int[sizeOfArray];
    }
//----------------------------------------------------------------------------------------------
    public int lastIndexOfGivenNumber(int givenNumber){
        return this.BinarySearch(givenNumber);
    }

    private int BinarySearch(int givenNumber) {
        int first = 0 ;
        int last = this.array.length - 1;
        int mid = Math.round((first + last)/2);
        while(first <= last){
            if(this.array[mid] > givenNumber){
                last = mid - 1 ;
            }
            else if(this.array[mid] == givenNumber){
                if(mid == this.array.length - 1){
                    return -1;
                }
                else if(this.array[mid] < this.array[mid + 1]){
                    return -1;
                }
                else if(this.array[mid] == this.array[mid + 1]){
                    //FLAG used to implement two different approaches in the same program
                    if(FLAG){
                        return mid;
                    }
                    else {
                        mid++;
                        while (this.array[mid] == this.array[mid + 1]) {
                            mid++;
                        }
                        return mid;
                    }
                }
            }
            else{
                first = mid + 1 ;
            }
            mid = Math.round((first + last)/2);
        }
        return -1;
    }
//-----------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        arrayProblem array = new arrayProblem();
        int result = array.lastIndexOfGivenNumber(9);
        System.out.print(result);
    }
}
