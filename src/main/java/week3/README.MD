# 3주차 과제: 연산자



## 목표

자바가 제공하는 다양한 연산자를 학습하세요.



## 학습할 것

- 산술 연산자
- 비트 연산자
- 관계 연산자
- 논리 연산자
- instanceof
- assignment(=) operator
- 화살표(->) 연산자
- 3항 연산자
- 연산자 우선 순위
- (optional) Java 13. switch 연산자





### 산술 연산자

* 기본적인 연산을 위한 자바에서 제공해주는 연산자

  

#### 기본적인 연산자

| 연산자 | 기능                      | 사용법    | 사용 설명                         |
| :----: | :------------------------ | :-------- | :-------------------------------- |
|   +    | 덧셈                      | op1 + op2 | op1과 op2를 더한다.               |
|   -    | 뺄셈 (또는 단항 마이너스) | op1 - op2 | op1과 op2를 뺀다.                 |
|   *    | 곱셈                      | op1 * op2 | op1과 op2를 곱한다                |
|   /    | 나눗셈                    | op1 / op2 | op1을 op2로 나눈다.               |
|   %    | 나머지                    | op1 % op2 | op1을 op2로 나눈 나머지를 구한다. |



```
		int a = 2;
        int b = 3;

        System.out.println("a = "+ a + " b = " + b);
        System.out.println("a + b = "+ (a+b) );
        System.out.println("a - b = " + (a-b));
        System.out.println("a / b = " + (a/b));
        System.out.println("a * b = " + (a*b));
        System.out.println("a % b = " + (a%b));
        //System.out.println(a%0);
        //System.out.println(a%0);
        System.out.println("0 / a = " + 0/a);
```



```
a = 2 b = 3
a + b = 5
a - b = -1
a / b = 0
a * b = 6
a % b = 2
0 / a = 0
```



0으로 나누기 연산을 진행시

Exception in thread "main" java.lang.ArithmeticException: / by zero 에러 발생



#### 전위/후위 연산자

* 변수를 증가, 감소 시키는 연산자
* 위치에 따라 전위/후위로 구분

| 연산자 | 기능               | 사용법 | 사용 설명                                           |
| :----: | :----------------- | :----- | :-------------------------------------------------- |
|   ++   | 전위(prefix) 증가  | ++op   | op에 값 1 증가, op값이 증가시킨 다음 값을 반환한다. |
|        | 후위(postfix) 증가 | op++   | op에 값 1 증가, op값이 증가시키기 전 값을 반환한다. |
|   --   | 전위(prefix) 감소  | --op   | op에 값 1 감소, op값이 감소시킨 다음 값을 반환한다. |
|        | 후위(postfix) 감소 | op--   | op에 값 1 감소, op값이 감소시키기 전 값을 반환한다. |



```
		System.out.println("a = " + a);
        System.out.println("++a " + ++a);
        System.out.println("a = " + a);

        System.out.println();
        System.out.println("a = " + a);
        System.out.println("a++ "+a++);
        System.out.println("a = " + a);

		System.out.println();
        System.out.println("a = " + a);
        System.out.println("--a " + --a);
        System.out.println("a = " + a);

        System.out.println();
        System.out.println("a = " + a);
        System.out.println("a-- "+a--);
        System.out.println("a = " + a);
```



결과

```
a = 2
++a 3
a = 3

a = 3
a++ 3
a = 4

a = 4
--a 3
a = 3

a = 3
a-- 3
a = 2
```



#### 대입 연산자

