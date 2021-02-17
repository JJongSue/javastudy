# 13주차 과제: I/O

# 목표

자바의 Input과 Ontput에 대해 학습하세요.

# 학습할 것 (필수)

- 스트림 (Stream) / 버퍼 (Buffer) / 채널 (Channel) 기반의 I/O
- InputStream과 OutputStream
- Byte와 Character 스트림
- 표준 스트림 (System.in, System.out, System.err)
- 파일 읽고 쓰기



## 스트림 (Stream) / 버퍼 (Buffer) / 채널 (Channel) 기반의 I/O

### 스트림(Stream)

* JAVA IO의 핵심 개념

* 자바에서는 데이터는 스트림(Stream, 데이터의 흐름)을 통해 입출력된다



### 버퍼(Buffer)

* 입출력장치가 CPU보다 느리기 때문에 발생하는 비효율성을 방지하기 위해 나온 개념
* 메모리에 버퍼라는 공간을 두고 이를 쌓아놨다가 데이터가 버퍼크기보다 크면 flush()를 통해 출력

```
public class BufferedWriter extends Writer {

    private Writer out;

    private char cb[];
    private int nChars, nextChar;

    private static int defaultCharBufferSize = 8192;
    
    ...
    
    public void write(int c) throws IOException {
            synchronized (lock) {
                ensureOpen();
                if (nextChar >= nChars)
                    flushBuffer();
                cb[nextChar++] = (char) c;
            }
        }     
        
     ...
     
     void flushBuffer() throws IOException {
        synchronized (lock) {
            ensureOpen();
            if (nextChar == 0)
                return;
            out.write(cb, 0, nextChar);
            nextChar = 0;
        }
    }
    ...
```

* BufferedReader의 구조



* 많은 프로그램들이 유니코드(UTF-8 등)을 통해 문자를 표현하는 데, 위와 같이 stream은 byte를 처리하기 때문에 한글의 경우 깨지게 된다.
* 이를 해결하기 위해 Re



## InputStream과 OutputStream

* 바이트 기반의 추상클래스인 최상위 클래스 InputStream / OutputStream를 가지며  각 각 Closeable과 Closeable, Flushable를 상속받고 있다.

```
InputStream is = System.in;
int a = is.read();
is.close();
OutputStream os = System.out;
os.write(a);
os.flush();
os.close();

```

```
a
a
```

```
가
�
```

* InputStream에서는 read()를 통해 데이터를 읽고, OutputStream에선 write를 통해  쓰고, flush()를 통해 출력 스트림 내부의 작은 버퍼에 남아있는 데이터를 모두 출력후 비운다.
* 사용후 둘 다 close를 호출하여 시스템 자원을 풀어줘야한다.



- Byte와 Character 스트림
- 표준 스트림 (System.in, System.out, System.err)
- 파일 읽고 쓰기





