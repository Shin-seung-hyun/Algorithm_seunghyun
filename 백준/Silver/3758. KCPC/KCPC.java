import java.io.*;
import java.util.*;

/*
// 최종 점수 = 점수의 총합
// 순위 =  (나보다 높은 점수를 받은 팀의 수) + 1

1. 최종 점수가 같은 경우 -> 풀이 제출 횟수가 적은 팀의 순위가 높다.
2. 최종 점수, 제출 횟수 같은 경우 -> 마지막 제출 시간이 더 빠른 팀의 순위가 높다.

 */
public class Main {
    static int N,K,ID,M;
    static class Team implements Comparable<Team>{
        int id;         // 팀 ID
        int totoalScore;    // 최종 점수
        int tryCnt;     // 시도 횟수
        int submitTime; // 마지막 제출 시간

        public Team(int id, int totoalScore, int tryCnt, int submitTime){
            this.id = id;
            this.totoalScore = totoalScore;
            this.tryCnt = tryCnt;
            this.submitTime = submitTime;
        }

        @Override
        public int compareTo( Team t){
            if( this.totoalScore == t.totoalScore){
                if(this.tryCnt == t.tryCnt){
                   return  this.submitTime - t.submitTime;  // 제출시간 오름차순
                }
                return this.tryCnt - t.tryCnt;  //시도횟수 오름차순
            }
            return t.totoalScore - this.totoalScore;    // 점수 내림차순
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int test = 1; test <= testCase; test++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());   // 팀 수
            K = Integer.parseInt(st.nextToken());   // 문제 수
            ID = Integer.parseInt(st.nextToken());  // 내 팀의 ID
            M = Integer.parseInt(st.nextToken());   // 엔드리 수

            int score[][] = new int [N+1][K+1]; // 팀별 문제별 점수
            int cnt[] =  new int [N+1]; // 팀별 제출 횟수
            int time[] = new int [N+1]; // 팀별 마지막 제출 시간

            for(int i=1; i<=M; i++){
                st = new StringTokenizer(br.readLine());

                int id = Integer.parseInt(st.nextToken());      // 제출한 팀ID
                int n = Integer.parseInt(st.nextToken());       // 문제 번호
                int s = Integer.parseInt(st.nextToken());       // 점수

                score[id][n] = Math.max(score[id][n], s);
                cnt[id]++;
                time[id] = i;
            }

            Team team[] = new Team[N+1];

            for(int i =1; i<=N; i++){
                int sum = 0;
                for(int j =1; j<=K; j++){
                    sum += score[i][j];
                }
                team[i] = new Team(i, sum, cnt[i], time[i]);
            }

            // 정렬
            Arrays.sort(team, 1,N+1 );

            // 출력
            for(int i=1; i<=N; i++){
                if( team[i].id == ID) System.out.println( i );
            }
        }

    }
}