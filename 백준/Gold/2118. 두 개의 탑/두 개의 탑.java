import java.util.*;

//투 포인터
// 원형으로 된 곳의 두탑의 거리가 최대가 되도록
public class Main{

    static int N;
    static int[] arr;
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        arr = new int[N+1];
        for(int i =1; i<=N; i++){
            arr[i] = sc.nextInt() + arr[i-1];
        }

        twoPointer();
    }

    public static void twoPointer() {
        int maxVal = Integer.MIN_VALUE;

        // 시계 방향이 반시계 방향보다 더 커지면 확인할 필요가 없음
        for(int left = 1; left<=N; left++){
            for(int right = left; right<=N; right++){

                int rightDistance = arr[right -1] - arr[left-1];
                int leftDistacne = arr[N]-rightDistance;

                maxVal = Math.max(maxVal,Math.min(rightDistance,leftDistacne));

                if(rightDistance >= leftDistacne) break;
            }

        }
        System.out.println(maxVal);
    }

}