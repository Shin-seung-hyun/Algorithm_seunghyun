import java.util.*;
import java.io.*;

//구현
class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    //국회의원 후보

        if(N == 1){
            System.out.println(0);
            return;
        }
        
        int candidate1 = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N-1];
        for(int i=0; i<N-1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int answer = 0;
        while( candidate1 <= arr[0]){

            arr[0]--;
            candidate1++;
            answer++;
            Arrays.sort(arr, Collections.reverseOrder());
        }

        System.out.println(answer);
    }
}
