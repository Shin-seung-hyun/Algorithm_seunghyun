import java.io.*;
import java.util.*;

//모음(a,e,i,o,u) 하나를 반드시 포함
//모음이 3개 or 자음이 3개 연속으로 오면 X
//같은 글자가 연속적으로 두번 오면 X -> 단, ee 와 oo는 허용
class Main{

    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){

            String str = br.readLine();

            if(str.equals("end")) break;

            int mo =0;
            int ja =0;
            boolean check_acceptable = true;
            boolean check_mo = false;
            for(int i =0; i< str.length(); i++){
                char tmp = str.charAt(i);

                // 하나 이상의 모음
                if(tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u') check_mo = true;

                // 같은 글자가 연속으로 두번 나오면 안되나, ee oo는 예외
                if( i-1 < 0) continue;
                if( str.charAt(i-1) == str.charAt(i)){

                    if((str.charAt(i) != 'e' && str.charAt(i) != 'o')) {
                        check_acceptable = false;
                        break;
                    }
                }
                // 모음, 자음이 연속으로 3개 나오면 안됨
                if( i-2 < 0) continue;
                if( tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u') mo++;
                else ja++;
                if( str.charAt(i-1) == 'a' || str.charAt(i-1) == 'e' || str.charAt(i-1) == 'i' || str.charAt(i-1) == 'o' || str.charAt(i-1) == 'u') mo++;
                else ja++;
                if( str.charAt(i-2) == 'a' || str.charAt(i-2) == 'e' || str.charAt(i-2) == 'i' || str.charAt(i-2) == 'o' || str.charAt(i-2) == 'u') mo++;
                else ja++;

                if( ja >=3 || mo >=3){
                    check_acceptable = false;
                    break;
                }
                else{
                    ja = 0;
                    mo = 0;
                }
            }

            if( check_acceptable && check_mo) sb.append("<" + str + "> is acceptable.\n");
            else sb.append("<" + str + "> is not acceptable.\n");
        }

        System.out.print(sb.toString());
    }

}