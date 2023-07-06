import java.io.*;
import java.util.*;

// 문자열
class Main{
    static int M;   // M 이상
    static int N;   // N 이하의 정수
    static StringBuilder sb = new StringBuilder();
    static String[] enNum = {"zero", "one", "two", "three", "four","five",
                            "six", "seven","eight","nine"};

    // Comparable(compareTo) vs Comparator(compare)
    static public class Number implements Comparable<Number>{
        int num;
        String word;
        Number(int  num, String word){
            this.num = num;
            this.word = word;
        }

        @Override
        public int compareTo(Number num1){
            return this.word.compareTo(num1.word);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        ArrayList<Number> arrList = new ArrayList<>();
        for(int i=M; i<=N; i++){
            String tmp1 = String.valueOf(i); //"82"
            String tmp2 = "";

            for(int j=1; j<=tmp1.length(); j++){
                tmp2 += enNum[tmp1.charAt(j-1) - '0'];
            }

            arrList.add(new Number(i, tmp2));
        }

        // 정렬
        Collections.sort(arrList);

        //출력
        for(int i=1; i<=arrList.size(); i++){
            sb.append(arrList.get(i-1).num + " ");

            // 한 줄에 10개씩 출력
            if( i % 10 ==0) sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}