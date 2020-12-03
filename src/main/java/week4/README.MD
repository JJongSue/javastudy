# 목표

자바가 제공하는 제어문을 학습하세요.

# 학습할 것 (필수)

선택문
반복문

# 과제 (옵션)

## 과제 0. JUnit 5 학습하세요.

- 인텔리J, 이클립스, VS Code에서 JUnit 5로 테스트 코드 작성하는 방법에 익숙해 질 것.
- 이미 JUnit 알고 계신분들은 다른 것 아무거나!
- [더 자바, 테스트](https://www.inflearn.com/course/the-java-application-test?inst=86d1fbb8) 강의도 있으니 참고하세요~

## 과제 1. live-study 대시 보드를 만드는 코드를 작성하세요.

- 깃헙 이슈 1번부터 18번까지 댓글을 순회하며 댓글을 남긴 사용자를 체크 할 것.
- 참여율을 계산하세요. 총 18회에 중에 몇 %를 참여했는지 소숫점 두자리가지 보여줄 것.
- [Github 자바 라이브러리](https://github-api.kohsuke.org/)를 사용하면 편리합니다.
- 깃헙 API를 익명으로 호출하는데 제한이 있기 때문에 본인의 깃헙 프로젝트에 이슈를 만들고 테스트를 하시면 더 자주 테스트할 수 있습니다.

## 과제 2. LinkedList를 구현하세요.

- LinkedList에 대해 공부하세요.
- 정수를 저장하는 ListNode 클래스를 구현하세요.
- ListNode add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요.
- ListNode remove(ListNode head, int positionToRemove)를 구현하세요.
- boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.

## 과제 3. Stack을 구현하세요.

- int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
- void push(int data)를 구현하세요.
- int pop()을 구현하세요.

## 과제 4. 앞서 만든 ListNode를 사용해서 Stack을 구현하세요.

- ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요.
- void push(int data)를 구현하세요.
- int pop()을 구현하세요.

## 과제 5. Queue를 구현하세요.

- 배열을 사용해서 한번
- ListNode를 사용해서 한번.



## 제어문

* 프로그램의 흐름을 제어할 수 있도록 하는 실행문(<> 순차문 : 코드가 작성된 순서대로 실행대는 문장)



### 선택문

* 조건에 따라 코드의 실행을 제어하는 구문
* if, if ~ else, switch가 이 있다



##### if문

```
if (조건식) 처리할 문장

if (조건식) {
	처리할 문장
}
```

* 이런식의 구조로 되어있으며, 조건식이 참일 경우, 코드를 실행한다.
* 조건식에는 변수, 관계연산자, 논리연산자 등이 들어간다.
* 

```
int a = 1;
int b = 0;
if ( a == 1) System.out.println("a는 1");
if ( b == 1 ) System.out.println("b는 1");
if (a == 1 || b == 1) System.out.println("a 또는 b가 1");
if (++a == 2 || ++b == 1) System.out.println("a : " + a + " " + "b : " +b);
```

```
a는 1
a 또는 b가 1
a : 2 b : 0
```

* 논리연산자 중 ||의 경우, 앞의 것이 참일 경우 뒤의 내용을 실행하지 않고 처리한다.



##### if else문

```
if (조건식) 처리할 문장
else if(조건식) 처리할 문장
else if(조건식) 처리할 문장
...
else 처리할 문장

```

* 조건식이 참일 경우 코드를 실행, 참이 아닐 경우, else if문을 순차적으로 실행한다.
* 참일 경우 처리할 문장을 처리하고 종료하고, 위의 if, else if문이 모두 거짓일 경우 else 문을 실행한다.



```
a = 5;
b = 2;
if ( a == 1) System.out.println("a는 1");
else if ( a == 2) System.out.println("a는 2");
else if ( a == 3) System.out.println("a는 3");
else if ( a == 4) System.out.println("a는 4");
else  System.out.println("a는 5이상의 수");

if ( ++a == 7 ) System.out.println("a : " + a);
else if(++a == 7) System.out.println("a : " + a);
else if(++a == 10) System.out.println("a : " + a);
else System.out.println("a : " + a);

if (a == 8) System.out.println("a는 8");
else if (a == 9) System.out.println("a는 9");

if (a == 7) System.out.println("a는 7");
else System.out.println("a는 7이 아님");
```



```
a는 5이상의 수
a : 7
a는 7
```

* else if로 참이 수행후에는 다른 나머지 else if문은 조건을 처리하지 않는다.



##### switch







### 반복문