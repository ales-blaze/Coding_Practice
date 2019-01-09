import java.util.ArrayList;

public class Coursera {
    //correct
        public void MaxProductWise(int[] numbers){
            int maxNumber1 = numbers[0];
            int firstMaxPosition = 0;

            for(int index = 1; index < numbers.length; index++){
                if(maxNumber1 < numbers[index]){
                    maxNumber1 = numbers[index];
                    firstMaxPosition = index;
                }
            }
            int maxNumber2 = numbers[0];
            for(int index = 1; index < numbers.length;index++){
                if(maxNumber2 < numbers[index] && firstMaxPosition != index /*numbers[index] != maxNumber1*/){
                    maxNumber2 = numbers[index];
                }
            }
            int result = maxNumber1 * maxNumber2;
            System.out.println(result);
        }


        public ArrayList<Long> FiboniccaSeries(int input){
            long first = 0;
            long second = 1;
            int numberOfElementsInSequence = input;
            long third = 0 ;
            ArrayList<Long> list = new ArrayList(numberOfElementsInSequence);
            list.add(first);
            list.add(second);
            while(numberOfElementsInSequence > 2){
                third = first + second;
                list.add(third);
                first = second;
                second = third;
                numberOfElementsInSequence--;
            }
            System.out.print(list);
            return list;
        }
        public ArrayList<Long> FibonacchiSeries(int input){
            ArrayList<Long> series = new ArrayList<Long>(input);

            series.add(Long.valueOf(0));
            series.add(Long.valueOf(1));
            for(int index = 2 ; index < input ;index++){
                series.add(index ,series.get(index - 1) + series.get(index - 2));
            }

            System.out.print(series);
            return series;
        }
        public static void main(String[] args) {
            Coursera solution = new Coursera();
            solution.FibonacchiSeries(80);
            //solution.FiboniccaSeries(80);
//            int[] numbers1 = {1, 2, 14 , 5, 8, 20, 7};
//            int[] numbers = {2, 9, 3, 1, 9};
//            solution.MaxProductWise(numbers1);
//            solution.MaxProductWise(numbers);
        }
}
