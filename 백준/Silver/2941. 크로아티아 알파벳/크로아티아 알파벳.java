import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //방법1
//        String str = br.readLine();
//        str = str.replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=" ," ");
//        System.out.println(str.length());

        //방법2.
        char[] charArr = br.readLine().toCharArray();

        int sum =0;
        for(int i= charArr.length-1; i>=0; i--){
            if(i-1>=0) {
                if (charArr[i] == '=') {

                    if (i - 2 >= 0 && charArr[i - 1] == 'z' && charArr[i - 2] == 'd') {
                        i = i - 2;
                    }
                    else if (charArr[i - 1] == 'c' || charArr[i - 1] == 's' || charArr[i - 1] == 'z') {
                        i--;
                    }
                } else if (charArr[i] == 'j') {
                    if (charArr[i - 1] == 'l' || charArr[i - 1] == 'n') {
                        i--;
                    }
                } else if (charArr[i] == '-') {
                    if (charArr[i - 1] == 'c' || charArr[i - 1] == 'd') {
                        i--;
                    }
                }
            }
            sum++;
        }

        System.out.println(sum);
    }
}