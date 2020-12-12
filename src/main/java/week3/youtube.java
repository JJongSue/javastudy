package week3;


import java.util.HashSet;
import java.util.Set;

public class youtube {
    public static void main(String[] args) {
        int i = 0;
        int j = 0;

        if(i++ == 0 || j++ == 0){
            System.out.println("Hello");
        }
        System.out.println(i);
        System.out.println(j);

        i = 0;
        j = 0;
        if(i++ == 0 | j++ == 0){
            System.out.println("Hello");
        }
        System.out.println(i);
        System.out.println(j);


        int start = Integer.MAX_VALUE;
        int end = Integer.MAX_VALUE;

        int mid = (start + end) / 2; //오버플로우가 날 수 있다.
        mid = start + (end - start )/2;
        mid = (start + end) >>> 1;
        // >> signed shift >>> unsigend shift
        // 양수에서만 가능, 음수는 안됨
        System.out.println(mid);

        // TODO numbers라는 int형 배열이 있다.
        // 해당 배열에 들어있는 숫자들은 오직 한 수자를 제외하고는 모두 두번씩 들어있다.
        // 오직 한번만 등장하는 숫자를 찾는 코드를 작성하라.

        youtube y = new youtube();
        System.out.println(y.solution(new int[] {5,2,4,1,2,4,5, 1, 0, 0, 3}));
        //​Integer[] array = new Integer[]{5, 10, 20, 58, 10}; Stream.of(array) .distinct() .forEach(i -> System.out.print(" " + i));

    }
    // 비트연산 xor
    private int solution(int [] numbers){
        int result = 0;
        for (int number : numbers) {
            result ^= number;
        }

        return result;
    }
}
