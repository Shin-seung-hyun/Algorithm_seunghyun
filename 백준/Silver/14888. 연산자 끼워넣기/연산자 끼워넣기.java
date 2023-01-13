import java.util.Scanner;

//중복 x, 순서 있게 나열하기
public class Main {


	public static int N ,max, min;
	public static int[] nums; // N개의 숫자 입력
	public static int[] operators = new int [4]; // 연산자 수

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		nums = new int[N];

		for(int i =0; i< N; i++) nums[i] = sc.nextInt();        //숫자 입력
		for(int i =0; i< 4; i++) operators[i] = sc.nextInt();   //연산자 입력

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;

		//1부터 M번째 원소를 조건에 맞게
		dfs(nums[0], 1);

		System.out.println(max);
		System.out.println(min);
	}

	public static void dfs(int num , int index){

		//재귀 종료 조건
		if( index == N){
			max = Math.max(max, num);
			min = Math.min(min, num);
			return;
		}

		//재귀
		for(int i =0; i< 4; i++){
			if(operators[i] >0){
				operators[i]--;

				switch (i){
					case 0: dfs(num + nums[index], index +1); break;
					case 1: dfs(num - nums[index], index +1); break;
					case 2: dfs(num * nums[index], index +1); break;
					case 3: dfs(num / nums[index], index +1); break;
				}

				operators[i]++;
			}
		}


	}
 
}