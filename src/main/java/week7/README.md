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



## 클래스패스



## CLASSPATH 환경변수



## -classpath 옵션



## 접근지시자