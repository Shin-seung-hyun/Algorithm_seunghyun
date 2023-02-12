import java.io.*;
import java.util.*;

//투 포인터
public class Main{

    static int N;
    static int M;
    static int []A;
    static int []B;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int [N+1];
        B = new int [M+1];

        st = new StringTokenizer(br.readLine());
        for(int i =1 ;i<= N ;i ++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i<= M; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();

        br.close();
    }

    static void twoPointer(){
        int left = 1;
        int right =1;

        while(left <= N && right <=M){
            if(A[left] <= B[right]) sb.append(A[left++]).append(" ");
            else{
                sb.append(B[right++]).append(" ");
            }
        }

        //둘 중 남아 있는 것 넣기
        while(left <= N) sb.append(A[left++]).append(" ");
        while(right <= M) sb.append(B[right++]).append(" ");

        System.out.println(sb.toString());
    }

}