import java.util.*;

//그래프와 DFS, BFS
    //BFS
public class Main{

    static int[] limit = new int[3];    //물통 A,B,C의 양을 저장할 배열
    static boolean visit[][][];
    static boolean possible[];          // 정답을 저장할 배열

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i<3; i++){
            limit[i] = sc.nextInt();
        }

        possible = new boolean[limit[2]+1]; //C 물통의 양만큼
        visit = new boolean[201][201][201];

        //BFS 시작
        BFS(0 , 0, limit[2]);   //처음에는 C만 가득차 있음

        //출력
        for(int i = 0; i<= limit[2]; i++){
            if(possible[i]) sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }

    static void BFS(int x1, int x2, int x3){
        Queue<Bottle> queue = new LinkedList<>();

        //x1,x2,x3 방문
        queue.add(new Bottle(new int[]{x1,x2,x3}));
        visit[x1][x2][x3] = true;

        //BFS 탐색
        while(!queue.isEmpty()){
            Bottle bottle = queue.poll();

            //정답을 위한 처리
                //A 물통이 비어있다면 당시 C물통의 양을 possible에 true로 저장
            if(bottle.x[0] == 0 ) possible[bottle.x[2]] = true;

            for(int from= 0; from <3; from++){
                for(int to = 0; to<3; to++){

                    //같은 물통끼리는 부을 수 없음
                    if(from == to )continue;

                    Bottle nBottle = bottle.move(from, to, limit);

                    //만약 탐색한 적이 없다면
                    if(visit[nBottle.x[0]][nBottle.x[1]][nBottle.x[2]] == false){
                        visit[nBottle.x[0]][nBottle.x[1]][nBottle.x[2]] = true;
                        queue.add(nBottle);
                    }
                }
            }

        }
    }
}

class Bottle{
    int []x;

    //생성자
    Bottle(int input[]){
        x = new int[3];

        for(int i =0 ;i<3; i++){
            x[i] = input[i];
        }
    }

    //메소드
    Bottle move(int from, int to, int limit[]){

        int nx[] = new int[]{x[0],x[1],x[2]};

        //from 물통에서 to 물통으로 옮긴다.
            //from의 물을 to에 다 부을 수 있다면
        if(x[from] + x[to] <= limit[to]){
            nx[to] = nx[from] + nx[to];
            nx[from] =0;
        }
            //from의 일부만 옮길 수 있다면
        else{
            nx[from] = nx[from] - (limit[to] - x[to]);
            nx[to] = limit[to];
        }

        return new Bottle(nx);
    }
}