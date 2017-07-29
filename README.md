# Flow
The Very light weight java 8 like stream for Android.


# Usage

### Filter

```java
        Flow.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
```

### Reduce

```java
        Integer sum = Flow.of(1, 2, 3, 4, 5, 6, 7, 8, 9)
                .reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(sum);  //output: 45

```

### First Match
```java
        String firstMatch = Flow.of("USA", "Canada", "India", "Russia", "China")
                .firstMatch(c -> c.endsWith("ia"));
        System.out.println(firstMatch); //India

```

### Map

```java
        Flow.of("USA", "Canada", "India", "Russia", "China")
                .map(String::length).forEach(System.out::println);

```

### How to include in your Android project

#### 1. Add this to your project `build.gradle`

```javascript
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

#### 2. Add this to your app module's build.gradle file:

```javascript
dependencies {
    ...
    compile 'com.github.00ec454:Flow:0.5'
}
```
check the of lib [latest version](https://jitpack.io/#00ec454/Flow) 

#### 3. And start using .... :)