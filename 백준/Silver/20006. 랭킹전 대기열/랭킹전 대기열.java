import java.io.*;
import java.util.*;

public class Main {
    static class Player{
        int level;
        String nickName;
        boolean check = false;  // 방에 참가했는지 여부 확인

        public Player(String nickName, int level){
            this.level = level;
            this.nickName = nickName;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(st.nextToken());    // 사람 수
        int M = Integer.parseInt(st.nextToken());    // 방 정원

        Player[] player = new Player[P+1];

        for(int i=1; i<=P; i++){

            st = new StringTokenizer(br.readLine());

            int level = Integer.parseInt(st.nextToken());   // 레벨
            String nickName = st.nextToken();               // 닉네임

            player[i] = new Player(nickName, level);
        }

        for(int i =1; i<=P; i++){

            ArrayList<Player> room = new ArrayList<>();

            // check == true, 방에 참가했다면
            if(player[i].check) continue;

            int level = player[i].level;    // 기준이 되는 레벨

            for(int j = i; j<=P; j++){
                if( room.size() >=M) break;

                if( player[j].check) continue;
                if( level -10 <= player[j].level && level + 10 >= player[j].level ){
                    player[j].check = true;
                    room.add( new Player(player[j].nickName, player[j].level) );
                }
            }

            // 정렬 -> 닉네임 오름차순
            Collections.sort(room, (o1, o2) -> o1.nickName.compareTo(o2.nickName));

            // 출력
            if( room.size() == M ) sb.append( "Started!\n");
            else sb.append("Waiting!\n");

            for(Player p : room){
                sb.append(p.level + " " + p.nickName + "\n");
            }

        }// for문 종료

        System.out.print(sb.toString());
    }
}