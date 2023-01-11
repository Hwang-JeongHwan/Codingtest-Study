package week1;
import java.util.*;
import java.io.*;

public class S4_11508_2plus1세일 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i ++){
            data[i] = Integer.parseInt(br.readLine());

        }

        Arrays.sort(data, Collections.reverseOrder());
        int count = 0;
        long result = 0;
        for (int i = 0; i < n; i ++){
            result += data[i];
            count ++;
            if (count == 3){
                result -= data[i];
                count = 0;
            }

        }
        System.out.println(result);

    }
    
}
