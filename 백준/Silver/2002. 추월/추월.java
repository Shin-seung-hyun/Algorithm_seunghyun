import java.util.*;
import java.io.*;

class Main{

    static int N;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            hashMap.put(br.readLine(), i);
        }

        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            // arr[]에 탈출 순서대로 입장번호 저장
            arr[i] = hashMap.get(br.readLine());
        }

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {

                if (arr[i] > arr[j]) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}