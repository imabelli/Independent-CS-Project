package javaikmpreparation;

import java.io.FileNotFoundException;
import java.io.IOError;
import java.io.IOException;

/**
 * Created by Isabel on 8/4/2016.
 */
public class StaticOverRidding {
    public static void sayHi(){
        System.out.println("StaticOverRidding");
    }

    public boolean parent() throws IOException {
        throw new NullPointerException();
    }


    public boolean runtimeExeptionFunctionOverridenTest() throws NullPointerException {
        throw new NullPointerException();
    }

    private boolean overRidePrivateFunctionTest(){
        return false;
    }

    public static void main(String[] args){
        try {
            System.exit(0);
        }finally{
            //below line will not be executed if System.out called in try or catch block
            System.out.println("hi");
        }
    }
}

class B extends StaticOverRidding {

    //can only hide, not override
    //@Override
    public static void sayHi(){
        System.out.println("B");
    }




    //for runtime exception thrown from a function,  child function can throw a wider exception
    @Override
    public boolean runtimeExeptionFunctionOverridenTest() throws RuntimeException {
        throw new RuntimeException();
    }


    //for checked exception,  child thrown exception can not be wider,  can only be narrower or the same
    @Override
    public boolean parent() throws  FileNotFoundException  {
        throw new NullPointerException();
    }

    //you can hide but not override
    //@Override
    private boolean overRidePrivateFunctionTest(){
        return false;
    }



}