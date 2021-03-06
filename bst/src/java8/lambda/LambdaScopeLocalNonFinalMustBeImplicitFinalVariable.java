package java8.lambda;

import java8.lambda.interfaces.Converter;

/**
 * Created by Isabel on 8/2/2016.
 */
public class LambdaScopeLocalNonFinalMustBeImplicitFinalVariable {

    public static void main(String[] args){
        int num = 1;
        Converter<Integer, String> stringConverter =
                (from) -> String.valueOf(from + num);

        //num=2;
        System.out.println(stringConverter.convert(2));     // 3
    }

}
