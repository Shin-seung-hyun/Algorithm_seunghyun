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

/*
        <ArrayList 사용 시 O(N^2)로 시간초과 발생 >
             ArrayList의 romove(0)은 모든 원소를 앞으로 당겨온다
             따라서 시간복잡도가  O(N) * delete = O(N^2)이다.

        <LinekdList 사용 시 O(N)>
             문제 해결을 위해 LinkedList를 사용한다면 O(N)이 된다.
*/
//        for(int i=1; i<=delete; i++){
//            arrList.remove(0);
//            arrList.remove( arrList.size()-1);
//        }
//
//        int sum = 0;
//        for(int i=0; i<arrList.size()-1 ; i++){
//            sum += arrList.get(0);
//        }
//        System.out.println(Math.round( (double)sum / arrList.size()));

        int sum = 0;
        for(int i = delete; i<= arrList.size() - 1 - delete; i++){
            sum += arrList.get(i);
        }

        System.out.println(  Math.round((double)sum/ (arrList.size() - delete *2 ) ) );
    }
}
