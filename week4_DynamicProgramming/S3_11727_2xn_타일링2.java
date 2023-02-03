package book_study;

import java.util.Scanner;
public class S3_11727_2xn_타일링2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 2]; // 1 <= n <= 1000, dp[1], dp[2] 초기화후 진행
        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i < n + 1; i++){
//            if(i % 2 == 0){
//                dp[i] = ((dp[i - 1]) * 2 + 1) % 10007; // 짝수 일 때
//            }
//            else{
//                dp[i] = (dp[i - 1] * 2 - 1 ) % 10007; // 홀수일 때
//            }
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007; //
        }
        System.out.println(dp[n]);
    }
}
