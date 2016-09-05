package basicrecursion;

/**
 * Created by Isabel on 7/17/2016.
 */
public class SumToN {
    public static void main(String args[]){
        System.out.println(getSum(3));
    }
    public static int getSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n+getSum(n-1);
    }
}
