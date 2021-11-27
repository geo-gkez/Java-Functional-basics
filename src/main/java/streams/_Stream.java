package streams;




import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Stream.Gender.FEMALE;
import static streams._Stream.Gender.MALE;


public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(

                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Mike", MALE),
                new Person("Takis", MALE),
                new Person("Mpampis", MALE),
                new Person("Tonia", FEMALE),
                new Person("Katia", FEMALE),
                new Person("Natassa", FEMALE)
        );

        people.stream()
                .map(person -> person.name)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println();
        System.out.println("name's length");

//        Function<Person, String> personStringFunction = person -> person.name;
//        ToIntFunction<String> length = String::length;
//        IntConsumer println = System.out::println;

        people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);

        System.out.println();
        System.out.println();
        System.out.println();

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        boolean containsAtLeastOneFemale = people.stream()
                .anyMatch(personPredicate);

        boolean containsOnlyFemales= people.stream()
                .allMatch(personPredicate);

        System.out.println("containsAtLeastOneFemale: "+containsAtLeastOneFemale);
        System.out.println("containsOnlyFemales: "+containsOnlyFemales);
    }

    static class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum Gender{
        MALE,FEMALE
    }
}
