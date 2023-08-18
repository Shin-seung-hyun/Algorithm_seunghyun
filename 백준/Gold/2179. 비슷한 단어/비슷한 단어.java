import java.io.*;
import java.util.*;


public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());    // 영단어 수

		ArrayList<String> arrList = new ArrayList<>();
		for(int i=0;i<N;i++) {
			String s= br.readLine();

			// 중복 저장 방지
			if(!arrList.contains(s))
				arrList.add(s);
		}

		int result1=0;
		int result2=0;
		int maxCnt=0;

		for(int i=0; i<N; i++) {
			String str1 = arrList.get(i);

			for(int j=i+1; j<N; j++) {
				int cnt=0;
				String str2 = arrList.get(j);
				int size = Math.min(str1.length(),str2.length());

				for(int k =0; k<size; k++) {
					if(str1.charAt(k) == str2.charAt(k)) cnt++;
					else break;
				}

				if(cnt > maxCnt) {
					result1 = i;
					result2 = j;
					maxCnt = cnt;
				}
			}
		}

		System.out.println(arrList.get(result1));
		System.out.println(arrList.get(result2));
	}


}