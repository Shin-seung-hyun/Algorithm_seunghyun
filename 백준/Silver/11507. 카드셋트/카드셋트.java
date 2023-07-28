import java.io.*;
import java.util.*;

// 문자열
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        HashSet<String> hashSet = new HashSet<>();
        int [] cnt = new int [4];

        // 중복 확인
        for(int i = 0; i< str.length(); i= i+3){
            String tmp = str.substring(i, i+3); // i, i+1, i+2

            if( hashSet.contains(tmp)){

                System.out.println("GRESKA");
                return;
            }
            else hashSet.add(tmp);

        }

        // 13개 중 몇개가 있는지
        for(String card : hashSet){

            char ch = card.charAt(0);

            switch(ch){
                case 'P' : cnt[0]++; break;
                case 'K' : cnt[1]++; break;
                case 'H' : cnt[2]++; break;
                case 'T' : cnt[3]++; break;
            }
        }


        // 출력
        for(int i =0; i< cnt.length; i++){
            sb.append(13 - cnt[i] + " ");
        }
        System.out.println(sb.toString());
    }

}