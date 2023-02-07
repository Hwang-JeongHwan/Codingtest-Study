package week4_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1_2156_포도주_시식 {
    // 고를 수 있는 경우
    // arr[i]를 고르지 않는 경우 -> dp[i - 1]
    // arr[i]를 고르는 경우 dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int [n + 1];

        for(int i = 1; i < n + 1;  i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = arr[1];
        if(n > 1) {
            dp[2] = arr[1] + arr[2];
        }
        for(int i = 3; i < n + 1; i++){
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));

        }
        System.out.println(dp[n]);

    }
}
