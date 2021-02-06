# 목표

자바의 애노테이션에 대해 학습하세요.

# 학습할 것 (필수)

- 애노테이션 정의하는 방법
- [@retention](https://github.com/retention)
- [@target](https://github.com/target)
- [@documented](https://github.com/documented)
- 애노테이션 프로세서



## 애노테이션

* Annotation : 주석

* 정보의 정보인 메타데이터 라고도 부름
* 1.5에 등장
* 용도
  * 컴파일러에게 정보를 알려주거나
  * 컴파일할 때와 설치(deployment) 시의 작업 지정
  * 실행할 때 별도의 처리가 필요할 때



* @override

```
class Parent{
    void print(){
        System.out.println("Parent Print()!");
    }
}

class Child extends Parent{
    @Override
    void print(){
        System.out.println("Child Print()");
    }
}
```

* Override 했다는 것을 명시적으로 선언하는 것
* Override하지 않은 메소드에 사용할 경우 아래와 같은 에러가 발생한다.

![image](https://user-images.githubusercontent.com/34182908/106897406-37620e00-6736-11eb-92e6-7af715035301.png)

```
java: method does not override or implement a method from a supertype
```



* @Deprecated

```
@Deprecated
void cprint(){
    System.out.println("c print");
}
```

![image](https://user-images.githubusercontent.com/34182908/106898003-0209f000-6737-11eb-87fc-b75c30ef4edf.png)

* 더 이상사용하지 않은 클래스나 메소드에 선언시 경고를 띄어준다.



* SuppressWarnings

  * 컴파일러가 보여주는 경고 메시지를 무시하게 해줌

  

* @SafeVaragrs

  * java7부터 지원
  * Generic과 같은 가변인자의 매개변수를 사용할 때의 경고 무시

  

* @FunctionalInterface

  * Java8부터 지원
  * 함수형 인터페이스 지정(Ex Runnable 인터페이스)
  * 메서드가 존재하지 않거나, 1개 이상의 메서드(디플트 메소드 제외)가 존재시 컴파일 에러



## 애노테이션 정의하는 방법

```
@Myannotation
@MyAnnotation1(name = "first", value = 1, type = "class",array = {3,7,2,1})
@Myannotation2
//@Myannotation2(name = "hello")
class PracticeAnnotation{

}

@interface Myannotation{

}

@interface MyAnnotation1{
    String name() default  "myannotation";
    int value();
    String type() default "default";
    int[] array() default {1,2,3};
}

@interface Myannotation2{
    String name() default "hello";
}
```

* @interface로 선언해야한다
* 기본 타입, String, Class, 배열을 멤버로 가질 수 있고, default를 사용하여 기본값을 설정하고 반드시 ()로 정의하여야 한다.



## Meta Annotation

* 애노테이션을 위한 애노테이션
* target, retetion 등



## @retention

* 애노테이션의 유지시간을 지정
* CLASS, RUNTIME, SOURCE가 있다.

```
@Retention(RetentionPolicy.CLASS)
@interface Myannotation{
}
```



* CLASS : 클래스 파일에 존재, 런타임 시 사용불가, 기본값
* RUNTIME : 클래스 파일에 존재, 런타임 시 사용 가능(java.lang.reflect, Class)
* SOURCE : 소스파일에만 존재



```
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DefaineAnnotation {
    public static void main(String[] args) {
        Annotation a[] = PracticeAnnotation.class.getAnnotations();
        for (Annotation tmp :
                a) {
            System.out.println(tmp.toString());
        }
    }
}

@Myannotation
@MyAnnotation1(name = "first", value = 1, type = "class",array = {3,7,2,1})
@Myannotation2
//@Myannotation2(name = "hello")
class PracticeAnnotation{

}

@Retention(RetentionPolicy.CLASS)
@interface Myannotation{

}

@interface MyAnnotation1{
    String name() default  "myannotation1";
    int value();
    String type() default "default";
    int[] array() default {1,2,3};
}
@Retention(RetentionPolicy.RUNTIME)
@interface Myannotation2{
    String name() default "hello";
}
```

```
@week12.Myannotation2(name="hello")
```



## @target

* 애노테이션을 적용할 수 있는 위치 지정
* 선언한 위치와 다른 대상에 적용시 컴파일 에러

```
@Target(ElementType.ANNOTATION_TYPE)
```

- TYPE: class, interface, annotation, enum 에만 적용 가능
- FIELD: 필드, enum 상수에만 적용 가능
- METHOD: 메소드에만 적용 가능
- PARAMETER: 파라미터에만 적용가능
- CONSTRUCTOR: 생성자에만 적용 가능
- LOCAL_VARIABLE: 지역 변수에만 적용 가능
- ANNOTATION_TYPE: 애노테이션에만 적용 가능
- PACKAGE: 패키지에만 적용 가능
- TYPE_PARAMETER: 자바 8부터 추가 되었으며, 타입 파라미터(T,E 와 같은)에만 적용 가능
- TYPE_USE: 자바 8부터 추가되었으며, (JLS 의 15가지 타입)과 타입 파라미터에 적용 가능
- MODULE: 모듈에만 적용 가능



## @documented

* 지정된 대상의 JavaDoc에 이 어노테이션에 존재를 표시하도록 지정





## 애노테이션 프로세서

* 컴파일 시간에 사용자 정의 애노테이션 소스코드를 분석, 처리하기 위해 사용되는 hook
* Lombok, JPA 등이 예시이다