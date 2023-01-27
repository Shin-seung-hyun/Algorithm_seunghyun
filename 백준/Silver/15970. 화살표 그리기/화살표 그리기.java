import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2]; //좌표와 색깔을 가지는 이차원 배열 생성

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i] = new int[] {
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())
            };
            //arr[]에 (0 1) (1 2) (3 1) (4 2) (5 1) 값을 차례대로 넣어줍니다.
        }
        br.close();

        int answer = 0;
        // 색깔 기준으로 정렬하고 색깔이 같으면 좌표기준으로 정렬을 해준다.
        Arrays.sort(arr, (o1, o2) -> { //그냥 함수임. 이렇게 쓰면됨.
            if (o1[1] == o2[1]) //2번째 배열의 수가 같으면 첫번째 배열의 숫자를 기준으로 정렬을 해준다.
                return o1[0] - o2[0];
            else // 그 밖의는 2번째 배열의 수가 다를 경우는 두번째 배열의 숫자를 기준으로 정렬을 해준다.
                return o1[1] - o2[1];
        });

        for (int i = 0; i < n; i++) {
            //반복문을 한번 돌면서 양끝 좌표인 케이스는 인접한 좌표와의 거리만 계산하고
            //중간의 좌표는 왼쪽과 오른쪽 좌표의 색깔을 비교해서 양쪽 다 같으면 좌표 거리 차이가 최소인 좌표,
            //한쪽만 같으면 해당 좌표 거리만 더해서 정답을 구한다.
            if (i == 0) {
                answer += (arr[1][0] - arr[0][0]);//시작 좌표는 바로 아래 점과의 거리 값 구해서 더하기
            }
            else if (i == n-1) {
                answer += (arr[n-1][0] - arr[n-2][0]);//마지막 좌표는 비로 위 점과의 거리 값 구해서 더하기
            }
            else
            {// 위쪽 아래쪽 같은 색이면 좌표 거리차이 최소값
                if (arr[i][1] == arr[i-1][1] && arr[i][1] == arr[i+1][1])
                    answer += Math.min(arr[i][0] - arr[i-1][0], arr[i+1][0] - arr[i][0]);
                    //양쪽 점중에서 가장 거리가 가까운 값을 반환합니다.

                else if (arr[i][1] == arr[i-1][1]) // 위쪽만 같은 색
                    answer += (arr[i][0] - arr[i-1][0]);

                else // 아래쪽만 같은 색
                    answer += (arr[i+1][0] - arr[i][0]);
            }
        }
        System.out.println(answer);
    }
}