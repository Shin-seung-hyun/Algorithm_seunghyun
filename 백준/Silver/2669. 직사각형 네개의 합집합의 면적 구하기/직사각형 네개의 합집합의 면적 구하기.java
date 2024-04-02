import java.util.*;
import java.io.*;

//구현
class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        boolean[][] visit = new boolean[101][101];

        int answer = 0;
        for(int i=1; i<=4; i++){
            st = new StringTokenizer(br.readLine());

            int lx = Integer.parseInt(st.nextToken());
            int ly = Integer.parseInt(st.nextToken());
            int rx = Integer.parseInt(st.nextToken());
            int ry = Integer.parseInt(st.nextToken());

            for(int j = lx; j<rx; j++){
                for(int k= ly; k <ry; k++) {
                    if (!visit[j][k]) {
                        visit[j][k] = true;
                        answer++;
                    }

                }
            }
        }

        System.out.println(answer);
    }
}
