import java.util.*;
import java.io.*;


/*
   해당 문제의 경우 종료 지점을 명시하지 않았기 때문에 
   입력에서 더이상 읽을 수 있는 데이터가 존재하지 않은, EOF(End of File) 즉, 파일의 끝이 종료 지점이다.
   Buffereader에서는 EOF를 null로 반환함으로 null 인지 아닌지를 while문 조건으로 작성한다.
   
   IDE : ctrl + Z (= EOF)
  
   참고 : https://st-lab.tistory.com/40
*/

class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        
        while( (str = br.readLine())!= null ){
            st = new StringTokenizer(str, " ");
           
            System.out.println( Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()));
        }
        
    }
}