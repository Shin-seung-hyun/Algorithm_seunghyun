import java.io.*;
import java.util.*;

public class Main {

    static int N ;
    static String[] strArr = {
            "\"재귀함수가 뭔가요?\"",
            "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
            "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
            "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\""
    };
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
        func(1, "");

        System.out.print(sb.toString());
    }

    static void func(int cnt, String tmp){

        //종료조건
        //if( cnt == N+1){
        if( cnt > N){
            sb.append(tmp).append("\"재귀함수가 뭔가요?\"").append("\n");
            sb.append(tmp).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
            sb.append(tmp).append("라고 답변하였지.").append("\n");
            return;
        }

        //반복 조건
        for(String s : strArr){
            sb.append(tmp).append(s).append("\n");
        }

        func(cnt +1, tmp+"____");

        sb.append(tmp).append("라고 답변하였지.").append("\n");
    }

}