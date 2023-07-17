import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String str = Integer.toString(N);

        Integer []arr = new Integer[str.length()];

        for(int i=0; i< arr.length; i++){
            arr[i] = Integer.valueOf(str.charAt(i) - '0');
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(int i =0; i< arr.length; i++){
            System.out.print(arr[i]);
        }

    /* 방법2
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        char [] charArray = str.toCharArray();

        Arrays.sort(charArray);

        for(int i = charArray.length-1; i >0; i--){
            System.out.print(charArray[i]);
        }

     */
    }
}
