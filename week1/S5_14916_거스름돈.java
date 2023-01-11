package week1;
import java.util.*;
import java.io.*;


public class S5_14916_거스름돈 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        //int[] array = new int[n + 1]; // 이렇게 하면 4일때 값을 못넣음 n < 4out of range
        int[] array = new int[100001];
        // for(int i = 0; i <= n; i ++){
        //     array[i] = 100001;

        // }
        Arrays.fill(array, Integer.MAX_VALUE);
        array[2] = 1;
        array[4] = 2;
        array[5] = 1;

        for(int i = 6; i <= n; i ++){
            // int minNum = Math.min(array[i - 2], array[i - 5]);
            // if(array[i] == minNum){
            //     continue;

            // }
            // else{
            //     array[i] = minNum + 1;
            // }
            array[i] = Math.min(array[i - 2], array[i - 5]) + 1;

        }
        // System.out.println(Arrays.toString(array));
        if(array[n] == Integer.MAX_VALUE){
            System.out.println(-1);
        }
        else{
            System.out.println(array[n]);
        }
        // == System.out.pringln(array[n] == Integer.MAX_VALUE ? -1 : array[n])
        // true -> -1, false -> array[n]
    }
    
}
