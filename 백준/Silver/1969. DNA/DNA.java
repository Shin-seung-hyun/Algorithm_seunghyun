import java.util.*;
import java.io.*;

// 문자열
class Main{

    static String[] arr;
    static int N;   // DNA 수
    static int M;   // 문자열의 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = br.readLine();
        }

        DNA();
    }
    static void DNA(){

        int max = 0;
        char maxChar = ' ';

        int sum = 0;            // distance의 합
        String result = "";     // distance가 가장 작은 DNA

        for(int i=0; i<M; i++){
            HashMap<Character, Integer> hashMap = new HashMap<>();
            max = 0;

            for(int j =1; j<=N; j++){
                hashMap.put(arr[j].charAt(i),hashMap.getOrDefault(arr[j].charAt(i),0)+1);
            }

            //HashMap 정렬
            for( char key : hashMap.keySet()){
                if( max < hashMap.get(key)){
                    max = hashMap.get(key);
                    maxChar = key;
                }
                else if( max == hashMap.get(key)){ // distance가 같을 때, 오름차순 정렬
                    int num1 = maxChar -'A';
                    int num2 = key -'A';

                    // 사전순으로 앞서는 것 출력
                    if( num1 > num2) maxChar = key;
                }
            }

            result += maxChar;
            sum += N - max;     // maxChar와 다른 DNA의 개수 더하기
        }

        System.out.println(result);
        System.out.println(sum);
    }

}