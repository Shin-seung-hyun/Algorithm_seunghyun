import java.io.*;
import java.util.*;


public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        String[] RSP = new String[4];
        for(int i=0; i<4; i++){
            RSP[i] = st.nextToken();
        }

        int[] score = new int[4];

        for(int i=0; i<2; i++){
            for(int j=2; j<4; j++) {

                if (RSP[i].equals("R") && !RSP[j].equals("R")) {
                    if (RSP[j].equals("S")) score[i]++;
                    else score[j]++;
                }
                else if (RSP[i].equals("S")&& !RSP[j].equals("S")) {
                    if (RSP[j].equals("P")) score[i]++;
                    else score[j]++;
                }
                else if (RSP[i].equals("P")&& !RSP[j].equals("P")) {
                    if (RSP[j].equals("R")) score[i]++;
                    else score[j]++;
                }
            }
        }

        for(int i=0; i<4; i++){
            if( score[i] >= 2){
                if( i <=1) System.out.println("MS");
                else System.out.println("TK");
                return;
            }
        }

        System.out.println("?");

    }

}