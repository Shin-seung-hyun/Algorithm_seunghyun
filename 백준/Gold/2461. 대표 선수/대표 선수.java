import java.util.*;
import java.io.*;

//최댓값과 최솟값의 차이가 최소가 되도록
class Main{
    static int N;   // 학급 수
    static int M;   // 학생 수
    static ArrayList<Stu> arrayList;
    static int classVisit[];
    static class Stu implements Comparable<Stu> {
        int stuClass;  //반
        int stuPower;  //0 <= 능력치 <= 10^9

        Stu(int stuClass, int stuPower){
            this.stuClass = stuClass;
            this.stuPower = stuPower;
        }

        @Override
        public int compareTo(Stu s){
            return this.stuPower - s.stuPower;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList<Stu>();
        classVisit = new int [N+1];

        for(int i =1; i<=N; i++){
            st =  new StringTokenizer(br.readLine());
            for(int j =1; j<=M; j++){
                arrayList.add(new Stu(i,Integer.parseInt(st.nextToken())));
            }
        }

        // stuPower에 따라 정렬
        Collections.sort(arrayList);

        //stuClass의 종류가 N개가 되도록 최솟값 뽑기
        twoPointer();
    }

    static void twoPointer(){

        int left = 0;
        int right = -1;
        int classCnt = 0;
        int answer = arrayList.get(arrayList.size()-1).stuPower - arrayList.get(left).stuPower;

        while(true){

            //모든 반에서 선발되지 않았다면
            if(classCnt < N ) {
                right++;

                if(right == arrayList.size()) break;

                if (classVisit[arrayList.get(right).stuClass] == 0) classCnt++;
                classVisit[arrayList.get(right).stuClass]++;
            }

            // 모든 반에서 선발되었다면
            if(classCnt >=N ){
                answer = Math.min(answer, arrayList.get(right).stuPower - arrayList.get(left).stuPower);

                classVisit[arrayList.get(left).stuClass]--;
                if(classVisit[arrayList.get(left).stuClass] == 0) classCnt--;
                left++;
            }
        }

        System.out.println(answer);
    }

}