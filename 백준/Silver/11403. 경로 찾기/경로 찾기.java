import java.util.*;

//그래프와 DFS, BFS
    //인접 행렬
class Main{
    static int N;   //정점의 개수
    static int [][]arr; //인접 행렬 배열
    static boolean visit[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String []args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        arr = new int[N+1][N+1];

        //인접 행렬 입력 받기
        for(int i =1; i<=N; i++){
            for(int j =1; j<=N; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        visit = new boolean[N+1];

        //각 정점의 탐색
        for(int i =1; i<=N; i++){

            //BFS 탐색 시작
            BFS(i);

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static void BFS(int start){
        Queue<Integer> queue = new LinkedList<>();

        //visit 초기화
        for(int j =1; j<=N; j++) visit[j] = false;

        queue.add(start);
        visit[start] = false; // 자기 자신으로 돌아올 수 있는지 판단해야 함으로 false로 시작함

        while(!queue.isEmpty()){
            int x = queue.poll();

            //인접행렬 탐색
            for(int i =1; i<=N; i++){

                if(visit[i]) continue;
                if(arr[x][i] == 0) continue;

                queue.add(i);
                visit[i] = true;
            }
        }

        for(int j=1; j<=N; j++){
            if(visit[j]) sb.append("1").append(" ");
            else sb.append("0").append(" ");
        }

    }

}