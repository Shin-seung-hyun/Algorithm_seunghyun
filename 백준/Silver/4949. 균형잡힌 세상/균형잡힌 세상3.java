
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            String str = br.readLine();

            //중단 조건
            if (str.equals(".")) break;

            str = str.replaceAll("[A-Za-z.]", "").replace(" ", "");

            while (str.contains("()") || str.contains("[]")) {
                str = str.replace("()", "").replace("[]", "");
            }

            if (str.equals("")) {
                System.out.println("yes");
            }
            else {
                System.out.println("no");
            }

        }//end while

    }//end main
}




    }
}