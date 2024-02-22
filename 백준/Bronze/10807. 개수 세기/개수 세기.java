import java.util.*;
import java.io.*;

//배열
class Main{

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[200+1]; // 음수(0 ~ 99), 0(100), 양수(101 ~ 200) 로 저장 

        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[num + 100]++;
        }

        int v = Integer.parseInt(br.readLine());
        System.out.println(arr[v+100]);
    }
}