import java.util.*;

//동적 프로그래밍 DP
    // level 1. 가짜 문제와 진짜 문제가 같을 때
class Main{

    static int []Dy;    //DP array
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();   //테스트 케이스

        pre();
        
        for(int i =0; i<T; i++){

            int N = sc.nextInt();

            sb.append(Dy[N]).append("\n");
        }

        //출력
        System.out.println(sb.toString());
    }

    static void pre(){
        Dy = new int[12]; // n은 양수이며 11보다 작다.

        //초기값 넣기
        Dy[1] = 1;
        Dy[2] = 2;
        Dy[3] = 4;

        //점화식을 바탕으로 Dy 배열 채우기
        for(int i = 4; i<=11; i++){
            Dy[i] = Dy[i-3] + Dy[i-2] + Dy[i-1];
        }
    }

}