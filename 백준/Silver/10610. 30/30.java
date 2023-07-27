import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String strNum = br.readLine();
        char[] charArr = strNum.toCharArray();

        // 오름 차순 정렬
            // 내림차순 정렬 시 , char[] -> Charatcter[] 타입 변경 필요
        Arrays.sort(charArr);

        int sum = 0;
        for(int i = charArr.length -1; i >=0; i--){
            int num = charArr[i] - '0';
            sum +=num;
            sb.append(num);
        }

        // 30의 배수인지 확인 (10 의 배수인지 && 3의 배수인지)
            // 10의 배수가 무조건 하나는 포함되어 있어야 함으로 charAt(0) =='0' 이어야 함
        if(charArr[0] != '0' || sum % 3 !=0){
            System.out.println("-1");
            return;
        }

        System.out.println(sb.toString());
    }

}