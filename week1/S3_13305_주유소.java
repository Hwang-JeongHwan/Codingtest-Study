package week1;
import java.util.*;
import java.io.*;
public class S3_13305_주유소 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] distance = new long[n - 1];
        long[] cost = new long[n];
        for (int i = 0; i < n - 1; i ++){
            distance[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i ++){
            cost[i] = Integer.parseInt(st.nextToken());
        }

        long now = cost[0];
        long result = 0;
        for(int i = 0; i < n - 1; i ++){
            if (now >  cost[i]){
                now = cost[i];
            }
            result += now * distance[i];
//            System.out.println(result);
        }
        System.out.print(result);

    }
}
