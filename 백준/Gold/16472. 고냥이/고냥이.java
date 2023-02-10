import java.io.*;

//투 포인터
//kind 탐색 시 ->O(1) 시간 복잡도
public class Main{

    static int N;
    static int[] cnt;
    static int kind;
    static String str;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        cnt = new int[26];

        twoPointer();
    }

    // x 알파벳 개수 증가
    static void add(char x){
        cnt[x -'a']++;

        //만약 새롭게 등장한 알파벳이면
        if(cnt[x -'a'] == 1) kind++;
    }

    // x 알파벳 개수 감소
    static void erase(char x){
        cnt[x -'a']--;

        //만약 [left ~ right] 범위에서 빠지는 순간이라면
        if(cnt[x -'a'] == 0) kind--;
    }
    static void twoPointer(){
        int left = 0;
        int answer =0;

        for(int right = 0; right < str.length(); right++){

            //right를 오른쪽으로 이동
            add(str.charAt(right));

            //kind 와 N 비교
            //kind 가 N 이하이면 kind 가 N보다 클 때까지 right를 오른쪽으로 이동
            while(kind >N){
                erase(str.charAt(left));
                left++;
            }

            //정답 갱신
            answer = Math.max(answer, right - left +1);
        }

        System.out.println(answer);
    }

}