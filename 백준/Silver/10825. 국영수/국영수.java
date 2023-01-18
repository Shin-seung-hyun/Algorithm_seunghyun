import java.util.Arrays;
import java.util.Scanner;

//국어 내림차순
    //영어 오름차순
        //수학 내림차순
            //이름 오름차순
public class Main{

    public static int N;
    public static Student[] stu;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        N = sc.nextInt();

        stu = new Student[N];
        for(int i = 0; i< N; i++){
            stu[i] = new Student();
            stu[i].name = sc.next();
            stu[i].korean = sc.nextInt();
            stu[i].english = sc.nextInt();
            stu[i].math = sc.nextInt();
        }

        Arrays.sort(stu);

        for(int i = 0; i< N; i++){
            sb.append(stu[i].name).append("\n");
        }
        System.out.print(sb.toString());

    }
}

class Student implements Comparable<Student>{
    String name;
    int korean, english, math;

    @Override
    public int compareTo(Student other){
        //국어 내림차순
        if (korean != other.korean) return other.korean - korean;
        
        //영어 오름차순
        if (english != other.english) return english - other.english;
        
        //수학 내림차순
        if (math != other.math) return other.math - math;
        
        //이름 오름차순
        return name.compareTo(other.name);
    }
    
}