package com.vistrav.flow;

public class FlowTest {

    public static void main(String[] args) {
        String[] tests = {"groupon", "google", "microsoft", "linkedin"};
        boolean result = Flow.of(tests).anyMatch(test -> test.startsWith("grou"));
        System.out.println("AnyMatch :: " + result);

        Integer result1 = Flow.of(tests).reduce(0, (Integer val, String test) -> val+1);
        System.out.println("=====>" + result1);
        String result2 = Flow.of(tests).firstMatch(t -> t.endsWith("soft1"));
        System.out.println(result2);
    }

}
