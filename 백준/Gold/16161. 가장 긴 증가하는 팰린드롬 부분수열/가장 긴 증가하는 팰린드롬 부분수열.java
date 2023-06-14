import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] s = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			s[i] = Integer.parseInt(st.nextToken());
		}
		
	    int left = 0;
	    int right = 0;
	    int answer = 1;
	    while (right < N - 1)
	    {
	        int cnt, l, r;
	        if (s[right] < s[right + 1])
	        {
	            right += 1;
	        }
	        else
	        {
	            if (s[right] > s[right + 1])
	            {
	                cnt = 1;
	                l = right - 1;
	                r = right + 1;
	            }
	            else
	            {
	                cnt = 0;
	                l = right;
	            }
	            r = right + 1;

	            while (l >= left && r < N)
	            {
	                if (s[l] == s[r])
	                {
	                    cnt += 2;
	                    l -= 1;
	                    r += 1;
	                }
	                else
	                    break;
	            }
	            answer = Math.max(answer, cnt);

	            right += 1;
	            left = right;
	            right = right;
	        }
	    }
	    
	    System.out.println(answer);
	}
}