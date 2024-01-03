import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        
        ArrayList arrList = new ArrayList<>();
        while(st.hasMoreTokens()){
            arrList.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(arrList);
        
        System.out.println(arrList.get(0) + " " + arrList.get(arrList.size()-1) );
    }
}