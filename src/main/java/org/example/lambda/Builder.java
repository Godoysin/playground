package org.example.lambda;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Builder {

    public static String createAStringUsingStreamBuilder() {
        Stream<String> streamBuilder = Stream.<String>builder().add("a").add("s").add("d").build();
        return streamBuilder.collect(Collectors.joining());
    }

}
