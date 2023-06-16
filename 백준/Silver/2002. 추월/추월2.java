import java.util.*;
import java.io.*;

//문자열
public class Main {

    static int N;   // 차량수
    static String[] in;
    static String[] out;
    static boolean[] visit;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        in = new String[N+1];
        out = new String[N+1];
        visit = new boolean[N+1];

        // 터널의 입구
        for(int i =1; i<=N; i++){
            in[i] = br.readLine();
        }

        // 터널의 출구
        for(int i =1; i<=N; i++){
            out[i] = br.readLine();
        }


        // 확인
        for(int i =1; i<=N; i++){
            for(int j =1; j<=N; j++){

                if(in[i].equals(out[j])){
                    visit[j] = true;
                    break;
                }

                // 나를 만나기 전에 나오는 차들은 모두 자신을 추월한 차량임
                else{
                    if(!visit[j]){
                        answer++;
                        visit[j] = true;
                    }
                }
            }
        }

        System.out.println(answer);
    }

}