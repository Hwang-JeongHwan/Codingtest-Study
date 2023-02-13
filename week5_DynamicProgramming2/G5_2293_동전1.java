package week5_DynamicProgramming2;
import java.io.*;
import java.util.*;
public class G5_2293_동전1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int dp[] = new int[k + 1];
        dp[0] = 1;

        for(int i = 0; i < n; i++){
            int coin = Integer.parseInt(br.readLine());
            for(int j = coin; j < k + 1; j++){
                dp[j] += dp[j - coin];
            }
        }
        System.out.println(dp[k]);
    }
}
