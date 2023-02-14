import java.util.*;

//그래프 DFS와 BFS
    // 격자형 문제 풀이
    // DFS
public class Main{

    static int N;           //지도의 크기
    static int group_cnt;   //단지 내에 집이 몇개 있는가
    static String[] a;      //격좌형 입력 받기
    static boolean[][] visit;
    static int [][] dir = {{1, 0}, {0,1}, {-1,0}, {0,-1}}; //빠른 위치 이동을 위해 임의로 생성한 좌표
    static ArrayList<Integer> group;    //인접 리스트

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        
        //개행문자 제거
        sc.nextLine();

        a = new String[N];
        for(int i = 0; i<N; i++){
            a[i] = sc.nextLine();
        }

        visit = new boolean[N][N];

        group = new ArrayList<>();
        //격좌형 반복
        for(int i =0; i<N; i++){
            for(int j =0; j<N; j++){

                //방문 하지 않았는데 + 집이 있는 칸이면 -> 단지 발견!!
                if(!visit[i][j] && a[i].charAt(j) =='1'){
                    group_cnt = 0;
                    DFS(i, j);
                    group.add(group_cnt);
                }
            }
        }

        //출력
        Collections.sort(group);
        sb.append(group.size()).append("\n");
        for(int cnt : group){
            sb.append(cnt).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void DFS(int x, int y){

        //(x,y) 방문했어요
        group_cnt++;
        visit[x][y] = true;

        //인접한 4곳에 갈 수 있니? 갈 수 있으면 가!
        for(int k =0; k<4; k++){

            //(x,y)에서 dir[k]만큼 움직인 위치를 찾는다
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];

            //격자를 벗어난 위치인지 확인
            if(nx <0 || nx >=N || ny <0 || ny>=N) continue;

            //유효한 격자라면 이 위치에 집이 있니?
            if(a[nx].charAt(ny) == '0') continue;

            //이미 방문한 적이 있니?
            if(visit[nx][ny]) continue;

            //이 모든 조건에도 걸러진다면
            DFS(nx,ny);

        }
    }
}