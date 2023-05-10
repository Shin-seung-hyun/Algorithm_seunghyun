import java.util.*;

//투 포인터
    // 앞뒤가 똑같으면 0
    // 하나만 다르면 1
    // 완전히 다르면 2
public class Main{
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static String N;

    public static void main(String args[]) {

        int T = sc.nextInt();
        for(int i =1; i<=T; i++){
            N = sc.next();

            twoPointer();
        }
        System.out.print(sb.toString());
    }

    public static boolean checkSimilar(int left ,int right){
        while(left <= right){
            if(N.charAt(left) == N.charAt(right)){
                left++;
                right--;
            }
            else return false;

        }

        return true;
    }
    public static void twoPointer(){
        int left = 0;
        int right = N.length()-1;
        int cnt = 0;

        while(left <= right){

            if(N.charAt(left) == N.charAt(right)){
                left++;
                right--;
            }
            else{
                if(checkSimilar(left+1, right) || checkSimilar(left, right-1)) {
                    cnt =1;
                    break;
                }
                else{
                    cnt = 2;
                    break;
                }
            }

        }

        sb.append(cnt +"\n");
    }

}