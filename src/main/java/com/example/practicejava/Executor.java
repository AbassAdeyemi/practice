package com.example.practicejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Executor {
    public static void main(String[] args) {

    //        int [] a = {5, 2, 3, 4, 6, 7, 8};
    //        int [] ans = EPI1.evenOdd(a);
    //        Stream<Integer> stream = IntStream.of(ans).boxed();
    //        stream.forEach(System.out::println);

    List<EPI1.Color> A =
        Arrays.asList(
            EPI1.Color.BLUE,
            EPI1.Color.RED,
            EPI1.Color.BLUE,
            EPI1.Color.WHITE,
            EPI1.Color.RED,
            EPI1.Color.RED,
            EPI1.Color.WHITE);
     List<Integer> list = Arrays.asList(1, 4, 4, 4, 5, 3);
     List<Double> doubles = Arrays.asList(310.00,315.00, 275.00, 295.00, 260.00, 270.00, 290.00, 230.00, 255.00, 250.00);
     List<Integer> B = new ArrayList<>(list);
        System.out.println(EPI1.deleteDuplicates(B));
    }
}
