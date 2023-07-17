import java.util.*;
import java.io.*;

// 문자열 + BF
class Main{

    static ArrayList<String> arrList = new ArrayList<>();
    static int []arr;
    static String word;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word = br.readLine();

        arr = new int [3];

        // 7개 중에서 3개 뽑기 -> 중복 X, 순서 X
         /*
            1 2     2 3
            1 3     2 4
            1 4
         */
        DFS(1,1);

        //사전순으로 가장 앞서는 단어
        Collections.sort(arrList);

        System.out.println(arrList.get(0));
    }


    static String reverse(String str){
        String reverseWord = "";

        for(int i= str.length()-1; i >= 0; i--){
            reverseWord += String.valueOf(str.charAt(i));
        }

        return reverseWord;
    }

    static void DFS(int at, int depth){

        // 종료 조건
        if( depth == 3){

            /* 1. String Builder 사용을 통한 뒤집기 */
            StringBuilder sb1 = new StringBuilder(word.substring(0,arr[1]));
            StringBuilder sb2 = new StringBuilder(word.substring(arr[1], arr[2]));
            StringBuilder sb3 = new StringBuilder(word.substring(arr[2], word.length()));

            arrList.add( sb1.reverse().toString() +
                    sb2.reverse().toString() +
                    sb3.reverse().toString());

            return;

        /* 2. 반복문 사용을 통한 뒤집기
            String first = word.substring(0, arr[1]);
            String second = word.substring(arr[1], arr[2]);
            String third = word.substring(arr[2]);

            String result = reverse(first) + reverse(second) + reverse(third);

            arrList.add(result);

            return;
        */

        }

        // 반복 조건
        for(int i= at; i< word.length(); i++){
            arr[depth] = i;
            DFS(i + 1, depth+ 1);
        }

    }
}