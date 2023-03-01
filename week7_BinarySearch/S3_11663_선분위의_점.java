package week7_BinarySearch;

import java.util.*;
import java.io.*;

public class S3_11663_선분위의_점 {
    static int dot[];
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dot = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++){
            dot[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dot);
//        System.out.println(Arrays.toString(dot));

        for(int i = 0; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            sb.append(binarySearch(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())) + "\n");

        }
        System.out.print(sb);
    }
    static int binarySearch(int left, int right){
        //right 보다 작거나 같은 인덱스 - left보다 크거나 같은 인덱스 + 1 = count
        int start = 0, mid = 0, end = n - 1;
        int startIndex = 0, endIndex = 0;
        while(start <= end){
            mid = (start + end) / 2;

            if(dot[mid] <= right){
                start = mid + 1;
            }
            else{ // dot[mid] <= right
                end = mid - 1;
            }

        }
        endIndex = end;
        start = 0;

        end = n - 1;

        while(start <= end){
            mid = (start + end) / 2;

            if(dot[mid] < left){
                start = mid + 1;
            }
            else{ // dot[mid] <= right
                end = mid - 1;
            }

        }
        startIndex = start;

//        System.out.println(endIndex + " " +  startIndex + " : " +  (endIndex - startIndex));
        return endIndex - startIndex + 1;

    }
}
