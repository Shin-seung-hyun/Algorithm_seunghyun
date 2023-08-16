import java.io.*;
import java.util.*;

// DFS
public class Main {

    static char[] op = new char[]{ '+', '-', ' '};
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String > arrList;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st  = new StringTokenizer(br.readLine());

        int testCase = Integer.parseInt(br.readLine());
        for(int t =1; t<= testCase; t++){


            N = Integer.parseInt(br.readLine());

            arrList = new ArrayList<>();

            DFS(1, "1");

            // 정렬
            Collections.sort(arrList);

            // 출력
            for( String s  : arrList) System.out.println(s);
            System.out.println();
        }

    }

    static void DFS(int depth, String str){
        // 중복 O, 순서 X

        // 종료 조건
        if( depth == N){
            //System.out.println(str);

            String s = str.replaceAll(" ", "");

            //StringTokenizer(String s, 구분자, 구분자 포함여부 T/F)
            //T :   1, +, 2, +, 3
            //F :   1, 2, 3
            StringTokenizer st = new StringTokenizer(s, "+-",true);

            int sum = Integer.parseInt(st.nextToken()); // 1

            while(st.hasMoreTokens()){
                String op = st.nextToken(); // +

                if( op.equals("+")) sum += Integer.parseInt(st.nextToken());
                else sum -= Integer.parseInt(st.nextToken());
            }

            if( sum ==0) arrList.add(str);

            return;
        }

        // 반복 조건
        for(int i = 0; i<3; i++){
            DFS(depth+1, str +op[i]+ (depth+1) );
        }
    }

}
