import java.io.*;
import java.util.*;

// ArrayList
/*
    제일 높은 기둥을 기준으로
    1. 왼쪽은 커지는 구간 넓이 + 제일 높은 기둥 넓이 + 2. 오른쪽은 작아지는 구간 넓이

*/
public class Main {

    static class Rectangle {
        int location;
        int height;

        public Rectangle(int location, int height){
            this.location = location;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        ArrayList<Rectangle> arrList = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());     // 창고 기둥 수

        for(int i=1; i <=N; i++){
            st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            arrList.add(new Rectangle(location,height));
        }

        // 위치 순으로 정렬
        Collections.sort(arrList,(o1,o2) -> o1.location - o2.location);

        int maxHeightIdx = 0;
        int sum = 0;

        // 1. 왼쪽의 커지는 구간
        Rectangle rectangle = arrList.get(0);

        for(int i=1; i<arrList.size(); i++){
            Rectangle current = arrList.get(i);

            if( rectangle.height <= current.height){
                sum += (current.location - rectangle.location) * rectangle.height;
                rectangle = current;
                maxHeightIdx = i;
            }
        }

        // maxHeight의 넓이 더하기
        sum += arrList.get(maxHeightIdx).height;

        // 2. 오른쪽의 작아지는 구간
        rectangle = arrList.get(arrList.size()-1);

        for(int i = arrList.size()-2; i>=maxHeightIdx; i--){
            Rectangle current = arrList.get(i);

            if( rectangle.height <= current.height){
                sum += (rectangle.location - current.location) * rectangle.height;
                rectangle = current;
            }
        }

        System.out.println(sum);
    }
}

