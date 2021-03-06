# 15주차 과제: 람다식

# 목표

자바의 람다식에 대해 학습하세요.

# 학습할 것 (필수)

- 람다식 사용법
- 함수형 인터페이스
- Variable Capture
- 메소드, 생성자 레퍼런스



## 람다식 사용법

* 인터페이스 형태를 통해 함수식을 표현한 것
* ( 매개변수목록 ) -> { 처리식 }
* 장점 : 코드의 가독성 향상, 병렬 프로그래밍 가능 등
* 단점 : 무명함수는 재사용 불가능, 너무 남발하면 지저분해질 수 있다 등
* 

```java
public class LamdaExample {
    public static void main(String[] args) {
        Calculate c = new Calculate<Integer>(){
            @Override
            public Integer operation(Integer a, Integer b){
                return a+b;
            }
        };
        Calculate<Integer> c2 = (a, b) -> a+b;
    }
}
@FunctionalInterface
interface Calculate<T>{
    T operation(T a, T b);
}
```



## 함수형 인터페이스

* 추상 메서드를 하나만 가지고 있는 메서드(SAM(Single Abastracgt Method))
* 구분을 위해 @FunctionalInterface를 사용한다

```java
@FunctionalInterface
interface Calculate{
    int operation(int a, int b);
}
```

* java.util.function 패키지에 java 8에서 제공하는 주요 함수형 인터페이스

  * Predicate, Supplier, Consumer, Function, 등

  * Predicate

    * boolean test(T t); 메소드 존재
    * 데이터 필터링, 조건에 맞는지 여부를 확인할 때 사용

    ```java
    Predicate<Long> p = (t) -> t>5 ? true:false;
    ```

  * Supplier

    * T get(); 메소드 존재

```java
Supplier<String> s = () -> "Hello Wolrd";
```





## Variable Capture

* 변수의 복사본을 만들어 접근을 허용한 것

```java
public class VarableCaptureMain {
    public static void main(String[] args) {
        int A = 10;
        int b = 10;
        FIAdd<Integer> fia = (a) -> A*a;
        System.out.println(fia.add(10));

        A = 20; // 주석 처리시 에러 발생X
    }
}

@FunctionalInterface
interface FIAdd <N>{
    N add(N input);
}
```

```
java: local variables referenced from a lambda expression must be final or effectively final
```

* 람다식은 지역 변수를 참조할 수 있는데, 이 경우 변수가 final 이거나 effectively final(초기화후 값이 변경되지 않음)해야 한다.
* 객체가 생성되면 힙영역에 데이터가 저장되고, 메소드의 정보는 스택에 저장된다.
* 지역변수를 참고할 경우 스택의 있는 영역을 참고하는데, 변수가 스택에서 사라질 수 있다
* 이를 방지하기 위해 람다 쓰레드가 해당 지역변수 복사본을 만들어 접근한다.
* 복사본을 사용하지만 멀티 스레드에서 사용할 경우 스레드마다 값이 변할 수 있기때문에 동기화를 위해 fianl/effetively final을 사용해야한다.



```java
public class VarableCaptureMain {
    static int sa = 10;
    public static void main(String[] args) {
        int A = 10;
        int b = 10;
        FIAdd<Integer> fia = (a) -> sa*a;
        System.out.println(fia.add(10));

        sa = 20;
        System.out.println(fia.add(10));
    }
}
```

* 스태틱이나 인스턴스 변수는 힙 영역에 생성되기 때문에 가능



## 메소드, 생성자 레퍼런스

* 람다식을 더 간단하게 표현하게 하는 것

```java
class Calc{
    static int add(int a, int b){
        return a+b;
    }
    int minus(int a, int b){
        return a-b;
    }
}

@FunctionalInterface
interface Operator<N extends Number>{
    N op(N a, N b);
}
```



1. static 메소드 참조

* 클래스명::메소드명

```java
Operator<Integer> oadd = (a, b) -> Calc.add(a,b);
oadd = Calc::add;
```

2. 인스턴스 메소드 참조

* 인스턴스명::메소드명

```java
Calc c= new Calc();
Operator<Integer> ominus = (a, b) -> c.minus(a, b);
ominus = c::minus;
```

3. 람다식의 매개변수로 접근 가능한 메소드 참조

* 매개변수 타입 클래스::메소드명

```java
Operator<Integer> ocmp = (a, b) -> a.compareTo(b);
ocmp = Integer::compareTo;
```



4. 생성자 참조

* 클래스명::new

