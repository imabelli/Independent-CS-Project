package java8.lambda;

import java8.lambda.interfaces.Converter;

/**
 * Created by Isabel on 8/2/2016.
 */
public class MethodInterfaceAssignedConstructor {
    public static void main(String[] args){
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("Peter", "Parker");
    }

}


class Person {
    String firstName;
    String lastName;

    Person() {}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}