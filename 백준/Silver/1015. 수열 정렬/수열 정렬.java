import java.util.Scanner;
import java.util.Arrays;

//오름차순으로 정렬할 때, 현재 숫자가 몇번째 index에 위치하는지

class Main{

    public static int N;
    public static int[]P;
    public static Elem[] B;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        P = new int[N];
        B = new Elem[N];

        for(int i = 0 ;i < N; i++){
            B[i] = new Elem();
            B[i].value = sc.nextInt();
            B[i].idx = i;
        }

        Arrays.sort(B);

        for (int i = 0; i< N ;i ++){
            P[B[i].idx] = i;
        }

        //출력
        for(int i =0 ; i< N; i++){
            sb.append(P[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}

class Elem implements Comparable<Elem>{

    public int value; // A[idx]의 원래 값
    public int idx; // A배열의 idx 위치

    @Override
    public int compareTo(Elem e){
        return this.value - e.value;
    }

}