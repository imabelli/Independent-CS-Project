package java8.lambda;

import java8.lambda.interfaces.Converter;

/**
 * Created by Isabel on 8/2/2016.
 */
public class LambdaScopeReadWriteInstanceStaticVariable {

    public static void main(String[] args){
        Lambda4 lambda4 = new Lambda4();

        lambda4.testScopes();
    }

}

class Lambda4 {
    static int outerStaticNum;
    int outerNum;

    void testScopes() {
        Converter<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };

        Converter<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };

        stringConverter1.convert(2);
        stringConverter2.convert(2);

        System.out.println( outerNum  );
        System.out.println(outerStaticNum   );

    }
}