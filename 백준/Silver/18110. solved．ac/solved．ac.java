import java.util.*;
import java.io.*;

//구현
class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i=1; i<=N; i++){
            arrList.add( Integer.parseInt(br.readLine()) );
        }

        Collections.sort(arrList);

        int delete = (int) Math.round(N * 0.15);

        // ArrayList의 romove(0)은 모든 원소를 앞으로 당겨와서 비효율적임
//        for(int i=1; i<=delete; i++){
//            arrList.remove(0);
//            arrList.remove( arrList.size()-1);
//        }

        int sum = 0;
        for(int i = delete; i<= arrList.size() - 1 - delete; i++){
            sum += arrList.get(i);
        }

        System.out.println(  Math.round((double)sum/ (arrList.size() - delete *2 ) ) );
    }
}
