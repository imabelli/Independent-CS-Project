package java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java8.lambda.interfaces.Converter;

/**
 * Created by Isabel on 8/2/2016.
 */
public class Lambda5OneAbstractMethodInterfaceCanBeFunctional {
    public static void main(String[] args){
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123
    }

}
