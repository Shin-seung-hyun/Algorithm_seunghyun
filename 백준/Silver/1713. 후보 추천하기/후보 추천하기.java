import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Stu implements Comparable<Stu>{
        int id;
        int vote;
        int time;

        public Stu(int id, int vote, int time ){
            this.id = id;
            this.vote = vote;
            this.time = time;
        }

        // 정렬
            // 투표 오름차순 -> 적은 투표수 삭제
            // 시간 오름차순 -> 오래된 것 삭제
        @Override
        public int compareTo(Stu o) {
            if(this.vote == o.vote) return this.time - o.time;
            else if (this.vote < o.vote) return -1;
            else return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N  = Integer.parseInt(br.readLine());       // 사진 틀의 수
        int num = Integer.parseInt(br.readLine());      // 추천 횟수

        int [] students = new int[100 + 1];         // 사진 틀에 담긴 학생의 투표수 카운트
        ArrayList<Stu> arrList = new ArrayList<>(); // 사진 틀

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<num; i++ ) {

            int stID = Integer.parseInt(st.nextToken());

            if( students[stID] > 0){        // 추천 학생이 이미 있다면
                students[stID]++;

                for( Stu s : arrList){

                    if( s.id == stID){
                        s.vote++;
                        break;
                    }
                }
            }
            else{                           // 액자에 추가해야 하는 경우

                if( arrList.size() >= N){
                    Collections.sort(arrList);

                    int id = arrList.get(0).id;
                    students[id] = 0;
                    arrList.remove(0);
                }

                arrList.add(new Stu( stID, 1, i));
                students[stID] = 1;
            }
        }


        // 출력
        int cnt = 0;
        for(int i = 0; i< students.length; i++){

            // 사진 틀에 들어있는 학생 출력
            if( students[i] != 0){
                sb.append( i + " ");
                cnt++;
            }

            if( cnt >= N) break;
        }
        System.out.println(sb.toString());

    }
}