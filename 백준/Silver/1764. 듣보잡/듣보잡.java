import java.util.Scanner;
import java.util.*;

public class Main{

    public static int N,M;
    public static HashMap <String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N= sc.nextInt();
        M = sc.nextInt();

        for(int i =0; i<N+M; i++){
            String name = sc.nextLine();
            hashMap.put(name, hashMap.getOrDefault(name,0)+1);
        }

        ArrayList<String> arr = new ArrayList<>();
        for( String name : hashMap.keySet()){
            if(hashMap.get(name) >1){
                arr.add(name);
            }
        }

        System.out.println(arr.size());

        Collections.sort(arr);

        for(int i = 0; i< arr.size(); i++){
            System.out.println(arr.get(i));
        }

    }


}