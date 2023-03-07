import java.util.*;

//동적 프로그래밍(DP)
    //트리와 동적 프로그래밍 (DFS)
public class Main{

    static int []Dy; // i를 루트로 하는 서브트리의 정점의 수 배열
    static int N;   // 정점의 수
    static int R;   //루트의 번호
    static int Q;   //쿼리의 수
    static ArrayList<Integer> [] adj;  //인접 리스트
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        R = sc.nextInt();
        Q = sc.nextInt();

        Dy = new int[N+1];
        adj = new ArrayList[N+1];
        for(int i =1; i<=N; i++){
            adj[i] = new ArrayList<>();
        }

        //인접 리스트
        for(int i =1; i<N ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj[u].add(v);
            adj[v].add(u);
        }

        //DP
        DFS(R,-1);

        //출력
        for(int i =1; i<=Q; i++){
            int input = sc.nextInt();
            sb.append(Dy[input]).append("\n");
        }
        System.out.print(sb.toString());

    }

    static void DFS( int root, int pre){

        //나를 루트로 하는 경우, 서브트리에 자기 자신 포함
        Dy[root] = 1;

        //자식 노드 탐색
        for(int y : adj[root]){

            //부모인 경우 패스
            if(y == pre) continue;
            DFS(y, root);
            Dy[root] += Dy[y];
        }

    }

}