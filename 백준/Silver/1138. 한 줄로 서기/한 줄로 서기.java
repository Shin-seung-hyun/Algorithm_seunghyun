import java.io.*;
import java.util.*;


//키가 큰 순으로 ArrayList에 삽입
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int []arr = new int [N+1];

        ArrayList<Integer> arrList = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 키가 큰 순으로 arr[i]번째 위치에 i 을 삽입
        for(int i =N; i>=1; i--){
            arrList.add(arr[i], i);
        }

        //출력
        for(int val : arrList) System.out.print(val + " ");
    }
}

