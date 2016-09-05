package java8.lambda.interfaces;

@FunctionalInterface
public interface MyFirstFunctionalInterface {
public void firstWork();
default void doSomeMoreWork1(){
//Method body
}
default void doSomeMoreWork2(){
//Method body
}
}