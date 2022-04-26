package es.fpdual;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

import es.fpdual.model.Person;
import es.fpdual.utility.CompareProvider;

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

        List<String> numbersAsString = Arrays.asList("10", "12", "24", "36", "784", "12", "5", "12", "47", "8456", "23",
                "56", "23");

        System.out.println("Unordered list: ");
        personList.forEach(p -> System.out.println(p));
        System.out.println("");

        // Collections.sort(personList, (person1, person2) ->
        // Person.compareByAge(person1, person2));
        Collections.sort(personList, Person::compareByAge);

        System.out.println("Ordered list by age: ");
        personList.forEach(p -> System.out.println(p));
        System.out.println("");

        CompareProvider comparator = new CompareProvider();

        // Collections.sort(personList, (p1, p2) -> comparator.compareByName(p1, p2));
        Collections.sort(personList, comparator::compareByName);

        System.out.println("(Instance) Ordered list by name: ");
        personList.forEach(System.out::println);
        System.out.println("");

        // Collections.sort(personList, (per1, per2) -> per1.compareByName(per2));
        Collections.sort(personList, Person::compareByName);
        System.out.println("(Arbitrary object) Ordered list by name: ");
        personList.forEach(System.out::println);
        System.out.println("");

        // getResults(numbersAsString, (stringNumber) ->
        // Integer.parseInt(stringNumber));
        getResults(numbersAsString, Integer::new).forEach(App::printMultipliedBy10);

    }

    public static List<Integer> getResults(List<String> data, Function<String, Integer> func) {
        List<Integer> results = new ArrayList<>();

        data.forEach(strNum -> results.add(func.apply(strNum)));

        return results;
    }

    public static void printMultipliedBy10(int number) {
        System.out.println("New value of " + number + " is " + number * 10);
    }
}
