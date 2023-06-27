import java.io.*;
import java.util.*;

// 문자열
class Main{
    static String X;
    static int []arr;
    static boolean[] visit;
    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        X = sc.nextLine();
        arr = new int [X.length()];
        visit = new boolean[X.length()];

        // N 개중에 M 개를 중복 X 순서 O  나열하기
        DFS(0,  arr);

        Collections.sort(arrayList);
        //for(int i =0;  i< arrayList.size();i++) System.out.println(arrayList.get(i));

        if( arrayList.size() == 0) System.out.println(0);
        else System.out.println(arrayList.get(0));
    }

    static void DFS(int depth, int [] arr){

        // 종료 조건
        if( depth == X.length()){

            int num =0;
            int len = arr.length;
            for(int val : arr){
                num = (int) (num + val * Math.pow(10, len - 1));
                len--;
            }

            if(num > Integer.parseInt(X)) arrayList.add(num);
            return;
        }

        for(int i= 0; i< X.length(); i++){

            if( visit[i]) continue;

            visit[i]= true;
            arr[depth] = X.charAt(i) - '0';
            DFS(depth+1,  arr);

            visit[i] = false;
        }
    }


}