import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
/*
<조건>
1. 국어 내림차순
    2. 영어 오름차순
        3.수학 내림차순
            4.이름 오름차순
<풀이>
Comparator -> compare()

*/
class Main{
    public static int N;
    public static Stu[] stu;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        stu = new Stu[N];

        for(int i =0; i<N; i++){
            stu[i] = new Stu();
            stu[i].name = sc.next();
            stu[i].korean = sc.nextInt();
            stu[i].english = sc.nextInt();
            stu[i].math = sc.nextInt();
        }

        //Student에 대한 Comparator를 익명객체로 구현하여 넘김
        Arrays.sort(stu, comp);

        for(int i = 0; i< N; i++){
            sb.append(stu[i].name).append("\n");
        }
        System.out.print(sb.toString());
    }

    //익명 객체(익명 클래스)
    public static Comparator<Stu> comp = new Comparator<>(){

        @Override
        public int compare(Stu o1, Stu o2){
            if(o1.korean == o2.korean ){
                if(o1.english == o2.english){
                    if(o1.math == o2.math){
                        return o1.name.compareTo(o2.name);
                    }
                    return o2.math - o1.math;
                }
                return o1.english - o2.english;
            }
            return o2.korean - o1.korean;
        }
    };

}

class Stu {
    String name;
    int korean,english,math;
}
