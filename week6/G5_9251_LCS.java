package week6;
import java.io.*;
import java.util.*;
public class G5_9251_LCS {
    private static int[][] dp;
    private static char[] a;
    private static char[] b;
    private static ArrayList<Character> path;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        path = new ArrayList<>();
        dp = new int[a.length + 1][b.length + 1];

        for(int i = 1; i < a.length + 1; i++){
            for(int j = 1; j < b.length + 1; j++){
                if(a[i - 1] == b[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 같으면 왼쪽위
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    // 다르면 max(왼쪽, 위)
                }
            }
        }
        System.out.println(dp[a.length][b.length]);
//        getText(a.length, b.length);
////        System.out.println(path);
//        for(int i = path.size() - 1; i >= 0; i--){
//            System.out.print(path.get(i));
//        }
//        System.out.println();


    }
    public static void getText(int x, int y){
        if(x == 0 || y == 0){
            return;
        }
        if(a[x - 1] == b[y - 1]){ // 같으면  add
            path.add(a[x - 1]);
            getText(x - 1, y - 1); // 왼쪽 위로 이동

        }
        else{
            // 다르면 큰쪽으로 이동
            if(dp[x - 1][y] > dp[x][y - 1]){
                getText(x - 1, y);
            }
            else{
                getText(x, y - 1);
            }
        }
    }

}
