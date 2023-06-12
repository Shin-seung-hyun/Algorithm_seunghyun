import java.util.*;
import java.io.*;

//문자열
    //소수점 4째자리까지 반올림해서 출력
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> hashMap = new HashMap<>();

        int totalCnt = 0;
        while(true){

            String str = br.readLine();
            if(str == null) break;

            hashMap.put(str, hashMap.getOrDefault(str,0) +1);
            totalCnt++;
        }

        ArrayList<String> arrayList = new ArrayList<>();
        for( String tmp : hashMap.keySet()){
            arrayList.add(tmp);
        }

        // 오름차순 정렬
        Collections.sort(arrayList);

        for(int i =0; i<arrayList.size(); i++){

            sb.append(arrayList.get(i) + " ");

            int cnt = hashMap.get(arrayList.get(i));

            // 백분율을 소수점 4째자리까지 반올림
            sb.append( String.format("%.4f", (double)(cnt) / totalCnt * 100 ) + "\n" );
        }

        System.out.print(sb.toString());
    }
}