package java8.lambda.interfaces;

/**
 * Created by Isabel on 8/2/2016.
 */
public interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}