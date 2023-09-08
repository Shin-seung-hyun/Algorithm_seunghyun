import java.util.*;
import java.io.*;

class Solution {

    static int answer = 0;
    static boolean []visit;
    static int[] arr;
    public int solution(int k, int[][] dungeons) {

        arr = new int[dungeons.length];
        visit = new boolean [dungeons.length];

        //탐험할 던전의 순서 DFS()
        //중복 X , 순서O 나열
        //12 13 14, 21 23 24
        DFS(0, k, dungeons, arr);

        return answer;
    }

    static int Possible(int[]arr, int[][] dungeons, int k){

        int cnt =0;
        for(int i=0; i< dungeons.length; i++){

            if( k < dungeons[arr[i]][0]) break;

            if( k - dungeons[arr[i]][1] < 0) break;

            k -= dungeons[arr[i]][1];

            cnt++;
        }

        return cnt;
    }

    static void DFS(int depth, int k, int[][] dungeons, int[]arr){

        // 종료조건
        if( depth == dungeons.length ){

            // 던전 탐험
            //System.out.println( Arrays.toString(arr));
            answer = Math.max( answer ,Possible( arr,dungeons,k ));

            return;
        }

        // 반복 조건
        for(int i=0; i< dungeons.length; i++){

            if( visit[i]) continue;
            visit[i] = true;
            arr[depth] = i;

            DFS(depth+1, k, dungeons, arr);

            visit[i] = false;
        }

    }
}