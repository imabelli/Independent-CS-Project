package ikm;

/**
 * Created by Isabel on 8/9/2016.
 */
public class Test1 {


public static void main(String[] args){
    Long a  = new Long(10);
    long b  = 10;
    long k = -5;
    System.out.println(a.equals(b));
    System.out.println(Long.compare(a, k));
    System.out.println(Long.compareUnsigned(a, k));
}
}

class T2 extends Test1{
    T2(){

    }
    T2(int a){
        super();
        //this();
    }


}