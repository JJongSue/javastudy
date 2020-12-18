package week5;

public class Main {
    static void outNum(int ... n){
        for(int i : n){
            System.out.println(i);
        }
    }
    static void outNum(int a, int b){
        System.out.println("a : " + a);
        System.out.println("b : " + b);
    }

    public static void main(String[] args) {
        TV tv = new TV();
        TV tv2 = new TV(true, 50);
        tv.turnOn();
        tv.channel = 5;
        // private인 변수에 접근할 때 에러
        //tv.volume = 1;
        outNum(1,2,3,4);
        outNum(1,2);
    }
}
