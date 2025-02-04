import java.util.*;
import java.io.*;

/*

    1. N번째 그룹에는 N개 만큼의 숫자가 존재한다.
    각 분수가 특정 대각선(행) 에 위치
    1번째 대각선: 1/1 → 1개
    2번째 대각선: 1/2, 2/1 → 2개
    3번째 대각선: 1/3, 2/2, 3/1 → 3개
    4번째 대각선: 1/4, 2/3, 3/2, 4/1 → 4개
    5번째 대각선: 1/5, 2/4, 3/3, 4/2, 5/1 → 5개

    2. N번째 대각선까지 총 몇 개의 숫자가 있는가?
    1번째 대각선까지의 총 숫자 개수: 1
    2번째 대각선까지의 총 숫자 개수: 1 + 2 = 3
    3번째 대각선까지의 총 숫자 개수: 1 + 2 + 3 = 6
    4번째 대각선까지의 총 숫자 개수: 1 + 2 + 3 + 4 = 10
    5번째 대각선까지의 총 숫자 개수: 1 + 2 + 3 + 4 + 5 = 15

    이것은 1부터 n까지의 합을 구하는 공식과 동일합니다.
    n번째 대각선까지 누적된 숫자 개수는 n * (n + 1) / 2

*/
public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(br.readLine());

        if(num ==1){
            System.out.println("1/1");
            return;
        }

        //1. 몇 번째 그룹인지 찾기
        int n = 0;
        int cnt = 0;
        while( cnt < num){
            n++;
            cnt = (n * (n+1))/2;
        }

        //2. 그룹의 몆 번째 값인지
        int value = num-(n*(n-1)/2);

        //3. 짝수, 홀수 그룹의 분자 분모 연산
        int top=1; int bottom =1;
        if(n%2 ==0){ //짝수이면
            top = value;
            bottom = n- value+1;
        }
        else{
            top = n-value+1;
            bottom = value;
        }

        System.out.println(top + "/" + bottom);
    }
}