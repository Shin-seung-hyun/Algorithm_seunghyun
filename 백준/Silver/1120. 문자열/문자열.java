import java.util.*;

public class Main{
    /*
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String A = sc.next(); //koder       5
        String B = sc.next(); //topcoder    8

        int answer = A.length();

        for(int i =0; i + A.length() <= B.length(); i++){

            int diff = distance(A, B.substring(i, i + A.length()));

            if( diff < answer) answer = diff;
        }

        System.out.println(answer);
    }
    public static int distance(String a, String b){

        if(a.length() != b.length()) return -1;

        int ret = 0;

        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) ret++;
        }

        return ret;
    }
    */
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String a = sc.next();
        String b = sc.next();
        
        int ans = a.length();

        for(int i=0; i<= b.length() - a.length(); i++) {
            int cnt = 0;
            
            for(int j=0; j < a.length(); j++) {
                
                if(a.charAt(j) != b.charAt(i+j)) cnt++;
            }
            
            ans = Math.min(cnt, ans);
        }
        
        System.out.println(ans);
    }
    
    
}
