package book_study;
import java.io.*;
import java.util.*;

public class B_1546_평균_구하기 {
    public static void main(String[] args) throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        float sum = 0;
        int max = 0;
        for(int i = 0; i < n; i ++){
            if(arr[i] > max){
                max = arr[i];
            }
            sum += arr[i];
        }
        System.out.println(sum / n / max * 100);
    }
}
