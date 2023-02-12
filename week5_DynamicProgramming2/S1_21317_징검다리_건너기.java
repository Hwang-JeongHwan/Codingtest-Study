package week5_DynamicProgramming2;
import java.util.*;
import java.io.*;

public class S1_21317_징검다리_건너기 {
    static final int max_num = 20001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int[][] arr = new int[20][2];
        int[][] dp = new int[21][2];
        for(int i = 1; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }
        for(int i = 0; i < n + 1; i ++){
            dp[i][0] = max_num;
            dp[i][1] = max_num;
        }
        int k = Integer.parseInt(br.readLine());
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 0;
        dp[2][0] = arr[1][0];
        dp[3][0] = Math.min(arr[1][1], dp[2][0] + arr[2][0]);
        for(int i = 4; i < n + 1; i++){
            dp[i][0] = Math.min(dp[i - 1][0] + arr[i - 1][0], dp[i - 2][0] + arr[i - 2][1]);
            dp[i][1] = Math.min(Math.min(dp[i - 1][1] + arr[i - 1][0], dp[i - 2][1] + arr[i - 2][1]), dp[i - 3][0] + k);
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(Math.min(dp[n][0], dp[n][1]));
    }
}
