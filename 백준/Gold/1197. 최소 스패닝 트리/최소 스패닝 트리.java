import java.util.*;
import java.io.*;

//최소 스패닝 트리 구하기(크루스칼 알고리즘)
//        0. 가중치를 오름차순 정렬
//        1. 가중치가 가장 작은 간선을 하나 꺼낸다.
//        2, 시작 노드와 끝 노드의 최상위 노드를 찾는다. (최상위 노드가 없다면 자기 자신이 될 것이다.)
//        3. 만약 최상위 노드가 같다면 사이클이 생기는 것이므로 지나간다.
//        4. 최상위 노드가 다르다면 union을 통해 그 간선을 고르고 가중치를 result에 더해준다.
//        5. 간선의 개수만큼 반복

class Main{
    static int V;   // 정점의 수
    static int E;   // 간선의 수
    static ArrayList<Edge> edges;
    static int []parent;    // 부모 확인용

    static class Edge implements Comparable<Edge>{
        int x;
        int y;
        int weight;

        public Edge(int x, int y, int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        // 간선의 가중치로 오름차순 정렬
        @Override
        public int compareTo(Edge e){
            return this.weight - e.weight;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        parent = new int [V+1];
        for(int i =1; i<=V; i++){
            parent[i] = i;
        }

        for(int i =1; i<=E; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add( new Edge(from, to , weight));
        }

        //1. 가중치로 오름차순 정렬
        Collections.sort(edges);

        //2. 정렬된 순서대로 간선 탐색
        int sum = 0;
        int cnt = 0;
        for(int i =1; i<= edges.size(); i++){
            Edge e = edges.get(i-1);

            // 두 노드의 부모가 다르다면 (= 사이클이 형성되지 않으면)
            if(union(e.x, e.y) ){

                //sum에 간선의 크기 저장
                sum += e.weight;

                cnt++;

                // 정점 - 1 개의 간선이 이어졌다면 MST 완성
                if(cnt == V-1) break;
            }
        }

        System.out.println(sum);
    }

    // 부모 노드 찾기
    static int findParent(int x){
        if(parent[x] == x) return x;
        return parent[x] = findParent(parent[x]);
    }

    //간선연결
    static boolean union(int x, int y){
        int xRoot = findParent(x);
        int yRoot = findParent(y);

        //부모가 같은지 판별
        if( xRoot == yRoot) return false;
        else parent[yRoot] = xRoot;
        return true;
    }
}