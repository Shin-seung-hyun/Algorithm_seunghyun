import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String gradeList[] = {"A+","A0","B+","B0","C+","C0","D+","D0","F","P"}; // 0 ~ 9
        double pointList[] = { 4.5, 4, 3.5, 3, 2.5, 2, 1.5, 1, 0}; // 0 ~8

        double sum = 0; // 내 학점
        double pointSum = 0; // 학점의 총합
        for(int i=0; i<20; i++){
            st = new StringTokenizer(br.readLine());

            st.nextToken();  //과목명
            double point = Double.parseDouble(st.nextToken()); // 학점
            String grade = st.nextToken(); // 등급

            if(!grade.equals("P")) pointSum += point;

            for(int j=0; j<9; j++){
                if( gradeList[j].equals(grade)){
                    sum += pointList[j] * point;
                }
            }

        }

        System.out.println(sum/pointSum);
    }
}