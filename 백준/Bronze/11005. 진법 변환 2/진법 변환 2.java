import java.util.*;
import java.io.*;

// 시뮬레이션
public class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        char[] arr = new char[B];
        for(int i=0; i<B; i++){

            if( i >=10) arr[i] = (char)( i -10 + 'A');
            else arr[i] = (char)(i + '0');
        }

        // 1차원 배열 출력하기
        //System.out.println(Arrays.toString(arr));

        while(num >0){
            sb.append( arr[num%B]);
            num = num/B;
        }

        System.out.println(sb.reverse().toString());
    }

}

//1 10 ..1
//   0

//2 10 ..0
//2  5 ..1
//2  2 .. 0
//   1