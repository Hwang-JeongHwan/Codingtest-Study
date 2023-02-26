package week6_DynamicProgramming3;
import java.util.*;
import java.io.*;
public class G5_2225_합분해 {
    final static int mod = 1000000000;
    private static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        dp = new int[k + 1][n + 1];
        Arrays.fill(dp[1],1);
        for(int i = 0; i < k + 1; i++){
            dp[i][0] = 1;
        }

        for(int i = 2; i < k + 1; i++){
            for(int j = 1; j < n + 1; j++){
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % mod;
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[k][n]);

    }
}
