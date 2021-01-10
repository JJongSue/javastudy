# 9주차 과제: 예외 처리



# 목표

자바의 예외 처리에 대해 학습하세요.



# 학습할 것 (필수)

- 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)
- 자바가 제공하는 예외 계층 구조
- Exception과 Error의 차이는?
- RuntimeException과 RE가 아닌 것의 차이는?
- 커스텀한 예외 만드는 방법



## 자바에서 예외 처리 방법 (try, catch, throw, throws, finally)

* null을 참조하거나, 배열의 index를 잘 못 접근할때 등 다양한 에러가 발생하는 데, 이때 에러를 무시하거나 적절한 처리를 하기 위한 방법

```
public class ExceptionExample {
    public static void main(String[] args) {
        ArrayException ae = new ArrayException();
    }
}

class ArrayException{
    int array[];

    public ArrayException() {
        array = new int[3];
        array[4] = 0;
    }
}
```

```
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 3
	at week9.ArrayException.<init>(ExceptionExample.java:14)
	at week9.ExceptionExample.main(ExceptionExample.java:5)
```

* 정상적으로 컴파일이 되고 실행시 java.lang.ArrayIndexOutOfBoundsException이 발생



```
try{
    ArrayException ae = new ArrayException();
    System.out.println(ae.array[0]);

} catch (Exception e) {
    System.out.println("error 발생");
}
```

```
error 발생
```

* try-catch로 묶어 주면 정상적으로 실행되고, catch안의 error 발생이 실행된다.



```
try{
	예외가 발생할 코드
}catch(Exception e){
	예외시 실행할 코드
}
```





* try-catch는 try 안의 내용을 주석처리하면 에러가 발생하지 않으므로 catch문은 실행되지 않는다.

```
try{
//            ArrayException ae = new ArrayException();
//            System.out.println(ae.array[0]);

} catch (Exception e) {
    System.out.println("error 발생");
}
```

* 

## 자바가 제공하는 예외 계층 구조



## Exception과 Error의 차이는?



## RuntimeException과 RE가 아닌 것의 차이는?



## 커스텀한 예외 만드는 방법

