import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] chess = {1,1,2,2,2,8};
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<chess.length; i++){
            sb.append( chess[i]- Integer.parseInt(st.nextToken()) + " ");
        }

        System.out.println(sb.toString());
    }
}