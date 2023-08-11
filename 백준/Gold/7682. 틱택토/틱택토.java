import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true){
			String str = br.readLine();
			if(str.equals("end")) break;

			System.out.println(check(str));
		}

	}
	public static String check(String str){
		char game[][] = new char[3][3];

		int xCount = 0;
		int oCount = 0;
		for(int i = 0; i < 9; i++){
			game[i / 3][ i % 3] = str.charAt(i);

			if(str.charAt(i) == 'X') xCount++;
			if(str.charAt(i) == 'O') oCount++;
		}

		boolean xWin = false;
		boolean oWin = false;

		//가로 세로로 누가 이겼는지 확인
		for(int i=0; i<3; i++){

			// 가로 우승
			if(game[i][0] == game[i][1] && game[i][1] == game[i][2]){
				if(game[i][0]=='X') xWin = true;
				if(game[i][0]=='O') oWin = true;
			}

			// 세로 우승
			if(game[0][i] == game[1][i] && game[1][i] == game[2][i]){
				if(game[0][i]=='X') xWin = true;
				if(game[0][i]=='O') oWin = true;
			}

		}

		//대각선 우승
		if( game[0][0] == game[1][1] && game[1][1] == game[2][2] ||
				game[0][2] == game[1][1] && game[1][1] == game[2][0] ){

			// game[1][1] 중심부분
			if(game[1][1]=='X') xWin = true;
			if(game[1][1]=='O') oWin = true;
		}


		// X 우승/ (X가 먼저 시작하기 때문에) X의 갯수가 더 크다면 X이 이겨야 함.
		if( xWin && !oWin && ( xCount - oCount == 1) ) return "valid";

			// O 우승/ (X가 먼저 시작하기 때문에) X의 갯수 == O의 갯수라면 O이 이겨야 함.
		else if( !xWin && oWin && xCount == oCount) return "valid";

			// 무승부인데 9개의 문자열 다 채운 경우
		else if( !xWin && !oWin && (xCount == 5 && oCount == 4) ) return "valid";
		else return "invalid";
	}

}
