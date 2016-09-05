package java8.lambda;

import java8.lambda.interfaces.Formula;

/**
 * Created by Isabel on 8/2/2016.
 */
public class InterfaceDefaultMethod {

    public static void main(String[] args){

        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };

        formula.calculate(100);     // 100.0
        formula.sqrt(16);

    }
}


