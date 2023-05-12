import java.util.*;

//DP
class Main{
    static int X;
    static int[][] Dy;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        X = sc.nextInt();
        Dy = new int[2][X+1];

        DP();

        System.out.println(Math.min(Dy[0][X],Dy[1][X]));
    }

    public static void DP(){

        //초기값
        Dy[0][1] = Dy[1][0] = 0;

        for(int i =2; i<=X; i++){

            // 6으로 나눠질 경우
            // 3으로 나누는 경우, 2로 나누는 경우, 1을 빼는 경우 비교
            if(i % 6 ==0){
                Dy[0][i] = Math.min(Math.min(Dy[0][i/3],Dy[1][i/3]), Math.min(Dy[0][i/2],Dy[1][i/2])) + 1;
            }
            // 3으로 나눠질 경우
            //3으로 나누는 경우, 1을 빼는 경우 비교
            else if(i %3 == 0){
                Dy[0][i] = Math.min(Dy[0][i/3],Dy[1][i/3]) + 1;
            }
            // 2로 나눠질 경우
            // 2로 나누는 경우, 1을 빼는 경우 비교
            else if(i %2 == 0){
                Dy[0][i] = Math.min(Dy[0][i/2],Dy[1][i/2]) + 1;
            }
            // 모두 아닐 경우
            //1을 빼는 경우 비교
            else{
                Dy[0][i] = Math.min(Dy[0][i-1],Dy[1][i-1]) +1;
            }

            Dy[1][i] = Math.min(Dy[0][i-1],Dy[1][i-1]) +1;
        }

    }
}