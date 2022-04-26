package es.fpdual;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import es.fpdual.model.Person;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("Juan", 24, "juan@email.com"),
                new Person("Pepe", 17, "pepe@email.com"),
                new Person("Carlos", 20, "carlos@email.com"),
                new Person("Laura", 26, "laura@email.com"),
                new Person("Fran", 21, "fran@email.com"),
                new Person("Pablo", 19, "pablo@email.com")

        );

        System.out.println("Unordered list: ");
        personList.forEach(p -> System.out.println(p));
        System.out.println("");

        // Collections.sort(personList, (person1, person2) ->
        // Person.compareByAge(person1, person2));

        Collections.sort(personList, Person::compareByAge);

        System.out.println("Ordered list by age: ");
        personList.forEach(p -> System.out.println(p));
    }
}
