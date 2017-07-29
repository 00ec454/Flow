package com.vistrav.flow;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class FlowTest {

    Flow<String> countries;

    @BeforeMethod
    public void setUp() throws Exception {
        countries = Flow.of("USA", "Canada", "United Kingdom", "India", "Russia", "China");
        Flow.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);

        Integer sum = Flow.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(sum);

        String firstMatch = Flow.of("USA", "Canada", "United Kingdom", "India", "Russia", "China")
                .firstMatch(country -> country.endsWith("ia"));
        System.out.println(firstMatch);

        Flow.of("USA", "Canada", "India", "Russia", "China")
                .map(String::length).forEach(System.out::println);

    }

    @Test
    public void testFilter() throws Exception {
        List<String> countriesStartingWithC = countries.filter(c -> c.startsWith("C")).toList();
        Assert.assertEquals(countriesStartingWithC, Arrays.asList("Canada", "China"));
    }

    @Test
    public void testForEach() throws Exception {
        countries.forEach(System.out::println);
    }

    @Test
    public void testReduce() throws Exception {
        String concateWithSpace = countries.filter(c -> c.contains("n")).reduce("", (value1, value2) -> value1 + " " + value2);
        Assert.assertEquals(" Canada United Kingdom India China", concateWithSpace);
    }


    @Test
    public void testAnyMatch() throws Exception {
        boolean noAus = countries.anyMatch(c -> c.equals("Australia"));
        Assert.assertFalse(noAus);
    }

    @Test
    public void testFirstMatch() throws Exception {
        String canada = countries.firstMatch(c -> c.startsWith("C"));
        Assert.assertEquals(canada, "Canada");
    }

}