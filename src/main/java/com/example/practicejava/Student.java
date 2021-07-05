package com.example.practicejava;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;


@Getter @Setter @AllArgsConstructor
public class Student {
    private Integer id;
    private String name;


    public static void main(String ... args) {

      //  System.out.println(
             //  var personAgg = createPeople().stream()
                //.filter(person -> person.getAge()>30)
//                .map(Person::getName)
//                .map(String::toUpperCase)
           //     .collect(collectingAndThen(maxBy(comparing(Person::getAge)), person -> person.map(Person::getName).orElse("")));
            //   System.out.println(personAgg);
       // );
//          Strategy Pattern
         List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);

         Predicate<Integer> greaterThan4 = (s) -> s<4;
         System.out.println(totalValue(numbers, greaterThan4));

      //   numbers.stream().takeWhile(n -> n==1).forEach(System.out::println);
//
//         numbers.stream().map(String::valueOf).map(String::toString).forEach(System.out::println);
//         System.out.println(
//                 createPeople().stream()
//
//         );
//        System.out.println("Add even "+totalValue(numbers, n -> n%2 == 0));
//        System.out.println("Add odd "+totalValue(numbers, n -> n%2 != 0));
//        System.out.println("Add all "+totalValue(numbers, n ->n>0));
//        numbers.stream().dropWhile(n -> n>2).forEach(System.out::println);

      //  IntStream.iterate(0, i -> i<=15, i -> i+3).forEach(System.out::println);

       // numbers.stream().filter(not(n -> n%2 == 0)).forEach(System.out::println);

     //   Optional<Integer> result = Optional.of(8);

     //   result.ifPresentOrElse(value -> System.out.println(value), () -> System.out.println("No value present"));
    }

  private static List<Person> createPeople() {
    return List.of(
        new Person("Sarah", 5),
        new Person("Nancy", 22),
        new Person("Bob", 22),
        new Person("Paula", 32),
        new Person("Paul", 32),
        new Person("Jack", 3),
        new Person("Bill", 73),
        new Person("Jill", 11));
  }

  private static int totalValue(List<Integer> numbers, Predicate<Integer> selector) {
    return numbers.stream().filter(selector).mapToInt(e -> e).sum();
      }
}
