import java.util.*;
import java.io.*;

//구현
    //Comparable
class Main{
    static StringBuilder sb = new StringBuilder();

    static class Stu implements Comparable<Stu> {
        String name;
        int dd;
        int mm;
        int yyyy;

        public Stu(String name, int dd ,int mm, int yyyy){
            this.name = name;
            this.dd =dd ;
            this.mm =mm;
            this.yyyy = yyyy;
        }

        @Override
        public int compareTo(Stu s){
            if( this.yyyy == s.yyyy){
                if(this.mm == s.mm)
                    return this.dd - s.dd;
                return this.mm - s.mm;
            }
            return this.yyyy - s.yyyy;
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Stu[] student = new Stu[N];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());

            String nameStr = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            student[i-1] = new Stu(nameStr, d, m ,y);
        }

        Arrays.sort(student);

        System.out.println(student[N-1].name);  // 나이가 어린 사람
        System.out.println(student[0].name);    // 나이가 많은
    }
}
