package java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Isabel on 8/2/2016.
 */
public class Lambda2WithBraces {
    public static void main(String[] args){
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        System.out.println(names);

        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });

        System.out.println(names);
    }

}
