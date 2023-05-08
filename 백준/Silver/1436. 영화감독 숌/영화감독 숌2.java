import java.util.*;

//완전탐색 BF
class Main{
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int num = 666;
        int cnt =1;

        while(cnt != N){

            num++;

            //int 형을 String으로 변환 후 "666"이 포함되는지 검사
            //Integer -> String 전환 방법
            //Integer.toString() -> null을 Null PointerException
            //String.valueOf()  -> null을 NUll 문자열로 처리

            //boolean contains(CharSequence s) 공백 여부도 체크
            if(String.valueOf(num).contains("666")) cnt ++;

        }

        System.out.println(num);

    }

}