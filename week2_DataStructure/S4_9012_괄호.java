package week2_DataStructure;
// ')' 면 + '(' 면 -
// stack에 넣고 스택이 빌때까지 pop반복
// -가 되는 순간 break => false반환
// 반복문이 stack.size()만큼 반복되고 값이 0 이면 true

import java.util.*;
import java.io.*;
public class S4_9012_괄호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            Stack<Character> stack = new Stack<>();
            String input = br.readLine();
            for(int j = 0; j < input.length(); j ++){
                stack.push(input.charAt(j));
            }
            int flag = 0;
            boolean check1 = true;
//            System.out.printf("size : %d\n", stack.size());
            int len = stack.size();
            for(int k = 0; k < len; k ++){
                char check = stack.pop();
//                System.out.println("check = " + check);
                if(check == ')'){
                    flag ++;
                }
                else{
                    flag --;
                    if(flag < 0){
                        sb.append("NO\n");
//                        System.out.printf("flag < 0 %d\n",flag);
//                        System.out.println("NO");
                        check1 = false;
                        break;
                    }
                }
            }
            if (check1) {
                if (flag == 0) {
//                    System.out.println("YES");
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
//                    System.out.println("NO");
//                System.out.printf("no %d\n", flag);
                }
            }
        }
        System.out.println(sb);
//        +++ - ++ --
    }
}
