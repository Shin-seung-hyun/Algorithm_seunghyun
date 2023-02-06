import java.util.*;
import java.io.*;

public class Main{

    public static int N,M;
    public static int arr[];
    public static HashMap<Integer,Integer> hashMap = new HashMap<>();
    public static StringBuilder sb = new StringBuilder();

    public static void main(String args[]) throws IOException{
        //Scanner 사용 시, 시간초과 발생
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        for(int i = 0; i<N ;i++){
            int num = Integer.parseInt(st.nextToken());
            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }
        arr = new int[hashMap.size()+1];

        int index = 0;
        for(int value :hashMap.keySet()){
            arr[++index] = value;
        }

        //이분탐색을 위한 정렬
            //-10 2 3 6 7 10
            //  2 1 2 1 1 3
        Arrays.sort(arr, 1, arr.length);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i =0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());

            //이분 탐색
            if(search(1, arr.length-1, num)) sb.append(hashMap.get(num)).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb.toString());
        br.close();
    }

    public static boolean search(int left, int right, int x){

        while(left <= right){
            int mid = (left+ right)/2;

            if(arr[mid] == x) return true;
            else if (arr[mid] > x) right = mid -1;
            else left = mid +1;
        }

        return false;
    }

}