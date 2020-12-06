package week4;

public class for1 {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        int arr[] = {1,2,3};
        for(int i=0;i<3;i++){
            System.out.println(arr[i]);
        }

        for (int a : arr){
            System.out.println(a);
        }

        int i = 0;
        while(i < 5){
            System.out.println(i);
            i++; //증감이 없으면 0 , 0 0 0 0 무한루프
        }

        do{
            System.out.println(i);
            i--;
        }while(i > 0);

        //무한루프
        while(true){
            i++;
            if(i == 2) continue;
            System.out.println(i);
            if(i == 5) break;
        }

    }
}
