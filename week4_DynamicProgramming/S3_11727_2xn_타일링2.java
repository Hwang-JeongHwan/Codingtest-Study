package week4_DynamicProgramming;

import java.util.*;
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

//[0, 1, 3, 5, 11, 21, 43, 85, 171, 341, 683, 1365, 2731, 5461, 10923, 21845, 0]
//21845