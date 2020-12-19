# 목표

자바의 Class에 대해 학습하세요.

# 학습할 것 (필수)

- 클래스 정의하는 방법
- 객체 만드는 방법 (new 키워드 이해하기)
- 메소드 정의하는 방법
- 생성자 정의하는 방법
- this 키워드 이해하기

# 마감일시

2020년 12월 19일 토요일 오후 1시까지.

# 과제 (Optional)

- int 값을 가지고 있는 이진 트리를 나타내는 Node 라는 클래스를 정의하세요.
- int value, Node left, right를 가지고 있어야 합니다.
- BinrayTree라는 클래스를 정의하고 주어진 노드를 기준으로 출력하는 bfs(Node node)와 dfs(Node node) 메소드를 구현하세요.
- DFS는 왼쪽, 루트, 오른쪽 순으로 순회하세요.



## 클래스

* 객체 지향 프로그래밍(OOP) : 현실 세계의 사물을 객체로 보고,  객체를 기반으로 프로그래밍하는 기법
* OOP 특징
  * 캡슐화 : 하나의 객체에 대해 특정한 목적을 위해 필요한 변수나 메소드를 하나로 묶는 것(클래스 => 은닉화)
  * 추상화 : 객체의 공통적인 요소나 필수적인 요소를 정의해 놓은 것(인터페이스)
  * 다형성 : 오버로딩, 오버라이드(상속)
  * 상속 : 상위클래스를 기반으로 새로운 클래스 정의

* 객체 지향 프로그래밍(OOP)에서 특정 객체를 생성하기 위해 변수와 메소드를 정의하는 일종의 틀
* 객체를 정의 하기 위한 상태(변수)와 메서드, 생성자로 구성된다.
* 객체
  * 사전적 정의로는 실제로 존재하는 것
  * 프로그래밍에서는 클래스에 정의된 내용대로 메모리에 생성된 것
  * 





## 클래스 정의하는 방법

```
접근지정자 class 클래스명{

}
```

* 클래스는 속성을 표현하는 필드(변수), 기능을 표현하는 메소드로 구성된다.
* 접근제어자 : 해당 메소드에 접근할 수 있는 범위(변수에도 사용 가능)
  * public : 어떤 클래스에서라도 접근 가능
  * protected : 동일 패키지 내의 클래스 또는 해당 클래스를 상속받은 외부 패키지 클래스에서 접근 가능
  * default : 접근제어자를 별도로 설정하지 않으면, default 접근제어자가 되고, 해당 패키지 내에서만 접근가능
  * private : 해당 클래스에서만 접근 가능

| 접근지정자               | 클래스 내부 | 동일 패키지 | 하위 클래스 | 그 외 |
| ------------------------ | ----------- | ----------- | ----------- | ----- |
| public                   | O           | O           | O           | O     |
| protected                | O           | O           | O           | X     |
| default(기본, 생략 가능) | O           | O           | X           | X     |
| private                  | O           | X           | X           | X     |

* 클래스의 경우 생성자를 통해 객체를 만드므로, 생성자가 반드시 있어야하며, 없을 시 디폴트 생성자가 생성된다.
* 객체 변수의 경우 초기화를 하지 않아도 변수의 기본값에 맞게 자동으로 할당(boolean:false, int: 0 등)



```
public class TV {
    boolean on;
    int channel;
    private int volume= 20;

    public TV() {
        System.out.println("기본 생성자");
        print();
    }

    public TV(boolean on) {
        this.on = on;
        print();
    }

    public TV(boolean on, int channel) {
        this.on = on;
        this.channel = channel;
        print();
    }

    public void turnOn(){
        on = true;
        System.out.println("TV On");
    }

    public void print(){
        System.out.println("TV " + on +" channel : " + channel + " volume : " + volume);
    }
}
```





## 객체를 만드는 방법

```
클래스명 객체변수명 = new 클래스();
```

* 자바의 new 연산자를 통해서 객체를 메모리(Heap)영역에 할당한다. (메모리영역에 할당된 객체: 인스턴스)
* 그리고 그 주소값을 객체변수명에 반환해주고, 클래스() => 생성자를 호출

```
public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        TV tv2 = new TV(true, 50);
        tv.turnOn();
        tv.channel = 5;
        // private인 변수에 접근할 때 에러
        //tv.volume = 1;
    }
}
```

```
기본 생성자
TV false channel : 0 volume : 20
TV true channel : 50 volume : 20
TV On
```



## 메소드 정의하는 방법

```
접근제어자 반환타입 메소드명(매개변수들){ //선언부
  //구현부
  //void일 경우 반환타입이 없고
  //void가 아닐경우
  return 반환타입;

}
```

* 메소드가 모든 작업을 마치고 반환하는 데이터 타입(return 시 메소드 종료)
* 매개변수 목록 : 메소드 호출시 전달되는 인수의 값
* 구현부 : 기능을 수행하는 명령문의 집합

```
public void turnOn(){
        on = true;
        System.out.println("TV On");
    }
```

```
public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        TV tv2 = new TV(true, 50);
        tv.turnOn();
        tv.channel = 5;
        // private인 변수에 접근할 때 에러
        //tv.volume = 1;
    }
}
```

* 가변인자
  * jdk 1.5부터 매개변수의 개수를 동적으로 지정 가능

```
void outNum(int ... n){
    for(int i : n){
        System.out.println(i);
    }
}
```





## 생성자 정의하는 방법

* 생성자 : 객체
  * 반환값이 없는 메소드(유일)
  * 생성자의 이름은 반드시 클래스와 동일
  * 매개변수에 따라 여러 개를 만들 수 있다.

```
public TV(boolean on) {
    this.on = on;
    print();
}

public TV(boolean on, int channel) {
    this.on = on;
    this.channel = channel;
    print();
}
```

* 인텔리제이의 경우 alt+insert 키를 통해 Constructor를 통해 쉽게 생성가능



## 다형성

* 객체지향의 특징
* 여러 가지 형태를 가질 수 있는 능력
* 자바에서는 오버로딩(Overloading)과 오버라이딩(Overriding)이있다.
* 오버로딩
  * 하나의 클래스에서 같은 이름의 메소드를 여러 개 가질 수 있게하는 것(생성자 포함)
  * 인자는 달라야 한다.(갯수, 종류 등)

```
public TV(boolean on) {
    this.on = on;
    print();
}

public TV(boolean on, int channel) {
    this.on = on;
    this.channel = channel;
    print();
}

static void outNum(int ... n){
    for(int i : n){
        System.out.println(i);
    }
}
static void outNum(int a, int b){
    System.out.println("a : " + a);
    System.out.println("b : " + b);
}
```

* 오버라이딩
  * 상속 받은 클래스에서 상위 클래스의 메소드를 새롭게 정의하는 것(후에 상속때 다룰 예정)



## this 키워드 이해하기

* 인스턴스 자기 자신을 가르키는 키워드



1. 클래스의 속성을 사용할 때

```
public TV(boolean on, int channel) {
    this.on = on;
    this.channel = channel;
    print();
}
```



2. 다른 생성자 호출

```
public TV(boolean on) {
    this(on, 0);
}

public TV(boolean on, int channel) {
    this.on = on;
    this.channel = channel;
    print();
}
```



3. 객체 자기 자신을 전달할때

```
TV changeTv(){
    return this;
}
```

* 객체인 TV를 반환하는 changeTv()메소드가 있을때 이를 반환하는 메소드


[과제](https://github.com/JJongSue/javastudy/blob/master/src/main/java/week5/BinaryTree.md)