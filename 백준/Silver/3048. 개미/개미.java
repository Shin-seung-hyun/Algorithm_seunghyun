import java.util.*;
import java.io.*;
 
public class Main {
    static int N1, N2, T;
    static ArrayList<Node> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ")        ;
        
        N1 = Integer.parseInt(st.nextToken());
        N2 = Integer.parseInt(st.nextToken());
        
        char[] tmp1 = br.readLine().toCharArray();
        for(int i = N1 - 1 ; i >= 0 ; i--) {
            list.add(new Node(tmp1[i], true));
        }
        
        char[] tmp2 = br.readLine().toCharArray();
        for(int i = 0 ; i < N2 ; i++) {
            list.add(new Node(tmp2[i], false));
        }
        
 
        T = Integer.parseInt(br.readLine()); // T : 교환 횟수
        
        // Case 1 : T가 충분히 큰 경우
        if(N2 + N1 - 1 <= T) {
            // tmp2 배열을 그대로 추가
            for(int i = 0 ; i < tmp2.length ; i++) {
                sb.append(tmp2[i]);
            }
            // tmp1 배열을 역순으로 추가
            for(int i = tmp1.length - 1;  i >= 0 ; i--) {
                sb.append(tmp1[i]);
            }
            System.out.println(sb.toString());
            return;
        }
        
        // Case 2 : T가 작은 경우
        while(T --> 0) { // 인접한 두 노드 객체 비교해 교환
            for(int i = 0 ; i < list.size() -1 ; i++) {
                Node cur = list.get(i);
                Node next = list.get(i + 1);
                
                if(!cur.team || cur.team == next.team)   continue;
                
                list.set(i, next);
                list.set(i + 1, cur);
                i++;
            }
        }
        
        // 정렬된 리스트에서 문자를 순서대로 추가해 출력
        for(int i = 0 ; i < list.size() ; i++) {
            sb.append(list.get(i).c);
        }
        System.out.println(sb.toString());
    }
}
 
class Node {
    char c; // 문자
    boolean team; // 팀 정보
    
    Node(char c, boolean team) {
        this.c = c;
        this.team = team;
    }
}
