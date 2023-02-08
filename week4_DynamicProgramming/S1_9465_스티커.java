package week4_DynamicProgramming;
import java.util.*;
import java.io.*;
public class S1_9465_스티커 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++){
            int n = Integer.parseInt(br.readLine());
            long[][] dp = new long[2][n + 1];
            long[][] arr = new long[2][n + 1];
            for(int i = 0; i < 2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j < n + 1; j++){
                    arr[i][j] = Long.parseLong(st.nextToken());
                }

            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];

            for(int j = 2; j < n + 1; j++){
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + arr[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + arr[1][j];
            }
            sb.append(Math.max(dp[0][n], dp[1][n]) + "\n");
        }
        System.out.println(sb);
    }

}
