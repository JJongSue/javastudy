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
* 에러 
  * 컴파일 에러 : 컴파일시 발생하는 에러, 주로 문법 에러이며 비교적 수정이 쉽다.
  * 런타임 에러 : 실행시 발생하는 에러

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
	예외가 발생할 코드
}catch(Exception e){
	예외시 실행할 코드
}finally{
	반드시 실행되는 문장
	생략 가능

}
```



```
try{
    ArrayException ae = new ArrayException();
    System.out.println(ae.array[0]);

} catch (Exception e) {
    System.out.println("error 발생");
}  finally {
    System.out.println("finally");
}
```

```
error 발생
finally
```

* try-catch로 묶어 주면 정상적으로 실행되고, catch안의 error 발생이 실행된다.
* finally문을 작성하면 finally는 에러가 발생해도, 발생하지 않아도 반드시 실행된다.



* try-catch는 try 안의 내용을 주석처리하면 에러가 발생하지 않으므로 catch문은 실행되지 않는다.

```
try{
//            ArrayException ae = new ArrayException();
//            System.out.println(ae.array[0]);

} catch (Exception e) {
    System.out.println("error 발생");
} finally {
    System.out.println("finally");
}
```



```
try{
    ArrayException ae = new ArrayException();
    System.out.println(ae.array[0]);
}catch (NullPointerException e){
    System.out.println("NullPointerException");
}catch (ArrayIndexOutOfBoundsException e){
    System.out.println("ArrayIndexOutOfBoundsException");
} catch (Exception e) {
    System.out.println("error 발생");
} finally {
    System.out.println("finally");
}
```

```
ArrayIndexOutOfBoundsException
finally

Process finished with exit code 0
```

* 여러 개의 catch를 넣어 원하는 예외처리를 할 수도 있다.
* catch와 일치하는 exception을 찾지 못하면 예외가 처리되지 못한다.



```
catch (NullPointerException | InterruptedException){
            System.out.println("|");
        }
```

* JDK 1.7부터 여러 catch를 하나로 만드는 멀티 catch 블럭을 지원한다.
* 멀티 catch시 예외 클래스가 상속관계이면 에러가 발생하므로 조상 클래스만 사용하도록 한다.



throw, thorws 예외발생



## 자바가 제공하는 예외 계층 구조



## Exception과 Error의 차이는?



## RuntimeException과 RE가 아닌 것의 차이는?



## 커스텀한 예외 만드는 방법

