package week7_BinarySearch;

import java.util.Scanner;

public class S4_2417_정수_제곱근 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long target = sc.nextLong();
        long start = 0, mid = 0, end = target;
        long pow  = 0;
        long min = Long.MAX_VALUE;
        while(start <= end){
            // target보다 큰 값중 제일 제일 값을 찾아야함
            mid = (start + end) / 2;
            pow = (long)Math.pow(mid, 2);
//            System.out.println(mid);
//            System.out.println(Math.pow(mid, 2));
            if(target <= pow){
                // 제곱값이 target보다 큰경우 가장 작은 값을 찾는거기 때문에
                // end의 범위를 좁히면서 탐색 
                end = mid - 1;
                min = mid;


            }
            else {
                start = mid + 1;
            }

        }
        System.out.println(min);

    }

}
