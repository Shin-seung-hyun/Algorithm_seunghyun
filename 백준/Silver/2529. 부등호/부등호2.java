import java.util.*;

class Main{
    static int K;   //부등호 수
    static String []arr;
    static boolean visit[];
    static ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();

        visit = new boolean[10];
        arr = new String[K+1];
        for(int i =1; i<=K; i++){
            arr[i] = sc.next();
        }

        DFS("", 0);

        System.out.println(arrayList.get(arrayList.size()-1));
        System.out.println(arrayList.get(0));

    }

    public static boolean check(int a, int b, String c){

        if(c.equals(">") && a > b) return true;
        else if ( c.equals("<") && a < b) return true;

        return false;
    }

    public static void DFS(String num, int depth){

        //depth가 K 면 종료
        if(depth ==K+1){
            arrayList.add(num);
            return;
        }

        //반복 조건
        for(int i =0; i<=9; i++){

            if(visit[i]) continue;

            //Character.getNumericValue : char->int
            //check(int a, int b, String 부등호)
            if(depth == 0 || check(Character.getNumericValue(num.charAt(depth-1)), i, arr[depth]) ){
                visit[i] = true;
                DFS(num + i , depth+1);
                visit[i] = false;
            }
        }

    }


}