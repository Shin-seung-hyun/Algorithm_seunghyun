import java.util.*;
import java.io.*;

//구현
class Main{
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken()); // 가로
        int col = Integer.parseInt(st.nextToken()); // 세로

        int cut = Integer.parseInt(br.readLine());

        ArrayList<Integer> rowArr = new ArrayList<>();
        ArrayList<Integer> colArr = new ArrayList<>();

        rowArr.add(0);
        colArr.add(0);
        for(int i= 1; i<=cut; i++){
            st = new StringTokenizer(br.readLine());

            int checkRC = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if( checkRC == 1) rowArr.add(num);
            else colArr.add(num);
        }

        rowArr.add(row);
        colArr.add(col);

        Collections.sort(rowArr);
        Collections.sort(colArr);

        int answer = 0;
        for(int i=0; i< rowArr.size()-1; i++){
            for(int j= 0; j<colArr.size()-1; j++){

                int value =  (rowArr.get(i+1) - rowArr.get(i)) * (colArr.get(j+1) - colArr.get(j));

                //System.out.println(value);
                answer = Math.max(answer, value);
            }
        }

        System.out.println(answer);
    }
}
