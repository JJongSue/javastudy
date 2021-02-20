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
* 단방향
* 바이트 기반의 추상클래스인 최상위 클래스 InputStream / OutputStream와 그것을 상속받는 FileInputStream, PrintStream 등등이 존재



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

* BufferedWriter의 구조 cb[] 버퍼, write에서 일정크기의 버퍼가 차면, 그것을 flushBuffer()



## Channel

* Stream과는 다르게  입출력이 양방향으로 가능한 통로 제공
* java.nio(new io) 클래스들은 channel기반의 IO 제공
* 기본적으로 입출력시 Buffer 사용



## java.io / java.nio

| java.io                               | java.nio    |
| ------------------------------------- | ----------- |
| Stream                                | Channel     |
| 단방향                                | 양방향      |
| InputStreamReader, OutputStreamReader | Reader      |
| Blocking                              | NonBlocking |



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

```
public abstract class InputStream implements Closeable {

    // MAX_SKIP_BUFFER_SIZE is used to determine the maximum buffer size to
    // use when skipping.
    private static final int MAX_SKIP_BUFFER_SIZE = 2048;

    private static final int DEFAULT_BUFFER_SIZE = 8192;
    
    ...
    
        public int read(byte b[], int off, int len) throws IOException {
        Objects.checkFromIndexSize(off, len, b.length);
        if (len == 0) {
            return 0;
        }

        int c = read();
        if (c == -1) {
            return -1;
        }
        b[off] = (byte)c;

        int i = 1;
        try {
            for (; i < len ; i++) {
                c = read();
                if (c == -1) {
                    break;
                }
                b[off + i] = (byte)c;
            }
        } catch (IOException ee) {
        }
        return i;
    }
    
    ..
```

* 내부적으로 byte로 읽어오고, Buffer를 사용하지 않아, 데이터의 양이 많을 경우 성능이 느리다.





## Byte와 Character 스트림

* Byte 스트림 
  * 1바이트 기반의 데이터 입출력
  * FileInputStream, FileOutputstream, FilterInputStream, PrintStream 등
* Character 스트림
  * 2바이트 단위의 데이터 입출력(유니코드 기반)
  * Raeader, Writer가 들어가며 BufferedReader, BufferedWriter, FileReader 등

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
가
�
```



```
try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
    int b = br.read();
    System.out.println((char)b);
}catch (IOException e){
    System.out.println("IOException!");
}
```

```
가
가
```



## 표준 스트림 (System.in, System.out, System.err)

* 자바에서 미리 정의해둔 표준 입출력 스트림
* 콘솔 화면에 입출력된다고 해서 콘솔 입출력이라고도 함

* System.in.read(), System.out.write()로 기본적인 입출력

```
public final class System {
	public static final InputStream in = null;
    public static final PrintStream out = null;
    public static final PrintStream err = null;
	
    public void println(char x) {
        synchronized (this) {
            print(x);
            newLine();
        }
    }
    
    public void print(char c) {
        write(String.valueOf(c));
    }
```

```
public class SystemExample {
    public static void main(String[] args) {
        System.out.println("System out println");
        System.err.println("System err println");
        System.out.print("System out print");
        System.err.print("System err print");
    }
}

```

```
D:\>java SystemExample > system.txt
System err println
System err print

```

```system.txt
System out println
System out print
```

* System.out.print는 표준출력을 하지만 System.err.print의 경우 표준에러 출력으로 에러메시즈를 화면으로만 출력
* 다른 파일등으로 결과가 redirection 되지 않음



## 파일 읽고 쓰기

```
public class FileStreamExample {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String fileInputName = null;
        String fileOutputName = null;
        String line = null;

        try {
            fileInputName = br.readLine();
            fileOutputName = br.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            BufferedReader fbr = new BufferedReader(new FileReader(new File(fileInputName)));
            BufferedWriter fbw = new BufferedWriter(new FileWriter(new File(fileOutputName)));
            while( (line = fbr.readLine()) != null ){
                System.out.println(line);
                fbw.write(line);
                fbw.newLine();
            }
            fbw.flush();


        }catch(FileNotFoundException e){

        }catch(IOException e){

        }



    }
}
```



