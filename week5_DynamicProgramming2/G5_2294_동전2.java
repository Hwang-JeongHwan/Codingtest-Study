package week5_DynamicProgramming2;
import java.util.*;
import java.io.*;
public class G5_2294_동전2 {
    static final int maxNum = 987654321;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Integer[] coins = new Integer[n];
        int[] dp = new int [k + 1];
        Arrays.fill(dp, maxNum);
        dp[0] = 0;
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());

        }
//        Arrays.sort(coins, Collections.reverseOrder());
        /*
            3 14
            6       2
            4       4
            2       6

            3       7


        */

//        System.out.println(Arrays.toString(coins));
//        for(int i = 0; i < n ; i++){ 2 12, 5, 7일때 5 10 7 14 이렇게 배수만 탐색 그래서 틀림
        // 5 + 7인경우도 봐야함
//            for(int j = coins[i]; j  < k + 1; j += coins[i]){
//                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
//            }
//        }
//
        for(int i = 0; i < n ; i++){
            for(int j = coins[i]; j  < k + 1; j ++){
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }
//        System.out.println(Arrays.toString(dp));
        if(dp[k] == maxNum){
            System.out.println(-1);
        }
        else {
            System.out.println(dp[k]);
        }
    }
}
