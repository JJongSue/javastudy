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

* 



- super 키워드
- 메소드 오버라이딩
- 다이나믹 메소드 디스패치 (Dynamic Method Dispatch)
- 추상 클래스
- final 키워드
- Object 클래스