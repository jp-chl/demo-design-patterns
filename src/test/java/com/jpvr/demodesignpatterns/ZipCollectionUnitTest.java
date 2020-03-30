package com.jpvr.demodesignpatterns;

import org.jooq.lambda.Seq;
import org.jooq.lambda.tuple.Tuple2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@TestInstance(Lifecycle.PER_CLASS)
public class ZipCollectionUnitTest {

    private List<String> names;
    private List<Integer> ages;
    private List<String> expectedOutput;

    @BeforeAll
    public void setUp() {//} throws Exception {

        names = Arrays.asList("John", "Jane", "Jack", "Dennis");
        ages  = Arrays.asList(24, 25, 27);
        expectedOutput = Arrays.asList("John:24", "Jane:25", "Jack:27");
    } // end setUp()

    @Test
    public void zipCollectionUsingIntStream() {

        List<String> output = IntStream
                .range(0, Math.min(names.size(), ages.size()))
                .mapToObj(i -> names.get(i) + ":" + ages.get(i))
                .collect(Collectors.toList());

        assertEquals(expectedOutput, output);
    } // end void zipCollectionUsignIntStream()

    @Test
    public void zipCollectionUsingJool() {

        Seq<String> output = Seq
            .of("John", "Jane", "Jack")
            .zip(Seq.of(24, 25, 27), (x, y) -> x + ":" + y);

        assertEquals(expectedOutput, output.toList());
    } // end void zipCollectionUsingJool()

    @Test
    public void zipCollectionsUsingJoolTuple() {

        Seq<Tuple2<String, Integer>> output = Seq
            .of("John", "Jane", "Jack")
            .zip(Seq.of(24, 25, 27));

        Tuple2<String, Integer> element1 = new Tuple2<String, Integer>("John", 24);
        Tuple2<String, Integer> element2 = new Tuple2<String, Integer>("Jane", 25);
        Tuple2<String, Integer> element3 = new Tuple2<String, Integer>("Jack", 27);

        List<Tuple2> innerExpectedOutput = Arrays.asList(element1, element2, element3);

        assertEquals(innerExpectedOutput, output.collect(Collectors.toList()));
    } // end void zipCollectionsUsingJoolTuple()

    @Test
    public void zipCollectionsUsingJoolWithIndex() {

        Seq<Tuple2<String, Long>> output = Seq
            .of("John", "Jane", "Jack")
            .zipWithIndex();

        Tuple2<String, Long> element1 = new Tuple2<>("John", 0L);
        Tuple2<String, Long> element2 = new Tuple2<>("Jane", 1L);
        Tuple2<String, Long> element3 = new Tuple2<>("Jack", 2L);

        List<Tuple2> innerExpectedOutput = Arrays.asList(element1, element2, element3);

        assertEquals(innerExpectedOutput, output.collect(Collectors.toList()));
    } // end void zipCollectionsUsingJoolWithIndex()
} // end class ZipCollectionUnitTest
