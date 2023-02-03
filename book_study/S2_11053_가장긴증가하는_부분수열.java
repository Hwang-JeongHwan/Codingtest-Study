package week4_DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class S2_11053_가장긴증가하는_부분수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    //10 20 1 2 5 30 40
                    //1  2  1 2 3 4  5
                }
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            if(max < dp[i]){
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
