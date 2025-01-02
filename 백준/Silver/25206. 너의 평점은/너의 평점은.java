import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double sum = 0; // 내 학점
        double pointSum = 0; // 학점의 총합
        for(int i=0; i<20; i++){
            st = new StringTokenizer(br.readLine());

            st.nextToken();  //과목명
            double point = Double.parseDouble(st.nextToken()); // 학점
            String grade = st.nextToken(); // 등급

            switch(grade){
                case "A+" :
                    sum += 4.5 * point;
                    break;
                case "A0" :
                    sum += 4.0 * point;
                    break;
                case "B+" :
                    sum += 3.5 * point;
                    break;
                case "B0" :
                    sum += 3.0 * point;
                    break;
                case "C+" :
                    sum += 2.5 * point;
                    break;
                case "C0" :
                    sum += 2.0 * point;
                    break;
                case "D+" :
                    sum += 1.5 * point;
                    break;
                case "D0" :
                    sum += 1.0 * point;
                    break;
                case "F" :
                    sum += 0.0 * point;
                    break;
            }

            if(!grade.equals("P"))pointSum += point;

        }

        System.out.println(sum/pointSum);
    }
}