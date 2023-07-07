import java.util.*;
import java.io.*;

//M 이상의 길이 단어 외우기
class Main{

    static int N;   // 단어의 수
    static int M;   // 길이 기준
    static StringBuilder sb = new StringBuilder();
    static class Word implements Comparable<Word>{
        String str;
        int len;
        int cnt;

        public Word(String str, int len, int cnt){
            this.str = str;
            this.len = len;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word o1){
            // 빈도수 - 내림차순
            if(this.cnt == o1.cnt){
                // 단어의 길이 - 내림차순
                if(this.len == o1.len){
                    // 사전순 - 오름차순
                    return this.str.compareTo(o1.str);
                }
                return o1.len - this.len;
            }
            return o1.cnt - this.cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i=1; i<=N; i++){
            String word = br.readLine();

            if( word.length() < M) continue;
            hashMap.put(word, hashMap.getOrDefault(word,0) +1);
        }


        ArrayList<Word> arrList = new ArrayList<>();
        for(String str : hashMap.keySet()){
            arrList.add(new Word(str, str.length(), hashMap.get(str)));
        }

        // 정렬
        Collections.sort(arrList);

        // 출력
        for(int i =0; i< arrList.size(); i++){
            sb.append(arrList.get(i).str + "\n");
        }

        System.out.print(sb.toString());
    }
}
