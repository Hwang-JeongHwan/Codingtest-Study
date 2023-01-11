package week1;
import java.io.*;
import java.util.*;;
public class S4_11399_ATM {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i ++ ){
            data[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(data);
        int result = 0;
        for (int i = 0; i < n; i ++){
            for (int j = 0; j <= i; j ++){
                result += data[j];
                
            }
        }
        System.out.println(result);
        
    }
    
}

