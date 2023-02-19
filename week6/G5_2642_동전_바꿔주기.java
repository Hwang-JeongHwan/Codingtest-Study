package week6;
import java.util.*;
import java.io.*;
public class G5_2642_동전_바꿔주기 {
    private static int[] dp;
    private static int[] p;
    private static int[] n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int coin;
        int target = Integer.parseInt(br.readLine());
        int  num = Integer.parseInt(br.readLine());
        dp = new int[target + 1];
        p = new int[num + 1];
        n = new int[num + 1];

        dp[0] = 1;

        for (int i = 1; i <= num; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = Integer.parseInt(st.nextToken());
            n[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= num; i++){
            coin = p[i];
            for(int j = target; j >= coin; j--){
                for(int k = 1; k <= n[i]; k++){
                    if(j - coin * k < 0){
                        break;
                    }
                    dp[j] += dp[j - coin * k];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[target]);
    }
}
