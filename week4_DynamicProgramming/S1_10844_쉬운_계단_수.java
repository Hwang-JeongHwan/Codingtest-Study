package week4_DynamicProgramming;
import java.util.Arrays;
import java.util.Scanner;

public class S1_10844_쉬운_계단_수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[][]dp = new long[n + 1][10];
        long mod = 1000000000l;
        for(int i = 1; i < 10; i++){
            // n == 1인경우 초기화
            dp[1][i] = 1; //0으로 시작하는 수는 계단수가 아니므로
            // 1 ~ 9 까지만 계단수

        }
        for(int i = 2; i < n + 1; i ++){
            dp[i][0] = dp[i - 1][1] % mod;
            dp[i][9] = dp[i - 1][8] % mod;
            // 끝자리가 0 과 9 인 수는 앞자리에 1, 8이 와야함
            for(int j = 1; j < 9; j++){
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1] )% mod;
            }
        }
        long result = 0;
        for(int i = 0; i < 10; i++){
            result = (result + dp[n][i]) % mod;
        }
        System.out.println(result);
//        System.out.println(Arrays.deepToString(dp));
    }
}

