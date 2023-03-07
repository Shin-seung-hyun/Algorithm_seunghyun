import java.util.*;

//동적 프로그래밍(DP)
    //트리와 동적프로그래밍(DFS)
public class Main{
    static int[][] Dy;
    static ArrayList<Integer> [] adj;   //인접 리스트
    static int[] arr;   //마을의 주민 수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();   // 마을의 수
        arr = new int[N+1];
        for(int i =1; i<=N ;i++){
            arr[i] = sc.nextInt();
        }

        //인접리스트 입력
        adj = new ArrayList[N+1];
        for(int i =1; i<=N ;i++){
            adj[i] = new ArrayList<>();
        }
        for(int i =1; i<N ;i++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            adj[x].add(y);
            adj[y].add(x);
        }

        Dy = new int[N+1][2];

        DFS(1 , -1);

        System.out.println(Math.max(Dy[1][0], Dy[1][1]));
    }

    static void DFS( int root, int parent ){

        Dy[root][1] = arr[root];

        for(int vertex : adj[root]) {

            if (vertex == parent) continue;

            DFS(vertex, root);

            //Dy[start][0] start를 선택 안 할 때
            Dy[root][0] = Dy[root][0] + Math.max(Dy[vertex][0] , Dy[vertex][1]);

            //Dy[start][1] start를 선택할 때
            Dy[root][1] = Dy[root][1] + Dy[vertex][0];
        }

    }

}