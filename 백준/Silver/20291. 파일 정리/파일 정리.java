import java.util.Comparator;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String,Integer> map = new HashMap<>();

        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() , ".");
            String title = st.nextToken();
            String file_name = st.nextToken();

            map.put(file_name, map.getOrDefault(file_name, 0)+1);
        }

        //확장자 이름순으로 정렬하기
        ArrayList<String> keySet = new ArrayList<>(map.keySet());

        Collections.sort(keySet);

        //출력하기
        for(String name :keySet){
            System.out.print(name + " " + map.get(name));
            System.out.println();
        }


    }
}