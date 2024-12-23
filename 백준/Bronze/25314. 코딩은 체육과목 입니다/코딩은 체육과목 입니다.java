import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String result = "";

        for(int i=0; i<N/4; i++) result += "long ";
        result += "int";

        System.out.println(result);
    }
}