import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0 ;i<N; i++){
            st = new StringTokenizer(br.readLine());

            HashMap<Long,Integer> map = new HashMap<>();
            int cntSoldier= Integer.parseInt(st.nextToken());
            for(int j=0; j<cntSoldier; j++){
                long num  = Long.parseLong(st.nextToken());

                map.put(num, map.getOrDefault(num,0)+1);
            }

            boolean flag = false;
            for(Long key  : map.keySet()){
                if(map.get(key) > cntSoldier/2){
                    sb.append(key).append("\n");
                    flag = true;
                    break;
                }
            }

            if(!flag) sb.append("SYJKGW\n");
        }

        System.out.print(sb.toString());
    }

}