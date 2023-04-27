package org.example.lambda;

import java.util.Optional;
import java.util.stream.Stream;

public class Null {

    public static Optional<Integer> generateIntegerStream(Integer integer) {
        return Stream.ofNullable(integer).findAny();
    }

}
