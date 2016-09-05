package basicrecursion;

/**
 * Created by Isabel on 7/17/2016.
 */
public class Palindrome2 {

    public static void main(String args[]){
        //System.out.println(isPalindromeWhile(x,e));
        System.out.println(isPalindromeRecursion("aa"));
    }

    public static boolean isPalindromeRecursion(String testStr){
        if (testStr.length()==1  || testStr.length()==0)
        {
            return true;
        }

        int length = testStr.length();

        if (testStr.charAt(0)!=testStr.charAt(length -1))
        {
            return false;
        }

        return isPalindromeRecursion(testStr.substring(1, length -1));

    }
}
