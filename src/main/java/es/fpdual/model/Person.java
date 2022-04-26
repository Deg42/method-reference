package es.fpdual.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Person {
    private String name;
    private Integer age;
    private String email;

    public static int compareByAge(Person a, Person b) {
        return a.getAge().compareTo(b.getAge());
    }
}
