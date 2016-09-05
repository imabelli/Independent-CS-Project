package maxsubsequencesum;

/**
 * Created by Isabel on 7/21/2016.
 */
public class BigOCubic {
    public static int maxSubSum1( int []a)
    {
        int maxSum = 0;

        for( int i = 0; i < a.length; i++ )
            for( int j = i; j < a.length; j++ )
             {
             int thisSum = 0;

             for( int k = i; k <= j; k++ )
                 thisSum += a[ k ];

             if( thisSum > maxSum )
                 maxSum = thisSum;
             }

         return maxSum;
         }


    public static void  main(String[] args){
        int test[] = {1, 2, 4, -1, 2, -3,1};

        System.out.println(maxSubSum1 (test));
    }
}
