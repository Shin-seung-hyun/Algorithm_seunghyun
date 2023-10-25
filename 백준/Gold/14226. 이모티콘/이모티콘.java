import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int S;

    static boolean[][] visit = new boolean[1_001][1_001]; // [clipboard 수 ][ screen 수 ]

    // 클립보드 2, 스크린 4, 시간 5일 때, 붙여넣기 1번-> 삭제하기 2번을 하면
    // 클립보도 2, 스크린 4, 시간 8로  클립보드와 스크린은 같지만 시간이 다른 상황이 발생 가능하다.
    // 따라서 시간의 최솟값을 얻지 못할 수 있음으로 visit[][]로 확인이 필요
    static class Emo{
        int clipboard;
        int screen;
        int time;

        public Emo(int clipboard, int screen, int time){
            this.clipboard = clipboard;
            this.screen = screen;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(br.readLine());

        BFS();
    }

    static void BFS(){
        Queue<Emo> queue = new LinkedList<>();

        queue.add(new Emo(0,1,0));
        visit[0][1] = true;


        while(!queue.isEmpty()){
            Emo current = queue.poll();

            if( current.screen == S){
                System.out.println(current.time );
                return;
            }

            // 화면에 있는 거 클립보드에 저장
            queue.add(new Emo( current.screen, current.screen, current.time +1));

            //붙여 넣기
            if( current.clipboard !=0 &&
                current.screen + current.clipboard <= S &&
                !visit[current.clipboard][current.screen + current.clipboard]){

                queue.add( new Emo(current.clipboard,current.screen + current.clipboard, current.time +1));
                visit[current.clipboard][current.screen + current.clipboard] = true;
            }

            // 화면에 임티 삭제
            if( current.screen >=1 &&
                !visit[current.clipboard][current.screen -1]){

                queue.add( new Emo(current.clipboard, current.screen-1, current.time+1 ));
                visit[current.clipboard][current.screen-1] = true;
            }
        }
    }


}