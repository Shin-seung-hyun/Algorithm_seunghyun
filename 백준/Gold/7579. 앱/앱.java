import java.util.*;

//평범한 배낭 문제 유사
//몇 개를 비활성화 하여 C를 최소로하는 M만큼의 메모리 추가로 확보하기
    // 완전탐색으로 각각 앱을 끈 경우, 킨 경우로 하면 2^100가지로 시간초과 -> DP
class Main{
    static int N;   // 앱의 수
    static int M;   // 필요한 메모리

    static int memory[];   // A[i] 앱의 메모리 크기
    static int cost[];   // A[i] 앱 비활성화 비용
    static int Dy[][];

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        memory = new int [N+1];
        cost = new int[N+1];
        for(int i =1; i<=N; i++) memory[i] = sc.nextInt();
        for(int i =1; i<=N; i++) cost[i] = sc.nextInt();

        //Dy[앱이 어디까지 입력되었는지][비용(100 * 100개)] = 해당 비용으로 확보한 메모리 값
        Dy = new int[N+1][100_000 + 1];

        DP();
    }

    static void DP(){

        for(int i =1; i<=N; i++){
            for(int j =0; j<=100_000; j++){

                //이전 값으로 초기화
                if(j < cost[i]) Dy[i][j] = Dy[i-1][j];

                else Dy[i][j] = Math.max(Dy[i-1][j], Dy[i-1][j-cost[i]] + memory[i]);
            }
        }

        //M 이상인 것 출력
        for(int i =1; i<=100_000; i++){
            if(Dy[N][i] >= M){
                System.out.println(i);
                return;
            }
        }

    }



}