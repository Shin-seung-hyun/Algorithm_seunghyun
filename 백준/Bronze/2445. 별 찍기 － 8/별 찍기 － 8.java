import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String str1, str2;
        for(int i=1; i<=N; i++){
            str1 ="";
            str2 ="";

            for(int j=1; j<= i; j++) str1 += "*";
            for(int j=1; j<= N-i; j++) str2 += " ";

            sb.append(str1 + str2 + str2 + str1).append("\n");
        }

        for(int i=1; i<= N-1; i++){
            str1 ="";
            str2 ="";

            for(int j = 1; j<= N-i; j++) str1 +="*";
            for(int j= 1; j<=i; j++) str2 +=" ";

            sb.append(str1 + str2 + str2 + str1).append("\n");
        }

        System.out.println(sb.toString());
    }
}