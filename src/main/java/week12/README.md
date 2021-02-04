# 목표

자바의 애노테이션에 대해 학습하세요.

# 학습할 것 (필수)

- 애노테이션 정의하는 방법
- [@retention](https://github.com/retention)
- [@target](https://github.com/target)
- [@documented](https://github.com/documented)
- 애노테이션 프로세서



## 애노테이션

* Annotation : 주석

* 정보의 정보인 메타데이터 라고도 부름
* 1.5에 등장
* 용도
  * 컴파일러에게 정보를 알려주거나
  * 컴파일할 때와 설치(deployment) 시의 작업 지정
  * 실행할 때 별도의 처리가 필요할 때



* @override

```
class Parent{
    void print(){
        System.out.println("Parent Print()!");
    }
}

class Child extends Parent{
    @Override
    void print(){
        System.out.println("Child Print()");
    }
}
```

* Override 했다는 것을 명시적으로 선언하는 것
* Override하지 않은 메소드에 사용할 경우 아래와 같은 에러가 발생한다.

![image](https://user-images.githubusercontent.com/34182908/106897406-37620e00-6736-11eb-92e6-7af715035301.png)

```
java: method does not override or implement a method from a supertype
```



* @Deprecated

```
@Deprecated
void cprint(){
    System.out.println("c print");
}
```

![image](https://user-images.githubusercontent.com/34182908/106898003-0209f000-6737-11eb-87fc-b75c30ef4edf.png)

* 더 이상사용하지 않은 클래스나 메소드에 선언시 경고를 띄어준다.



* SuppressWarnings