package week6_DynamicProgramming3;

import java.io.*;
import java.util.*;
//https://www.acmicpc.net/problem/18427
public class G4_18427_함께_블록_쌓기 {
    static int[][] dp;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int count;
        dp = new int[n + 1][h + 1];
        list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1; // 0은 모든경우가 다 가능
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            count = st.countTokens();
            for(int j = 0; j < count; j++){
//                int x =  Integer.parseInt(st.nextToken());
//                System.out.println(j + " " + x );
                list[i].add(Integer.parseInt(st.nextToken()));


            }
//            System.out.println(list[i]);
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= h; j++){
                for(int k : list[i]){
                    if(j >= k){
                        dp[i][j] += dp[i - 1][j - k] % 10007; // 블록을 쌓을수 있는경우
                    }
                }
                dp[i][j] += dp[i - 1][j]; // 블록을 안쌓는 경우 dp[i - 1][j]를 더해줌
            }
        }
        System.out.println(dp[n][h] % 10007);
    }
}
