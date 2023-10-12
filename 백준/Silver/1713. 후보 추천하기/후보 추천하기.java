import java.io.*;
import java.util.*;

public class Main {

    static class Stu implements Comparable<Stu>{
        int id;
        int vote;
        int time;

        public Stu(int id, int vote, int time ){
            this.id = id;
            this.vote = vote;
            this.time = time;
        }

        // 내림차순 정렬
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

        int N  = Integer.parseInt(br.readLine());  // 사진 틀의 수
        int num = Integer.parseInt(br.readLine());   // 추천 횟수

        int [] students = new int[100 + 1];         // 전체 학생들의 투표수를 담을 배열
        ArrayList<Stu> arrList = new ArrayList<>(); // 사진 틀

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<num; i++ ) {

            int stID = Integer.parseInt(st.nextToken());

            if( students[stID] > 0){      // 추천 학생이 이미 있다면
                students[stID]++;

                for( Stu s : arrList){

                    if( s.id == stID){
                        s.vote++;
                        break;
                    }
                }
            }
            else{                       // 액자에 추가해야 하는 경우

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
        for(int i = 0; i< students.length; i++){
            if( students[i] != 0) System.out.print( i + " ");
        }

    }
}