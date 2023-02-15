package week5_DynamicProgramming2;
import java.io.*;
import java.util.*;


public class G5_1106_호텔 {
    static final int maxNum = 987654321;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int dp[] = new int[c + 101]; // 한번에 가장 많이 채울 수 있는 사람의 수 100
        Arrays.fill(dp, maxNum);
        dp[0] = 0;
        for(int i = 1; i < n + 1; i ++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            for(int j = people; j < c + 101; j++){
                dp[j] = Math.min(dp[j], dp[j - people] + cost);
//                System.out.println(j + " " + dp[j]);
            }
        }
//        System.out.println(Arrays.toString(dp));
        int result = Integer.MAX_VALUE;
        for(int i = c; i < c + 101; i++){

            result = Math.min(result, dp[i]);

        }
        System.out.println(result);
    }
}
