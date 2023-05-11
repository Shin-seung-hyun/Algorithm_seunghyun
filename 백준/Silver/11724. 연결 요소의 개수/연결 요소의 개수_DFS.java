import java.util.*;

//그래프와 DFS, BFS
//인접 행렬

//연결 요소 찾기
// 끊겨 있는 연결 요소 부분은 DFS나 BFS 탐색이 끝난 후에도 탐색이 안 될 것이다.
// 반면, 같은 연결 요소에 속한 정점들은 한번의 DFS나 BFS로 이미 해당 정점을 방문할 것이다.
class Main{

    static int N;   //정점의 개수
    static int M;   //간선의 개수
    static boolean visit[];   //방문 여부 확인
    static ArrayList<Integer> [] arrList;   //인접 행렬
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        visit = new boolean[N+1];

        arrList = new ArrayList[N+1];
        for(int i =1; i<= N; i++){
            arrList[i] = new ArrayList<>();
        }
        for(int i =1; i<= M; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            arrList[u].add(v);
            arrList[v].add(u);
        }

        for(int i =1; i<=N; i++){
            if(visit[i]) continue;
            DFS(i);
            answer++;
        }

        System.out.println(answer);
    }

    static void DFS(int x ){

        //visit 체크
        visit[x] = true;

        //반복
        for(int y : arrList[x]){

            if(visit[y]) continue;
            DFS(y);
        }

    }
}