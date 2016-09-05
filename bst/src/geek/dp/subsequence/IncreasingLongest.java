package geek.dp.subsequence;

/**
 * Created by Isabel on 7/24/2016.
 */
public class IncreasingLongest {

    //int maxLength = 0;

    int[] maxLisAtArrayIndex = null;

//    private void setMax(int localMax){
//        if (localMax > maxLength){
//            maxLength = localMax;
//        }
//    }

    //returns the max increasing subSequence ending at index
    int getLengthMaximumIncreasingSubSequence(int[] inputArray, int index){


        //holder for maxLength for longest increasing subSequence ending at each index position
        //only initialized once
        if (maxLisAtArrayIndex == null )
        {
            maxLisAtArrayIndex = new int[inputArray.length];
        }


        if (index == 0)
        {
            maxLisAtArrayIndex[0]=1;
            return 1;
        }



        int previousLongest = 0;
        for (int i = 0; i < index ; i++){
            if (inputArray[i] < inputArray[index]){

                if (maxLisAtArrayIndex[i] == 0){
                    maxLisAtArrayIndex[i] = getLengthMaximumIncreasingSubSequence(inputArray, i);
                }

                if (maxLisAtArrayIndex[i] > previousLongest){
                    previousLongest = maxLisAtArrayIndex[i];
                }
            }
        }
        maxLisAtArrayIndex[index]=previousLongest + 1;
        return previousLongest + 1;
    }

    // driver program to test above functions
    public static void main(String args[])
    {
        int inputArray[] ={3, 4, 1, 5};

        IncreasingLongest program = new IncreasingLongest();

        int maxPosition = 0, maxLength = 0;
        for (int i = inputArray.length-1; i >=0; i--){
            int tempLength = program.getLengthMaximumIncreasingSubSequence(inputArray, i);
            if (tempLength >= maxLength){
                maxLength = tempLength;
                maxPosition = i;
            }
        }

        System.out.println("maxLength: "  +  maxLength + "  maxEndingPosition: " + maxPosition);
    }
}
