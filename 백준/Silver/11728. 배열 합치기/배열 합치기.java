import java.io.*;
import java.util.*;

//투 포인터
public class Main{

    static int N;
    static int M;
    static int []arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+M];

        st = new StringTokenizer(br.readLine());
        for(int i =0 ;i< N ;i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<M; i++){
            arr[N+i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        
        for(int i =0 ;i <N+M; i++){
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());
        br.close();
    }

}