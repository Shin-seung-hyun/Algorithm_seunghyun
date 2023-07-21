import java.io.*;
import java.util.*;

// 문자열
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int t =1; t<=testCase; t++){
            int K = Integer.parseInt(br.readLine());

            String arr[] = new String[K+1];
            for(int i =1; i<=K; i++) arr[i] = br.readLine();

            String result = "0";
            loop:
            for(int i =1; i<=K; i++){
                for(int j= 1; j<=K; j++){
                    if( i == j) continue;
                    if( isPalin(arr[i] + arr[j])){
                        result = arr[i] + arr[j];
                        break loop;
                    }
                }
            }

            System.out.println(result);
        }

    }

    static boolean isPalin(String str){

        int left = 0;
        int right = str.length() -1;

        while(left < right){
            if( str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }
            else return false;
        }

        return true;
    }

}