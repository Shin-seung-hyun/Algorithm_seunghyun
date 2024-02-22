import java.util.*;
import java.io.*;

//배열
class Main{

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 학생수
        int K = Integer.parseInt(st.nextToken()); // 한 방 내 최대 인원수

        int room[][] = new int[6+1][2]; // room[학년][성별]

        //최소 방의 개수를 출력하시오.

        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            int sex = Integer.parseInt(st.nextToken());   // 성별 ( 남1, 여 0)
            int year = Integer.parseInt(st.nextToken());  // 학년

            room[year][sex]++;
        }

        int cnt = 0;
        for(int i=1; i<=6; i++){        // 학년
            for(int j=0; j<2; j++){     // 성별
                
             //방법1. K개로 나눈 후, 나머지는 올림해야 함으로 room[i][j] + (K-1)을 함.
                cnt += (room[i][j] +(K-1) )/K;
                
             //방법2.
                //방 배정 + 남은 학생 방 배정
                //cnt += (room[i][j] /K) + (room[i][j] % K);
            }
        }

        System.out.println(cnt);
    }
}