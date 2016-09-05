package java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Isabel on 8/2/2016.
 */
public class Lambda4OmittingParamTypeWhenCanBeDeduced {
    public static void main(String[] args){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        System.out.println(names);

        Collections.sort(names, ( a,  b) -> b.compareTo(a) );

        System.out.println(names);
    }

}
