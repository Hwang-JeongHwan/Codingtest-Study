package week4_DynamicProgramming;
import java.util.*;
import java.io.*;
public class S2_11055_가장큰_증가부분수열 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = arr[i];
        }
        int max = dp[0];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], arr[i] + dp[j]);
//                    System.out.println(Arrays.toString(dp));
                    max = Math.max(dp[i], max);
                }
            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(max);
    }
}
