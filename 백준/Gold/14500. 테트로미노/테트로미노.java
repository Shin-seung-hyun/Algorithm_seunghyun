import java.util.*;
import java.io.*;

// 테트로미노를 한 개 놓을 때, 놓인 칸들의 합의 최대 구하기
public class Main {

    static int N;   //세로
    static int M;   //가로
    static int[][] arr; // N * M 배열
    static boolean [][] visit;
    static int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1][M+1];
        arr = new int [N+1][M+1];

        for(int i =1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<=N; i++){
            for(int j =1; j<=M; j++){

                //ㅜ 를 제외한 나머지 4개 모양은 길이가 4인 DFS의 탐색 모양과 같다.
                visit[i][j] = true;
                DFS(i, j, 1, arr[i][j]);
                visit[i][j] = false;

                // ㅜ모양은 ㅓ,ㅏ,ㅗ로도 가능하므로 인접한 4칸 중 3칸을 선택한다
                    // 중복X, 순서X
                check(i, j, 0,1, arr[i][j]);
            }
        }

        System.out.println(answer);
    }

    static void check(int y, int x, int at, int depth, int sum){

    // 종료 조건
        // depth 4 인 경우 모두 탐색 완료
        if( depth == 3+1){
            answer = Math.max(answer, sum);
            return;
        }

    // 반복조건
        // (x,y)고정 ㅜ, ㅏ, ㅓ, ㅗ 순회
        for(int i = at; i<4; i++) {
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];

            if(nx <= 0 || ny <= 0 || ny > N || nx > M ) continue;
            
            // y, x 는 고정!!
            check(y, x, i + 1, depth + 1, sum + arr[ny][nx]);
        }
    }

    static void DFS(int y, int x, int cnt, int sum){

    // 종료조건
        // cnt가 4 인 경우 모두 탐색 완료
        if( cnt == 4 ){
            answer = Math.max(answer, sum);
            return;
        }

    // 반복조건
        for(int i =0; i< 4; i++){
            int ny = y + dir[i][0];
            int nx = x + dir[i][1];

            if(nx <= 0 || ny <= 0 || ny > N || nx > M ) continue;
            if(visit[ny][nx]) continue;

            visit[ny][nx] = true;
            DFS(ny, nx, cnt +1, sum + arr[ny][nx] );
            visit[ny][nx] = false;
        }
    }

}