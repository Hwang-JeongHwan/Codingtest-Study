package week1_Greedy;
import java.util.*;
import java.io.*;
public class S5_1758_알바생강호 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] data = new Integer[n];
        for (int i  = 0; i < n; i ++){
            data[i] = Integer.parseInt(br.readLine());
        }        
        
        Arrays.sort(data, Collections.reverseOrder());
        long result = 0;
        for (int i = 0; i < n; i ++){
            long sum = data[i] - i;
            if (sum <= 0){
                break;
            }
            result += sum;


        }
        System.out.println(result);
    }
    
}
