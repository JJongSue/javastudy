- # 목표

자바의 패키지에 대해 학습하세요.



# 학습할 것 (필수)

- package 키워드

- import 키워드

- 클래스패스

- CLASSPATH 환경변수

- -classpath 옵션

- 접근지시자

  

## package 키워드

* 클래스들의 묶음(폴더)
* 클래스의 이 중복이나 어떤 클래스가 어떤 일을 하는 지 혼동되는 경우를 방지하기 위해 클래스들을 폴더별로 묶는데 이를 패키지라 한다.

* 예시

```
예시
    ├── src
    │   ├── week1
    │   ├── week2

		...
		
    │   ├── week6
    │   │   ├── AbstartMain.java
    │   │   ├── Runner.java
    │   │   ├── Student.java

		...
		
        ├── week7

```

src 폴더 밑에 wee1, 2, ..의 폴더로 되어있는데, 이때 week6 밑의 AbstarctMain, Runner, Student는 같은 week6의 패키지가 된다.



```
package week6;

public class Runner extends Person{
    public Runner() {
        super();
    }

    void run(){
        System.out.println("run fast");
    }

}

```

```
package week6;

public class Student extends Person{

    void study(){
        System.out.println("hard study");
    }
}

```

* 컴파일시 가장 상위 폴더인 root 디렉터리에서 실행해야한다는 약속이 있다.
* 각 패키지 별로 가장 최상단에 현재 폴더와 일치하는  'package 패키지명;'을 하남ㄴ 선언해야한다.

```
    ├── src
    │   ├── week7
    │   │     ├── p1
    │   │     │   ├── hi.java
    	
```

```
package week7.p1;
```



| 패키지 시작이름 | 내용                                    |
| --------------- | --------------------------------------- |
| java            | 자바 기본 패키지(Java vendor 개발)      |
| javax           | 자바 확장 패키지(Java vendor 개발)      |
| org             | 일반적으로 비영리단체 (오픈소스) 패키지 |
| com             | 일반적으로 영리단체(회사) 패키지        |

* 패키지이름은 소문자
* 예약어X(ex int, static ...)



## import 키워드

* 자바는 같은 패키지에 있는 클래스들과 java.lang 패키지에 있는 클래스만 찾을 수 있다.
* import : 다른 패키지에 있는 클래스를 찾기 위해 사용되는 예약어
* import 패키지명.클래스명 / import 패키지명.*;
* java.lang 패키지, 같은 패키지는 import 하지 않아도 된다.

```
package week7;
public class Like {
    public void IL(){
        System.out.println("LIKE");
    }
}
```

```
package week7;
public class Like {
    public void IL(){
        System.out.println("LIKE");
    }
}
```

```
package week7;
//import week7.p1.*;
import week7.p1.hi;
public class Example {
    public static void main(String[] args) {
        hi h = new hi();
        h.hello();
        Like li = new Like();
        li.IL();
    }
}
```



#### import static

* jdk 5부터 static한 변수, 메소드를 사용할 때 편리한 기능



```
    ├── src
    │   ├── week7
    │   │     ├── Example.java
    │   │     ├── p1
    │   │     │   ├── StaticClass.java
    	
```



* StaticClass

```
package week7.p1;
public class StaticClass {
    public static int MAXVAL = 100;
    public static int MINVAL = 100;
    public static void print(){
        System.out.println("print!!!!");
    }

}
```

```
import week7.p1.StaticClass;
public class Example {
    public static void main(String[] args) {
        StaticClass.print();
    }
}
```

* 기존에 사용시 import 하여 클래스명.메소드명, 클래스명.변수명으로 사용해야 했지만

```
//import static week7.p1.StaticClass.*;
import static week7.p1.StaticClass.print;
public class Example {    
    public static void main(String[] args) {

//        StaticClass.print();
        print();
    }
```

* import static으로 클래스 이름을 지정하지 않아도 사용 가능하다.
* static  메소드, 변수가 중복되는 경우, 자신 클래스의 static 변수, 메소드가 우선이다.



## 클래스패스



## CLASSPATH 환경변수



## -classpath 옵션



## 접근지시자

* 클래스, 메소드, 인스턴스 및 클래스 변수를 선어할 때 사용
* 접근제어자 : 해당 메소드에 접근할 수 있는 범위(변수에도 사용 가능)
  * public : 어떤 클래스에서라도 접근 가능
  * protected : 동일 패키지 내의 클래스 또는 해당 클래스를 상속받은 외부 패키지 클래스에서 접근 가능
  * default : 접근제어자를 별도로 설정하지 않으면, default 접근제어자가 되고, 해당 패키지 내에서만 접근가능
  * private : 해당 클래스에서만 접근 가능

| 접근지정자                                | 클래스 내부 | 동일 패키지 | 하위 클래스 | 그 외 |
| ----------------------------------------- | ----------- | ----------- | ----------- | ----- |
| public                                    | O           | O           | O           | O     |
| protected                                 | O           | O           | O           | X     |
| default(기본, 생략 가능, package private) | O           | O           | X           | X     |
| private                                   | O           | X           | X           | X     |



* 클래스 선언시 반드시 클래스파일이름에 해당하는 클래스만 public으로 선언 가능하다.
* PublicClass.java

```
package week7;

class PublicClass {
    public static void main(String[] args) {
        Second.print();
    }
}

class Second{
    static void print(){
        System.out.println("Hello!");
    }
}
```

* 위와 같이 public으로 선언된 class 없이 default로 선언하여도 상관이 없으나

```

class PublicClass {
    public static void main(String[] args) {
        Second.print();
    }
}

public class Second{
    static void print(){
        System.out.println("Hello!");
    }
}

```

* PublicClass.java에서 PublicClass가 아닌 Second을 public으로 선언하면

```
Class 'Second' is public, should be declared in a file named 'Second.java'
```

* 에러가 발생