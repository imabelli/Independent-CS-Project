package geek.dp.subsequence;

/**
 * Created by Isabel on 7/24/2016.
 */
public class MinimumCoins {

    int findMinCoins(int changeAmount, int[] coins){

        if (changeAmount == 0){
            return 0;
        }

        if (changeAmount < 0){
            throw new RuntimeException("change amount negative!");
        }

        int localMinCoinsCount = Integer.MAX_VALUE;

        for (int currentCoinCount : coins){
            if (currentCoinCount > changeAmount){
                continue;
            }

            if (currentCoinCount == changeAmount){
              return 1;
            }

            int recurrsiveMinCoinCount  = findMinCoins(changeAmount - currentCoinCount, coins);
            if (localMinCoinsCount > recurrsiveMinCoinCount){
                localMinCoinsCount = recurrsiveMinCoinCount;
            }
        }

        if (localMinCoinsCount  == Integer.MAX_VALUE){
            return localMinCoinsCount;
        }


        return localMinCoinsCount + 1;
    }


    public static void main(String[] args) {
        int[] coins = { 3, 4, 6 };
        int amount = 20;
        MinimumCoins m;
        m = new MinimumCoins();
        System.out.println("(Dynamic Programming) Minimum Coins required to make change for "
                + amount + " are: " + m.findMinCoins(amount, coins));
    }



}
