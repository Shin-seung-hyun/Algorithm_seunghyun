import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int one[] = {
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        };
        st = new StringTokenizer(br.readLine());
        int two[] = {
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        };
        st = new StringTokenizer(br.readLine());
        int three[] = {
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        };

        int x,y;
        if( one[0] == two[0]) x = three[0];
        else if( one[0] == three[0]) x = two[0];
        else x = one[0];

        if( one[1] == two[1]) y = three[1];
        else if( one[1] == three[1]) y = two[1];
        else y = one[1];

        System.out.println(x +" " + y);
    }
}