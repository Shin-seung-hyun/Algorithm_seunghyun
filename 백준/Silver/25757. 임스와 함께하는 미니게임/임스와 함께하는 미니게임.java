import java.io.*;
import java.util.*;


class Main{

    static int N;   //플레이 신청횟수
    static char game;   // 윷놀이 Y(2), 그림찾기 F(3), 원카드 O(4)

    // HashMap 은 key 값은 중복X, value 중복 O -> hashMap.put(key, value);
    static HashMap<String, Integer> hashMap = new HashMap<>();

    // HashSet 은 중복 X -> hashSet.add(value);
    static HashSet<String> hashSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        game = st.nextToken().charAt(0);


        for(int i =1; i<=N; i++){
            String player = br.readLine();

            hashSet.add(player);
//            if( hashMap.getOrDefault(player, 0) != 0) continue;
//            hashMap.put(player, 1);
        }

        if(game == 'Y') System.out.println(hashSet.size());
        else if( game == 'F') System.out.println(hashSet.size() / 2);
        else System.out.println(hashSet.size() / 3);
    }

}