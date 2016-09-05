package java8.lambda;

import java8.lambda.interfaces.Converter;

/**
 * Created by Isabel on 8/2/2016.
 */
public class MethodInterfaceAssignedStaticMethod {
    public static void main(String[] args){
        Converter<String, Integer> converter = Integer::valueOf;
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123
    }

}
