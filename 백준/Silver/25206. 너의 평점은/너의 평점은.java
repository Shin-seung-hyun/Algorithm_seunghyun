import java.util.*;
import java.io.*;

//구현
class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] gradeList = { "A+","A0","B+","B0","C+","C0","D+","D0","F","P"}; // 0 ~ 9
        double[] pointList = { 4.5, 4, 3.5, 3, 2.5, 2, 1.5, 1, 0};      // 0 ~8

        double sum = 0;
        double pointSum= 0;
        for(int i=1; i<=20; i++){
            String str = br.readLine();

            double point = Double.parseDouble(str.split(" ")[1] );
            String grade = str.split(" ")[2];

            if( !grade.equals("P")) pointSum += point;

            //P는 계산에서 제외
            for(int j=0; j<=8; j++){

                if(grade.equals(gradeList[j])){
                    sum += (point * pointList[j]);
                }

            }

        }

        System.out.printf( "%.6f",sum/pointSum);
    }

}