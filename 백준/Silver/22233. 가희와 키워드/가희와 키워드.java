import java.io.*;
import java.util.*;


public class Main {

    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 키워드 수
        M = Integer.parseInt(st.nextToken());   // 블로그 글 수

        HashSet<String> hashSet = new HashSet<>();

        for(int i=1; i<=N; i++){
            hashSet.add(br.readLine());
        }

        for(int i =1; i<=M; i++){

        // 방법1
//            String[] arrString = br.readLine().split(",");
//
//            for( String str : arrString){
//                if( hashSet.contains(str)){
//                    hashSet.remove(str);
//                }
//            }

        // 방법2.
            st = new StringTokenizer(br.readLine(),",");

            while(st.hasMoreTokens()) {
                String key = st.nextToken();

                hashSet.remove(key); // hashSet에 존재하는지 확인하지 않아도 됨
            }

            sb.append(hashSet.size()+ "\n");
        }

        System.out.println(sb.toString());
    }
}