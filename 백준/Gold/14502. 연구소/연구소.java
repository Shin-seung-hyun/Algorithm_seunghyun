import java.util.*;

//그래프와 DFS, BFS
    // 벽 세우기 -> DFS (완전탐색)
    // 바이러스 퍼뜨리기 -> BFS
class Main{

    static StringBuilder sb = new StringBuilder();
    static int N;   //지도의 가로
    static int M;   //지도의 세로
    static int empty;   //지도의 빈공간
    static int answer;

    static boolean [][]visit;
    static int [][]dir = {{1,0}, {-1,0}, {0,1}, {0,-1}}; //임의의 값 설정
    static int [][] arr;    //지도 배열
    static int [][] blank;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        visit = new boolean[N+1][M+1];
        arr = new int[N+1][M+1];
        blank = new int[N * M +1][2];

        //지도 입력받기
        for(int i =1; i<=N; i++){
            for(int j =1; j<=M; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        //빈 벽의 위치를 모아놓기
        for(int i = 1; i<=N; i++){
            for(int j =1; j<= M ;j++){
                if(arr[i][j] ==0){
                    empty++;
                    blank[empty][0] = i;
                    blank[empty][1] = j;
                }
            }
        }

        // 벽 3개를 세우는 모든 방법
        DFS(1,0);

        System.out.println(answer);
    }

    //1. 벽 세우기 -  idx 번째 빈칸에 벽을 세울지 말지를 결정
        // 세운 벽의 수 selected_cnt
    static void DFS(int idx, int selected_cnt){

        //3개의 벽을 모두 다 세운 경우
        if(selected_cnt ==3){

            //바이러스 퍼뜨리기
            BFS();
            return;
        }

        //더 이상 세울 수 있는 벽이 없는 상태
        if(idx > empty) return;

        arr[blank[idx][0]][blank[idx][1]] =1;
        DFS(idx +1, selected_cnt+1);

        arr[blank[idx][0]][blank[idx][1]] = 0;
        DFS(idx +1, selected_cnt);

    }

    //2. 바이러스 퍼뜨리기
    static void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        
        // 시작점이 여러 개 일때 -> 모든 바이러스 위치를 큐에 넣어준다
        for(int i =1; i<=N; i++){
            for(int j =1; j<=M; j++){
                visit[i][j] = false;
                
                if(arr[i][j] ==2){
                    
                    //x좌표 y좌표를 queue에 추가
                    queue.add(i); //x 좌표
                    queue.add(j); //y 좌표
                    visit[i][j] = true;
                }
            }
        }
        
        while(!queue.isEmpty()){
            int x = queue.poll();
            int y = queue.poll();
            
            for(int k =0; k< 4; k++){
                int nx = x+ dir[k][0];
                int ny = y + dir[k][1];
                
                //좌표를 넘지 않으면 안됨
                if(nx <0 || ny <0 || nx >N || ny >M) continue;
                
                //빈 벽이 아니면 안됨
                if(arr[nx][ny] != 0) continue;
                
                //방문 했던 곳이면 안됨
                if(visit[nx][ny] == true) continue;
                
                //해당 조건에 모두 해당하지 않으면
                visit[nx][ny] = true;
                queue.add(nx);
                queue.add(ny);
            }
        }
        
        //탐색이 종료 되었으니, 안전 영역의 넓이 계산
        int cnt =0;
        for(int i =1; i<=N; i++){
            for(int j =1; j<=M; j++){
                
                if(arr[i][j] == 0 && visit[i][j] ==false) cnt++;
            }
        }
        
        answer = Math.max(answer, cnt);
    }
}