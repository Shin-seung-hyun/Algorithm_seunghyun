import java.util.*;
import java.io.*;


// 남학생 1 : 자기가 받은 수의 배수이면, 스위치 변경
// 여학생 2 : 자기가 받은 수를 중심으로 좌우가 대칭이고 가장 많은 스위치를 포함하는 구간 변경
class Main{

    static int N;   // 스위치의 개수
    static boolean [] OnOff;
    static int StuCnt;   // 학생수

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());


        /*
            String -> Boolean
            Boolean.parseBoolean("True") -> true
            Boolean.parseBoolean("true") -> true
         */
        OnOff  = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            OnOff[i] = st.nextToken().equals("1");
        }

        StuCnt = Integer.parseInt(br.readLine());
        for(int i=1; i<=StuCnt; i++){
            st = new StringTokenizer(br.readLine());

            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if( gender == 1 ) male(num);
            else female(num);
        }

        //출력
        for(int i = 1; i<=N; i++){
            if(i % 20 == 1 && i !=1) sb.append("\n");

            if( OnOff[i]) sb.append( "1 ");
            else sb.append("0 ");
        }

        System.out.print(sb.toString());
    }

    static void male(int num){

        // num의 배수 스위치 변경
        int index = num;
        int cnt =1;
        while( index <= N){
            OnOff[index] = !OnOff[index];

            cnt ++;
            index = num * cnt;
        }
    }

    static void female(int num){

        int left = num - 1;
        int right = num + 1;
        int cnt = 0;

        while(left >=1 && right <=N){
            if(OnOff[left] == OnOff[right]){
                left--;
                right++;
                cnt++;
            }
            else break;
        }

        for(int i = num - cnt ; i<= num + cnt; i++){
            OnOff[i] = !OnOff[i];
        }

    }

}
