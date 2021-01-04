# 인터페이스

# 목표

자바의 인터페이스에 대해 학습하세요.



# 학습할 것 (필수)

- 인터페이스 정의하는 방법
- 인터페이스 구현하는 방법
- 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법
- 인터페이스 상속
- 인터페이스의 기본 메소드 (Default Method), 자바 8
- 인터페이스의 static 메소드, 자바 8
- 인터페이스의 private 메소드, 자바 9



## 인터페이스

* 상수, 추상메소드, default 메소드(java 8), static 메소드(java8), private 메소드(java9)만 선언 가능한 예약어
* 다중 상속이 가능하다
* 기본 접근제어자는 public



## 인터페이스 정의하는 방법

```
public interface Computer {
    public void on();
    public int max_battery = 100;
    public int min_battery = 0;
}
```

* interface로 선언 후 변수 선언 및 메소드는 구현부 없이 정의하여야한다.
* 변수는 반드시 초기화를 하여야 한다(public static final로 간주된다.)





## 인터페이스 구현하는 방법

```
public class Notebook implements Computer{
    @Override
    public void on() {
        System.out.println("Notebook ON!");
    }
    @Override
    public void off() {
        System.out.println("Notebook Turn OFF");
    }
}
```

* implements로 상속받고, 여러개의  인터페이스를 상속받을 수 있다.
* 상속받은 추상메소드는 반드시 구현하여야한다.



## 인터페이스 레퍼런스를 통해 구현체를 사용하는 방법

```
public class Week8Main {
    public static void main(String[] args) {
        Computer C = new Notebook();
        C.on();

        C = new Desktop();
        C.on();

        ((Desktop)C).upgrade();
    }
}

class Notebook implements Computer{
    @Override
    public void on() {
        System.out.println("Notebook ON!");
    }
    @Override
    public void off() {
        System.out.println("Notebook Turn OFF");
    }
}

class Desktop implements Computer{

    @Override
    public void on() {
        System.out.println("Desktop On");
    }

    @Override
    public void off() {
        System.out.println("Desktop off");
    }

    public void upgrade(){
        System.out.println("upgrade PC");
    }
}
```

```
Notebook ON!
Desktop On
upgrade PC
```

* 클래스처럼 부모클래스를 이용해 구현하는 것처럼 인터페이스도 가능하다.



## 인터페이스 상속

```
public class Note {
    void draw(){
        System.out.println("draw!");
    }
}

```

```
class SmartPhone extends Note implements Computer, Phone{
    @Override
    public void on() {
        System.out.println("Smart Phone On");
    }

    @Override
    public void off() {
        System.out.println("Smart Phone OFF");
    }

    @Override
    public void call(String phonenum) {
        System.out.println("SmartPhone Call "+ phonenum);
    }
}
```

* extneds는 다중상속이 불가능하지만, implements는 가능하다.

  



## 인터페이스의 기본 메소드 (Default Method), 자바 8

```
public interface Calculator {
    public int plus(int a, int b);
    default int exe(int a, int b){
        return a+b;
    }
}
```

```
public class CalcMain {
    public static void main(String[] args) {
        AbsCalculator ac = new AbsCalculator();
        System.out.println(ac.exe(-5, 6));
    }
}
class AbsCalculator implements Calculator{

    @Override
    public int plus(int a, int b) {
        return Math.abs(a)+Math.abs(b);
    }
}
```

* java 8부터 사용할 수 있는 기능
* default 메소드를 통해 인터페이스에서도 메소드를 구현할 수 있다.
* 그 전에는 인터페이스가 선언만할 수 있어서 인터페이스에 메소드를 추가시 인터페이스를 상속받는 모든 클래스에 추가된 메소드를 추가해야했지만 Default 메소드를 통해 이를 방지할 수 있다.
* 다중 상속을 통해 default메소드가 중복되는 경우 에러가 발생하는데, 이 경우 오버라이드하여야 한다.



## 인터페이스의 static 메소드, 자바 8



## 인터페이스의 private 메소드, 자바 9