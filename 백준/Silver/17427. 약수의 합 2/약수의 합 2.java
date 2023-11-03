import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		int N;
		long res = 0;
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for(int i = 1; i <= N; i++) {
			res += i * (N/i);
		}
		System.out.println(res);
	}
}