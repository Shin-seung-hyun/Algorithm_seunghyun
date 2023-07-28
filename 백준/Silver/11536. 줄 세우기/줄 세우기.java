import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] input = new String[N];
        String[] arr = new String[N];

        for(int i=0; i<N; i++){
            input[i]= br.readLine();
        }
        arr = input.clone();

        // 오름차순 정렬
        Arrays.sort(arr);

        boolean check = true;
        for(int i = 0; i<N; i++){
            if( !input[i].equals(arr[i])){
                check = false;
                break;
            }
        }

        if(check) System.out.println("INCREASING");
        else {

            // 내림차순 정렬
            Arrays.sort(arr, Collections.reverseOrder());

            for (int i = N - 1; i >= 0; i--) {
                if (!input[i].equals(arr[i])) {
                    System.out.println("NEITHER");
                    return;
                }
            }
            System.out.println("DECREASING");
        }
    }

}