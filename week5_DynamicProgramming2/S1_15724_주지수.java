package week5_DynamicProgramming2;
import java.io.*;
import java.util.*;
public class S1_15724_주지수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        int x1, x2, y1, y2, sum;
        for(int i = 1; i < n + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < m + 1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        System.out.println(Arrays.deepToString(dp));
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < m + 1; j ++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i ++){
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            sum = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];
            sb.append(sum + "\n");

        }
        System.out.println(sb);
    }
}
