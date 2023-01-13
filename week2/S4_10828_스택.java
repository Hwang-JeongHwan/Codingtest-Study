package week2;
import java.util.*;
import java.io.*;
public class S4_10828_스택 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        String op = "";
        int num;
//        System.out.println(stack.empty()); // 비어있으면 true 아니면 false
        //System.out.println(stack.peek()); // 비어 있으면 오류, 가장위의 값을 pop하지 않고 반환, 스택에서 제거하지 않고
//        System.out.println(stack.size()); // size를 반환
//        System.out.println(stack.pop()); // 비어있으면 오류, 가장위의 값을 pop, 스택에서 제거하고 반환
        for(int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            op = st.nextToken();
//            System.out.println(op);
            if(op.equals("push")){
                stack.push(Integer.parseInt(st.nextToken())); // 최상단에 push 넣어줌
            }
            if(op.equals("top")){
                if(stack.empty()){
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.peek());
                }
            }
            if(op.equals("empty")){
                if(stack.empty() == true){
                    System.out.println(1);
                }
                else{
                    System.out.println(0);
                }

            }

            if(op.equals("size")){
                System.out.println(stack.size());
            }
            if(op.equals("pop")){
                if(!stack.empty()){
                    System.out.println(stack.pop());
                }
                else{
                    System.out.println(-1);
                }
            }
        }
    }
}
