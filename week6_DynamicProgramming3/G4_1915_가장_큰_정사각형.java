package week6_DynamicProgramming3;
import java.io.*;
public class G4_1915_가장_큰_정사각형 {
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int max = 0;
        dp = new int[n][m];
        for(int i = 0; i < n; i++){
            String line = br.readLine();
            for(int j = 0; j < m; j++){
                dp[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
//                System.out.println(dp[i][j]);
                if(dp[i][j] != 0 && i > 0 && j > 0){
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1; // + dp[i][j]
                }
                max = Math.max(dp[i][j], max);
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(max * max);
    }
}
