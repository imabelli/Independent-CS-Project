package basics;

/**
 * Created by Isabel on 7/17/2016.
 */
public class PassByValue {
    public static void main(String[] args){

        int n = 10;

        PassByValue obj = new PassByValue();

        int result =obj.add5(n);

        System.out.println(result);
        System.out.println(n);
    }

    public int add5(int n){
        n = n+5;
        return n;
    }
}
