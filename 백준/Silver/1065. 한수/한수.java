import java.util.Scanner;

public class Main {
    public static void main(String arg[]){

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int result = arithmetic_sequence(N);

        System.out.println(result);

    }


    public static int arithmetic_sequence(int N){

        int cnt = 0 ; // 한수의 수

        if(N < 100 ) return N;

        else{

            cnt = 99;

            for(int i = 100; i <= N; i++){

                int num1 = i / 100;
                int num2 = (i / 10) % 10;
                int num3 = i % 10;

                if((num1 - num2) == (num2 -num3)) cnt++;

            }

        }

        return cnt;
    }

}


