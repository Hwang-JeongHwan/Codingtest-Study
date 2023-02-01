package week2_DataStructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class S4_2164_카드2 {
    public static void main(String[] args) {
        // 담음과 같은 동작을 카드가 한 장 남을 때까지 반복
        // 우선 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일위에 있는 카드를 제일 아래에 있는 카트 밑으로 옮긴다.
        // N = 4인경우 카드는 제일위에서부터 1234순서로 놓여있다
        // 1을 버리면 234가 남고 여기서 2를 제일 아래로 옮기면 342가 된다
        // 3을 버리면 42가 되고 4를 밑으로 옮기면 24가 된다 마지막으로 2를 버리고 나면 남는카드는 4가 된다
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        LinkedList<Integer> stack = new LinkedList<>();
//        for(int i = 1; i < n + 1; i++){
//            stack.add(i);
//        }
////        System.out.println(stack);
//        while(stack.size() > 1){
//            stack.pop();
//            if(stack.size() > 1){
//                stack.add(stack.pop());
//            }
//        }
//        System.out.println(stack.get(0));
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < n + 1; i++){
            queue.offer(i);
        }
        while(queue.size() > 1){
            queue.poll();
            queue.offer(queue.poll());

        }
        System.out.println(queue.poll());
    }
}
