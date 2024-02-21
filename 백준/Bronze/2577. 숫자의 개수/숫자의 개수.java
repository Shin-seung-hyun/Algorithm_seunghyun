import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        int num = A * B * C;
        String temp = String.valueOf(num);
        int result [] = new int[10];

        for(int i = 0; i <temp.length(); i++){

            result[temp.charAt(i) -'0'] += 1 ;
        }

        for(int i = 0; i< result.length; i++){
            System.out.println(result[i]);
        }
        
    }
}