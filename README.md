# Flow
The Very light weight java 8 like stream for Android


# Usage

```java
List<Integer> evens = Flow.of(1,2,3,4,5,6,7).filter(i -> i%2).toList();
```
