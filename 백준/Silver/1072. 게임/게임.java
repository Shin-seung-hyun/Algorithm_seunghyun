import java.util.Scanner;

public class Main{
    public static int X, Y, Z;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        X = sc.nextInt();
        Y = sc.nextInt();
        Z = getPercent(X,Y);

        search(Z);
    }

    public static void search(int z){
        int left = 1;
        int right = 1_000_000_000;
        int result = -1;

        while(left <= right){
            int mid = (left + right) /2;

            if(getPercent(X + mid, Y+ mid)  > Z ){
                right = mid -1;
                result = mid;
            }
            else{
                left = mid +1;
            }
        }
        
        System.out.println(result);
    }

    static int getPercent(int x , int y){
        return (int) ((long) y * 100 / x);
    }
}