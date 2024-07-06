import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int roomNum = Integer.parseInt(br.readLine());

        int[] arr = new int[10];

        while (roomNum > 0) {

            arr[roomNum % 10]++;
            roomNum /= 10;
        }

        int cnt = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9) continue;
            if(arr[i] > cnt) cnt = arr[i];
        }

        cnt = Math.max (cnt, (arr[6] + arr[9] + 1) / 2);
        System.out.println( cnt);

    }
}