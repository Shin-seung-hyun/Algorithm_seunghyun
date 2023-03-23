import java.util.*;

//동적 프로그래밍(DP)
    //참고용
class Main{
    static int N;   // 곡의 수
    static int S;   // 시작 볼륨
    static int M;   // 최대 볼륨
    static boolean[][]  Dy;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        M = sc.nextInt();

        Dy = new boolean[N+1][M+1];
        arr= new int[N+1];

        for(int i =1; i<=N; i++){
            arr[i] = sc.nextInt();
        }

        DP();
    }
    static void DP(){

        //초기값
        Dy[0][S] = true;

        //점화식
        int answer = 0;
        for(int i =1; i<=N; i++){
            boolean flag = false;
            answer =0;

            for(int pre =0; pre<=M; pre++){

                if(!Dy[i-1][pre]) continue;

                for (int cur : new int[]{pre - arr[i], pre + arr[i]}) {

                    if (cur < 0 || cur > M) continue;

                    answer = Math.max(answer, cur);

                    Dy[i][cur] = true;

                    flag = true;
                }
            }

            //결과
            if(!flag){
                System.out.println(-1);
                return;
            }
        }
        System.out.println(answer);
    }

}
