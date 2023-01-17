import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;

//중복 x, 순서 o 개 나열하기
public class Main{

    public static int N,M;
    public static int[] arr;
    public static int[] nums;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static HashSet<String> hashSet = new HashSet<>();


    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[M];
        nums = new int[N];
        visit = new boolean[N];

        for(int i =0; i<N; i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);

        dfs(0);

        System.out.print(sb);
    }

    public static void dfs(int depth){

        //재귀 종료조건
        if(depth == M){
            StringBuilder sb2 = new StringBuilder();

            for(int val : arr){
                sb2.append(val).append(" ");
            }
            if(!hashSet.contains(sb2.toString())){
                sb.append(sb2.toString()).append("\n");
                hashSet.add(sb2.toString());
            }

            return;
        }

        //재귀 반복
        for(int i = 0; i<N; i++){
            if(visit[i] == false){
                visit[i] = true;
                arr[depth] = nums[i];
                dfs( depth+1);
                visit[i] = false;
            }

        }
    }

}