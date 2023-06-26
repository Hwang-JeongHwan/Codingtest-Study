package week12;

import java.util.Scanner;

/**
 * packageName    : Brute_Force
 * fileName       : S3_15651_N과_M_3
 * author         : jeonghwan
 * date           : 2023/05/27
 * time           : 11:07 PM
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2023/05/29        jeonghwan       최초 생성
 */

public class 이분탐색_S5_1789_수들의_합 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        long count = 1;
        while(s - count > count){
            s -= count;
            count++;
        }
        System.out.println(count);



    }

}
