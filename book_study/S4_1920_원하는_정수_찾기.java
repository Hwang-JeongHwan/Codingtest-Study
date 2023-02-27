package book_study;

import java.util.*;
import java.io.*;
public class S4_1920_원하는_정수_찾기 {
    static int[] a;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m;
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++){
            System.out.println(binarySearch(0, n - 1, Integer.parseInt(st.nextToken())));
        }
    }

    public static int binarySearch(int start, int end, int target){
        int mid = 0;
        boolean flag = false;
        while(start <= end){
            mid = (start + end) / 2;
            if(a[mid] == target){
                flag = true;
                break;
            }
            else if(a[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return flag == true ? 1 : 0;
    }
//    public static int binarySearch(int start, int end, int target){
//        int mid = (start + end) / 2;
////        System.out.println("start : " + start + " mid : " + mid + " end : " + end);
//        if(start == end){
//            if(a[start] == target){
//                return 1;
//            }
//            else{
//                return 0;
//            }
//        }
//        if(a[mid] == target){
//            return 1;
//        }
//        else if(a[mid] > target){
//            return binarySearch(start, mid - 1, target);
//        }
//        else{
//            return binarySearch(mid + 1, end, target);
//        }
//    }
}
