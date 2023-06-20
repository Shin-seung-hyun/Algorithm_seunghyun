import java.io.*;
import java.util.*;

class Main{

    static int N;   //플레이 신청횟수
    static char game;   // 윷놀이 Y(2), 그림찾기 F(3), 원카드 O(4)
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        game = st.nextToken().charAt(0);

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i =1; i<=N; i++){
            String player = br.readLine();

            if( hashMap.getOrDefault(player, 0) != 0) continue;
            hashMap.put(player, 1 );

            queue.add(player);
        }

        System.out.println(check(game));
    }
    static int check(char game){

        int player_cnt;
        int cnt = 0;

        if( game == 'Y') player_cnt = 1;
        else if (game =='F') player_cnt = 2;
        else player_cnt = 3;

        while(true) {
            for (int i = 1; i <= player_cnt; i++) {
                if (!queue.isEmpty()) queue.poll();
                else return cnt;
            }
            cnt++;
        }

    }

}