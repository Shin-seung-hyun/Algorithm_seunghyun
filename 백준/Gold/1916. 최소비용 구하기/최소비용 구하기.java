import java.util.*;

//최단거리 Dijkstra 알고리즘
    //인접 리스트
class Main{

    //인접 리스트 형식으로 저장할 Edge(to, weight)
    static class Edge{
        int to;
        int weight;

        //생성자
        Edge(int _to, int _weight){
            this.to = _to;
            this.weight = _weight;
        }
    }

    //Priority Queue에 넣을 자료형
    static class Info{
        int idx;
        int dist;

        //기본 생성자
        public Info(){}

        public Info(int _idx, int _dist){
            this.idx = _idx;
            this.dist = _dist;
        }
    }

    static int N;       //도시의 수(정점의 수)
    static int M;       //버스의 수(간선의 수)
    static int dist[];  //다른 지점과의 최단거리 저장 배열
    static ArrayList<Edge> [] edges;
    static int start;
    static int end;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        dist = new int[N+1];
        edges = new ArrayList[N+1];
        for(int i =1; i<=N; i++){
            edges[i] = new ArrayList<Edge>();
        }

        //인접 리스트 입력 받기
        for(int i =1; i<=M; i++){
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            edges[from].add(new Edge(to, weight));
        }

        start= sc.nextInt();
        end = sc.nextInt();

        //다익스트라
        dijkstra(start);

        //출력
        System.out.println(dist[end]);
    }

    static void dijkstra( int start){

        //dist 초기화
            //모든 정점에 대한 거리 무한대로 초기화 해주기
        for(int i =1; i<=N; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        //우선순위 큐 생성
            //우선순위를 dist로 설정
            //낮은 수가 우선순위를 가짐으로 낮은 순서대로 출력됨
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);

        //시작점을 넣고, 거리 배열 0으로
        pq.add(new Info(start,0));
        dist[start]=0;

        //비어있을 때까지 거리 갱신 반복
        while(!pq.isEmpty()){
            //가장 작은 거리 값 poll
            Info info = pq.poll();

            //가치가 있는지 확인
            // 꺼낸 정보가 최신 정보 dist랑 다르면, 의미없이 낡은 정보이므로 패스
            // 꺼낸 정보다 더 큼으로 갱신할 필요가 없음
            //if(dist[info.idx] != info.dist) continue; 와 같음
            if(dist[info.idx] < info.dist) continue;

            //연결된 모든 간선을 통해 다른 정점들에 대한 정보를 갱신
            for(Edge e : edges[info.idx]){

                if(dist[info.idx] + e.weight >= dist[e.to]) continue;

                //e.to까지 갈 수 있는 더 짧은 거리가 있다면
                    //새로운 정보를 갱신하고, pq 에 저장
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to,dist[e.to]));
            }
        }


    }
}