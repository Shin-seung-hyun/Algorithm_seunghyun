import java.util.*;
import java.io.*;


//구현
class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        boolean[][] paper = new boolean[100 + 1][101];

        //넓이 계산
        int answer = 0;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int j=x; j< x + 10; j++){
                for(int k = y; k <y + 10; k++){
                    if(paper[j][k]) continue;

                    paper[j][k] = true;
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

}