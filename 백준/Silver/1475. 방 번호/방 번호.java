import java.util.*;
import java.io.*;

class Main{
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int roomNum = Integer.parseInt(br.readLine());

        int numArr[] = new int[10];

    //1. 다솜이 방번호 하나씩 나누기
        // 4325
        while(roomNum >0){
            numArr[roomNum % 10]++;
            roomNum = roomNum/10;
        }

    //2. 필요한 세트 수 구하기
        int result =0;
        for(int i=0; i<10; i++){

            if (numArr[i] == 0) continue;

            // 6, 9 일 때
            if( i == 6 || i == 9){

                // 둘 중 하나라도 0이면
                if (numArr[6] * numArr[9] == 0)
                    result = Math.max(result, numArr[i]/2 + numArr[i]%2 );
                else
                    result = Math.max(result, (numArr[6] + numArr[9] +1)/2 );
            }

            else result = Math.max(result, numArr[i]);
        }

        System.out.println(result);
    }
}