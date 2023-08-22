import java.io.*;
import java.util.*;

//Stack
public class Main {

    static class Building {
        int idx;
        int height;

        public Building(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] counts = new int[N+1];
        int[] close = new int[N+1];
        Building[] buildings = new Building[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            buildings[i] = new Building(i, Integer.parseInt(st.nextToken()));
        }

        Stack<Building> stack = new Stack<>();

        for(int i=N; i>=1; i--) {

            // 현재 건물의 오른쪽에서 보이는 건물들
            while(!stack.isEmpty() && stack.peek().height <= buildings[i].height) {
                stack.pop();
            }

            if(!stack.isEmpty()) {
                counts[i] += stack.size();
                close[i] = stack.peek().idx;
            }
            stack.push(buildings[i]);
        }

        stack = new Stack<>();
        for(int i=1; i<=N; i++) {
            // 현재 건물의 왼쪽에서 보이는 건물들
            while(!stack.isEmpty() && stack.peek().height <= buildings[i].height) {
                stack.pop();
            }

            // 그 중 가장 가까운 건물의 번호 저장
            if(!stack.isEmpty()) {
                counts[i] += stack.size();
                if(Math.abs(i - stack.peek().idx) <= Math.abs(i - close[i])) {
                    close[i] = stack.peek().idx;
                }
            }
            stack.push(buildings[i]);
        }

        // 출력
        for(int i=1; i<=N; i++) {
            if(counts[i] > 0) {
                sb.append(counts[i] + " " + close[i] + "\n");
            }
            else sb.append("0\n");
        }
        System.out.println(sb.toString());

    }

}
