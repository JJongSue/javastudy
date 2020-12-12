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
if (조건식) true일 경우 처리할 문장

if (조건식) {
	처리할 문장
}
```

* 이런식의 구조로 되어있으며, 조건식이 참일 경우, 코드를 실행한다.
* 조건식에는 변수, 관계연산자, 논리연산자 등이 들어간다.



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
if (조건식) 조건식이 true일 경우처리할 문장 
else if(조건식) 위의 조건식이 false이고, 현재 조건식이 true 처리할 문장
else if(조건식) 처리할 문장
...
else 위의 조건식 모두 false일때 처리할 문장

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

```
switch (변수){
	case 값:
		실행문;
		break;
		
	...
	
	default
		실행문;
		break;

}
```

* 변수에는 int, short, char, byte, 또는 래퍼클래스,  String(java8때 추가), enum이 가능하다
* case값과 일치하는 실행문을 실행
* break가 없을 경우 case이후 break가 나올때까지의 case문을 모두 실행



```
String str = "hi";
    switch (str){
        case "hi":
        case "HI":
            System.out.println("HI");
            break;
        case "Hello":
            System.out.println("Hello");
        case "HELL":
            System.out.println("HELL");
            break;
        default:
            System.out.println("default");
```

```
String str = switch (inputstr) {
	case "A" -> "A";
	case "B", "b" -> "B";
	default -> 'default';
}
```

* java12이후에는 지시자(->)나 복수의 case로 간략화가 가능하다.



### 반복문

* 코드를 자동으로 반복시켜주는 구문
* for, while(do while)이 있다.
* 무한루프가 발생할 수 있다.



##### for

```
for(초기화식; 조건부; 증감부){
	// 반복할 문장
}
```

* 초기화식, 조건부, 증감부는 반드시 작성하지 않아도 되지만, 세미콜론(;)은 반드시 존재해야한다.
* for문안에 for문을 여러 개 넣어 다중 for문을 활용하기도 한다.

```
for(int i=0;i<5;i++){
    for(int j=0;j<i;j++){
        System.out.print("*");
    }
    System.out.println();
}
```

```

*
**
***
****
```



##### for each

* jdk 5.0 부터 제공되는 기능
* 순차적으로 변수에 객체를 대입하여 수행하는 for문
* 인덱스를 통한 접근은 불가하므로 그 경우 for문을 사용한다.
* 더 간결하게 컬렉션(Collection) 데이터를 사용할 수 있다.

* 컬렉션 프레임워크 : 다수의 데이터를 쉽고 효과으로 처리할 수 있는 표준화된 방법을 제공하는 클래스집합, 자세한 것은 17주차 예정

  

```
for(배열타입 변수명: 배열){
	//반볼할 문장
}

for(타입 변수명 : 컬렉션){
	//반복할문장
}
```

```
int arr[] = {1,2,3};
for(int i=0;i<3;i++){
    System.out.println(arr[i]);
}

for (int a : arr){
    System.out.println(a);
}
```

```
1
2
3
1
2
3
```



##### while

```
while(조건문) {
	//반복할 문장
}

do{
	//반복할 문장
}while(조건문);
```

* 조건문이 참일 동안 반복한다.
* 종료시점을 정해주지않으면 무한반복한다.



```
int i = 0;
while(i < 5){
    System.out.println(i);
    i++; //증감이 없으면 0 , 0 0 0 0 무한루프
}

do{
    System.out.println(i);
    i--;
}while(i > 0);
```

```
1
2
3
4
5
4
3
2
1
```



##### break, continue

* 반복문 사용시 종료를 원할경우 break;, 반복문 사용시 아래문장을 skip하고 싶을 경우에 continue 사용



```
while(true){
    i++;
    if(i == 2) continue;
    System.out.println(i);
    if(i == 5) break;
}
```

```
1
3
4
5
```



## 과제 0. JUnit 5 학습하세요.

* 단위 테스트 : 소스 코드의 특정 모듈이 의도대로 정확히 작동하는지 검증하는 일련의 절차 과정



### JUnit5

* 자바용 단위 테스트 작성을 위한 산업 표준 프레임워크
* java8 이상을 필요
* 메이븐으로 의존성을 추가해줘야한다.

```
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-engine</artifactId>
    <version>5.5.2</version>
    <scope>test</scope>
</dependency>
```



* 만약 내가 만든 arraystack을 테스트한다고 하면

```
public static void main(String[] args) {
    ArrayStack arraystack = new ArrayStack();
    Stack<Integer> stack = new Stack<>();
    arraystack.add(5);
    stack.add(5);

    arraystack.add(8);
    stack.add(8);

    arraystack.add(12);
    stack.add(12);

    while(!arraystack.is_empty()){
        int as = arraystack.pop();
        int s = stack.pop();
        if ( as != s) System.out.println("실패 실제 : "+ s + " 값 : " + as);
        else System.out.println("성공 " + as);
    }
}
```

* main문을 만들어 확인해야하지만 Junit을 사용하여 간단한 로직으로 작성할 수 있다.
* intelliJ는 ctrl+shift+t나 create test code를 통해 테스트 코드가 생성된다.

![image](https://user-images.githubusercontent.com/34182908/101490883-534f6a80-39a6-11eb-8ad5-74c7796c309a.png)

* 생성 직후의 모습

```
package week4;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class ArrayStackTest {


    @Test
    void is_full() {
    }

    @Test
    void is_empty() {
    }

    @Test
    void sizeUP() {
    }

    @Test
    void add() {
    }

    @Test
    void pop() {
    }
}
```



### 기본 어노테이션

#### @Test

* @Test는 각 각의 메소드가 단위 테스트임을 지정하는 어노테이션이다
* 이를 실행하면 아래와 같이 표시된다.

![image](https://user-images.githubusercontent.com/34182908/101491337-f7391600-39a6-11eb-9fb8-8e46fd6875ed.png)
![image](https://user-images.githubusercontent.com/34182908/101491480-26e81e00-39a7-11eb-936d-d6ac0835626f.png)

밑의 그림은 is_full()의 @Test를 지우고 실행했을 때의 모습이다.

@Test를 없앨 경우 테스트를 수행하지 않는다.



#### @BeforeAll / @AfterAll

* 각 각 static으로 선언되어야 한다.
* 해당 annotation이 달린 메서드가 현재 클래스의 모든 테스트보다 먼저 실행된다.
* 각 각 이전의 @BeforeClass, @AfterClass와 동일하다

```
@BeforeAll
static void beforeall2(){
    System.out.println("Before All2");
}

@BeforeAll
static void beforeal(){
    System.out.println("Before Al");
}

@BeforeAll
static void beforeall(){
    System.out.println("Before All");
}
@BeforeAll
static void beforeall1(){
    System.out.println("Before All1");
}
@AfterAll
static void afterall(){
    System.out.println("After All");
}

@Test
void is_full() {
    System.out.println("is_full");
}
```

```
Before All
Before All1
Before All2
Before Al

is_full

After All

Process finished with exit code 0
```

* @BeforeAll 내부에서 실행순서가 함수명 순인것 같은데 조금 더 알아봐야한다..



#### @BeforeEach / @AfterEach

* 각 각의 테스트 메서드 전에 실행 / 각 각의 테스트 메서드 이후에 실행
* 이전에는 @Before, @After이었다.

```
@BeforeAll
static void beforeall(){
    System.out.println("Before All");
}

@AfterAll
static void afterall(){
    System.out.println("After All");
}

@BeforeEach
void beforeeach(){
    System.out.println("BeforeEach");
}
@AfterEach
void aftereach(){
    System.out.println("AfterEach");
}

@Test
void is_full() {
    System.out.println("is_full");
}
@Test 4개
```

```
Before All

BeforeEach
AfterEach


BeforeEach
AfterEach


BeforeEach
AfterEach


BeforeEach
AfterEach


BeforeEach
is_full
AfterEach

After All

Process finished with exit code 0

```



#### Disabled

* 테스트 클래스 또는 메소드를 비활성화
* 이전의 @Ignore



#### @DisplayNameGenration

* 메소드와 클래스 레퍼런스를 사용해서 테스트 이름을 표기하는 방법 설정
* 기본 구현체로 ReplaceUnderscores 제공

#### @DisplayName

* 어떤 테스트인지 테스트 이름을 보다 쉽게 표현할 수 있는 방법을 제공하는 애노테이션
* @DisplayNameGeneration 보다 우선 순위가 높다.

```
@DisplayName("테스트is_full()")
@Test
void is_full() {
    System.out.println("is_full");
}
```

![image](https://user-images.githubusercontent.com/34182908/101494372-96134180-39aa-11eb-9fd0-5038e1f85c4b.png)









## 과제 1. live-study 대시 보드를 만드는 코드를 작성하세요.



## 과제 2. LinkedList를 구현하세요.



## 과제 3. Stack을 구현하세요.

```
public class ArrayStack {
    private int size = 16;
    private int[] Stack = new int[size];
    private int now = 0;

    boolean is_full(){
        return size == now;
    }
    boolean is_empty(){
        return size == 0;
    }
    void sizeUP(){
        int tmp[] = new int[size];
        for (int i = 0; i < size; i++) {
            tmp[i] = Stack[i];
        }
        Stack = new int[(size<<1)];
        for (int i = 0; i < size; i++) {
            Stack[i] = tmp[i];
        }
        size <<= 1;
    }

    void add(int input){
        if(is_full()) sizeUP();
        Stack[now++] = input;
    }

    int pop(){
        if(is_empty()){
            System.out.println("empty");
            return -1;
        }
        return Stack[now--];
    }
}
```





## 과제 4. 앞서 만든 ListNode를 사용해서 Stack을 구현하세요.



## 과제 5. Queue를 구현하세요.

