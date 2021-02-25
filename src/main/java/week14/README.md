# 14주차 과제: 제네릭



# 목표

자바의 제네릭에 대해 학습하세요.

# 학습할 것 (필수)

- 제네릭 사용법
- 제네릭 주요 개념 (바운디드 타입, 와일드 카드)
- 제네릭 메소드 만들기
- Erasure



## 제네릭 사용법

* JDK 1.5 부터 추가된 기능
* 실행전 컴파일 시 잘못된 타입을 강하게 체크하여 에러를 방지
* Ex) ArrayList



```
ArrayList al = new ArrayList();
al.add(1);
int a = (int)al.get(0);

ArrayList<Integer> al2 = new ArrayList();
al2.add(1);
int b = al2.get(0);
```



## 제네릭 주요 개념 (바운디드 타입, 와일드 카드)



## 제네릭 메소드 만들기



## Erasure