# 목표

자바의 상속에 대해 학습하세요.

# 학습할 것 (필수)

- 자바 상속의 특징
- super 키워드
- 메소드 오버라이딩
- 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
- 추상 클래스
- final 키워드
- Object 클래스



## 상속(Inheritance)

* 상위 클래스의 모든 멤버를 하위 클래스가 물려 받는 것
* 기존의 클래스에 기능을 추가하거나 재정의하여 새로운 클래스를 정의하는 것을 의미
* 기존에 정의된 클래스를 부모 클래스, 상위 클래스(super class), 기초 클래스 라고 한다
* 새롭게 만들어지는 클래스를 자식 클래스(child class), 하위 클래스(sub class), 파생 클래스(derived class)
* extends를 이용한다.
* 상속을 하지 않는 경우 자동으로 Object라는 클래스를 상속받게 된다. => 모든 클래스는 Object 클래스를 super class로 가진다.
* 코드의 간결성, 재사용성을 위해 사용한다.



```
public class 클래스이름 extends 상위클래스이름{
	//클래스 내용

}
```



```
public class Person {
    int age = 20;

    void run(){
        System.out.println("slow");
    }
}
```

```
public class Student extends Person{
    void study(){
        System.out.println("hard study");
    }
}

```

* 부모의 run을 선언하지 않아도 자식의 student가 이를 상속받아 사용하고, 부모에는 없는 기능인 study를 사용할 수 있다.



```
Person person = new Person();
person.run();

Student student = new Student();
student.run();
student.study();

Runner runner = new Runner();
runner.run();
```

```
slow
slow
hard study
```



```
public class Runner extends Person{
    void run(){
        System.out.println("run fast");
    }
}

```

```
public static void main(String[] args) {
    Person person = new Person();
    person.run();

    Runner runner = new Runner();
    runner.run();
}
```



## 자바 상속의 특징

* 단일 상속만 가능 다중상속이 불가능하다. (extends 뒤에는 하나의 클래스!)
* 상속 받지 않을시 Object클래스를 자동으로 상속 => 모든 클래스의 최상위 부모 클래스는 Object
* 부모클래스에는 반드시 매개변수가 없는 기본 생성자가 있어야한다.(생성자를 만들지 않으면 자동으로 매개변수가 없는 기본생성자가 생성)
* 자식 클래스의 생성자를 호출하면 부모의 매개변수가 없는 기본 생성자가 호출된다



## super 키워드

- 자식 클래스에서 부모 클래스의 객체를 가르키는 참조 변수

- 메소드 오버라이드(재정의)할 경우 부모의 메소드를 재사용하기 위해서 사용

- this와 마찬가지고 super.부모변수, super.부모메소드(매개변수), super.() => 생성자 로 사용할 수 있다.

- 자식 클래스를 초기화시 super()를 호출한다.

  

```
public Runner() {
    super();
}
```



## 메소드 오버라이딩

* 재정의
* 자식 클래스에서 부모의 메소드를 재정의하면 부모의 메소드가 아닌 자식의 메소드를 호출하는데, 이것을 오버라이딩이라 함.
* 부모의 리턴타입, 매개변수 등이 모두 같아야한다.
* 접근 제어자의 경우, 부모보다는 좁은 범위로 변경할 수 없다.(public -> pirvate X, private => public O)

```
public class Person {
    int age = 20;

    public Person() {
        System.out.println("Person 생성자");
    }

    void run(){
        System.out.println("slow");
    }
}
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
public static void main(String[] args) {
    Person person = new Person();
    person.run();

    Student student = new Student();
    student.run();
    student.study();

    Runner runner = new Runner();
    runner.run();
}
```

```
Person 생성자
slow
Person 생성자
slow
hard study
Person 생성자
run fast
```



## 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)

* 메소드 디스패치 : 메소드를 어떻게 호출할 지를 정해서 호출하는 것(정적, 동적)
* 정적 메소드 디스패치(static) : 컴파일 타임에 메소드가 어떻게 실행될 지 결정됨(private, static, final은 static)
* 동적 메소드 디스패치(Dynamic) : 런타임에 결정됨.



## 추상 클래스

* 공통적인 부분(변수, 메소드)를 선언한 클래스
* 클래스 선언시 abstarct라는 예약어를 사용하여 선언하다.
* 선언후 변수나 메소드에 abstract를 붙여 선언할 경우, 상속받은 자식클래스는 abstract를 반드시 오버라이딩하여야 한다.

```
abstract class Car{
    public abstract void start();
}
class HD extends Car{

    @Override
    public void start() {
        System.out.println("fast");
    }
}
```



## final 키워드

- 불변()하게 하는 예약어(재정의를 막는다.)
- class, 변수, 메소드에 사용 가능하다
- 변수 : 변경할 수 없는 상수값이 된다
- 메소드 : 재정의 할 수 없게 만듬(오버라이딩)
- class : 클래스의 상속을 막음



## Object 클래스

* 상속받지 않을 경우 자동적으로 Object 클래스를 상속받으므로 모든 클래스의 최상위 클래스이다.
* 따라서 모든 클래스는 object의 기본메서드가 포함되어있다.
* toString(), hashCode() 등의 메소드가 있다.
* [자바 API](https://docs.oracle.com/javase/7/docs/api/)의 Object 클래스를 참고하면 자세한 정보를 알 수 있다.