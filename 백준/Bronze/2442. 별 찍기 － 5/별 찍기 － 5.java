import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){
            String str1 = "";
            String str2 = "";

            for(int j=1; j<= 2*i-1; j++) str2 += "*";

            //별의 앞
            for(int j=1; j<= N-i; j++) str1 += " ";

            System.out.println(str1 + str2);
        }
    }
}