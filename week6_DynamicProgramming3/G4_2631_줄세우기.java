package week6_DynamicProgramming3;

import java.util.*;
import java.io.*;
public class G4_2631_줄세우기 {
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n];
        int max = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
//        System.out.println(Arrays.toString(arr));
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }
            max = Math.max(dp[i], max);
        }
//        System.out.println(Arrays.toString(dp));
//        System.out.println(max);
        System.out.println(n - max); // 전체 - 최장 증가 부분 수열(LIS, Longest Increasing Subsequence)
    }
}
