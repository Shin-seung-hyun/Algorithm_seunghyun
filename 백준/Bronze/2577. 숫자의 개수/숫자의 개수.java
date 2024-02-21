import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int num  = A * B * C;
        int numArr[] = new int[10];

        //1. num을 연산으로 하나씩 떨구기
        // 4325
        while( num > 10){
            int idx = num % 10;
            numArr[idx]++;

            num = num/10;
        }
        numArr[num]++;


        //2. String으로 만들어서 하나씩 떨구기
//        String str = String.valueOf(num);
//
//        for(int i =0; i< str.length(); i++){
//            numArr[ str.charAt(i) - '0']++;
//        }

        //출력
        for(int i =0; i<10; i++) System.out.println(numArr[i]);

    }
}