import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int count = 0;
    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {1, 0, -1, 0};
    static int[][] grid;
    static boolean[][] visited;
    static Point[] destinations;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visited = new boolean[n][n];
        destinations = new Point[m];

        for (int i = 0; i < n; i++) {
            grid[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            destinations[i] = new Point(Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1);
        }

        dfs(destinations[0], 1);

        System.out.println(count);
    }

    private static void dfs(Point cur, int index) {
        if (cur.equals(destinations[index])) {
            if (index == m - 1) {
                count++;
                return;
            }
            index++;
        }
        int curX = cur.x;
        int curY = cur.y;
        visited[curX][curY] = true;
        for (int i = 0; i < 4; i++) {
            int nextX = curX + dx[i];
            int nextY = curY + dy[i];

            if (outOfRange(nextX, nextY)) {
                continue;
            }
            if (visited[nextX][nextY]) {
                continue;
            }
            if (grid[nextX][nextY] == 1) {
                continue;
            }
            dfs(new Point(nextX, nextY), index);
        }
        visited[curX][curY] = false;
    }

    private static boolean outOfRange(int nextX, int nextY) {
        return nextX < 0 || nextX >= n || nextY < 0 || nextY >= n;
    }

    static class Point {

        int x;
        int y;

        private Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    }
}