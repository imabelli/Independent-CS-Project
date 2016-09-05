package basicrecursion;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Isabel on 7/20/2016.
 */
public class Fib {
    public static void main(String args[]){
        //for(int k=0;k<100;k++)
        {
            System.out.println(getFibMomization2(100));

            System.out.println(getFibBottom(100));

            //System.out.println(getFib(100));
        }
    }
    public static int getFib(int n){
        System.out.println("getFib: " + n);
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        else
            return getFib(n-1)+getFib(n-2);
    }

    static Map<Long, Long> memoization = new HashMap<Long, Long>();

    public static long getFibMemoization(long n){

        if (memoization.get(n) != null)
        {
            return (memoization.get(n));
        }

        System.out.println("getFib: " + n);
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        else {
            long result = getFibMemoization(n - 1) + getFibMemoization(n - 2);

            memoization.put(n, result);

            return result;
        }
    }


    static Map<Long, Long> memoization2 = new TreeMap<Long, Long>();

    public static long getFibMomization2(long n){
        if(memoization2.get(n)!=null)
        {
            return (memoization2.get(n));
        }
        System.out.println("getFib: " + n);
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        long result = getFibMomization2(n - 1)+ getFibMomization2(n - 2);
        memoization2.put(n, result);
        return result;
    }

    public static long getFibBottom(int x){
        long[] fib = new long[x+1];
        fib[0]=0;
        fib[1]=1;
        for(int k=2;k<x+1;k++)
            fib[k]=fib[k-1]+fib[k-2];
        return fib[x];
    }

}
