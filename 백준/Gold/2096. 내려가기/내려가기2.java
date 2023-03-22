import java.util.*;

//동적 프로그래밍(DP)
    // 메모리의 제한이 4MB이므로 슬라이딩 윈도우 알고리즘 적용이 필요
    // 4MB 밖에 안 되는 메모리에 최대 100,000 * 100,000 짜리 배열을 저장할 수 없음.
    // 슬라이딩 윈도우 기법을 차용하여 int[] dp를 정의한 후 연속적으로 초기화
class test{
    static int N;
    static int [] maxDy;
    static int [] minDy;
    static int [] arr;
    static StringBuilder sb = new StringBuilder();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        N = sc.nextInt();
        maxDy = new int[3 + 1];
        minDy = new int[3 + 1];
        arr = new int[3+1];

        DP();

        sb.append(Math.max(Math.max(maxDy[1],maxDy[2]),maxDy[3]));
        sb.append(" ");
        sb.append(Math.min(Math.min(minDy[1],minDy[2]),minDy[3]));
        System.out.println(sb.toString());

    }
    static void DP() {

        //초기값
        for(int i =1; i<=3; i++) {
            maxDy[i] = minDy[i] = sc.nextInt();
        }

        for (int i = 2; i <= N; i++) {

            for(int j = 1; j<=3; j++) arr[j] = sc.nextInt();

            //최댓값
            int preMax_1 = maxDy[1], preMax_3 = maxDy[3];
            maxDy[1] = Math.max(maxDy[1] , maxDy[2]) + arr[1];
            maxDy[3] = Math.max(maxDy[2], maxDy[3]) + arr[3];
            maxDy[2] = Math.max(Math.max(preMax_1, maxDy[2]),preMax_3) + arr[2];

            //최솟값
            int preMin_1 = minDy[1], preMin_3 = minDy[3];
            minDy[1] = Math.min(minDy[1] , minDy[2]) + arr[1];
            minDy[3] = Math.min(minDy[2], minDy[3]) + arr[3];
            minDy[2] = Math.min(Math.min(preMin_1, minDy[2]),preMin_3) + arr[2];
        }
    }

}
