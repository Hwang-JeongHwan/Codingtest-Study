package week4_DynamicProgramming;
import java.util.*;
import java.io.*;
public class S1_1890_점프 {
    // 오른쪽으로 가는경우 dp[i][j + x]++
    // 아래로 가는경우 dp[i + x][j]++
    // 범위를 벗어나는경우 i > n or j > n

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long[][] arr = new long[n + 1][n + 1];
        long[][] dp = new long[n + 1][n + 1];
        dp[1][1] = 1;
        for(int i = 1; i < n + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n + 1; j++){
                int distance = Integer.parseInt(st.nextToken());
                arr[i][j] = distance;

                if(dp[i][j] > 0 && distance != 0){
                    if(i + distance <= n){
                        dp[i + distance][j] += dp[i][j];
//                        System.out.println(i + " " + j+" " + dp[n][n]);
                    }
                    if(j + distance <= n) {
                        dp[i][(j + distance)] += dp[i][j];
//                        System.out.println(i + " " + j+" " + dp[n][n]);
                    }
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[n][n]);

    }
}
