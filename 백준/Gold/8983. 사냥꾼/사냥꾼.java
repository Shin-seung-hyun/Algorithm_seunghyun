import java.util.*;
import java.io.*;

// 1. 동물을 기준으로 동물이 자신을 잡을 수 있는 사대를 이분 탐색
// 2. 사냥 가능한 범위는 L값을 기준으로 동물의 위치로 부터 가장 멀리 떨어 질 수 있는 lower와 upper를 구한다.
// 3. 각 동물의 lower와 upper 내에 사대가 있는지 이분 탐색
class Main{
    static int M;   // 사대(총을 쏘는 위치) 수
    static int N;   // 동물의 수
    static int L;   // 사정거리
    static int[] location; // 사대 위치 배열
    static int answer =0;

    public static void main(String[]args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        location = new int [M+1];
        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=M; i++){
            location[i] = Integer.parseInt(st.nextToken());
        }

        // 이분 탐색을 위한 정렬
        Arrays.sort(location);

        // 동물의 위치 입력 받기
        for(int i =1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 사정거리를 벗어남
            if( y > L) continue;

            // 동물의 위치에서 가장 가까운 사대의 위치를 이분탐색
            // 사대의 위치 xi, 동물의 위치 (aj, bj) 간의 거리 = |xi-aj| + bj로 계산
            search(x,y);
        }

        System.out.println(answer);
    }

    static void search( int x, int y){
        int upper = x + ( L - y);
        int lower = x - ( L - y);

        int left = 1;
        int right = M;

        while(left <= right) {
            int mid = (left + right) / 2;

            // 사냥 가능한 범위에 사대가 있다면
            if (lower <= location[mid] && location[mid] <= upper) {
                answer++;
                break;
            }

            // 사대의 위치가 동물의 왼쪽에 있다면
            else if (location[mid] < lower) left = mid + 1;
            else right = mid - 1;
        }
    }

}