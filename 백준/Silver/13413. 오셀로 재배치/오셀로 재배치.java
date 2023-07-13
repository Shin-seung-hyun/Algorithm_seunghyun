import java.util.*;
import java.io.*;

// 문자열
    // 1. 임의의 말을 골라서 서로의 위치 변경
    // 2. 말을 1개를 뒤집어서 색상 변경
// 목표 상태로 만드는 작업의 최소 횟수를 구하시오
class Main{

    static StringBuilder sb = new StringBuilder ();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i=1; i<=testCase; i++){
            int N = Integer.parseInt(br.readLine());    // 오셀로 말의 개수

            String inputStr = br.readLine();
            String goalStr = br.readLine();

            int Wcnt = 0;
            int Bcnt = 0;

            for(int j = 1; j<= N; j++){
                if(inputStr.charAt(j-1) != goalStr.charAt(j-1)){

                    if(inputStr.charAt(j-1) == 'W') Wcnt++;
                    else Bcnt++;
                }
            }

            if( Wcnt <= Bcnt) sb.append( Bcnt+ "\n");
            else sb.append(Wcnt + "\n");
        }

        System.out.println(sb.toString());
    }
}