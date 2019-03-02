package Sorting;

public class MergeSort {
    public static void split(int A[]){
        if(A.length < 2) return;
        int first = 0 ;
        int last = A.length;
        int mid = (last + first)/ 2;

        int L[] = new int[mid];
        int R[] = new int[last - mid];

        for(int index = 0 ; index < L.length ; index++){
            L[index] = A[index];
        }

        for(int index = 0 ; index < R.length ; index++){
            R[index] = A[index + mid];
        }
        split(L);
        split(R);
        combine(A, L ,R);
    }

    private static void combine(int[] a, int[] l, int[] r) {
        int indexA = 0 ,indexL = 0 , indexR = 0;

        while(indexL < l.length && indexR < r.length){
            if(l[indexL] <= r[indexR])
                a[indexA++] = l[indexL++];
            else
                a[indexA++] = r[indexR++];
        }
        while (indexL < l.length){
            a[indexA++] = l[indexL++];
        }
        while (indexR < r.length){
            a[indexA++] = r[indexR++];
        }
    }

    public static void main(String[] args) {
        int[] A = {10 , 7  , 2 ,70 ,1 ,6};
        MergeSort.split(A);
        for(int number : A) {
            System.out.print(number + " , ");
        }
    }
}
