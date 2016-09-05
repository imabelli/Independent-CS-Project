package basics;

/**
 * Created by Isabel on 7/17/2016.
 */
public class PassByReference {

    public static void main(String[] args){

        ValueObject n = new ValueObject(10);

        PassByReference obj = new PassByReference();

        ValueObject result =obj.add5(n);

        System.out.println(result.n);
        System.out.println(n.n);
    }

    public ValueObject add5(ValueObject n){
        n.n = n.n + 5;
        return n;
    }

}

class ValueObject{
    int n;

    public ValueObject(int n){
        this.n = n;
    }
}
