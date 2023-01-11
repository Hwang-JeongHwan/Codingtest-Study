package week1;
import java.io.*;
import java.util.*;
public class S4_11047_동전0 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        //System.out.println(Integer.MAX_VALUE);
        Integer[] data = new Integer[n];
        for(int i = 0; i < n; i ++){
            data[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(data, Collections.reverseOrder());
        int result = 0;
        for (int i = 0; i < n; i ++){
            if (k < data[i]){
                continue;
            }
            else{
                result += k / data[i];
                k = k % data[i];

            }
        }
        System.out.println(result);
    }    
}
