package week7_BinarySearch;
import java.io.*;
import java.util.*;

public class S1_22871_징검다리_건너기_large {
    static int n,k=0;
    static long[] arr, dp;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new long[n];
        dp = new long[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            dp[i] = -1;
        }
        System.out.println(jump(0));

    }
    public static long jump(int x){
        if (x == n - 1) return 0;
        if (dp[x] != -1) {
            return dp[x];
        }
        dp[x] = Long.MAX_VALUE;

        for(int i = x + 1; i < n ;i++){
            dp[x] = Math.min(dp[x], Math.max(jump(i),(i - x) * (1 + Math.abs(arr[x] - arr[i]))));
        }
        return dp[x];
    }
}