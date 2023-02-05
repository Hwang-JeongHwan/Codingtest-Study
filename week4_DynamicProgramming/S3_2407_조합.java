package week4_DynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;
public class S3_2407_조합 {
    // nCr = n! / (n - r)! / r!
    // ==> 100C6 => 100 * 99 * ... 95 / 6!
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        BigInteger numerator = BigInteger.ONE; // 무한대까지 저장가능한 자료형
        BigInteger denominator = BigInteger.ONE;

        for(int i = 0; i < m; i++){
            numerator = numerator.multiply(new BigInteger(String.valueOf(n - i)));
            denominator = denominator.multiply(new BigInteger(String.valueOf(i + 1)));

        }
        System.out.println(numerator.divide(denominator));
//        System.out.println(combination(n, m));
    }
    public static int combination(int n, int r){
        if(r == 0 || n == r){
            return 1;
        }

        return combination(n - 1, r - 1) + combination(n - 1, r);

    }
}
