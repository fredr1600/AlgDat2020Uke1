import java.lang.reflect.Array;
import java.util.Arrays;

public class RecursivePermutation {

    public static void main(String[] args) {

        System.out.println("Recursive permutations");

        int[] values = {1,2,3};
        //1,2,3
        //1,3,2
        //2,1,3
        //2,3,1
        //3,1,2
        //3,2,1

        recursive_permutation(values, 0);

    }


    public static void recursive_permutation(int [] values, int k){
        if (k == values.length-1){
            System.out.println(Arrays.toString(values));
        }

        //1,2,3
        //2,1,3
        //3,2,1
        for(int i= k; i < values.length; i++){
            swap(values, i, k);
            recursive_permutation(values, k+1);
            swap(values, k, i);
        }
    }

    public static void swap(int[] values, int m, int n){

        int temp = values[m];
        values[m] = values[n];
        values[n] = temp;
    }
}
