package java8.lambda.interfaces;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
