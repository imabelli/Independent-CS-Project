package basicrecursion;

/**
 * Created by Isabel on 7/17/2016.
 */
public class Factorial {
    public static int getFactorial(int n){
        if (n==1){
            return 1;
        }

        int j = n* getFactorial(n-1);
        return j;
    }


    public static void main(String arg[]){
        System.out.println(getFactorial(4));

    }
}
