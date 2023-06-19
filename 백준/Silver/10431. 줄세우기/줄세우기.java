import java.util.*;
import java.io.*;

//
class Main {

    static int[] height;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());

        for (int i = 1; i <= P; i++) {
            st = new StringTokenizer(br.readLine());

            int classNum = Integer.parseInt(st.nextToken());

            height = new int[20 + 1];
            for (int j = 1; j <= 20; j++) {
                height[j] = Integer.parseInt(st.nextToken());
            }

            //순서 정렬
            int cnt = 0;
            for(int k = 2; k<=20; k++){
                // height[k] 보다 index가 작은 배열 중에 큰 값이 있나 확인
                for(int l = k-1; l>=1; l--){

                    if(height[k] < height[l]) cnt++;
                }
            }

            sb.append(classNum +" " + cnt + "\n");
        }

        System.out.print(sb.toString());
    }
}