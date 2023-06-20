import java.util.Scanner;

class Main{
    private static boolean isCheck(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch =='o' || ch =='u')
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            String password = sc.nextLine();
            boolean isaccept = false;
            int v = 0, c = 0;

            if(password.equals("end"))
                break;

            for(int i = 0; i < password.length(); i++) {
                if(isCheck(password.charAt(i))) {
                    isaccept = true;
                    break;
                }
            } // password가 1개만 일때 적용.

            for(int i = 0; i < password.length(); i++) {
                char ch = password.charAt(i);

                if(i != password.length() - 1 && ch == password.charAt(i + 1) && ch != 'o' && ch != 'e') { //2번 조건
                    isaccept = false;
                    break;
                }

                boolean ischeck = isCheck(ch);
                if(ischeck) { //3번 조건
                    v++;
                    c = 0;
                }

                else {
                    c++;
                    v = 0;
                }

                if(v == 3 || c == 3) {
                    isaccept = false;
                    break;
                }
            }
            System.out.println((isaccept) ? "<" + password + "> is acceptable." : "<" + password + "> is not acceptable.");
        }
    }

}