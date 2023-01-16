import java.util.Arrays;
import java.util.Scanner;

//C개 중에 L개를 중복 x, 순서 o 개 나열하기
//단, 최소 한개의 모음과 두 개의 자음으로 구성될 것

public class Main{

    public static int C, L;
    public static char[] arr;
    public static char[] pwd;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt(); //L개 중에
        C = sc.nextInt(); //C개 고르기
        arr = new char[C];
        pwd = new char[L];

        for(int i = 0; i< C; i++) arr[i] = sc.next().charAt(0);
        Arrays.sort(arr);

        dfs(0,0);
    }

    private static boolean check(char[] pwd) {
        int vowel = 0;      // 모음
        int consonant = 0;  // 자음

        for (char val : pwd) {
            if( val =='a' || val =='e'|| val =='i'||val =='o'||val =='u') vowel++;
            else consonant++;
        }
        if(consonant >=2 && vowel>=1) return true;
        else return false;
    }
    public static void dfs (int depth, int start){

        //재귀 종료 조건
        if(depth == L ) {

            //최소 한 개 모음, 두 개 자음인지 확인
            if(check(pwd)){
                for (char val : pwd) {
                    System.out.print(val);
                }
                System.out.println();
            }
            return;
        }

        //재귀 반복
        for(int i = start; i < C; i++){
            pwd[depth] = arr[i];
            dfs(depth+1 ,i +1);
        }

    }
}