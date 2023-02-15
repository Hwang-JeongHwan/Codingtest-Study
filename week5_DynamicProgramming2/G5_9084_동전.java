package week5_DynamicProgramming2;
import java.io.*;
import java.util.*;
public class G5_9084_동전 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc, n, m, coin;
        int[] arr, dp;

        tc = Integer.parseInt(br.readLine());
        for(int t = 0; t < tc; t++){
            n = Integer.parseInt(br.readLine());
            arr = new int [n + 1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i < n + 1; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            m = Integer.parseInt(br.readLine());
            dp = new int[10001];
            dp[0] = 1;
            for(int i = 1; i < n + 1; i++){
                coin = arr[i];
                for(int j = coin; j < m + 1; j++){
                    dp[j] += dp[j - coin];
                }
            }
            sb.append(dp[m] + "\n");
        }
        System.out.print(sb);
    }
}
