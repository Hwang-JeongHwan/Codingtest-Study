package week1_Greedy;
import java.util.*;
import java.io.*;


public class S4_2217로프 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = new int[n];
        //10, 20, 30 ->
        //10 * 3
        //20 * 2
        //30 * 1 -> max = 40 


        for (int i = 0; i < n; i ++){
            data[i] = Integer.parseInt(br.readLine());

        }
        Arrays.sort(data);

        int result = 0;
        for (int i = 0; i < n ; i ++){
            result = Math.max(result, data[i] * (n - i));


        }
        System.out.println(result);

    }
}
