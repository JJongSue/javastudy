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



```
try{
    throw new ArrayIndexOutOfBoundsException("Array");
}catch (NullPointerException e){
    System.out.println("|");
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
```

* throw Exception객체 를 이용하면 예외를 발생시킬 수 있다.
* throw Exception를 checked Exception의 경우 try-catch로 묶지않으면 컴파일 에러 발생



```
void makeException() throws Exception {
    throw new Exception("make Exeption");
}
```

* throw를 try-catch로 묶지않고 컴파일 에러를 발생시키지 않는 방법이 있는데, thorws를 이용한다.
* 이 경우 thorws한 메서드를 사용할 경우, 그 메서드를 사용하는 곳에서 try-catch를 통해 예외를 처리하거나 마찬가지로 thorws를 통해 예외를 처리하면 된다.
* Exception을 이용할 경우 모든 에러가 발생할 수 있다를 내포하고, 특정 예외를 지정하거나 여러 개의 예외를 지정할 수 있다.



## 자바가 제공하는 예외 계층 구조

```
Object
├── Throwable
│	├── Error
│   │     
│   │     
│	├── Exeption
│   │     ├──────── Checked Exception(RuntimeException이 아닌 나머지 클래스)
│   │     │   
│   │     ├──────── RuntimeException(Uncheck Exception)
    	
```





## Exception과 Error의 차이는?

* Throwable을 상속받는 클래스
* Error는 컴파일 시 문법적인 오류, 런타임 시 Null값 참조 등으로 프로세스에 심각한 문제를 일으켜 프로세스를 종료시킬 수 있다(메모리 부족 등)
* Exception은 동작 도중 예기치 못한 상태 이상이 발생하여 수행 중인 프로그램이 영향을 받는 것, 오버플로우로 양의값이 음의 값이 되는 문제 등



## RuntimeException과 RE가 아닌 것의 차이는?

* RuntimeException : RE와 RE의 자손 클래스, 실행 단계에서 확인, 예외 발생 시 트랙잭션을 roll back
  * NullPointerException, IndexOutOfBoundException, SystemException 등
* RE가 아닌 것 : Exception 클래스의 자손중, RE을 제외한 모든 클래스, 반드시 예외처리 하여야한다, 컴파일 단계에서 확인, 예외 발생시 트랜잭션 처리 roll back하지 않음
  * IOException, SqlException 등





## 커스텀한 예외 만드는 방법

```
public class CustomExceptionMain {
    public static <ce> void main(String[] args) {


        try{
            System.out.println("Try");
            CustomExceptionMain cem = new CustomExceptionMain();
            cem.throwCustomException();
        }catch (CustomException ce){
            System.out.println("CustomException Catch");
        }
    }
    public void throwCustomException() throws CustomException{
        System.out.println("throwCustomException()!");
        throw new CustomException();
    }
}

class CustomException extends Exception{
    public CustomException() {
//        //super();
    }
//
    public CustomException(String message) {
//        //super(message);
    }
}
```

```
Try
throwCustomException()!
CustomException Catch
```

