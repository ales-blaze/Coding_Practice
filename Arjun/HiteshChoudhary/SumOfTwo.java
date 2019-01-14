import java.util.ArrayList;

public class SumOfTwo {

    public int[] findTheSumOfGivenDigit(int numbers[] , int givenDigit) {
        for(int slowPointer = 0 ; slowPointer < numbers.length - 1 ; slowPointer++){
            for(int fastPointer = slowPointer + 1 ; fastPointer < numbers.length ; fastPointer++){
                if(numbers[slowPointer] + numbers[fastPointer] == givenDigit){
                     int outputArray[] = {numbers[slowPointer], numbers[fastPointer]};
                     return outputArray;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int numbers[] = {2,3,5,6,12,-2,9};
        SumOfTwo sum = new SumOfTwo();
        int resultArray[] = sum.findTheSumOfGivenDigit(numbers,10);
        for(int number : resultArray)
        System.out.print(number + " ");
    }
}
//Method 2
class SumOfTwoAlternative{
    public int[] findSumOfGivenNumber(int[] numbers, int givenDigit){
        for(int slowPointer = 0 ; slowPointer < numbers.length - 1 ; slowPointer++){
            int requiredDigit = givenDigit - numbers[slowPointer];
            for (int searcher = slowPointer + 1 ; searcher < numbers.length;searcher++){
                if(requiredDigit == numbers[searcher]){
                    int twoDigits[] ={numbers[slowPointer] , numbers[searcher]};
                    return twoDigits;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int numbers[] = {2,3,5,6,12,-2,9,8};
        SumOfTwoAlternative sum = new SumOfTwoAlternative();
        int[] pairOfDigits = sum.findSumOfGivenNumber(numbers , 10);
        for(int number : pairOfDigits){
            System.out.print(number + " ");
        }
    }
}
