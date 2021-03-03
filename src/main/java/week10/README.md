# 10주차 과제: 멀티쓰레드 프로그래밍

# 목표

자바의 멀티쓰레드 프로그래밍에 대해 학습하세요.

# 학습할 것 (필수)

- Thread 클래스와 Runnable 인터페이스
- 쓰레드의 상태
- 쓰레드의 우선순위
- Main 쓰레드
- 동기화
- 데드락



# Thread 클래스와 Runnable 인터페이스

* 프로세스
  * 운영체제에서 실행중인 하나의 어플리케이션(메모리를 할당받아 실행 중인 프로그램)
  * JVM이 시작되면 자바 프로세스가 시작
* 쓰레드
  * 프로세스 내의 실행의 흐름의 단위
  * 하나의 프로세스에 여러 개의 쓰레드가 존재할 수 있고 이를 멀티 쓰레드라 함
* 자바에서 쓰레드를 만드는 법은

1.  java.lang의 Runnable 인터페이스를 구현하는 것(주로 사용함)
2.  Runnable을 구현한 Thread 클래스를 상속 받는 방법

```
public class ThreadMain {
    public static void main(String[] args) {
        ImplThread it = new ImplThread();
        new Thread(it).start();

        ExtendsThread et = new ExtendsThread();
        et.start();
    }
}

class ImplThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Runable Thread가 생성되었습니다.");
    }
}

class ExtendsThread extends Thread{
    @Override
    public void run(){
        System.out.println("ExtendsThread가 생성되었습니다.");
    }
}
```

```
Runable Thread가 생성되었습니다.
ExtendsThread가 생성되었습니다.
```

* 쓰레드가 수행되는 run() 메소드는 구현해야한다
* start() 메소드를 통해 쓰레드를 실행할 수 있다.



### Runnable

```
class ImplThread implements Runnable{

    @Override
    public void run() {
        System.out.println("Runable Thread가 생성되었습니다.");
    }
}
```



### Thread

```
class ExtendsThread extends Thread{
    @Override
    public void run(){
        System.out.println("ExtendsThread가 생성되었습니다.");
    }
}
```



생성자

* Thread() : 새로운 쓰레드 생성
* Thread(Runnable target ), Thread(Runnable, target, String name)
* Thread(ThreadGroup group, Runnable target), Thread(ThreadGroup group, Runnable target, String name), Thread(ThreadGroup group, Runnable target, String name, long stackSize), Thread(ThreadGroup group, Runnable target, String name, long stackSize, boolean inheritThreadLocals),  Thread(ThreadGroup group, String name)
* 8가지의 생성자 존재(이름, 그룹, 스택사이즈 등)



```
ExtendsThread et = new ExtendsThread();
et.start();
for (int i = 0; i < 10; i++) {
    new NameThread(Integer.toString(i)).start();
}
```

```
class NameThread extends Thread{
    NameThread(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println(NameThread.currentThread().getName() + " is Run");
    }
}
```

```
2 is Run
4 is Run
5 is Run
8 is Run
0 is Run
3 is Run
7 is Run
1 is Run
6 is Run
9 is Run

```

* 여러 번 실행시 매번 다른 결과값이 나오는데, 쓰레드 구현 시 start() 메소드를 호출하면, 쓰레드 클래스에 있는 run() 메소드의 내용이 끝나든, 끝나지 않던 간에 쓰레드를 시작한 메소드에서는 그 다음 줄에 있는 코드를 실행한다



## 쓰레드의 상태

1. new

* 쓰레드가 생성되었지만 아직 start는 호출되지 않은 상태

2. runnable

* 실행 대기중인 상태로 언제든 실행 상태가 될 수 있는 상태

3. waiting

* 일시 중지중인 상태로 다른 쓰레드의 notify를 기다리는 상태

4. Blocked

* 일시 정지 중 하나로 공유 객체의 락이 풀리기를 기다리는 상태
* 공유 객체 락은 공유 객체에 대해 이미 다른 쓰레드가 사용중 일경우 다른 쓰레드가 사용하지 못하도록 동기화 한 것()

5. Termineted

* 모든 실행을 마친 상태

![image](https://user-images.githubusercontent.com/34182908/105850345-f3c81f80-6024-11eb-8f8d-0b3a6ba2a895.png)
![image](https://user-images.githubusercontent.com/34182908/105850362-f7f43d00-6024-11eb-90fc-89f7084ed51f.png)



## 쓰레드의 우선순위

* 대기하고 있는 상황에서 더 먼저 수행할 수 있는 순위
* 기본값 5 / 범위 1~10 높을수록 우선순위가 높아진다.
* getPriority(), setPriority(int newPriority)로 반환/변경 가능



## Main 쓰레드

* Java 실행시 실행하는 main() 메소드가 Main 쓰레드
* 따로 쓰레드를 실행하지 않고 main 메소드만 실행하면 싱슬 쓰레드 어플리케이션이라 한다.
* Daemon Thread
  * 메인쓰레드의 작업을 돕는 보조적인 역할을 하는 쓰레드
  * 메인 종료시 강제적으로 자동종료
  * 쓰레드에 setDaemon(true) 호출시 데몬 쓰레드가 됨



## 동기화

* 멀티 쓰레드에서 한 개의 리소스를 사용할때, 다른 쓰레드의 접근을 막는것 -> Thread-Safe
* Synchronized
  * 
* Atomic 클래스
* Volatile

데드락