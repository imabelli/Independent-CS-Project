package basicrecursion;

/**
 * Created by Isabel on 7/17/2016.
 */
public class Palindrome {
    static String testBackwards="";
    static String x="amymya";
    static int e=x.length()-1;
    static int b=0;
    public static int maxCount=x.length()/2;
    public static int counter=0;

    public static void main(String args[]){
        //System.out.println(isPalindromeWhile(x,e));
        System.out.println(isPalindromeRecursion(x,b,e));
    }
    public static boolean isPalindromeWhile(String test, int index){
        while(index>=0) {
            testBackwards += test.charAt(index);
            index=index-1;
        }
        return testBackwards.equals(test);
    }
    public static boolean isPalindromeRecursion(String test, int beg, int end){
        if((test.charAt(beg))==(test.charAt(end))&&counter<maxCount){
            beg=beg+1;
            end=end-1;
            counter=counter+1;
            isPalindromeRecursion(test, beg, end);
        }
        if(counter==maxCount)
            return true;
        return false;
    }
}
