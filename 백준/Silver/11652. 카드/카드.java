import java.util.Scanner;
import java.util.HashMap;

class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        HashMap<Long, Integer> map = new HashMap<>();

        for(int i =0 ; i< N; i++){
            long val = sc.nextLong();

            map.put(val,map.getOrDefault(val, 0) +1);

        }

        int cnt = Integer.MIN_VALUE;
        long value = 0;

        for(long tmp : map.keySet()){
            if(map.get(tmp) > cnt){
                cnt = map.get(tmp);
                value = tmp;

            }
            
            //가장 많은 것이 여러 가지라면, 작은 것을  출력
            else if(map.get(tmp) == cnt){
                value = Math.min(value, tmp);
            }
        }

        System.out.println(value);

    }
}